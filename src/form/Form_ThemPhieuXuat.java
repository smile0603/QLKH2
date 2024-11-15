package form;

import DAO.PhieuNhapDAO;
import DAO.PhieuXuatDAO;
import entity.KhachHang;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.PhieuNhap;
import entity.PhieuXuat;
import entity.SanPham;
import java.sql.Date;

public class Form_ThemPhieuXuat extends javax.swing.JPanel {

    public Form_ThemPhieuXuat() {
        initComponents();
        cbbNhaCC.setSelectedIndex(-1);
        cbbNhaCC.setLabeText("Tên nhà cung cấp");
        cbbNV.setLabeText("Nhân viên");
        cbbNV.setSelectedIndex(-1);
        cbbSanPham.setLabeText("Tên sản phẩm");
        cbbSanPham.setSelectedIndex(-1);
        cbbKH.setLabeText("Khách hàng");
        cbbKH.setSelectedIndex(-1);
        txtMaPN.setLabelText("Mã phiếu xuất");
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

    public void loadDataCbbNhanVien(PhieuXuatDAO phieuXuatDAO) {
        try {
            for (NhanVien nv : phieuXuatDAO.getNhanVienDAO().getAllNhanVien()) {
                cbbNV.addItem(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadDataCbbSanPham(PhieuXuatDAO phieuXuatDAO) {
        try {
            for (SanPham sp : phieuXuatDAO.getSanPhamDAO().getAllSanPham()) {
                cbbSanPham.addItem(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadDataCbbNhaCungCap(PhieuXuatDAO phieuXuatDAO) {
        try {
            for (NhaCungCap ncc : phieuXuatDAO.getNhaCungCapDAO().getAllNhaCungCap()) {
                cbbNhaCC.addItem(ncc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadDataCbbKhachHang(PhieuXuatDAO phieuXuatDAO) {
        try {
            for (KhachHang kh : phieuXuatDAO.getKhachHangDAO().getAllKhachHang()) {
                cbbKH.addItem(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadData(PhieuXuatDAO phieuXuatDAO, PhieuXuat data) {
        loadDataCbbSanPham(phieuXuatDAO);
        loadDataCbbNhaCungCap(phieuXuatDAO);
        loadDataCbbNhanVien(phieuXuatDAO);
        loadDataCbbKhachHang(phieuXuatDAO);
        if (data != null) {
            if (data.getNgayXuat() != null) {
                datePicker.setSelectedDate(data.getNgayXuat().toLocalDate());
            }

            txtGhiChu.setText(data.getGhiChu());
            txtSoLuong.setText(Integer.toString(data.getSoLuong()));
            txtDonGia.setText(Double.toString(data.getDonGia()));
            txtChietKhau.setText(Double.toString(data.getChietKhau()));
            txtThanhTien.setText(Double.toString(data.getThanhTien()));

        }
    }

    public PhieuXuat getDataFromInput() {
        SanPham sp = (SanPham) cbbSanPham.getSelectedItem();
        NhaCungCap ncc = (NhaCungCap) cbbNhaCC.getSelectedItem();
        NhanVien nv = (NhanVien) cbbNV.getSelectedItem();
        KhachHang kh = (KhachHang) cbbKH.getSelectedItem();
        Date ngayXuat = datePicker.isDateSelected() ? Date.valueOf(datePicker.getSelectedDate()) : null;
        int soLuong = Integer.parseInt(txtSoLuong.getText().trim());
        double donGia = Double.parseDouble(txtDonGia.getText().trim());
        double chietKhau = Double.parseDouble(txtChietKhau.getText().trim());
        double thanhTien = (soLuong * donGia) - (soLuong * donGia * (chietKhau / 100));
        String ghiChu = txtGhiChu.getText().trim();
        return new PhieuXuat(0, nv, ncc, sp, ngayXuat, soLuong, donGia, chietKhau, thanhTien, ghiChu, kh);

    }
    public PhieuNhap getPhieuNhapTheoMa(){
        PhieuNhapDAO pnDAO = new PhieuNhapDAO();
        PhieuNhap pn = pnDAO.getSoLuongTheoMaSP();
        return pn;
    }
    
    public boolean validData() {
        String soLuong = txtSoLuong.getText().trim();
        String donGia = txtDonGia.getText().trim();
        String chietKhau = txtChietKhau.getText().trim();
        Date ngayXuat = datePicker.isDateSelected() ? Date.valueOf(datePicker.getSelectedDate()) : null;
        PhieuNhap pn = getPhieuNhapTheoMa();
        if (ngayXuat == null) {
            lbNotification.setText("Vui lòng chọn ngày xuất");
            return false;
        }
        if (!(soLuong.length() > 0 && soLuong.matches("[1|2|3|4|5|6|7|8|9]+[0-9]"))) {
            lbNotification.setText("Số lượng không hợp lệ");
            return false;
        }
        if(pn.getSoLuong() < Integer.parseInt(soLuong)){
            lbNotification.setText("Số lượng xuất > số lượng nhập");
        }
        if (!(donGia.length() > 0 && donGia.matches("^(\\d+\\.)?\\d+$"))) {
            lbNotification.setText("Đơn giá không hợp lệ");
            return false;
        }
        if (!(chietKhau.length() > 0 && chietKhau.matches("^(\\d+\\.)?\\d+$") && Double.parseDouble(chietKhau) <= 100)) {
            lbNotification.setText("Chiết khấu <= 100%");
            return false;
        }

        return true;
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
        cbbKH = new swing.Combobox<>();
        lbNotification = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtMaPN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Ngày xuất");

        cbbNhaCC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtDonGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbbNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtChietKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtThanhTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbbSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbbKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbNotification.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbNotification.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbbNV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbNhaCC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(txtMaPN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtChietKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbKH, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(txtGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(txtThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbNotification)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbKH, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbNhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(cbbNV, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(txtChietKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Combobox<Object> cbbKH;
    private swing.Combobox<Object> cbbNV;
    private swing.Combobox<Object> cbbNhaCC;
    private swing.Combobox<Object> cbbSanPham;
    private raven.datetime.component.date.DatePicker datePicker;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbNotification;
    private swing.TextField txtChietKhau;
    private javax.swing.JFormattedTextField txtDate;
    private swing.TextField txtDonGia;
    private swing.TextField txtGhiChu;
    private swing.TextField txtMaPN;
    private swing.TextField txtSoLuong;
    private swing.TextField txtThanhTien;
    // End of variables declaration//GEN-END:variables
}
