package DAO;


import entity.NhanVien;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NhanVienDAO {

    public ArrayList<NhanVien> getAllNhanVien() {
        ArrayList<NhanVien> dsNV = new ArrayList<>();
        Connection con = (Connection) config.JDBCUtil.getConnection();
        String sql = "SELECT * FROM tb_NhanVien";

        try {
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
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

    public boolean create(NhanVien nv) {
        int result = 0;

        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "INSERT INTO tb_NhanVien(MaNV,tenNV,mail,sdt) VALUES(?,?,?,?)";
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);

            p.setString(1, nv.getMaNV());
            p.setString(2, nv.getTenNV());
            p.setString(3, nv.getMail());
            p.setInt(4, nv.getSdt());
            result = p.executeUpdate();

            config.JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result > 0;
    }

    public void edit(NhanVien nv){
        int result = 0;

        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "UPDATE tb_NhanVien set tenNV=?,mail=? ,sdt=? WHERE maNV=?";
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);

            p.setString(1, nv.getTenNV());
            p.setString(2, nv.getMail());
            p.setInt(3, nv.getSdt());
            p.setString(4, nv.getMaNV());
            result = p.executeUpdate();

            config.JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void delete(String id) {
        int result = 0;

        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "DELETE from tb_NhanVien where maNV =?";
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, id);
            result = p.executeUpdate();

            config.JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<NhanVien> search(String txtSearch) {
        ArrayList<NhanVien> dsNV = new ArrayList<>();
        Connection con = (Connection) config.JDBCUtil.getConnection();
        String sql = "SELECT * FROM tb_NhanVien WHERE (maNV LIKE ? or tenNV LIKE ?)";

        try {
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, "%" + txtSearch + "%");
            p.setString(2, "%" + txtSearch + "%");

            ResultSet rs = p.executeQuery();
            while (rs.next()) {
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
