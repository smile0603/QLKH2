package DAO;

import entity.NhaCungCap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NhaCungCapDAO {
    public static NhaCungCapDAO getInstance(){
        return new NhaCungCapDAO();
    }
    
    public NhaCungCap selectNCCByMaNCC(int maNCC){
        NhaCungCap ncc = null;
        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "SELECT * FROM tb_NCC WHERE maNCC = ?";
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setInt(1, maNCC);
            ResultSet rs = (ResultSet) p.executeQuery();
            while(rs.next()){
                int mncc = rs.getInt("maNCC");
                String tenNCC = rs.getString("tenNCC");
                String diaChi = rs.getString("diaChiNCC");
                String mailNCC = rs.getString("mailNCC");
                String sdt = rs.getString("sdtNCC");
                NhaCungCap ncc_temp = new NhaCungCap(mncc, tenNCC, diaChi, mailNCC, sdt);
                ncc = ncc_temp;
                
            }
            config.JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
        }
        return ncc;
    }
    
    
    public boolean create(NhaCungCap ncc){
        int result = 0;
        
        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "INSERT INTO tb_NCC(tenNCC,diaChiNCC,mailNCC,sdtNCC) VALUES(?,?,?,?)";
            PreparedStatement p = (PreparedStatement)con.prepareStatement(sql);
           
            p.setString(1, ncc.getTenNCC());
            p.setString(2, ncc.getDiaChi());
            p.setString(3, ncc.getEmail());
            p.setString(4, ncc.getSdtNCC());
            result = p.executeUpdate();
            
           config.JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result > 0;
    }
    public void edit(NhaCungCap ncc){
        int result = 0;
        
        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "UPDATE tb_NCC set tenNCC=?,diaChiNCC=? ,mailNCC=?,sdtNCC=? WHERE maNCC=?";
            PreparedStatement p = (PreparedStatement)con.prepareStatement(sql);
           
            p.setString(1, ncc.getTenNCC());
            p.setString(2, ncc.getDiaChi());
            p.setString(3, ncc.getEmail());
            p.setString(4, ncc.getSdtNCC());
            p.setInt(5, ncc.getMaNCC());
            result = p.executeUpdate();
            
           config.JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void delete(int id){
        int result = 0;
        
        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "DELETE from tb_NCC where maNCC =?";
            PreparedStatement p = (PreparedStatement)con.prepareStatement(sql); 
            p.setInt(1, id);
            result = p.executeUpdate();
            
           config.JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   public ArrayList<NhaCungCap> search(String txtSearch){
        ArrayList<NhaCungCap> dsNCC = new ArrayList<>();
        Connection con = (Connection) config.JDBCUtil.getConnection();
        String sql = "SELECT * FROM tb_NCC WHERE (maNCC LIKE ? or tenNCC LIKE ? or sdtNCC LIKE ?)";
        
        try {
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, "%" + txtSearch + "%");
            p.setString(2, "%" + txtSearch + "%");
            p.setString(3, "%" + txtSearch + "%");
    
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                int mncc = rs.getInt("maNCC");
                String tenNCC = rs.getString("tenNCC");
                String diaChi = rs.getString("diaChiNCC");
                String mailNCC = rs.getString("mailNCC");
                String sdt = rs.getString("sdtNCC");

                NhaCungCap ncc = new NhaCungCap(mncc, tenNCC, diaChi, mailNCC, sdt);
                dsNCC.add(ncc);
                
                
            }
            config.JDBCUtil.closeConnection(con);
            
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNCC;
        
    }
    
    public ArrayList<NhaCungCap> getAllNhaCungCap(){
        ArrayList<NhaCungCap> dsNCC = new ArrayList<>();
        Connection con = (Connection) config.JDBCUtil.getConnection();
        String sql = "SELECT * FROM tb_NCC";
        
        try {
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                int mncc = rs.getInt("maNCC");
                String tenNCC = rs.getString("tenNCC");
                String diaChi = rs.getString("diaChiNCC");
                String mailNCC = rs.getString("mailNCC");
                String sdt = rs.getString("sdtNCC");

                NhaCungCap ncc = new NhaCungCap(mncc, tenNCC, diaChi, mailNCC, sdt);
                dsNCC.add(ncc);
                
                
            }
            config.JDBCUtil.closeConnection(con);
            
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNCC;
        
    }
    

    
    
}
