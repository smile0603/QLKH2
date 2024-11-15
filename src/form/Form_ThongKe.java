package form;

import DAO.ThongKeDAO;
import java.sql.Date;
import com.formdev.flatlaf.FlatClientProperties;
import entity.ThongKeNgay;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Form_ThongKe extends javax.swing.JPanel {

    public Form_ThongKe() {
        initComponents();
        init();
    }

    private void init() {

        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Table.background;");
        scroll1.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Table.background;");
        datePickerFromTK.setCloseAfterSelected(true);
        datePickerFromTK.setEditor(txtDateFrom);
        datePickerToTK.setCloseAfterSelected(true);
        datePickerToTK.setEditor(txtDateTo);
    }

    private void loadData() {
        ThongKeDAO thongKeDAO = new ThongKeDAO();
        Date dateFrom = datePickerFromTK.isDateSelected() ? Date.valueOf(datePickerFromTK.getSelectedDate()) : null;
        Date dateTo = datePickerToTK.isDateSelected() ? Date.valueOf(datePickerToTK.getSelectedDate()) : null;

        try {
            DefaultTableModel model = (DefaultTableModel) tableThongKe.getModel();
            if (tableThongKe.isEditing()) {
                tableThongKe.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<ThongKeNgay> listTK = thongKeDAO.getThongKeTuNgay(dateFrom, dateTo);
            for (ThongKeNgay tk : listTK) {
                model.addRow(tk.toTableRow(tableThongKe.getRowCount() + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datePickerFromTK = new raven.datetime.component.date.DatePicker();
        datePickerToTK = new raven.datetime.component.date.DatePicker();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        materialTabbed = new swing.MaterialTabbed();
        tabbedTonKho = new swing.MaterialTabbed();
        jPanel2 = new javax.swing.JPanel();
        txtDateFrom = new javax.swing.JFormattedTextField();
        txtDateTo = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCheck = new swing.ButtonAction();
        scroll = new javax.swing.JScrollPane();
        tableThongKe = new swing.TableDesign();
        lbNotification = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        scroll1 = new javax.swing.JScrollPane();
        tableDesign1 = new swing.TableDesign();
        searchText1 = new swing.SearchText();
        jLabel3 = new javax.swing.JLabel();
        buttonAction2 = new swing.ButtonAction();
        tabbedDoanhthu = new swing.MaterialTabbed();
        tabbedNCC = new swing.MaterialTabbed();

        jButton3.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel.png"))); // NOI18N
        jButton3.setText("Print Excel");

        jButton4.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pdf.png"))); // NOI18N
        jButton4.setText("Print PDF");

        jButton5.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/import.png"))); // NOI18N
        jButton5.setText("Import");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Từ ngày :");

        jLabel2.setText("Đến ngày :");

        btnCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-interface-symbol.png"))); // NOI18N
        btnCheck.setText("Kiểm tra");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        tableThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Mã SP", "Tên SP", "Tồn đầu kì", "SL Nhập", "SL xuất", "Tồn trong kì", "Tổng tồn"
            }
        ));
        scroll.setViewportView(tableThongKe);

        lbNotification.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbNotification.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(lbNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(425, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(403, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        tabbedTonKho.addTab("Thống kê theo ngày", jPanel2);

        tableDesign1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Mã SP", "Tên SP", "Tồn đầu kì", "SL nhập", "SL xuất", "Tồn cuối kì", "Ghi chú"
            }
        ));
        scroll1.setViewportView(tableDesign1);

        jLabel3.setText("Mã SP");

        buttonAction2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-interface-symbol.png"))); // NOI18N
        buttonAction2.setText("Kiểm tra");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll1)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonAction2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(567, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAction2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(15, 15, 15)
                .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabbedTonKho.addTab("Thống kê theo sản phẩm", jPanel3);

        materialTabbed.addTab("Tồn kho", tabbedTonKho);
        tabbedTonKho.getAccessibleContext().setAccessibleName("");

        materialTabbed.addTab("Doanh thu", tabbedDoanhthu);
        materialTabbed.addTab("Nhà cung cấp", tabbedNCC);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(materialTabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 1034, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(materialTabbed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        materialTabbed.getAccessibleContext().setAccessibleName("Thống kê");
        materialTabbed.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        // TODO add your handling code here:
        if (validData() == true) {
            loadData();
        }

    }//GEN-LAST:event_btnCheckActionPerformed
    public boolean validData() {

//        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//        String ngayNhap = df.format(datePicker.isDateSelected() ? Date.valueOf(datePicker.getSelectedDate()) : null);
        Date dateFrom = datePickerFromTK.isDateSelected() ? Date.valueOf(datePickerFromTK.getSelectedDate()) : null;
        Date dateTo = datePickerToTK.isDateSelected() ? Date.valueOf(datePickerToTK.getSelectedDate()) : null;

        if (dateFrom == null || dateTo == null) {
            lbNotification.setText("Vui lòng chọn ngày");
            return false;
        }
        if(dateFrom.after(dateTo)){
            lbNotification.setText("Không hợp lệ(Từ ngày < Đến ngày)");
            return false;
        }

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonAction btnCheck;
    private swing.ButtonAction buttonAction2;
    private raven.datetime.component.date.DatePicker datePickerFromTK;
    private raven.datetime.component.date.DatePicker datePickerToTK;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbNotification;
    private swing.MaterialTabbed materialTabbed;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JScrollPane scroll1;
    private swing.SearchText searchText1;
    private swing.MaterialTabbed tabbedDoanhthu;
    private swing.MaterialTabbed tabbedNCC;
    private swing.MaterialTabbed tabbedTonKho;
    private swing.TableDesign tableDesign1;
    private swing.TableDesign tableThongKe;
    private javax.swing.JFormattedTextField txtDateFrom;
    private javax.swing.JFormattedTextField txtDateTo;
    // End of variables declaration//GEN-END:variables
}
