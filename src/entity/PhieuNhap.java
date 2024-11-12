package entity;

import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.text.NumberFormat;
public class PhieuNhap {

    public int getMaPN() {
        return maPN;
    }

    public void setMaPN(int maPN) {
        this.maPN = maPN;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getChietKhau() {
        return chietKhau;
    }

    public void setChietKhau(double chietKhau) {
        this.chietKhau = chietKhau;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    private int maPN;
    private NhanVien nhanVien;
    private NhaCungCap nhaCungCap;
    private SanPham sanPham;
    private Date ngayNhap;
    private int soLuong;
    private double donGia;
    private double chietKhau;
    private double thanhTien;
    private String ghiChu;

    public PhieuNhap() {
    }

    public PhieuNhap(int maPN, SanPham sanPham, NhaCungCap nhaCungCap,NhanVien nhanVien , Date ngayNhap, int soLuong, double donGia, double chietKhau, double thanhTien, String ghiChu) {
        this.maPN = maPN;
        this.sanPham = sanPham;
        this.nhaCungCap = nhaCungCap;
        this.nhanVien = nhanVien;
        this.ngayNhap = ngayNhap;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.chietKhau = chietKhau;
        this.thanhTien = thanhTien;
        this.ghiChu = ghiChu;
    }
    public Object[] toTableRow(int rowNum){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        NumberFormat nf = new DecimalFormat("$ #, ##0.##");
        
        
        return new Object[]{false, rowNum,this,sanPham,nhaCungCap,nhanVien,ngayNhap == null ? "":df.format(ngayNhap),soLuong,donGia,thanhTien,ghiChu};
    }
    public Object[] toTableRow2(int rowNum){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        NumberFormat nf = new DecimalFormat("$ #, ##0.##");
        
        
        return new Object[]{rowNum,this,sanPham,nhaCungCap,nhanVien,ngayNhap == null ? "":df.format(ngayNhap),soLuong,donGia,chietKhau,thanhTien,ghiChu};
    }

    @Override
    public String toString() {
        return Integer.toString(maPN);
    }
    
    
    
    
}
