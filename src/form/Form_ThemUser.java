package form;

import DAO.UserDAO;
import entity.User;

public class Form_ThemUser extends javax.swing.JPanel {

    public Form_ThemUser() {
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
        return new User(userName, txtpassWord, fullName, email);

    }

    public void loadData(UserDAO userDAO, User data) {

        if (data != null) {
            txtUserName.setText(data.getUserName());
            txtpassWord.setText(data.getPassWord());
            txtFullName.setText(data.getFullName());
            txtEmail.setText(data.getMail());
        }
    }
    public boolean checkUserName(String userName){
        UserDAO userDAO = new UserDAO();
        try {
            for (User u : userDAO.getAllUser()) {
                if(u.getUserName().trim().equals(userName.trim()))
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean validData() {
        String userName = txtUserName.getText().trim();
        String fullName = txtFullName.getText().trim();
        String txtpassWord = String.valueOf(this.txtpassWord.getPassword());
        String email = txtEmail.getText().trim();
        
        if (!(userName.length() > 0 && userName.matches("[A-Za-z0-9_-]{6,12}$"))) {
            lbNotification.setText("Tài khoản gồm 6-12 kí tự và không chứa khoảng trắng");
            return false;
        }
        if(checkUserName(userName) == true){
            lbNotification.setText("Tài khoản đã tồn tại");
            return false;
        }
        if (!(txtpassWord.length() > 0 && txtpassWord.matches("[a-z0-9_-]{6,12}$"))) {
            lbNotification.setText("Mật khẩu gồm 6-12 kí tự và không chứa khoảng trắng");
            return false;
        }
        if (!(email.length() > 0 && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))) {
            lbNotification.setText("Email không hợp lệ");
            return false;
        }
        if (!(fullName.length() > 0 && fullName.matches("[\\w\\dÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]+"))) {
            lbNotification.setText("Tên không hợp lệ không hợp lệ");
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUserName = new swing.TextField();
        txtFullName = new swing.TextField();
        txtEmail = new swing.TextField();
        txtpassWord = new swing.PasswordField();
        confirmPass = new swing.PasswordField();
        lbNotification = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        txtUserName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtFullName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbNotification.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbNotification.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFullName, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addComponent(txtpassWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(confirmPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNotification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(lbNotification)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
    private javax.swing.JLabel lbNotification;
    private swing.TextField txtEmail;
    private swing.TextField txtFullName;
    private swing.TextField txtUserName;
    private swing.PasswordField txtpassWord;
    // End of variables declaration//GEN-END:variables
}
