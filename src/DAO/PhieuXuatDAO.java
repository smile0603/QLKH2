package DAO;

import entity.KhachHang;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
import entity.NhaCungCap;
import entity.PhieuNhap;
import entity.SanPham;
import entity.NhanVien;
import entity.PhieuXuat;

public class PhieuXuatDAO {

    private SanPhamDAO sanPhamDAO;
    private NhanVienDAO nhanVienDAO;
    private NhaCungCapDAO nhaCungCapDAO;
    private KhachHangDAO khachHangDAO;

    public SanPhamDAO getSanPhamDAO() {
        if (sanPhamDAO == null) {
            sanPhamDAO = new SanPhamDAO();
        }
        return sanPhamDAO;
    }

    public NhanVienDAO getNhanVienDAO() {
        if (nhanVienDAO == null) {
            nhanVienDAO = new NhanVienDAO();
        }
        return nhanVienDAO;
    }

    public NhaCungCapDAO getNhaCungCapDAO() {
        if (nhaCungCapDAO == null) {
            nhaCungCapDAO = new NhaCungCapDAO();
        }
        return nhaCungCapDAO;
    }

    public KhachHangDAO getKhachHangDAO() {
        if (khachHangDAO == null) {
            khachHangDAO = new KhachHangDAO();
        }
        return khachHangDAO;
    }

    public boolean create(PhieuXuat data) {
        int result = 0;

        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "INSERT INTO tb_PhieuXuat(maSP,maNCC,maNV,ngayXuat,soLuongXuat,donGia,chietKhau,thanhTien,ghiChu,maKH)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, data.getSanPham().getMaSP());
            p.setInt(2, data.getNhaCungCap().getMaNCC());
            p.setString(3, data.getNhanVien().getMaNV());
            p.setDate(4, data.getNgayXuat());
            p.setInt(5, data.getSoLuong());
            p.setDouble(6, data.getDonGia());
            p.setDouble(7, data.getChietKhau());
            double thanhTien = (data.getSoLuong() * data.getDonGia()) - (data.getSoLuong() * data.getDonGia() * (data.getChietKhau() / 100));
            p.setDouble(8, thanhTien);
            p.setString(9, data.getGhiChu());
            p.setString(10, data.getKhachHang().getMaKH());
            result = p.executeUpdate();

            config.JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result > 0;
    }

    public void edit(PhieuXuat data) {

        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "update tb_PhieuXuat set maSP=?,maNCC=?,maNV=?,ngayXuat=?,soLuongXuat=?,donGia=?,chietKhau=?,thanhTien=?,ghiChu=?,maKH=? where maPX=?";

            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, data.getSanPham().getMaSP());
            p.setInt(2, data.getNhaCungCap().getMaNCC());
            p.setString(3, data.getNhanVien().getMaNV());
            p.setDate(4, data.getNgayXuat());
            p.setInt(5, data.getSoLuong());
            p.setDouble(6, data.getDonGia());
            p.setDouble(7, data.getChietKhau());
            double thanhTien = (data.getSoLuong() * data.getDonGia()) - (data.getSoLuong() * data.getDonGia() * (data.getChietKhau() / 100));
            p.setDouble(8, thanhTien);
            p.setString(9, data.getGhiChu());
            p.setString(10, data.getKhachHang().getMaKH());
            p.setInt(11, data.getMaPX());

            p.executeUpdate();

            config.JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void delete(int id) {

        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "delete from tb_PhieuXuat where maPX=?";

            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setInt(1, id);
            p.executeUpdate();

            config.JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<PhieuXuat> getAllPhieuXuat() {
        ArrayList<PhieuXuat> dsPhieuXuat = new ArrayList<>();
        Connection con = (Connection) config.JDBCUtil.getConnection();
        String sql = "select tb_PhieuXuat.*,tb_NhanVien.tenNV,tb_SanPham.tenSP,tb_NCC.tenNCC,tb_KhachHang.tenKH "
                + "from tb_PhieuXuat,tb_SanPham,tb_NhanVien,tb_NCC,tb_KhachHang "
                + "where tb_PhieuXuat.maSP=tb_SanPham.maSP "
                + "and tb_PhieuXuat.maNV = tb_NhanVien.maNV "
                + "and tb_PhieuXuat.maNCC = tb_NCC.maNCC "
                + "and tb_PhieuXuat.maKH = tb_KhachHang.maKH";

        try {
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);

            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                int maPX = rs.getInt("maPX");
                String maSP = rs.getString("maSP");
                int maNCC = rs.getInt("maNCC");
                String maNV = rs.getString("maNV");
                String maKH = rs.getString("maKH");
                Date ngayXuat = rs.getDate("ngayXuat");
                int soLuong = rs.getInt("soLuongXuat");
                double donGia = rs.getDouble("donGia");
                double chietKhau = rs.getDouble("chietKhau");
                double thanhTien = (soLuong * donGia) - (soLuong * donGia * (chietKhau / 100));
                String ghiChu = rs.getString("ghiChu");
                String tenNCC = rs.getString("tenNCC");
                String tenSP = rs.getString("tenSP");
                String tenNV = rs.getString("tenNV");
                String tenKH = rs.getString("tenKH");
                NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC);
                SanPham sp = new SanPham(maSP, tenSP);
                NhanVien nv = new NhanVien(maNV, tenNV);
                KhachHang kh = new KhachHang(maKH, tenKH);
                PhieuXuat px = new PhieuXuat(maPX, nv, ncc, sp, ngayXuat, soLuong, donGia, chietKhau, thanhTien, ghiChu, kh);
                dsPhieuXuat.add(px);

            }
            config.JDBCUtil.closeConnection(con);

        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsPhieuXuat;

    }
        public PhieuXuat getPhieuXuatTheoMa(int t) {
        PhieuXuat px = null;
        Connection con = (Connection) config.JDBCUtil.getConnection();
        String sql = "select tb_PhieuXuat.*,tb_NhanVien.tenNV,tb_SanPham.tenSP,tb_NCC.tenNCC,tb_NCC.diaChiNCC,tb_KhachHang.tenKH "
                + "from tb_PhieuXuat,tb_SanPham,tb_NhanVien,tb_NCC,tb_KhachHang "
                + "where tb_PhieuXuat.maPX like ? "
                + "and tb_PhieuXuat.maSP=tb_SanPham.maSP "
                + "and tb_PhieuXuat.maNV = tb_NhanVien.maNV "
                + "and tb_PhieuXuat.maNCC = tb_NCC.maNCC "
                + "and tb_PhieuXuat.maKH = tb_KhachHang.maKH";

        try {
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setInt(1, t);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                int maPX = rs.getInt("maPX");
                String maSP = rs.getString("maSP");
                int maNCC = rs.getInt("maNCC");
                String maNV = rs.getString("maNV");
                String maKH = rs.getString("maKH");
                Date ngayXuat = rs.getDate("ngayXuat");
                int soLuong = rs.getInt("soLuongXuat");
                double donGia = rs.getDouble("donGia");
                double chietKhau = rs.getDouble("chietKhau");
                double thanhTien = (soLuong * donGia) - (soLuong * donGia * (chietKhau / 100));
                String ghiChu = rs.getString("ghiChu");
                String tenNCC = rs.getString("tenNCC");
                String diaChiNCC = rs.getString("diaChiNCC");
                String tenSP = rs.getString("tenSP");
                String tenNV = rs.getString("tenNV");
                String tenKH = rs.getString("tenKH");
                NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC,diaChiNCC);
                SanPham sp = new SanPham(maSP, tenSP);
                NhanVien nv = new NhanVien(maNV, tenNV);
                KhachHang kh = new KhachHang(maKH, tenKH);
                px = new PhieuXuat(maPX, nv, ncc, sp, ngayXuat, soLuong, donGia, chietKhau, thanhTien, ghiChu, kh);
                

            }
            config.JDBCUtil.closeConnection(con);

        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return px;

    }
    public ArrayList<PhieuXuat> search(String search) {
        ArrayList<PhieuXuat> dsPhieuXuat = new ArrayList<>();
        Connection con = (Connection) config.JDBCUtil.getConnection();
        String sql = "select tb_PhieuXuat.*,tb_NhanVien.tenNV,tb_SanPham.tenSP,tb_NCC.tenNCC,tb_KhachHang.tenKH "
                + "from tb_PhieuXuat,tb_SanPham,tb_NhanVien,tb_NCC,tb_KhachHang "
                + "where tb_PhieuXuat.maSP=tb_SanPham.maSP "
                + "and tb_PhieuXuat.maNV = tb_NhanVien.maNV "
                + "and tb_PhieuXuat.maNCC = tb_NCC.maNCC "
                + "and tb_PhieuXuat.maKH = tb_KhachHang.maKH "
                + "and (tb_PhieuXuat.MaPX like ? or tb_NhanVien.tenNV like ? or tb_SanPham.tenSP like ? or tb_NCC.tenNCC like ? or tb_KhachHang.tenKH like ?)";

        try {
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, "%" + search + "%");
            p.setString(2, "%" + search + "%");
            p.setString(3, "%" + search + "%");
            p.setString(4, "%" + search + "%");
            p.setString(5, "%" + search + "%");
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                int maPX = rs.getInt("maPX");
                String maSP = rs.getString("maSP");
                int maNCC = rs.getInt("maNCC");
                String maNV = rs.getString("maNV");
                String maKH = rs.getString("maKH");
                Date ngayXuat = rs.getDate("ngayXuat");
                int soLuong = rs.getInt("soLuongXuat");
                double donGia = rs.getDouble("donGia");
                double chietKhau = rs.getDouble("chietKhau");
                double thanhTien = (soLuong * donGia) - (soLuong * donGia * (chietKhau / 100));
                String ghiChu = rs.getString("ghiChu");
                String tenNCC = rs.getString("tenNCC");
                String tenSP = rs.getString("tenSP");
                String tenNV = rs.getString("tenNV");
                String tenKH = rs.getString("tenKH");
                NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC);
                SanPham sp = new SanPham(maSP, tenSP);
                NhanVien nv = new NhanVien(maNV, tenNV);
                KhachHang kh = new KhachHang(maKH, tenKH);
                PhieuXuat px = new PhieuXuat(maPX, nv, ncc, sp, ngayXuat, soLuong, donGia, chietKhau, thanhTien, ghiChu, kh);
                dsPhieuXuat.add(px);

            }
            config.JDBCUtil.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dsPhieuXuat;

    }
    

}
