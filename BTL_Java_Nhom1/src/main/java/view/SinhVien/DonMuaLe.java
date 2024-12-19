/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.SinhVien;

import controller.DonMuaLeController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.FakeData;
import model.SachCuaKhoa;
import model.TTDonMuaLe;

/**
 *
 * @author Duyen
 */
public class DonMuaLe extends javax.swing.JDialog {

    private String maDonMuaLe;
    String maSV = FakeData.layMaSV_Test();
    private String tenSach;
    private String maSach;
    private int soLuong;
    private String maKhoa = "CNTT";
    List<SachCuaKhoa> dsSach = FakeData.laySachtheoKhoa(maKhoa);
    TTDonMuaLe dml = new TTDonMuaLe();
    
    public DonMuaLe(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        loadSachIntoComboBox();
        addComboBoxListener();
        addSLListener();
    }
    
    private void loadSachIntoComboBox() {
        cboTenSach.removeAllItems(); 
        cboTenSach.setFont(new Font("Times New Romand", Font.PLAIN, 14));
        for (SachCuaKhoa sach : dsSach) {
            cboTenSach.addItem(sach.getTenSach());
        }
    }
    
    private void updateMaSachField() {
        String selectedTenSach = (String) cboTenSach.getSelectedItem();
        for (SachCuaKhoa sach : dsSach) {
            if (sach.getTenSach().equals(selectedTenSach)) {
                txtMaSach.setText(sach.getMaSach()); // Cập nhật mã sách vào trường txtMaSach
                break;
            }
        }
    }
    
    
    
    private void addComboBoxListener() {
        cboTenSach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDonGiaField();
                updateMaSachField();
            }
        });
    }
    
    private void updateDonGiaField() {
        String selectedTenSach = (String) cboTenSach.getSelectedItem();
        for (SachCuaKhoa sach : dsSach) {
            if (sach.getTenSach().equals(selectedTenSach)) {
                txtDonGia.setText(String.valueOf(sach.getDonGia()));
                updateTongTien();
                break;
            }
        }
    }
    
    private void updateTongTien() {
        try {
            int donGia = Integer.parseInt(txtDonGia.getText().trim());
            int soLuong = Integer.parseInt(txtSL.getText().trim());
            int tongTien = donGia * soLuong;
            txtTong.setText(String.valueOf(tongTien));
        } catch (NumberFormatException e) {
            // Xử lý khi giá trị không hợp lệ
            txtTong.setText("0");
        }
    }

    private void addSLListener() {
        txtSL.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTongTien();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTongTien();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTongTien();
            }
        });
    }
    
    private static String generateCode(String crtCode) {
        // Tách phần tiền tố và hậu tố từ mã hiện tại
        String prefix = crtCode.substring(0, crtCode.length() - 3);
        int suffix = Integer.parseInt(crtCode.substring(crtCode.length() - 3));
        int newSuffix = suffix + 1;
        return String.format("%s%03d", prefix, newSuffix); // Đảm bảo định dạng 3 chữ số cho hậu tố
    }
    
    private static String loadLastCodeFromFile() {
        String lastCode = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\DSDonMuaLe.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) { // Kiểm tra xem dòng có rỗng không
                    lastCode = line.split(",")[0]; // Lấy mã ở cột đầu tiên, tách các cột bằng dấu phẩy
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastCode;
    }
    
    private String maDon() {
        String crtCode = loadLastCodeFromFile();
        if (crtCode == null) {
            // Nếu không có mã trong file -> khởi tạo mã ban đầu
            crtCode = "DML000";
        }
        String newCode = generateCode(crtCode);
        return newCode;
    }
    
    private boolean setResult() {
        this.maDonMuaLe = maDon();
    this.tenSach = cboTenSach.getSelectedItem().toString();
    this.maSach = txtMaSach.getText();

    try {
        int donGia = Integer.parseInt(txtDonGia.getText().trim());
        this.soLuong = Integer.parseInt(txtSL.getText().trim());

        if (this.soLuong <= 0) {
            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        double tongTien = donGia * soLuong;
        this.txtTong.setText(String.valueOf(tongTien));
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    if (this.maSach.trim().isEmpty()) {
        return false;
    }

    return true;
    }
    
    public  void reloadForm() {
        cboTenSach.setSelectedItem(0);
        txtMaSach.setText("");
        txtSL.setText("");
        txtDonGia.setText("");
        txtTong.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboTenSach = new javax.swing.JComboBox<>();
        txtMaSach = new javax.swing.JTextField();
        txtSL = new javax.swing.JTextField();
        btnThoat = new javax.swing.JButton();
        btnMua = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtTong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Tên sách: ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Mã sách: ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Số lượng: ");

        cboTenSach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnThoat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnMua.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnMua.setText("Mua");
        btnMua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Tổng tiền: ");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Đơn giá: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(btnMua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3)))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTong)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaSach)
                            .addComponent(cboTenSach, 0, 306, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cboTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThoat)
                    .addComponent(btnMua))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        int c = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if(c == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnMuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuaActionPerformed
        // TODO add your handling code here:
        if (!this.setResult()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                int donGia = Integer.parseInt(txtDonGia.getText().trim());
                int soLuong = Integer.parseInt(txtSL.getText().trim());
                int tongTien = donGia * soLuong;

                TTDonMuaLe dml = new TTDonMuaLe(maDonMuaLe, maSV, tenSach, maSach, donGia, soLuong, tongTien);
                DonMuaLeController.saveDonMuaLeInfo(dml);
                JOptionPane.showMessageDialog(this, "Mua thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                reloadForm();
            }catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnMuaActionPerformed

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
            java.util.logging.Logger.getLogger(DonMuaLe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DonMuaLe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DonMuaLe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DonMuaLe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DonMuaLe dialog = new DonMuaLe(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMua;
    private javax.swing.JButton btnThoat;
    private javax.swing.JComboBox<String> cboTenSach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtTong;
    // End of variables declaration//GEN-END:variables
}
