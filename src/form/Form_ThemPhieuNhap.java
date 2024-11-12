package form;

import DAO.PhieuNhapDAO;
import entity.NhanVien;
import entity.PhieuNhap;
import entity.SanPham;
import entity.NhaCungCap;
import java.sql.Date;

public class Form_ThemPhieuNhap extends javax.swing.JPanel {


    public Form_ThemPhieuNhap() {
        initComponents();
        
        cbbNhaCC.setSelectedIndex(-1);
        cbbNhaCC.setLabeText("Tên nhà cung cấp");
        cbbNV.setLabeText("Nhân viên");
        cbbNV.setSelectedIndex(-1);
        cbbSanPham.setLabeText("Tên sản phẩm");
        cbbSanPham.setSelectedIndex(-1);
        
        txtMaPN.setLabelText("Mã phiếu nhập");
        txtMaPN.setEditable(false);
        txtSoLuong.setLabelText("Số lượng");
        txtDonGia.setLabelText("Đơn giá");
        txtChietKhau.setLabelText("Chiết khấu");
        txtThanhTien.setLabelText("Thành tiền");
        txtThanhTien.setEditable(false);
        txtGhiChu.setLabelText("Ghi chú");
        
        
        
        datePicker.setCloseAfterSelected(true);
        datePicker.setEditor(txtDate);
    }
    
    // get name tbNhanVien to combo box NhanVien
    public void loadDataCbbNhanVien(PhieuNhapDAO phieunhapDAO){
        try {
            for(NhanVien nv : phieunhapDAO.getNhanVienDAO().getAllNhanVien()){
                cbbNV.addItem(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadDataCbbSanPham(PhieuNhapDAO phieunhapDAO){
        try {
            for(SanPham sp : phieunhapDAO.getSanPhamDAO().getAllSanPham()){
                cbbSanPham.addItem(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadDataCbbNhaCungCap(PhieuNhapDAO phieunhapDAO){
        try {
            for(NhaCungCap ncc : phieunhapDAO.getNhaCungCapDAO().getAllNhaCungCap()){
                cbbNhaCC.addItem(ncc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    
    public PhieuNhap getDataFromInput(){
        SanPham sp = (SanPham) cbbSanPham.getSelectedItem();
        NhaCungCap ncc = (NhaCungCap) cbbNhaCC.getSelectedItem();
        NhanVien nv = (NhanVien) cbbNV.getSelectedItem();
        Date ngayNhap = datePicker.isDateSelected() ? Date.valueOf(datePicker.getSelectedDate()) : null;
        int soLuong = Integer.parseInt(txtSoLuong.getText().trim());
        double donGia = Double.parseDouble(txtDonGia.getText().trim());
        double chietKhau = Double.parseDouble(txtChietKhau.getText().trim());
        double thanhTien = (soLuong * donGia) - (soLuong * donGia * (chietKhau/100));
        String ghiChu = txtGhiChu.getText().trim();
        return new PhieuNhap(0, sp, ncc, nv, ngayNhap, soLuong, donGia, chietKhau, thanhTien, ghiChu);
        
    }
    public void loadData(PhieuNhapDAO phieuNhapDAO, PhieuNhap data){
       try {
            for(NhaCungCap ncc : phieuNhapDAO.getNhaCungCapDAO().getAllNhaCungCap()){
                cbbNhaCC.addItem(ncc);
                if(data != null && data.getNhaCungCap().getMaNCC() == ncc.getMaNCC()){
                    cbbNhaCC.setSelectedItem(ncc);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       try {
            for(NhanVien nv : phieuNhapDAO.getNhanVienDAO().getAllNhanVien()){
                cbbNV.addItem(nv);
                if(data != null && data.getNhanVien().getMaNV() == nv.getMaNV()){
                    cbbNV.setSelectedItem(nv);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       try {
            for(SanPham sp : phieuNhapDAO.getSanPhamDAO().getAllSanPham()){
                cbbSanPham.addItem(sp);
                if(data != null && data.getSanPham().getMaSP() == sp.getMaSP()){
                    cbbSanPham.setSelectedItem(sp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(data != null){
            if(data.getNgayNhap() != null){
                datePicker.setSelectedDate(data.getNgayNhap().toLocalDate());
            }
            
            txtGhiChu.setText(data.getGhiChu());
            txtSoLuong.setText(Integer.toString(data.getSoLuong()));
            txtDonGia.setText(Double.toString(data.getDonGia()));
            txtChietKhau.setText(Double.toString(data.getChietKhau()));
            txtThanhTien.setText(Double.toString(data.getThanhTien()));
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datePicker = new raven.datetime.component.date.DatePicker();
        jPanel1 = new javax.swing.JPanel();
        txtMaPN = new swing.TextField();
        jLabel2 = new javax.swing.JLabel();
        txtDate = new javax.swing.JFormattedTextField();
        cbbNhaCC = new swing.Combobox<>();
        txtSoLuong = new swing.TextField();
        txtDonGia = new swing.TextField();
        cbbNV = new swing.Combobox<>();
        txtChietKhau = new swing.TextField();
        txtThanhTien = new swing.TextField();
        txtGhiChu = new swing.TextField();
        cbbSanPham = new swing.Combobox<>();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtMaPN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Ngày nhập");

        cbbNhaCC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtDonGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbbNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtChietKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtThanhTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbbSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbbNV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDate)
                            .addComponent(cbbNhaCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaPN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(txtGhiChu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtChietKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(cbbNhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbNV, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtChietKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Combobox<Object> cbbNV;
    private swing.Combobox<Object> cbbNhaCC;
    private swing.Combobox<Object> cbbSanPham;
    private raven.datetime.component.date.DatePicker datePicker;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private swing.TextField txtChietKhau;
    private javax.swing.JFormattedTextField txtDate;
    private swing.TextField txtDonGia;
    private swing.TextField txtGhiChu;
    private swing.TextField txtMaPN;
    private swing.TextField txtSoLuong;
    private swing.TextField txtThanhTien;
    // End of variables declaration//GEN-END:variables
}
