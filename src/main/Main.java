package main;

import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import event.EventMenuSelected;
import form.Form_QuanLyUser;

import form.Form_PhieuNhap;

import form.Form_NhaCungCap;
import form.Form_PhieuXuat;
import form.Form_SanPham;

import form.Form_ThongKe;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main extends javax.swing.JFrame {

    private Form_PhieuNhap formPhieuNhap;
    private Form_PhieuXuat formPhieuXuat;
    private Form_NhaCungCap formNhaCungCap;
    private Form_SanPham formSanPham;
    private Form_ThongKe form_ThongKe;
    private Form_QuanLyUser form_Admin;

    public Main() {
        FlatRobotoFont.install();
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacLightLaf.setup();
        initComponents();
        setBackground(new Color(0, 0, 0, 0));

        formPhieuNhap = new Form_PhieuNhap();
        formSanPham = new Form_SanPham();
        formNhaCungCap = new Form_NhaCungCap();
        formPhieuXuat = new Form_PhieuXuat();
        form_ThongKe = new Form_ThongKe();

        form_Admin = new Form_QuanLyUser();
        menu.initMoving(Main.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    setForm(form_ThongKe);
                } else if (index == 1) {
                    setForm(formPhieuNhap);
                } else if (index == 2) {
                    setForm(formPhieuXuat);
                } else if (index == 3) {
                    setForm(formSanPham);

                } else if (index == 4) {
                    setForm(formNhaCungCap);
                } else if (index == 6) {
                    setForm(form_Admin);
                    
                    
                } else if (index == 7) {
                    setForm(form_Admin);

                }
                else if (index == 8) {
                    if (JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát?", "Thoát",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        // yes option
                        
                        System.exit(0);
                    } else {
                        // no option
                    }

                }
            }
        });
        //  set when system open start with home form
        setForm(form_ThongKe);
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new swing.PanelBorder();
        menu = new component.Menu();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private component.Menu menu;
    private swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
