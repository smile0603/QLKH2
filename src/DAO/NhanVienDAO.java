package DAO;

import entity.NhanVien;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NhanVienDAO {
    public ArrayList<NhanVien> getAllNhanVien(){
        ArrayList<NhanVien> dsNV = new ArrayList<>();
        Connection con = (Connection) config.JDBCUtil.getConnection();
        String sql = "SELECT * FROM tb_NhanVien";
        
        try {
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                String maNV = rs.getString("maNV");
                String tenNV = rs.getString("tenNV");
                String mail = rs.getString("mail");
                int sdt = rs.getInt("sdt");
                NhanVien nv = new NhanVien(maNV, tenNV, mail, sdt);
                dsNV.add(nv);
            }
            config.JDBCUtil.closeConnection(con);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dsNV;
        
    }
}
