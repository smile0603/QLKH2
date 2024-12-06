package form;

import DAO.ThongKeDAO;
import java.sql.Date;
import com.formdev.flatlaf.FlatClientProperties;
import entity.ThongKeNgay;
import helper.JTableExport;
import helper.writePDF;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Form_ThongKe extends javax.swing.JPanel {

    JTableExport jTableExport = new JTableExport();

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
        jPanel1 = new javax.swing.JPanel();
        materialTabbed = new swing.MaterialTabbed();
        tabbedTonKho = new swing.MaterialTabbed();
        jPanel2 = new javax.swing.JPanel();
        txtDateFrom = new javax.swing.JFormattedTextField();
        txtDateTo = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCheckTheoNgay = new swing.ButtonAction();
        scroll = new javax.swing.JScrollPane();
        tableThongKe = new swing.TableDesign();
        lbNotification = new javax.swing.JLabel();
        btnExportExcel = new javax.swing.JButton();
        btnExportPDF = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        scroll1 = new javax.swing.JScrollPane();
        tableThongKeMaSP = new swing.TableDesign();
        txtMaSearch = new swing.SearchText();
        jLabel3 = new javax.swing.JLabel();
        btnCheckTheoMaSP = new swing.ButtonAction();
        btnExportExcel1 = new javax.swing.JButton();
        btnExportPDF1 = new javax.swing.JButton();
        lbNotification2 = new javax.swing.JLabel();
        tabbedKhachHang = new swing.MaterialTabbed();
        tabbedNCC = new swing.MaterialTabbed();
        jPanel5 = new javax.swing.JPanel();
        scroll3 = new javax.swing.JScrollPane();
        tableThongKeMaSP1 = new swing.TableDesign();
        txtMaSearch1 = new swing.SearchText();
        jLabel6 = new javax.swing.JLabel();
        btnCheckNCC = new swing.ButtonAction();
        btnExportExcel3 = new javax.swing.JButton();
        btnExportPDF3 = new javax.swing.JButton();
        lbNotification3 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Từ ngày :");

        jLabel2.setText("Đến ngày :");

        btnCheckTheoNgay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-interface-symbol.png"))); // NOI18N
        btnCheckTheoNgay.setText("Kiểm tra");
        btnCheckTheoNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckTheoNgayActionPerformed(evt);
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

        btnExportExcel.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        btnExportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel24pix.png"))); // NOI18N
        btnExportExcel.setText("Export Excel");
        btnExportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportExcelActionPerformed(evt);
            }
        });

        btnExportPDF.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        btnExportPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pdf24pix.png"))); // NOI18N
        btnExportPDF.setText("ExportPDF");
        btnExportPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportPDFActionPerformed(evt);
            }
        });

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
                        .addComponent(txtDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(lbNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnCheckTheoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(btnExportExcel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportPDF)
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExportExcel)
                            .addComponent(btnExportPDF)
                            .addComponent(btnCheckTheoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(465, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        tabbedTonKho.addTab("Thống kê theo ngày", jPanel2);

        tableThongKeMaSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "#", "Mã SP", "Tên SP", "Tổng SL Nhập", "Tổng SL xuất", "Tổng tồn"
            }
        ));
        tableThongKeMaSP.setPreferredSize(new java.awt.Dimension(600, 120));
        scroll1.setViewportView(tableThongKeMaSP);

        txtMaSearch.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N

        jLabel3.setText("Mã SP");

        btnCheckTheoMaSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-interface-symbol.png"))); // NOI18N
        btnCheckTheoMaSP.setText("Kiểm tra");
        btnCheckTheoMaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckTheoMaSPActionPerformed(evt);
            }
        });

        btnExportExcel1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        btnExportExcel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel24pix.png"))); // NOI18N
        btnExportExcel1.setText("Export Excel");
        btnExportExcel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportExcel1ActionPerformed(evt);
            }
        });

        btnExportPDF1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        btnExportPDF1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pdf24pix.png"))); // NOI18N
        btnExportPDF1.setText("ExportPDF");
        btnExportPDF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportPDF1ActionPerformed(evt);
            }
        });

        lbNotification2.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbNotification2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCheckTheoMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExportExcel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExportPDF1)
                .addGap(90, 90, 90))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(lbNotification2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheckTheoMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnExportExcel1)
                    .addComponent(btnExportPDF1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabbedTonKho.addTab("Thống kê theo sản phẩm", jPanel3);

        materialTabbed.addTab("Tồn kho", tabbedTonKho);
        tabbedTonKho.getAccessibleContext().setAccessibleName("");

        materialTabbed.addTab("Khách hàng", tabbedKhachHang);

        tableThongKeMaSP1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "TênNCC", "Tên SP", "Ngày nhập", "SL Nhập", "Đơn giá", "Chiết khấu"
            }
        ));
        tableThongKeMaSP1.setPreferredSize(new java.awt.Dimension(600, 120));
        scroll3.setViewportView(tableThongKeMaSP1);

        txtMaSearch1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N

        jLabel6.setText("Mã NCC");

        btnCheckNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-interface-symbol.png"))); // NOI18N
        btnCheckNCC.setText("Kiểm tra");
        btnCheckNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckNCCActionPerformed(evt);
            }
        });

        btnExportExcel3.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        btnExportExcel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel24pix.png"))); // NOI18N
        btnExportExcel3.setText("Export Excel");
        btnExportExcel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportExcel3ActionPerformed(evt);
            }
        });

        btnExportPDF3.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        btnExportPDF3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pdf24pix.png"))); // NOI18N
        btnExportPDF3.setText("ExportPDF");
        btnExportPDF3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportPDF3ActionPerformed(evt);
            }
        });

        lbNotification3.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll3, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbNotification3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCheckNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExportExcel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExportPDF3)
                .addGap(90, 90, 90))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(lbNotification3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheckNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnExportExcel3)
                    .addComponent(btnExportPDF3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabbedNCC.addTab("Thống kê nhà cung cấp", jPanel5);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckTheoNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckTheoNgayActionPerformed
        // TODO add your handling code here:
        if (validData() == true) {
            loadData();
        }

    }//GEN-LAST:event_btnCheckTheoNgayActionPerformed

    private void btnExportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportExcelActionPerformed
        if (validData() == false) {
            lbNotification.setText("Vui lòng tạo phiếu thống kê");
        } else {
            try {
                // TODO add your handling code here:
                jTableExport.exportJTableToExcel(tableThongKe);
            } catch (IOException ex) {
                Logger.getLogger(Form_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
    }//GEN-LAST:event_btnExportExcelActionPerformed

    private void btnExportPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportPDFActionPerformed
        // TODO add your handling code here:
        if (validData() == false) {
            lbNotification.setText("Vui lòng tạo phiếu thống kê");
        } else {
            Date dateFrom = datePickerFromTK.isDateSelected() ? Date.valueOf(datePickerFromTK.getSelectedDate()) : null;
            Date dateTo = datePickerToTK.isDateSelected() ? Date.valueOf(datePickerToTK.getSelectedDate()) : null;
            writePDF write = new writePDF();
            // TODO add your handling code here:
            write.writeThongKe(dateFrom, dateTo);
        }


    }//GEN-LAST:event_btnExportPDFActionPerformed

    private void btnExportExcel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportExcel1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            jTableExport.exportJTableToExcel(tableThongKeMaSP);
        } catch (IOException ex) {
            Logger.getLogger(Form_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportExcel1ActionPerformed

    private void btnExportPDF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportPDF1ActionPerformed
        // TODO add your handling code here:
         writePDF write = new writePDF();
            // TODO add your handling code here:
        String maSearch = txtMaSearch.getText().trim();
        write.writeThongKeMaSP(maSearch);
    }//GEN-LAST:event_btnExportPDF1ActionPerformed

    private void btnCheckTheoMaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckTheoMaSPActionPerformed
        // TODO add your handling code here:
        String maSearch = txtMaSearch.getText().trim();
        ThongKeDAO thongKeDAO = new ThongKeDAO();
        try {
            DefaultTableModel model = (DefaultTableModel) tableThongKeMaSP.getModel();
            if (tableThongKeMaSP.isEditing()) {
                tableThongKeMaSP.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            if (maSearch.equals("")) {
                List<ThongKeNgay> listTK = thongKeDAO.getThongKeAllSP();
                for (ThongKeNgay tk : listTK) {
                    model.addRow(tk.toTableRow2(tableThongKeMaSP.getRowCount() + 1));
                }
            } else {
                List<ThongKeNgay> listTK = thongKeDAO.getThongKeSP(maSearch);
                for (ThongKeNgay tk : listTK) {
                    model.addRow(tk.toTableRow2(tableThongKeMaSP.getRowCount() + 1));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btnCheckTheoMaSPActionPerformed

    private void btnCheckNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckNCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCheckNCCActionPerformed

    private void btnExportExcel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportExcel3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportExcel3ActionPerformed

    private void btnExportPDF3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportPDF3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportPDF3ActionPerformed
    public boolean validData() {

//        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//        String ngayNhap = df.format(datePicker.isDateSelected() ? Date.valueOf(datePicker.getSelectedDate()) : null);
        Date dateFrom = datePickerFromTK.isDateSelected() ? Date.valueOf(datePickerFromTK.getSelectedDate()) : null;
        Date dateTo = datePickerToTK.isDateSelected() ? Date.valueOf(datePickerToTK.getSelectedDate()) : null;

        if (dateFrom == null || dateTo == null) {
            lbNotification.setText("Vui lòng chọn ngày");
            return false;
        }
        if (dateFrom.after(dateTo)) {
            lbNotification.setText("Không hợp lệ(Từ ngày < Đến ngày)");
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonAction btnCheckNCC;
    private swing.ButtonAction btnCheckTheoMaSP;
    private swing.ButtonAction btnCheckTheoNgay;
    private javax.swing.JButton btnExportExcel;
    private javax.swing.JButton btnExportExcel1;
    private javax.swing.JButton btnExportExcel3;
    private javax.swing.JButton btnExportPDF;
    private javax.swing.JButton btnExportPDF1;
    private javax.swing.JButton btnExportPDF3;
    private raven.datetime.component.date.DatePicker datePickerFromTK;
    private raven.datetime.component.date.DatePicker datePickerToTK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbNotification;
    private javax.swing.JLabel lbNotification2;
    private javax.swing.JLabel lbNotification3;
    private swing.MaterialTabbed materialTabbed;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JScrollPane scroll3;
    private swing.MaterialTabbed tabbedKhachHang;
    private swing.MaterialTabbed tabbedNCC;
    private swing.MaterialTabbed tabbedTonKho;
    private swing.TableDesign tableThongKe;
    private swing.TableDesign tableThongKeMaSP;
    private swing.TableDesign tableThongKeMaSP1;
    private javax.swing.JFormattedTextField txtDateFrom;
    private javax.swing.JFormattedTextField txtDateTo;
    private swing.SearchText txtMaSearch;
    private swing.SearchText txtMaSearch1;
    // End of variables declaration//GEN-END:variables
}
