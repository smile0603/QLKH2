package DAO;

import entity.NhanVien;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {

    public static UserDAO getInstance() {
        return new UserDAO();
    }

    public User getUserNamePassWord() {
        User user = null;
        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "SELECT userName,passWord FROM tb_User";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                String userName = rs.getString("userName");
                String passWord = rs.getString("passWord");
                user = new User(userName, passWord);

            }

            config.JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User selectByUserName(String userName) {
        User user = null;
        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "SELECT * FROM tb_User WHERE userName = ?";
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, userName);
            ResultSet rs = (ResultSet) p.executeQuery();
            while (rs.next()) {
                String taiKhoan = rs.getString("userName");
                String matKhau = rs.getString("passWord");
                user = new User(taiKhoan, matKhau);

            }
            config.JDBCUtil.closeConnection(con);

        } catch (SQLException e) {

        }
        return user;

    }

    public ArrayList<User> getUserInfo() {
        ArrayList<User> userList = new ArrayList<>();
        Connection con = (Connection) config.JDBCUtil.getConnection();
        String sql = "select tb_User.userName, tb_User.fullName,tb_User.email "
                + "from tb_User";

        try {
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                String userName = rs.getString("userName");
                String fullName = rs.getString("fullName");
                String email = rs.getString("email");
                User u = new User(userName, fullName, email);
                userList.add(u);
            }
            config.JDBCUtil.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userList;
    }

    public ArrayList<User> getAllUser() {
        ArrayList<User> userList = new ArrayList<>();
        Connection con = (Connection) config.JDBCUtil.getConnection();
        String sql = "select * from tb_User";

        try {
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                String userName = rs.getString("userName");
                String passWord = rs.getString("passWord");
                String fullName = rs.getString("fullName");
                String email = rs.getString("email");
                User u = new User(userName, passWord, fullName, email);
                userList.add(u);
            }
            config.JDBCUtil.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userList;
    }

    public void delete(String id) {

        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "delete from tb_User where userName=?";

            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, id);
            p.executeUpdate();

            config.JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<User> search(String search) {
        ArrayList<User> listUser = new ArrayList<>();
        Connection con = (Connection) config.JDBCUtil.getConnection();
        String sql = "select * from tb_User "
                + "where tb_User.userName like ? or tb_User.fullName like ?";

        try {
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, "%" + search + "%");
            p.setString(2, "%" + search + "%");
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                String userName = rs.getString("userName");
                String passWord = rs.getString("passWord");
                String fullName = rs.getString("fullName");
                String email = rs.getString("email");
                User u = new User(userName, passWord, fullName, email);
                listUser.add(u);

            }
            config.JDBCUtil.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listUser;

    }

    public void edit(User data) {

        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "update tb_User set passWord=?,fullName=?,email=? where userName=?";

            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);

            p.setString(1, data.getPassWord());
            p.setString(2, data.getFullName());
            p.setString(3, data.getMail());
            p.setString(4, data.getUserName());
            p.executeUpdate();

            config.JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public boolean create(User data) {
        int result = 0;

        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            String sql = "INSERT INTO tb_User(userName,passWord,fullName,email) "
                    + "VALUES(?,?,?,?)";
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, data.getUserName());
            p.setString(2, data.getPassWord());
            p.setString(3, data.getFullName());
            p.setString(4, data.getMail());
            result = p.executeUpdate();

            config.JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result > 0;
    }

}
