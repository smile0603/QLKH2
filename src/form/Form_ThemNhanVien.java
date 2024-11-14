package form;

import DAO.NhanVienDAO;
import entity.NhanVien;

public class Form_ThemNhanVien extends javax.swing.JPanel {
    private NhanVienDAO nhanVienDAO = new NhanVienDAO();
    public Form_ThemNhanVien() {
        initComponents();

        txtMaNV.setLabelText("Mã nhân viên");
        txtTenNV.setLabelText("Tên nhân viên");
        txtEmail.setLabelText("Email");
        txtSDT.setLabelText("Số điện thoại");
    }

    public NhanVien getDataFromText() {
        String maNV = txtMaNV.getText().trim();
        String tenNV = txtTenNV.getText().trim();
        String email = txtEmail.getText().trim();
        int sdt = Integer.parseInt(txtSDT.getText().trim());
        return new NhanVien(maNV, tenNV, email, sdt);


    }

    public void loadData(NhanVienDAO nhanVienDAO, NhanVien nv) {
        if (nv != null) {
            txtMaNV.setText(nv.getMaNV());
            txtTenNV.setText(nv.getTenNV());
            txtEmail.setText(nv.getMail());
            txtSDT.setText(Integer.toString(nv.getSdt()));
        }
    }

    public boolean validData() {
        String maNV = txtMaNV.getText().trim();
        String tenNV = txtTenNV.getText().trim();
        String email = txtEmail.getText().trim();
        String sdt = txtSDT.getText().trim();
        if (!(maNV.length() > 0 && maNV.matches("[A-Z]{2}\\d{4}"))) {
            lbNotification.setText("Mã NV có định dạng (vd: VP2048)");
            return false;
        }
        if (!(tenNV.length() > 0 && tenNV.matches("[\\wÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]+"))) {
            lbNotification.setText("Tên nhân viên không hợp lệ");
            return false;
        }
        if (!(email.length() > 0 && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))) {
            lbNotification.setText("Email không hợp lệ");
            return false;
        }
        
        if (!(sdt.length() > 0 && sdt.matches("([0]+(3|5|7|8|9|1[2|6|8|9]))+([0-9]{8})\\b"))) {
            lbNotification.setText("Số điện thoại không hợp lệ");
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtMaNV = new swing.TextField();
        txtTenNV = new swing.TextField();
        txtEmail = new swing.TextField();
        txtSDT = new swing.TextField();
        lbNotification = new javax.swing.JLabel();

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
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lbNotification)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
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
    private swing.TextField txtMaNV;
    private swing.TextField txtSDT;
    private swing.TextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
