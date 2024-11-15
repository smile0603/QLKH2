package entity;


public class KhachHang {
    private String maKH;
    private String tenKH;
    private String email;
    private String diaChi;
    private String sdt;
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    

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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public KhachHang() {
    }

    public KhachHang(String maKH, String tenKH) {
        this.maKH = maKH;
        this.tenKH = tenKH;
    }

    public KhachHang(String maKH, String tenKH, String email, String diaChi, String sdt) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.email = email;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }
    public Object[] toTableRow(int rowNum){
        return new Object[]{false,rowNum,maKH,this,diaChi,email,sdt};
    }
    public Object[] toTableRow2(int rowNum){
        return new Object[]{rowNum,maKH,this,email,diaChi,sdt};
    }
    @Override
    public String toString() {
        return tenKH;
    }
    

    
    
}
