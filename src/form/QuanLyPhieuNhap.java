package form;

import DAO.PhieuNhapDAO;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;

import entity.PhieuNhap;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

import javax.swing.border.EmptyBorder;
import raven.popup.DefaultOption;
import javax.swing.table.DefaultTableModel;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import raven.toast.Notifications;
import table.CheckBoxTableHeaderRenderer;
import table.TableHeaderAligment;

public class QuanLyPhieuNhap extends javax.swing.JFrame {

    private PhieuNhapDAO phieuNhapDAO = new PhieuNhapDAO();

    public QuanLyPhieuNhap() {
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
        lbTitle = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnThem = new swing.ButtonAction();
        btnChinhSua = new swing.ButtonAction();
        btnXoa = new swing.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chọn", "#", "Mã PN", "Tên SP", "Tên NCC", "Tên NV", "Ngày nhập", "Số lượng", "Đơn giá", "TT", "Ghi Chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scroll.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMaxWidth(40);
            table.getColumnModel().getColumn(1).setMaxWidth(50);
        }

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        lbTitle.setText("Tìm kiếm");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnThem.setText("Tạo phiếu nhập");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnChinhSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pen.png"))); // NOI18N
        btnChinhSua.setText("Chỉnh sửa");
        btnChinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/remove.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(btnChinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbTitle)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        Form_ThemPhieuNhap form_ThemPhieuNhap = new Form_ThemPhieuNhap();

        // Load data to combo box
        form_ThemPhieuNhap.loadDataCbbNhanVien(phieuNhapDAO);
        form_ThemPhieuNhap.loadDataCbbSanPham(phieuNhapDAO);
        form_ThemPhieuNhap.loadDataCbbNhaCungCap(phieuNhapDAO);

        DefaultOption option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
        };
        String actions[] = new String[]{"Hủy", "Thêm"};
        GlassPanePopup.showPopup(new SimplePopupBorder(form_ThemPhieuNhap, "Thêm Phiếu nhập", actions, (pc, i) -> {
            if (i == 1) {
                //Save
                try {
                    if (form_ThemPhieuNhap.validData() == true) {
                        phieuNhapDAO.create(form_ThemPhieuNhap.getDataFromInput());
                        pc.closePopup();
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, "Tạo phiếu nhập thành công");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                pc.closePopup();
            }
            loadData();
        }), option);

    }//GEN-LAST:event_btnThemActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        searchData(txtSearch.getText().trim());
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaActionPerformed
        // TODO add your handling code here:
        List<PhieuNhap> list = getSelectedData();
        if (!list.isEmpty()) {
            if (list.size() == 1) {
                PhieuNhap data = list.get(0);
                Form_ThemPhieuNhap form_ThemPhieuNhap = new Form_ThemPhieuNhap();
                form_ThemPhieuNhap.loadData(phieuNhapDAO, data);
                DefaultOption option = new DefaultOption() {
                    @Override
                    public boolean closeWhenClickOutside() {
                        return true;
                    }
                };
                String actions[] = new String[]{"Hủy", "Chỉnh sửa"};
                GlassPanePopup.showPopup(new SimplePopupBorder(form_ThemPhieuNhap, "Chỉnh sửa phiếu nhập", actions, (pc, i) -> {
                    if (i == 1) {
                        //edit
                        try {
                            if(form_ThemPhieuNhap.validData() == true){
                                PhieuNhap dataEdit = form_ThemPhieuNhap.getDataFromInput();
                                dataEdit.setMaPN(data.getMaPN());
                                phieuNhapDAO.edit(dataEdit);
                                pc.closePopup();
                                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Chỉnh sửa phiếu nhập thành công");
                            }
                            
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        pc.closePopup();
                    }
                    loadData();
                }), option);
            } else {
                Notifications.getInstance().show(Notifications.Type.WARNING, "Chỉ chọn 1 phiếu nhập");
            }
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Chọn phiếu nhập cần chỉnh sửa");
        }
    }//GEN-LAST:event_btnChinhSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        List<PhieuNhap> list = getSelectedData();
        if (!list.isEmpty()) {
            DefaultOption option = new DefaultOption() {
                @Override
                public boolean closeWhenClickOutside() {
                    return true;
                }
            };
            String actions[] = new String[]{"Hủy", "Xóa"};
            JLabel label = new JLabel("Bạn có chắn chắn xóa " + list.size() + " phiếu nhập");
            label.setBorder(new EmptyBorder(0, 25, 0, 25));

            GlassPanePopup.showPopup(new SimplePopupBorder(label, "Xóa phiếu nhập", actions, (pc, i) -> {
                if (i == 1) {
                    //Delete
                    try {
                        for (PhieuNhap phieuNhap : list) {
                            phieuNhapDAO.delete(phieuNhap.getMaPN());
                        }
                        pc.closePopup();
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, "Xóa phiếu nhập thành công");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    pc.closePopup();
                }
                loadData();
            }), option);
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Chọn phiếu nhập cần xóa");
        }
    }//GEN-LAST:event_btnXoaActionPerformed
    private List<PhieuNhap> getSelectedData() {
        List<PhieuNhap> list = new ArrayList<>();
        for (int i = 0; i < table.getRowCount(); i++) {
            if ((boolean) table.getValueAt(i, 0)) {
                PhieuNhap data = (PhieuNhap) table.getValueAt(i, 2);
                list.add(data);
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
            List<PhieuNhap> listPN = phieuNhapDAO.getAllPhieuNhap();
            for (PhieuNhap pn : listPN) {
                model.addRow(pn.toTableRow(table.getRowCount() + 1));
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
            List<PhieuNhap> listPN = phieuNhapDAO.search(search);
            for (PhieuNhap pn : listPN) {
                model.addRow(pn.toTableRow(table.getRowCount() + 1));
            }
        } catch (Exception e) {
        }
    }

//    public static void main(String args[]) {
//        FlatRobotoFont.install();
//        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
//        FlatMacLightLaf.setup();
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new QuanLyPhieuNhap().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonAction btnChinhSua;
    private swing.ButtonAction btnThem;
    private swing.ButtonAction btnXoa;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
