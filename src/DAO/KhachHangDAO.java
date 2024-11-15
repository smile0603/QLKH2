package DAO;

import entity.KhachHang;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KhachHangDAO {

    public ArrayList<KhachHang> getAllKhachHang() {
        ArrayList<KhachHang> dsKH = new ArrayList<>();
        Connection con = (Connection) config.JDBCUtil.getConnection();
        String sql = "SELECT * FROM tb_KhachHang";

        try {
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                String maKH = rs.getString("maKH");
                String tenKH = rs.getString("tenKH");
                String mail = rs.getString("email");
                String diaChi = rs.getString("diaChi");
                String sdt = rs.getString("sdt");

                KhachHang kh = new KhachHang(maKH, tenKH, mail,diaChi, sdt);
                dsKH.add(kh);
            }
            config.JDBCUtil.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dsKH;

    }

    public boolean create(KhachHang kh) {
        int result = 0;

        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "INSERT INTO tb_KhachHang(maKH,tenKH,email,sdt,diaChi) VALUES(?,?,?,?,?)";
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, kh.getMaKH());
            p.setString(2, kh.getTenKH());
            p.setString(3, kh.getEmail());
            p.setString(4, kh.getSdt());
            p.setString(5, kh.getDiaChi());
            result = p.executeUpdate();

            config.JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result > 0;
    }

    public void edit(KhachHang kh) {
        int result = 0;

        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "UPDATE tb_KhachHang set tenKH=?,email=?,sdt=?,diaChi=? WHERE maKH=?";
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);

            p.setString(1, kh.getTenKH());
            p.setString(2, kh.getEmail());
            p.setString(3, kh.getSdt());
            p.setString(4, kh.getDiaChi());
            p.setString(5, kh.getMaKH());
            result = p.executeUpdate();

            config.JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void delete(String id) {
        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "DELETE from tb_KhachHang where maKH=?";
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, id);
            p.executeUpdate();

            config.JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<KhachHang> search(String txtSearch) {
        ArrayList<KhachHang> dsKH = new ArrayList<>();
        Connection con = (Connection) config.JDBCUtil.getConnection();
        String sql = "SELECT * FROM tb_KhachHang WHERE (maKH LIKE ? or tenKH LIKE ?)";

        try {
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, "%" + txtSearch + "%");
            p.setString(2, "%" + txtSearch + "%");


            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                String maKH = rs.getString("maKH");
                String tenKH = rs.getString("tenKH");
                String email = rs.getString("email");
                String sdt = rs.getString("sdt");
                String diaChi = rs.getString("diaChi");
                KhachHang kh = new KhachHang(maKH, tenKH, email, diaChi, sdt);
                dsKH.add(kh);

            }
            config.JDBCUtil.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dsKH;

    }
}
