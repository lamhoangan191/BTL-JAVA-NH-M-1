/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.SinhVien;

import model.FakeData;
import view.DangNhap.DangNhap;
import view.DangNhap.DoiMatKhau;

/**
 *
 * @author HP
 */
public class TrangChuSV extends javax.swing.JFrame {

    /**
     * Creates new form TrangChuSV
     */
    public TrangChuSV() {
        initComponents();
        setTitle("Trang chủ sinh viên");
        setLocationRelativeTo(this);
    }
    
    private String maSV = FakeData.layMaSV_Test();
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMuaLe = new javax.swing.JButton();
        btnMuaLop = new javax.swing.JButton();
        btnXemDSHoaDon = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnMuaLe.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnMuaLe.setText("Mua lẻ");
        btnMuaLe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuaLeActionPerformed(evt);
            }
        });

        btnMuaLop.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnMuaLop.setText("Mua theo lớp");
        btnMuaLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuaLopActionPerformed(evt);
            }
        });

        btnXemDSHoaDon.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnXemDSHoaDon.setText("Xem danh sách hóa đơn mua");
        btnXemDSHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemDSHoaDonActionPerformed(evt);
            }
        });

        btnDangXuat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXemDSHoaDon)
                    .addComponent(btnMuaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMuaLe, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnMuaLe)
                .addGap(49, 49, 49)
                .addComponent(btnMuaLop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnXemDSHoaDon)
                .addGap(120, 120, 120)
                .addComponent(btnDangXuat)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
        DangNhap dn = new DangNhap();
        dn.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnMuaLeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuaLeActionPerformed
        // TODO add your handling code here:
        DonMuaLe dml = new DonMuaLe(this, true);
        dml.setVisible(true);
    }//GEN-LAST:event_btnMuaLeActionPerformed

    private void btnMuaLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuaLopActionPerformed
        // TODO add your handling code here:
        DonMuaLop dl = new DonMuaLop(this, true);
        dl.setVisible(true);
    }//GEN-LAST:event_btnMuaLopActionPerformed

    private void btnXemDSHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemDSHoaDonActionPerformed
        // TODO add your handling code here:
        DanhSachDonMua ds = new DanhSachDonMua(this, true);
        ds.setVisible(true);
    }//GEN-LAST:event_btnXemDSHoaDonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrangChuSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChuSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChuSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChuSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChuSV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnMuaLe;
    private javax.swing.JButton btnMuaLop;
    private javax.swing.JButton btnXemDSHoaDon;
    // End of variables declaration//GEN-END:variables
}
