package form;

import DAO.NhaCungCapDAO;
import entity.NhaCungCap;


public class Form_ThemNhaCungCap extends javax.swing.JPanel {

    public Form_ThemNhaCungCap() {
        initComponents();
        
        txtTenNCC.setLabelText("Tên nhà cung cấp");
        txtdiaChiNCC.setLabelText("Địa chỉ");
        txtEmailNCC.setLabelText("Email");
        txtSdtNCC.setLabelText("Số điện thoại");  
    }

    
    @SuppressWarnings("unchecked")
    public NhaCungCap getData(){
        String tenNCC = txtTenNCC.getText().trim();
        String diaChi = txtdiaChiNCC.getText().trim();
        String emailNCC = txtEmailNCC.getText().trim();
        int sdtNCC = Integer.parseInt(txtSdtNCC.getText().trim());
        NhaCungCap ncc = new NhaCungCap(0, tenNCC, diaChi, emailNCC, sdtNCC);
        return ncc;
        
    }
    public void loadData(NhaCungCapDAO nccDAO, NhaCungCap ncc){
        if(ncc != null){
            txtTenNCC.setText(ncc.getTenNCC());
            txtdiaChiNCC.setText(ncc.getDiaChi());
            txtEmailNCC.setText(ncc.getEmail());
            txtSdtNCC.setText(Integer.toString(ncc.getSdtNCC()));
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTenNCC = new swing.TextField();
        txtdiaChiNCC = new swing.TextField();
        txtEmailNCC = new swing.TextField();
        txtSdtNCC = new swing.TextField();

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSdtNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdiaChiNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtdiaChiNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtEmailNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtSdtNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.TextField txtEmailNCC;
    private swing.TextField txtSdtNCC;
    private swing.TextField txtTenNCC;
    private swing.TextField txtdiaChiNCC;
    // End of variables declaration//GEN-END:variables
}
