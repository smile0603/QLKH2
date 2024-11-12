package entity;

import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

public class PhieuXuat {
    private int maPX;
    private NhanVien nhanVien;
    private NhaCungCap nhaCungCap;
    private SanPham sanPham;
    private Date ngayXuat;
    private int soLuong;
    private double donGia;
    private double chietKhau;
    private double thanhTien;
    private String ghiChu;
    private KhachHang khachHang;

    public int getMaPX() {
        return maPX;
    }

    public void setMaPX(int maPX) {
        this.maPX = maPX;
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

    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
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

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public PhieuXuat(int maPX, NhanVien nhanVien, NhaCungCap nhaCungCap, SanPham sanPham, Date ngayXuat, int soLuong, double donGia, double chietKhau, double thanhTien, String ghiChu, KhachHang khachHang) {
        this.maPX = maPX;
        this.nhanVien = nhanVien;
        this.nhaCungCap = nhaCungCap;
        this.sanPham = sanPham;
        this.ngayXuat = ngayXuat;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.chietKhau = chietKhau;
        this.thanhTien = thanhTien;
        this.ghiChu = ghiChu;
        this.khachHang = khachHang;
    }

    public PhieuXuat() {
    }
        public Object[] toTableRow(int rowNum){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        NumberFormat nf = new DecimalFormat("$ #, ##0.##");
        
        
        return new Object[]{false, rowNum,this,sanPham,nhaCungCap,nhanVien,khachHang,ngayXuat== null ? "":df.format(ngayXuat),soLuong,donGia,thanhTien,ghiChu};
    }
    public Object[] toTableRow2(int rowNum){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        NumberFormat nf = new DecimalFormat("$ #, ##0.##");
        
        
        return new Object[]{rowNum,this,sanPham,nhaCungCap,nhanVien,khachHang,ngayXuat == null ? "":df.format(ngayXuat),soLuong,donGia,chietKhau,thanhTien,ghiChu};
    }

    @Override
    public String toString() {
        return Integer.toString(maPX);
    }
    
    
    
}
