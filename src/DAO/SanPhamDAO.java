package DAO;

import entity.NhaCungCap;
import entity.SanPham;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SanPhamDAO {

    private NhaCungCapDAO nhaCungCapDAO;

    public NhaCungCapDAO getNhaCungCapDAO() {
        if (nhaCungCapDAO == null) {
            nhaCungCapDAO = new NhaCungCapDAO();
        }
        return nhaCungCapDAO;
    }

    public ArrayList<SanPham> getAllSanPham() {
        ArrayList<SanPham> dsSP = new ArrayList<>();
        Connection con = (Connection) config.JDBCUtil.getConnection();
        String sql = "select tb_SanPham.*,tb_NCC.tenNCC "
                + "from tb_SanPham,tb_NCC where tb_SanPham.maNCC = tb_NCC.maNCC";

        try {
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                String ghiChu = rs.getString("ghiChu");
                int maNCC = rs.getInt("maNCC");
                String tenNCC = rs.getString("tenNCC");
                NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC);
                SanPham sp = new SanPham(maSP, tenSP, ghiChu, ncc);
                dsSP.add(sp);
            }
            config.JDBCUtil.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dsSP;

    }

    public ArrayList<SanPham> search(String search) {
        ArrayList<SanPham> dsSanPham = new ArrayList<>();
        Connection con = (Connection) config.JDBCUtil.getConnection();
        String sql = "select tb_SanPham.*,tb_NCC.tenNCC "
                + "from tb_SanPham,tb_NCC "
                + "where tb_SanPham.maNCC = tb_NCC.maNCC "
                + "and (tb_SanPham.maSP like ? or tb_SanPham.tenSP like ?)";

        try {
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, "%" + search + "%");
            p.setString(2, "%" + search + "%");
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                String ghiChu = rs.getString("ghiChu");
                int maNCC = rs.getInt("maNCC");
                String tenNCC = rs.getString("tenNCC");
                NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC);
                SanPham sp = new SanPham(maSP, tenSP, ghiChu, ncc);

                dsSanPham.add(sp);

            }
            config.JDBCUtil.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dsSanPham;

    }

    public void delete(String id) {

        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "delete from tb_SanPham where maSP=?";

            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, id);
            p.executeUpdate();

            config.JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void edit(SanPham data) {

        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "update tb_SanPham set tenSP=?,ghiChu=?,maNCC=? where maSP=?";

            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, data.getTenSP());
            p.setString(2, data.getGhiChu());
            p.setInt(3, data.getNhaCungCap().getMaNCC());
            p.setString(4, data.getMaSP());

            p.executeUpdate();

            config.JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public boolean create(SanPham data) {
        int result = 0;

        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "INSERT INTO tb_SanPham(maSP,tenSP,ghiChu,maNCC) "
                    + "VALUES(?,?,?,?)";
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, data.getMaSP());
            p.setString(2, data.getTenSP());
            p.setString(3, data.getGhiChu());
            p.setInt(4, data.getNhaCungCap().getMaNCC());

            result = p.executeUpdate();

            config.JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result > 0;
    }

}
