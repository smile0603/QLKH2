package form;

import DAO.KhachHangDAO;
import entity.KhachHang;

public class Form_ThemKhachHang extends javax.swing.JPanel {

    public Form_ThemKhachHang() {
        initComponents();
        txtMaKH.setLabelText("Mã khách hàng");
        txtTenKH.setLabelText("Tên khách hàng");
        txtdiaChi.setLabelText("Địa chỉ");
        txtEmail.setLabelText("Email");
        txtSDT.setLabelText("Số điện thoại");
    }

    public KhachHang getDataFromText() {
        String maKH = txtMaKH.getText().trim();
        String tenKH = txtTenKH.getText().trim();
        String diaChi = txtdiaChi.getText().trim();
        String email = txtEmail.getText().trim();
        String sdt = txtSDT.getText().trim();
        return new KhachHang(maKH, tenKH, email, diaChi, sdt);

    }

    public void loadData(KhachHangDAO khachHangDAO, KhachHang kh) {
        if (kh != null) {
            txtMaKH.setText(kh.getMaKH());
            txtTenKH.setText(kh.getTenKH());
            txtEmail.setText(kh.getEmail());
            txtdiaChi.setText(kh.getDiaChi());
            txtSDT.setText(kh.getSdt());
        }
    }

    public boolean validData() {
        String maKH = txtMaKH.getText().trim();
        String tenKH = txtTenKH.getText().trim();
        String diaChi = txtdiaChi.getText().trim();
        String email = txtEmail.getText().trim();
        String sdt = txtSDT.getText().trim();
        if (!(maKH.length() > 0 && maKH.matches("[A-Z]{2}\\d{3}"))) {
            lbNotification.setText("Mã KH có định dạng (vd: KH123)");
            return false;
        }
        if (!(tenKH.length() > 0 && tenKH.matches("[\\wÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]+"))) {
            lbNotification.setText("Tên khách hàng không hợp lệ");
            return false;
        }
        if (!(diaChi.length() > 0 && diaChi.matches("[\\w\\d\\\\/\\\\,\\\\.ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]+"))) {
            lbNotification.setText("Địa chỉ không hợp lệ");
            return false;
        }
        if (!(email.length() > 0 && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))) {
            lbNotification.setText("Email không hợp lệ");
            return false;
        }

        if (!(sdt.length() > 0 && sdt.matches("([\\+84|84|0]+(3|5|7|8|9|1[2|6|8|9]))+([0-9]{8})\\b"))) {
            lbNotification.setText("Số điện thoại không hợp lệ");
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtMaKH = new swing.TextField();
        txtTenKH = new swing.TextField();
        txtdiaChi = new swing.TextField();
        txtEmail = new swing.TextField();
        lbNotification = new javax.swing.JLabel();
        txtSDT = new swing.TextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbNotification.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbNotification.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbNotification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtdiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtdiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbNotification;
    private swing.TextField txtEmail;
    private swing.TextField txtMaKH;
    private swing.TextField txtSDT;
    private swing.TextField txtTenKH;
    private swing.TextField txtdiaChi;
    // End of variables declaration//GEN-END:variables
}
