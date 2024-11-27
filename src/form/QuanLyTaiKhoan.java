package form;

import DAO.UserDAO;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;

import entity.User;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import raven.toast.Notifications;
import table.CheckBoxTableHeaderRenderer;
import table.TableHeaderAligment;

public class QuanLyTaiKhoan extends javax.swing.JFrame {

    private UserDAO userDAO = new UserDAO();

    public QuanLyTaiKhoan() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        init();
    }

    private void init() {
        GlassPanePopup.install(this);
        Notifications.getInstance().setJFrame(this);
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$Table.background");

        table.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");

        table.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:30;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Table.background;");

        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +5;");

        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Tìm kiếm...");
        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("icon/Search.svg"));
        txtSearch.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin: 5,20,5,20;"
                + "background:$Panel.background");

        table.getColumnModel().getColumn(0).setHeaderRenderer(new CheckBoxTableHeaderRenderer(table, 0));
        table.getTableHeader().setDefaultRenderer(new TableHeaderAligment(table));
        try {
            config.JDBCUtil.getConnection();
            loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        lbTitle = new javax.swing.JLabel();
        btnXoa = new swing.ButtonAction();
        btnChinhSua = new swing.ButtonAction();
        bntThem = new swing.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chọn", "#", "Tài khoản", "Mật khẩu", "Tên người dùng", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll.setViewportView(table);

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lbTitle.setText("Tìm kiếm");

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/remove.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnChinhSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pen.png"))); // NOI18N
        btnChinhSua.setText("Chỉnh sửa");
        btnChinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaActionPerformed(evt);
            }
        });

        bntThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        bntThem.setText("Thêm");
        bntThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bntThem, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        searchData(txtSearch.getText().trim());
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        List<User> list = getSelectedData();
        if (!list.isEmpty()) {
            DefaultOption option = new DefaultOption() {
                @Override
                public boolean closeWhenClickOutside() {
                    return true;
                }

            };
            String actions[] = new String[]{"Hủy", "Xóa"};
            JLabel label = new JLabel("Bạn có muốn xóa " + list.size() + " tài khoản");
            label.setBorder(new EmptyBorder(0, 25, 0, 25));
            UserDAO userDAO = new UserDAO();
            GlassPanePopup.showPopup(new SimplePopupBorder(label, "Xác nhận xóa", actions, (pc, i) -> {
                if (i == 1) {
                    //Delete
                    try {
                        for (User u : list) {
                            userDAO.delete(u.getUserName());
                        }
                        pc.closePopup();
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, "Xóa thành công!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    loadData();
                } else {
                    pc.closePopup();
                }
            }), option);

        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Chọn dòng cần xoá");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaActionPerformed
        // TODO add your handling code here:
        List<User> list = getSelectedData();
        if (!list.isEmpty()) {
            if (list.size() == 1) {
                User user = list.get(0);
                UserDAO userDAO = new UserDAO();
                Form_ThemUser form_ThemUser = new Form_ThemUser();
                form_ThemUser.loadData(userDAO, user);
                form_ThemUser.setNoEditUserName();
                
                DefaultOption option = new DefaultOption() {
                    @Override
                    public boolean closeWhenClickOutside() {
                        return true;
                    }

                };
                String actions[] = new String[]{"Hủy", "Chỉnh sửa"};
                GlassPanePopup.showPopup(new SimplePopupBorder(form_ThemUser, "Chỉnh sửa tài khoản", actions, (pc, i) -> {
                    if (i == 1) {
                        //Edit
                        try {
                            if(form_ThemUser.validData() == true){
                                User userEdit = form_ThemUser.getDataFromInput();
                                userEdit.setUserName(user.getUserName());
                                userDAO.edit(userEdit);
                                pc.closePopup();
                                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Chỉnh sửa thành công!");
                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        loadData();
                    } else {
                        pc.closePopup();
                    }
                }), option);
            } else {
                Notifications.getInstance().show(Notifications.Type.WARNING, "Chỉ chọn một tài khoản");
            }
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Chọn dòng cần chỉnh sửa");
        }
    }//GEN-LAST:event_btnChinhSuaActionPerformed

    private void bntThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntThemActionPerformed
        Form_ThemUser form_ThemUser = new Form_ThemUser();

        DefaultOption option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }

        };
        String actions[] = new String[]{"Hủy", "Lưu"};
        GlassPanePopup.showPopup(new SimplePopupBorder(form_ThemUser, "Thêm tài khoản", actions, (pc, i) -> {
            if (i == 1) {
                //Save
                try {
                    if(form_ThemUser.validData() == true){
                        userDAO.create(form_ThemUser.getDataFromInput());
                        pc.closePopup();
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, "Thêm thành công!");
                        loadData();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                pc.closePopup();
            }
        }), option);
    }//GEN-LAST:event_bntThemActionPerformed

//    public static void main(String args[]) {
//        FlatRobotoFont.install();
//        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
//        FlatMacLightLaf.setup();
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new QuanLyTaiKhoan().setVisible(true);
//            }
//        });
//    }
    private List<User> getSelectedData() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < table.getRowCount(); i++) {
            if ((boolean) table.getValueAt(i, 0)) {
                User u = (User) table.getValueAt(i, 2); // Lien quan toi method toTableRow
                list.add(u);
            }

        }
        return list;
    }

    private void loadData() {
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            if (table.isEditing()) {
                table.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<User> listUser = userDAO.getAllUser();
            for (User u : listUser) {
                model.addRow(u.toTableRow2(table.getRowCount() + 1));
            }
        } catch (Exception e) {
        }
    }

    private void searchData(String search) {
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            if (table.isEditing()) {
                table.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<User> listUser = userDAO.search(search);
            for (User u : listUser) {
                model.addRow(u.toTableRow2(table.getRowCount() + 1));
            }
        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonAction bntThem;
    private swing.ButtonAction btnChinhSua;
    private swing.ButtonAction btnXoa;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
