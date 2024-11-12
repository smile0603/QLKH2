package entity;

public class SanPham {

    private String maSP;
    private String tenSP;
    private String ghiChu;
    private NhaCungCap nhaCungCap;

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public SanPham(String maSP, String tenSP, String ghiChu, NhaCungCap nhaCungCap) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.ghiChu = ghiChu;
        this.nhaCungCap = nhaCungCap;
    }

    public SanPham(String maSP, String tenSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    public SanPham() {
    }

    public Object[] toTableRow(int rowNum) {

        return new Object[]{false, rowNum,maSP, this, ghiChu, nhaCungCap};
    }

    public Object[] toTableRow2(int rowNum) {


        return new Object[]{rowNum,maSP, this, ghiChu, nhaCungCap};
    }

    @Override
    public String toString() {
        return tenSP;
    }

}
