/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.Admin;

import controller.PhatHanhSachController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import model.FakeData;
import static model.FakeData.isMaSachExist;
import model.Sach;
import model.TableSach;

/**
 *
 * @author HP
 */
public class PhatHanhSach extends javax.swing.JFrame {

    /**
     * Creates new form PhatHanhSach
     */
    ArrayList<Sach> dsS = new ArrayList<>();
   private TableSach tableModel;

    private void loadDataToTable() {
        ArrayList<Sach> dsS = new ArrayList<>(); // Đây là giả định. Hãy thay thế nó bằng phương thức tải dữ liệu từ tệp tin thực tế của bạn.
        dsS  = FakeData.loadSachFromFile();
        tableModel = new TableSach(dsS);
        tbl_Sach.setModel(tableModel);
    }
    private void clearInputFields() {
        txtMaSach.setText("");
        txtTenSach.setText("");
        txtMaKhoa.setText("");
        txtdonGia.setText("");
    }
    public PhatHanhSach() {
        initComponents();
        loadDataToTable();
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
        txtDonGia = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        txtMaKhoa = new javax.swing.JTextField();
        txtdonGia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Sach = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mã sách");

        jLabel2.setText("Mã khoa");

        jLabel3.setText("Tên sách");

        txtDonGia.setText("Đơn giá");

        txtMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSachActionPerformed(evt);
            }
        });

        txtTenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSachActionPerformed(evt);
            }
        });

        txtMaKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKhoaActionPerformed(evt);
            }
        });

        tbl_Sach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên Sách", "Mã Khoa", "Mã Sách", "Đơn Giá"
            }
        ));
        jScrollPane1.setViewportView(tbl_Sach);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btnThem)
                        .addGap(90, 90, 90)
                        .addComponent(btnSua)
                        .addGap(74, 74, 74)
                        .addComponent(btnXoa)
                        .addGap(85, 85, 85)
                        .addComponent(btnThoat))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(81, 81, 81)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtdonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDonGia)
                    .addComponent(txtdonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnThoat))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSachActionPerformed

    private void txtTenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSachActionPerformed

    private void txtMaKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKhoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKhoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
   String maSach = txtMaSach.getText();
        String tenSach = txtTenSach.getText();
        String strDonGia = txtdonGia.getText();
        String maKhoa = txtMaKhoa.getText();

        // Kiểm tra xem đơn giá có phải là số hay không
        try {
            int donGia = Integer.parseInt(strDonGia);
            if (donGia <= 0) {
            JOptionPane.showMessageDialog(this, "Đơn giá phải lớn hơn 0. Vui lòng nhập lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
            // Kiểm tra xem mã sách đã tồn tại trong danh sách hay chưa
            if (isMaSachExist(maSach)) {
                // Nếu mã sách đã tồn tại, hiển thị thông báo cảnh báo
                JOptionPane.showMessageDialog(this, "Mã sách đã tồn tại. Vui lòng nhập lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                // Nếu mã sách chưa tồn tại, tiến hành thêm sách vào danh sách
                // Tạo một đối tượng Sach mới
                Sach sach = new Sach(maSach, tenSach, maKhoa, donGia);

                // Lưu thông tin sách vào file Sach.txt
                PhatHanhSachController.saveSachInfo(sach);

                // Cập nhật bảng hiển thị danh sách sách
                loadDataToTable();

                // Xóa dữ liệu trên các trường nhập liệu để chuẩn bị cho việc nhập sách mới
                txtMaSach.setText("");
                txtTenSach.setText("");
                txtdonGia.setText("");
                txtMaKhoa.setText("");

                // Thông báo cho người dùng biết rằng sách đã được thêm thành công
                JOptionPane.showMessageDialog(this, "Thêm sách thành công!");
            }
        } catch (NumberFormatException e) {
            // Nếu đơn giá không phải là số, hiển thị thông báo lỗi
            JOptionPane.showMessageDialog(this, "Đơn giá phải là số. Vui lòng nhập lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int selectedRow = tbl_Sach.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sách để sửa!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String maSach = txtMaSach.getText().trim();
        String tenSach = txtTenSach.getText().trim();
        String maKhoa = txtMaKhoa.getText().trim();
        String strDonGia = txtdonGia.getText().trim();

        try {
            int donGia = Integer.parseInt(strDonGia);
            if (donGia <= 0) {
            JOptionPane.showMessageDialog(this, "Đơn giá phải lớn hơn 0. Vui lòng nhập lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
            ArrayList<Sach> dsSach = FakeData.loadSachFromFile();
            Sach sach = dsSach.get(selectedRow);
            sach.setMaSach(maSach);
            sach.setTenSach(tenSach);
            sach.setMaKhoa(maKhoa);
            sach.setDonGia(donGia);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter
        ("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\Sach.txt"))) {
                for (Sach s : dsSach) {
                    writer.write(s.toCSV());
                    writer.newLine();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Lỗi khi lưu file: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }

            JOptionPane.showMessageDialog(this, "Sửa sách thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            loadDataToTable();
           clearInputFields();

        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Đơn giá phải là số. Vui lòng nhập lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
     int selectedRow = tbl_Sach.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn một sách để xóa!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        return;
    }
    
    Sach sach = tableModel.getSachAt(selectedRow);
    
    try {
        // Xóa sách từ tệp và cập nhật lại danh sách
        PhatHanhSachController.xoaSach(sach);
        
        // Cập nhật lại bảng sau khi xóa
        loadDataToTable();
        
        // Xóa dữ liệu trên các trường nhập liệu
        clearInputFields();
        
        JOptionPane.showMessageDialog(this, "Xóa sách thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Lỗi khi xóa sách: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
        TrangChuAdmin trangChuAdmin = new TrangChuAdmin();
        trangChuAdmin.setVisible(true);
    }//GEN-LAST:event_btnThoatActionPerformed

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
            java.util.logging.Logger.getLogger(PhatHanhSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhatHanhSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhatHanhSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhatHanhSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhatHanhSach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Sach;
    private javax.swing.JLabel txtDonGia;
    private javax.swing.JTextField txtMaKhoa;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtdonGia;
    // End of variables declaration//GEN-END:variables
}