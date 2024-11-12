package entity;

public class ThongKeNgay {

    private SanPham sanPham;
    private int tonDauKy;
    private int tonCuoiKy;
    private int tongNhap;
    private int tongXuat;
    private int tongTon;

    public int getTongTon() {
        return tongTon;
    }

    public void setTongTon(int tongTon) {
        this.tongTon = tongTon;
    }
    

    public int getTongNhap() {
        return tongNhap;
    }

    public void setTongNhap(int tongNhap) {
        this.tongNhap = tongNhap;
    }

    public int getTongXuat() {
        return tongXuat;
    }

    public void setTongXuat(int tongXuat) {
        this.tongXuat = tongXuat;
    }

    public int getTonDauKy() {
        return tonDauKy;
    }

    public void setTonDauKy(int tonDauKy) {
        this.tonDauKy = tonDauKy;
    }

    public int getTonCuoiKy() {
        return tonCuoiKy;
    }

    public void setTonCuoiKy(int tonCuoiKy) {
        this.tonCuoiKy = tonCuoiKy;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public ThongKeNgay(SanPham sanPham, int tonDauKy, int tonCuoiKy, int tongNhap, int tongXuat, int tongTon) {
        this.sanPham = sanPham;
        this.tonDauKy = tonDauKy;
        this.tonCuoiKy = tonCuoiKy;
        this.tongNhap = tongNhap;
        this.tongXuat = tongXuat;
        this.tongTon = tongTon;
    }



    public ThongKeNgay() {
    }

    public Object[] toTableRow(int rowNum) {
        return new Object[]{rowNum, sanPham.getMaSP(), this, tonDauKy, tongNhap, tongXuat, tonCuoiKy,tongTon};
    }

    @Override
    public String toString() {
        return sanPham.getTenSP();
    }

}
