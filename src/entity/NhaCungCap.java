package entity;


public class NhaCungCap {
    private int maNCC;
    private String tenNCC;
    private String diaChi;
    private String email;
    private String sdtNCC;

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdtNCC() {
        return sdtNCC;
    }

    public void setSdtNCC(String sdtNCC) {
        this.sdtNCC = sdtNCC;
    }

    public NhaCungCap() {
    }

    public NhaCungCap(int maNCC, String tenNCC, String diaChi, String email, String sdtNCC) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.email = email;
        this.sdtNCC = sdtNCC;
    }
    
    public NhaCungCap(int maNCC) {
        this.maNCC = maNCC;
    }
    public NhaCungCap(int maNCC,String tenNCC){
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
    }
    public NhaCungCap(int maNCC, String tenNCC,String diaChi) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
    }
    
    public Object[] toTableRow(int rowNum){
        return new Object[]{false,rowNum,maNCC,this,diaChi,email,sdtNCC};
    }
    public Object[] toTableRow2(int rowNum){
        return new Object[]{rowNum,maNCC,tenNCC,diaChi,email,sdtNCC};
    }

    @Override
    public String toString() {
        return tenNCC;
    }
 
    
    

}
