package entity;

public class NhanVien {
    private String maNV;
    private String tenNV;
    private String mail;
    private String sdt;

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public NhanVien() {
    }


    public NhanVien(String maNV, String tenNV, String mail, String sdt) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.mail = mail;
        this.sdt = sdt;
    }
    public NhanVien(String maNV, String tenNV) {
        this.maNV = maNV;
        this.tenNV = tenNV;

    }    
    public Object[] toTableRow(int rowNum){
        return new Object[]{false,rowNum,maNV,this,mail,sdt};
    }
    public Object[] toTableRow2(int rowNum){
        return new Object[]{rowNum,maNV,this,mail,sdt};
    }
    @Override
    public String toString() {
        return tenNV;
    }
    
    

        


    
}
