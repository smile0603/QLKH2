package DAO;

import entity.SanPham;
import entity.ThongKeNgay;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThongKeDAO {

    public static ThongKeDAO getInstance() {
        return new ThongKeDAO();
    }

    public ArrayList<ThongKeNgay> getThongKeTuNgay(Date dateFrom, Date dateTo) {
        ArrayList<ThongKeNgay> listThongKe = new ArrayList<>();

        String sql = "with nhap as( "
                + "select tb_PhieuNhap.maSP, sum(tb_PhieuNhap.soLuongNhap) as tongNhap "
                + "from tb_PhieuNhap "
                + "where tb_PhieuNhap.ngayNhap between ? and ? "
                + "group by tb_PhieuNhap.maSP"
                + "),"
                + "xuat as( "
                + "select tb_PhieuXuat.maSP, sum(tb_PhieuXuat.soLuongXuat) as tongXuat "
                + "from tb_PhieuXuat "
                + "where tb_PhieuXuat.ngayXuat between ? and ? "
                + "group by tb_PhieuXuat.maSP"
                + "),"
                + "ton as("
                + "select  tb_SanPham.maSP,nhap.tongNhap,xuat.tongXuat,"
                + "coalesce(nhap.tongNhap,0) - coalesce(xuat.tongXuat,0) as tongTon,tb_SanPham.tenSP "
                + "from tb_SanPham "
                + "left join nhap on nhap.maSP = tb_SanPham.maSP "
                + "left join xuat on xuat.maSP = tb_SanPham.maSP"
                + "),"
                + "nhaptruocky as("
                + "select tb_PhieuNhap.maSP, sum(tb_PhieuNhap.soLuongNhap) as tongNhapTK "
                + "from tb_PhieuNhap "
                + "where tb_PhieuNhap.ngayNhap < ? "
                + "group by tb_PhieuNhap.maSP "
                + "),"
                + "xuattruocky as( "
                + "select tb_PhieuXuat.maSP, sum(tb_PhieuXuat.soLuongXuat) as tongXuatTK "
                + "from tb_PhieuXuat "
                + "where tb_PhieuXuat.ngayXuat < ? "
                + "group by tb_PhieuXuat.maSP "
                + "),"
                + "tonTK as("
                + "select  tb_SanPham.maSP,nhaptruocky.tongNhapTK,xuattruocky.tongXuatTK, "
                + "coalesce(nhaptruocky.tongNhapTK,0) - coalesce(xuattruocky.tongXuatTK,0) as tongTonTK,tb_SanPham.tenSP "
                + "from tb_SanPham "
                + "left join nhaptruocky on nhaptruocky.maSP = tb_SanPham.maSP "
                + "left join xuattruocky on xuattruocky.maSP = tb_SanPham.maSP "
                + ")"
                + "select ton.*,tonTK.tongTonTK "
                + "from ton, tonTK "
                + "where ton.maSP = tonTK.maSP";
        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            df.format(dateFrom);
            df.format(dateTo);

            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setDate(1, dateFrom);
            p.setDate(2, dateTo);
            p.setDate(3, dateFrom);
            p.setDate(4, dateTo);
            p.setDate(5, dateFrom);
            p.setDate(6, dateFrom);
            ResultSet rs = p.executeQuery();

            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                int tongNhap = rs.getInt("tongNhap");
                int tongXuat = rs.getInt("tongXuat");
                int tonSauKy = rs.getInt("tongTon");
                int tonTruocKy = rs.getInt("tongTonTK");
                int tongTon = tonTruocKy + tonSauKy;
                SanPham sp = new SanPham(maSP, tenSP);
                ThongKeNgay thongKe = new ThongKeNgay(sp, tonTruocKy, tonSauKy, tongNhap, tongXuat, tongTon);
                listThongKe.add(thongKe);
            }
            config.JDBCUtil.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listThongKe;

    }

    public ArrayList<ThongKeNgay> getThongKeSP(String maSearch) {
        ArrayList<ThongKeNgay> listThongKe = new ArrayList<>();

        String sql = "with nhap as( "
                + "select tb_PhieuNhap.maSP, sum(tb_PhieuNhap.soLuongNhap) as tongNhap "
                + "from tb_PhieuNhap "
                + "where tb_PhieuNhap.maSP like ? "
                + "group by tb_PhieuNhap.maSP "
                + ")," 
                + "xuat as( "
                + "select tb_PhieuXuat.maSP, sum(tb_PhieuXuat.soLuongXuat) as tongXuat "
                + "from tb_PhieuXuat "
                + "where tb_PhieuXuat.maSP like ? "
                + "group by tb_PhieuXuat.maSP "
                + "),"
                + "ton as( "
                + "select tb_SanPham.maSP,nhap.tongNhap,xuat.tongXuat, "
                + "coalesce(nhap.tongNhap,0) - coalesce(xuat.tongXuat,0) as tongTon,tb_SanPham.tenSP "
                + "from tb_SanPham "
                + "left join nhap on nhap.maSP = tb_SanPham.maSP "
                + "left join xuat on xuat.maSP = tb_SanPham.maSP "
                + ")"
                + "select ton.* "
                + "from ton "
                + "where ton.maSP like ?";
        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, maSearch);
            p.setString(2, maSearch);
            p.setString(3, maSearch);
            ResultSet rs = p.executeQuery();

            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                int tongNhap = rs.getInt("tongNhap");
                int tongXuat = rs.getInt("tongXuat");
                int tongTon = rs.getInt("tongTon");
                SanPham sp = new SanPham(maSP, tenSP);
                ThongKeNgay thongKe = new ThongKeNgay(sp, tongNhap, tongXuat, tongTon);
                listThongKe.add(thongKe);
            }
            config.JDBCUtil.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listThongKe;

    }
        public ArrayList<ThongKeNgay> getThongKeAllSP() {
        ArrayList<ThongKeNgay> listThongKe = new ArrayList<>();

        String sql = "with nhap as( "
                + "select tb_PhieuNhap.maSP, sum(tb_PhieuNhap.soLuongNhap) as tongNhap "
                + "from tb_PhieuNhap "
                + "group by tb_PhieuNhap.maSP "
                + ")," 
                + "xuat as( "
                + "select tb_PhieuXuat.maSP, sum(tb_PhieuXuat.soLuongXuat) as tongXuat "
                + "from tb_PhieuXuat "
                + "group by tb_PhieuXuat.maSP "
                + "),"
                + "ton as( "
                + "select tb_SanPham.maSP,nhap.tongNhap,xuat.tongXuat, "
                + "coalesce(nhap.tongNhap,0) - coalesce(xuat.tongXuat,0) as tongTon,tb_SanPham.tenSP "
                + "from tb_SanPham "
                + "left join nhap on nhap.maSP = tb_SanPham.maSP "
                + "left join xuat on xuat.maSP = tb_SanPham.maSP "
                + ")"
                + "select ton.* "
                + "from ton ";
        try {
            Connection con = (Connection) config.JDBCUtil.getConnection();
            PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = p.executeQuery();

            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                int tongNhap = rs.getInt("tongNhap");
                int tongXuat = rs.getInt("tongXuat");
                int tongTon = rs.getInt("tongTon");
                SanPham sp = new SanPham(maSP, tenSP);
                ThongKeNgay thongKe = new ThongKeNgay(sp, tongNhap, tongXuat, tongTon);
                listThongKe.add(thongKe);
            }
            config.JDBCUtil.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listThongKe;

    }
}
