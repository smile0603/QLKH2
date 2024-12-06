package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class JDBCUtil {
    public static Connection getConnection(){
        Connection con = null;
        //final String url = "jdbc:sqlserver://localhost:1433;databasename = CSDL_QLK;encrypt=true;trustServerCertificate=true";
        final String url = "jdbc:sqlserver://localhost:1433;databasename = CSDL_QLK;encrypt=true;trustServerCertificate=true";
        final String user  = "sa";
        final  String password = "123456";
        try {
            con = DriverManager.getConnection(url,user,password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối đến cơ sở dữ liệu !", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return con;
        
    }
    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
