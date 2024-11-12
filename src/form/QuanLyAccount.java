package form;

import DAO.UserDAO;
import entity.User;
import javax.swing.JOptionPane;
import main.Main_Login;

public class QuanLyAccount extends javax.swing.JFrame {

    public QuanLyAccount() {
        User user_temp = new Main_Login().getUserTemp();
        String ut_TK = user_temp.getUserName();
        initComponents();
        txtUserName.setLabelText("Tài khoản");
        txtPassWordOld.setLabelText("Mật khẩu cũ");
        txtPassWordNew.setLabelText("Mật khẩu mới");
        txtConfirmPW.setLabelText("Nhập lại mật khẩu mới");
        txtPassWordOld.setShowAndHide(true);
        txtConfirmPW.setShowAndHide(true);
        txtPassWordNew.setShowAndHide(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        txtUserName.setText(ut_TK);
        txtUserName.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtUserName = new swing.TextField();
        bntChange = new swing.ButtonAction();
        txtConfirmPW = new swing.PasswordField();
        txtPassWordNew = new swing.PasswordField();
        txtPassWordOld = new swing.PasswordField();
        notiPWOld = new javax.swing.JLabel();
        notiConfirm = new javax.swing.JLabel();
        notiPWNew = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        bntChange.setText("Đổi mật khẩu");
        bntChange.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bntChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntChangeActionPerformed(evt);
            }
        });

        notiPWOld.setForeground(new java.awt.Color(255, 0, 51));

        notiConfirm.setForeground(new java.awt.Color(255, 51, 51));

        notiPWNew.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(bntChange, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtConfirmPW, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                            .addComponent(txtPassWordNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassWordOld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(notiPWOld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(notiConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(notiPWNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(notiPWOld)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassWordOld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(notiPWNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassWordNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(notiConfirm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirmPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(bntChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntChangeActionPerformed
        // TODO add your handling code here:
        User user_temp = new Main_Login().getUserTemp();
        UserDAO userDAO = new UserDAO();
        String userName = txtUserName.getText();
        String passWordOld = String.valueOf(txtPassWordOld.getPassword());
        String passWordNew = String.valueOf(txtPassWordNew.getPassword());
        String confirmPW = String.valueOf(txtConfirmPW.getPassword());
        boolean action = true;
        if (passWordOld.trim().equals("")) {
            notiPWOld.setText("Vui lòng nhập mật khẩu cũ");
            if (action) {
                txtPassWordOld.grabFocus();
            }
            action = false;
        }
        if (passWordNew.trim().equals("")) {
            notiPWNew.setText("Vui lòng nhập mật khẩu mới");
            if (action) {
                txtPassWordNew.grabFocus();
            }
            action = false;
        }
        if (confirmPW.trim().equals("")) {
            notiPWNew.setText("Vui lòng nhập lại mật khẩu mới");
            if (action) {
                txtConfirmPW.grabFocus();
            }
            action = false;
        }
        if (action) {
            if (user_temp == null) {
                JOptionPane.showMessageDialog(this, "Tài khoản của bạn không tồn tại trên hệ thống", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);

            } else {
                if (user_temp.getPassWord().trim().equals(passWordOld.trim())) {
                    if (passWordNew.trim().equals(confirmPW.trim())) {
                        User user_Change = new User(userName, passWordNew);
                        userDAO.changePassWord(user_Change);
                        JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công", "Thông báo", JOptionPane.OK_OPTION);
                        this.dispose();

                    } else {
                        notiConfirm.setText("Nhập lại mật khẩu mới không đúng");
                    }

                } else {
                    notiPWOld.setText("Mật khẩu cũ không đúng");
                }
            }

        }
    }//GEN-LAST:event_bntChangeActionPerformed

//    public static void main(String args[]) {
//        FlatRobotoFont.install();
//        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
//        FlatMacLightLaf.setup();
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new QuanLyAccount().setVisible(true);
//            }
//        });
//    }
    public void loadData(UserDAO userDAO, User data) {

        if (data != null) {
            txtUserName.setText(data.getUserName());

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonAction bntChange;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel notiConfirm;
    private javax.swing.JLabel notiPWNew;
    private javax.swing.JLabel notiPWOld;
    private swing.PasswordField txtConfirmPW;
    private swing.PasswordField txtPassWordNew;
    private swing.PasswordField txtPassWordOld;
    private swing.TextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
