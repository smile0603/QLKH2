package form;

import DAO.NhaCungCapDAO;
import entity.NhaCungCap;

public class Form_ThemNhaCungCap extends javax.swing.JPanel {

    public Form_ThemNhaCungCap() {
        initComponents();

        txtTenNCC.setLabelText("Tên nhà cung cấp");
        txtdiaChiNCC.setLabelText("Địa chỉ");
        txtEmailNCC.setLabelText("Email");
        txtSdtNCC.setLabelText("Số điện thoại");
    }

    @SuppressWarnings("unchecked")
    public NhaCungCap getData() {
        String tenNCC = txtTenNCC.getText().trim();
        String diaChi = txtdiaChiNCC.getText().trim();
        String emailNCC = txtEmailNCC.getText().trim();
        int sdtNCC = Integer.parseInt(txtSdtNCC.getText().trim());
        NhaCungCap ncc = new NhaCungCap(0, tenNCC, diaChi, emailNCC, sdtNCC);
        return ncc;

    }

    public void loadData(NhaCungCapDAO nccDAO, NhaCungCap ncc) {
        if (ncc != null) {
            txtTenNCC.setText(ncc.getTenNCC());
            txtdiaChiNCC.setText(ncc.getDiaChi());
            txtEmailNCC.setText(ncc.getEmail());
            txtSdtNCC.setText(Integer.toString(ncc.getSdtNCC()));
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTenNCC = new swing.TextField();
        txtdiaChiNCC = new swing.TextField();
        txtEmailNCC = new swing.TextField();
        txtSdtNCC = new swing.TextField();
        lbNotification = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lbNotification.setBackground(new java.awt.Color(255, 255, 255));
        lbNotification.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbNotification.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSdtNCC, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addComponent(txtEmailNCC, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addComponent(txtdiaChiNCC, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addComponent(txtTenNCC, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addComponent(lbNotification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lbNotification)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtdiaChiNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtEmailNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtSdtNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    	public boolean validData() {
        String tenNCC = txtTenNCC.getText().trim();
        String diaChi = txtdiaChiNCC.getText().trim();
        String emailNCC = txtEmailNCC.getText().trim();
        String sdtNCC = txtSdtNCC.getText().trim();
        if (!(tenNCC.length() > 0 && tenNCC.matches("[\\w\\d\\/ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]+"))) {
            lbNotification.setText("Tên nhà cung cấp không hợp lệ");
            return false;
        }
        if (!(emailNCC.length() > 0 && emailNCC.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))) {
            lbNotification.setText("Email không hợp lệ");
            return false;
        }
        if (!(diaChi.length() > 0 && diaChi.matches("[\\w\\d\\\\/\\\\,\\\\.ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]+"))) {
            lbNotification.setText("Địa chỉ không hợp lệ");
            return false;
        }
        if (!(sdtNCC.length() > 0 && sdtNCC.matches("([\\+84|84|0]+(3|5|7|8|9|1[2|6|8|9]))+([0-9]{8})\\b"))) {
            lbNotification.setText("Số điện thoại không hợp lệ");
            return false;
        }

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbNotification;
    private swing.TextField txtEmailNCC;
    private swing.TextField txtSdtNCC;
    private swing.TextField txtTenNCC;
    private swing.TextField txtdiaChiNCC;
    // End of variables declaration//GEN-END:variables
}
