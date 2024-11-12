package form;

import DAO.UserDAO;
import entity.User;

public class Form_ThemTaiKhoan extends javax.swing.JPanel {

    public Form_ThemTaiKhoan() {
        initComponents();
        txtUserName.setLabelText("Tài khoản");
        txtpassWord.setLabelText("Mật khẩu");
        txtpassWord.setShowAndHide(true);
        confirmPass.setLabelText("Nhập lại mật khẩu");
        confirmPass.setShowAndHide(true);
        txtFullName.setLabelText("Họ & tên");
        txtEmail.setLabelText("Email");
    }

    public User getDataFromInput() {
        String userName = txtUserName.getText().trim();
        String fullName = txtFullName.getText().trim();
        String email = txtEmail.getText().trim();
        String txtpassWord = String.valueOf(this.txtpassWord.getPassword());
        return new User(userName,txtpassWord, fullName, email);

    }

    public void loadData(UserDAO userDAO, User data) {

        if (data != null) {
            txtUserName.setText(data.getUserName());
            txtpassWord.setText(data.getPassWord());
            txtFullName.setText(data.getFullName());
            txtEmail.setText(data.getMail());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUserName = new swing.TextField();
        txtFullName = new swing.TextField();
        txtEmail = new swing.TextField();
        txtpassWord = new swing.PasswordField();
        confirmPass = new swing.PasswordField();

        setBackground(new java.awt.Color(255, 255, 255));

        txtUserName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtFullName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                        .addComponent(txtUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                        .addComponent(txtpassWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirmPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtpassWord, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(confirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.PasswordField confirmPass;
    private swing.TextField txtEmail;
    private swing.TextField txtFullName;
    private swing.TextField txtUserName;
    private swing.PasswordField txtpassWord;
    // End of variables declaration//GEN-END:variables
}
