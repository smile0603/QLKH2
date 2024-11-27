package form;

import DAO.SanPhamDAO;
import entity.NhaCungCap;
import entity.SanPham;

public class Form_ThemSanPham extends javax.swing.JPanel {

    private SanPhamDAO sanPhamDAO = new SanPhamDAO();

    public Form_ThemSanPham() {
        initComponents();
        cbbNhaCC.setSelectedIndex(-1);
        cbbNhaCC.setLabeText("Tên nhà cung cấp");
        txtmaSP.setLabelText("Mã sản phẩm");
        txtTenSP.setLabelText("Tên sản phẩm");
        txtGhiChu.setLabelText("Ghi chú");
    }

    public SanPham getDataFromInput() {
        String maSP = txtmaSP.getText().trim();
        String tenSP = txtTenSP.getText().trim();
        NhaCungCap ncc = (NhaCungCap) cbbNhaCC.getSelectedItem();
        String ghiChu = txtGhiChu.getText().trim();
        return new SanPham(maSP, tenSP, ghiChu, ncc);

    }

    public void loadDataCbbNhaCungCap(SanPhamDAO sanPhamDAO) {
        try {
            for (NhaCungCap ncc : sanPhamDAO.getNhaCungCapDAO().getAllNhaCungCap()) {
                cbbNhaCC.addItem(ncc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadData(SanPhamDAO sanPhamDAO, SanPham data) {
        try {
            for (NhaCungCap ncc : sanPhamDAO.getNhaCungCapDAO().getAllNhaCungCap()) {
                cbbNhaCC.addItem(ncc);
                if (data != null && data.getNhaCungCap().getMaNCC() == ncc.getMaNCC()) {
                    cbbNhaCC.setSelectedItem(ncc);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (data != null) {
            txtmaSP.setText(data.getMaSP());
            txtTenSP.setText(data.getTenSP());
            txtGhiChu.setText(data.getGhiChu());
        }
    }
    public boolean checkMaSP(String t) {
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        try {
            for (SanPham sp : sanPhamDAO.getAllSanPham()) {
                if (sp.getMaSP().trim().equals(t.trim())) {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    public String getMaSPFromText() {
        String maSP = txtmaSP.getText().trim();
        return maSP;

    }

    public void setEditMaSP() {
        txtmaSP.setEditable(false);
    }
    public boolean validData() {
        String tenSP = txtTenSP.getText().trim();
        String maSP = txtmaSP.getText().trim();
        if (!(maSP.length() > 0 && maSP.matches("[A-Z]{2}\\d{3}"))) {
            lbNotification.setText("Mã SP có định dạng (vd: AB123)");
            return false;
        }

        if (!(tenSP.length() > 0 && tenSP.matches("[\\w\\d\\/ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]+"))) {
            lbNotification.setText("Tên sản phẩm không hợp lệ");
            return false;
        }



        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtmaSP = new swing.TextField();
        txtTenSP = new swing.TextField();
        txtGhiChu = new swing.TextField();
        cbbNhaCC = new swing.Combobox<>();
        lbNotification = new javax.swing.JLabel();

        txtmaSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTenSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbbNhaCC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbNotification.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbNotification.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbNotification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtmaSP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbNhaCC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtmaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(cbbNhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Combobox<Object> cbbNhaCC;
    private javax.swing.JLabel lbNotification;
    private swing.TextField txtGhiChu;
    private swing.TextField txtTenSP;
    private swing.TextField txtmaSP;
    // End of variables declaration//GEN-END:variables
}
