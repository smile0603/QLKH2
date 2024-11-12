package DAO;

import entity.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

    public static AdminDAO getInstance() {
        return new AdminDAO();
    }

    public Admin getUserNamePassWord() {
        Admin ad = null;
        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "SELECT userName,passWord FROM tb_Admin";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                String userName = rs.getString("userName");
                String passWord = rs.getString("passWord");
                ad = new Admin(userName, passWord);

            }

            config.JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ad;
    }

    public Admin selectByUserName(String userName) {
        Admin ad = null;
        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "SELECT * FROM tb_Admin WHERE userName = ?";
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, userName);
            ResultSet rs = (ResultSet) p.executeQuery();
            while (rs.next()) {
                String taiKhoan = rs.getString("userName");
                String matKhau = rs.getString("passWord");
                ad = new Admin(taiKhoan, matKhau);

            }
            config.JDBCUtil.closeConnection(con);

        } catch (SQLException e) {

        }
        return ad;

    }
}
