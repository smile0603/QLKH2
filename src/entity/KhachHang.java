package entity;


public class KhachHang {
    private String maKH;
    private String tenKH;
    private String email;
    private String diaChi;

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    private int sdt;

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public KhachHang() {
    }

    public KhachHang(String maKH, String tenKH) {
        this.maKH = maKH;
        this.tenKH = tenKH;
    }

    public KhachHang(String maKH, String tenKH, String email, String diaChi, int sdt) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.email = email;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return tenKH;
    }
    

    
    
}
