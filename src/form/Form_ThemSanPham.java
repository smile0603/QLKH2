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
    public void loadDataCbbNhaCungCap(SanPhamDAO sanPhamDAO){
        try {
            for(NhaCungCap ncc : sanPhamDAO.getNhaCungCapDAO().getAllNhaCungCap()){
                cbbNhaCC.addItem(ncc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
    public void loadData(SanPhamDAO sanPhamDAO, SanPham data) {
       try {
            for(NhaCungCap ncc : sanPhamDAO.getNhaCungCapDAO().getAllNhaCungCap()){
                cbbNhaCC.addItem(ncc);
                if(data != null && data.getNhaCungCap().getMaNCC() == ncc.getMaNCC()){
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtmaSP = new swing.TextField();
        txtTenSP = new swing.TextField();
        txtGhiChu = new swing.TextField();
        cbbNhaCC = new swing.Combobox<>();

        txtmaSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTenSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbbNhaCC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtmaSP, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbNhaCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtmaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(cbbNhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Combobox<Object> cbbNhaCC;
    private swing.TextField txtGhiChu;
    private swing.TextField txtTenSP;
    private swing.TextField txtmaSP;
    // End of variables declaration//GEN-END:variables
}
