package form;

import DAO.AdminDAO;
import entity.Admin;
import javax.swing.JOptionPane;




public class Form_QuanLyUser extends javax.swing.JPanel {


    public Form_QuanLyUser() {
        initComponents();
        txtAdmin.setLabelText("Tài khoản");
        passAdmin.setLabelText("Mật khẩu");
        passAdmin.setShowAndHide(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtAdmin = new swing.TextField();
        passAdmin = new swing.PasswordField();
        btnAdminLogin = new swing.ButtonAction();
        labelTK = new javax.swing.JLabel();
        labelMK = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtAdmin.setText("Admin");

        btnAdminLogin.setText("Login");
        btnAdminLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminLoginActionPerformed(evt);
            }
        });

        labelTK.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        labelTK.setForeground(new java.awt.Color(255, 51, 51));

        labelMK.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        labelMK.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTK, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMK, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(459, 459, 459)
                        .addComponent(btnAdminLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(353, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(labelTK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(labelMK)
                .addGap(18, 18, 18)
                .addComponent(passAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btnAdminLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(220, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminLoginActionPerformed
        // TODO add your handling code here:
        String userName = txtAdmin.getText().trim();
        String passWord = String.valueOf(passAdmin.getPassword());
        boolean action = true;
        //check tai khoan co null hay khong
        if (userName.equals("")) {
                labelTK.setText("Vui lòng nhập tài khoản");
                action = false;
            }
        //check tai khoan co null hay khong
        if (passWord.equals("")) {
                labelMK.setText("Vui lòng nhập mật khẩu");

            if (action) {
            }   
                action = false;
            }
        // kiem tra voi du lieu tu sql
        if (action) {
            Admin ad = AdminDAO.getInstance().selectByUserName(userName);
            if(ad == null){
                JOptionPane.showMessageDialog(this, "Tài khoản của bạn không tồn tại trên hệ thống", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                
            }
            else{

                if(ad.getPassWord().trim().equals(passWord)){
                    new QuanLyTaiKhoan().setVisible(true);
                   
                }
                else{
                    JOptionPane.showMessageDialog(this, "Sai mật khẩu", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                }
            }

        }
    }//GEN-LAST:event_btnAdminLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonAction btnAdminLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelMK;
    private javax.swing.JLabel labelTK;
    private swing.PasswordField passAdmin;
    private swing.TextField txtAdmin;
    // End of variables declaration//GEN-END:variables
}
