package DAO;

import DAO.NhaCungCapDAO;
import entity.NhaCungCap;
import entity.PhieuNhap;
import entity.SanPham;
import entity.NhanVien;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;



public class PhieuNhapDAO {
    private SanPhamDAO sanPhamDAO;
    private NhanVienDAO nhanVienDAO;
    private NhaCungCapDAO nhaCungCapDAO;
    

    public SanPhamDAO getSanPhamDAO(){
        if(sanPhamDAO == null){
            sanPhamDAO = new SanPhamDAO();
        }
        return sanPhamDAO;
    }
    
    public NhanVienDAO getNhanVienDAO(){
        if(nhanVienDAO == null){
            nhanVienDAO = new NhanVienDAO();
        }
        return nhanVienDAO;
    }
    
    public NhaCungCapDAO getNhaCungCapDAO(){
        if(nhaCungCapDAO == null){
            nhaCungCapDAO = new NhaCungCapDAO();
        }
        return nhaCungCapDAO;
    }
    
    
    public boolean create(PhieuNhap data){
        int result = 0;
        
        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "INSERT INTO tb_PhieuNhap(maSP,maNCC,maNV,ngayNhap,soLuongNhap,donGia,chietKhau,thanhTien,ghiChu)"
                    +" VALUES(?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement p = (PreparedStatement)con.prepareStatement(sql);
            p.setString(1,data.getSanPham().getMaSP());
            p.setInt(2, data.getNhaCungCap().getMaNCC());
            p.setString(3,data.getNhanVien().getMaNV());
            p.setDate(4, data.getNgayNhap());
            p.setInt(5, data.getSoLuong());
            p.setDouble(6, data.getDonGia());
            p.setDouble(7, data.getChietKhau());
            double thanhTien = (data.getSoLuong() * data.getDonGia()) - (data.getSoLuong() * data.getDonGia() * (data.getChietKhau()/100));
            p.setDouble(8, thanhTien);
            p.setString(9,data.getGhiChu());
            
            result = p.executeUpdate();
            
           config.JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result > 0;
    }
    public void edit(PhieuNhap data){
        
        
        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "update tb_PhieuNhap set maSP=?,maNCC=?,maNV=?,ngayNhap=?,soLuongNhap=?,donGia=?,chietKhau=?,thanhTien=?,ghiChu=? where maPN=?";
            
            PreparedStatement p = (PreparedStatement)con.prepareStatement(sql);
            p.setString(1,data.getSanPham().getMaSP());
            p.setInt(2, data.getNhaCungCap().getMaNCC());
            p.setString(3,data.getNhanVien().getMaNV());
            p.setDate(4, data.getNgayNhap());
            p.setInt(5, data.getSoLuong());
            p.setDouble(6, data.getDonGia());
            p.setDouble(7, data.getChietKhau());
            double thanhTien = (data.getSoLuong() * data.getDonGia()) - (data.getSoLuong() * data.getDonGia() * (data.getChietKhau()/100));
            p.setDouble(8, thanhTien);
            p.setString(9,data.getGhiChu());
            p.setInt(10, data.getMaPN());
            
            p.executeUpdate();
            
           config.JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void delete(int id){

        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "delete from tb_PhieuNhap where maPN=?";
            
            PreparedStatement p = (PreparedStatement)con.prepareStatement(sql);
            p.setInt(1, id);
            p.executeUpdate();
            
           config.JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public ArrayList<PhieuNhap> getAllPhieuNhap(){
        ArrayList<PhieuNhap> dsPhieuNhap = new ArrayList<>();
        Connection con = (Connection) config.JDBCUtil.getConnection();
        String sql = "select tb_PhieuNhap.*,tb_NhanVien.tenNV,tb_SanPham.tenSP,tb_NCC.tenNCC "
                + "from tb_PhieuNhap,tb_SanPham,tb_NhanVien,tb_NCC where tb_PhieuNhap.maSP=tb_SanPham.maSP and tb_PhieuNhap.maNV = tb_NhanVien.maNV and tb_PhieuNhap.maNCC = tb_NCC.maNCC";

        try {
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                int maPN = rs.getInt("maPN");
                String maSP = rs.getString("maSP");
                int maNCC = rs.getInt("maNCC");
                String maNV = rs.getString("maNV");
                Date ngayNhap = rs.getDate("ngayNhap");
                int soLuong = rs.getInt("soLuongNhap");
                double donGia = rs.getDouble("donGia");
                double chietKhau = rs.getDouble("chietKhau");
                double thanhTien = (soLuong * donGia) - (soLuong * donGia * (chietKhau/100));
                String ghiChu = rs.getString("ghiChu");
                String tenNCC = rs.getString("tenNCC");
                String tenSP = rs.getString("tenSP");
                String tenNV = rs.getString("tenNV");
                NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC);
                SanPham sp = new SanPham(maSP, tenSP);
                NhanVien nv = new NhanVien(maNV, tenNV);
                PhieuNhap phieuNhap = new PhieuNhap(maPN, sp, ncc, nv, ngayNhap, soLuong, donGia, chietKhau, thanhTien, ghiChu);
                dsPhieuNhap.add(phieuNhap);
                
            }
            config.JDBCUtil.closeConnection(con);
            
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsPhieuNhap;
        
    }
    public PhieuNhap getSoLuongTheoMaSP(){
        Connection con = (Connection) config.JDBCUtil.getConnection();
        PhieuNhap phieuNhap = null;
        String sql = "Select tb_PhieuNhap.maSP,sum(tb_PhieuNhap.soLuongNhap) as tongNhap " +
                     "from tb_PhieuNhap " +
                     "group by tb_PhieuNhap.maSP";

        try {
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                String maSP = rs.getString("maSP");
                int soLuong = rs.getInt("tongNhap");
                SanPham sp = new SanPham(maSP);
                phieuNhap = new PhieuNhap(sp, soLuong);
            }
            config.JDBCUtil.closeConnection(con);
            
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return phieuNhap;
    }
    
    public ArrayList<PhieuNhap> search(String search){
        ArrayList<PhieuNhap> dsPhieuNhap = new ArrayList<>();
        Connection con = (Connection) config.JDBCUtil.getConnection();
        String sql = "select tb_PhieuNhap.*,tb_NhanVien.tenNV,tb_SanPham.tenSP,tb_NCC.tenNCC "
                + "from tb_PhieuNhap,tb_SanPham,tb_NhanVien,tb_NCC "
                + "where tb_PhieuNhap.maSP=tb_SanPham.maSP "
                + "and tb_PhieuNhap.maNV = tb_NhanVien.maNV "
                + "and tb_PhieuNhap.maNCC = tb_NCC.maNCC "
                + "and (tb_PhieuNhap.MaPN like ? or tb_NhanVien.tenNV like ? or tb_SanPham.tenSP like ? or tb_NCC.tenNCC like ?)";
        
        try {
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, "%" + search + "%");
            p.setString(2, "%" + search + "%");
            p.setString(3, "%" + search + "%");
            p.setString(4, "%" + search + "%");
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                int maPN = rs.getInt("maPN");
                String maSP = rs.getString("maSP");
                int maNCC = rs.getInt("maNCC");
                String maNV = rs.getString("maNV");
                Date ngayNhap = rs.getDate("ngayNhap");
                int soLuong = rs.getInt("soLuongNhap");
                double donGia = rs.getDouble("donGia");
                double chietKhau = rs.getDouble("chietKhau");
                double thanhTien = (soLuong * donGia) - (soLuong * donGia * (chietKhau/100));
                String ghiChu = rs.getString("ghiChu");
                String tenNCC = rs.getString("tenNCC");
                String tenSP = rs.getString("tenSP");
                String tenNV = rs.getString("tenNV");
                NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC);
                SanPham sp = new SanPham(maSP, tenSP);
                NhanVien nv = new NhanVien(maNV, tenNV);
                PhieuNhap phieuNhap = new PhieuNhap(maPN, sp, ncc, nv, ngayNhap, soLuong, donGia, chietKhau, thanhTien, ghiChu);
                dsPhieuNhap.add(phieuNhap);
                
            }
            config.JDBCUtil.closeConnection(con);
            
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsPhieuNhap;
        
    }
    
}
