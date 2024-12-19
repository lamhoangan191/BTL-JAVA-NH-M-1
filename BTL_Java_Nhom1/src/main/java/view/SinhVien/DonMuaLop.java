/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.SinhVien;

import controller.DonMuaLopController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.FakeData;
import model.Sach;
import model.SachCuaKhoa;
import model.SinhVienLop;
import model.TTDonMuaLop;

/**
 *
 * @author HP
 */
public class DonMuaLop extends javax.swing.JDialog {

    private String maDonLop;
    private String maSV;
    private String tenSach;
    private String maSach;
    private List<SinhVienLop> dssv = new ArrayList<>();
    private String maKhoa = "CNTT";
    List<SachCuaKhoa> dsSach = FakeData.laySachtheoKhoa(maKhoa);
    
    public DonMuaLop(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Đơn mua lớp");
        initComponents();
        viewTable();
        loadSachIntoComboBox();
        addComboBoxListener();
    }

    private void loadSachIntoComboBox() {
        cboTenSach.removeAllItems(); 
        for (SachCuaKhoa sach : dsSach) {
            cboTenSach.addItem(sach.getTenSach());
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
    
    private void updateMaSachField() {
        String selectedTenSach = (String) cboTenSach.getSelectedItem();
        for (SachCuaKhoa sach : dsSach) {
            if (sach.getTenSach().equals(selectedTenSach)) {
                txtMaSach.setText(sach.getMaSach()); // Cập nhật mã sách vào trường txtMaSach
                break;
            }
        }
    }
    
    private void updateDonGiaField() {
        String selectedTenSach = (String) cboTenSach.getSelectedItem();
        for (SachCuaKhoa sach : dsSach) {
            if (sach.getTenSach().equals(selectedTenSach)) {
                txtDonGia.setText(String.valueOf(sach.getDonGia()));
                calculateTotal();
                break;
            }
        }
    }
    
    private static String generateCode(String crtCode) {
        // Tách phần tiền tố và hậu tố từ mã hiện tại
        String prefix = crtCode.substring(0, crtCode.length() - 2);
        int suffix = Integer.parseInt(crtCode.substring(crtCode.length() - 2));
        int newSuffix = suffix + 1;
        return String.format("%s%02d", prefix, newSuffix);
    }
    
    private static String loadLastCodeFromFile() {
        String lastCode = null;
        try ( BufferedReader reader = new BufferedReader
        (new FileReader("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\DSDonMuaLop.txt"))) {
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
    
    private String sinhMaDonLop() {
        String currentCode = loadLastCodeFromFile();
        if (currentCode == null) {
            // Nếu không có mã trong file, khởi tạo mã ban đầu
            currentCode = "DL000";
        }
        // Sinh mã mới
        String newCode = generateCode(currentCode);
        return newCode;
    }
    
    public void viewTable() {
        DefaultTableModel model = (DefaultTableModel) this.tblSVLop.getModel();
        model.setRowCount(0);

        for (SinhVienLop x : dssv) {
            model.addRow(new Object[]{x.getMaSV(), x.getTenSV(), x.getTenKhoa()});
        }
        calculateTotal();
    }
    
    public void reloadTable() {
        DefaultTableModel model = (DefaultTableModel) this.tblSVLop.getModel();
        model.setRowCount(0);
    }
    
    public void reloadForm() {
        cboTenSach.setSelectedIndex(0);
        txtMaSach.setText("");
        txtDonGia.setText("");
        txtTongTien.setText("");
        
        reloadTable();
    }
    
    private void calculateTotal() {
        try {
            int donGia = Integer.parseInt(txtDonGia.getText().trim());
            int soLuongSV = tblSVLop.getRowCount();
            int tongTien = donGia * soLuongSV;
            txtTongTien.setText(String.valueOf(tongTien));
        } catch (NumberFormatException e) {
            txtTongTien.setText("0");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboTenSach = new javax.swing.JComboBox<>();
        txtMaSach = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSVLop = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        btnMua = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Tên sách: ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Mã sách: ");

        cboTenSach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Danh sách sinh viên");

        tblSVLop.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tblSVLop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Tên sinh viên", "Tên khoa"
            }
        ));
        jScrollPane1.setViewportView(tblSVLop);

        btnThem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

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
        jLabel4.setText("Đơn giá: ");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Tổng tiền: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboTenSach, 0, 306, Short.MAX_VALUE)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongTien)
                            .addComponent(txtDonGia)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(btnMua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(31, 31, 31))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDonGia)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThoat)
                    .addComponent(btnMua))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        ChiTietDonMuaLop chiTietDMLop = new ChiTietDonMuaLop((java.awt.Frame)this.getParent(), true, dssv);
        chiTietDMLop.setAddMode();
        chiTietDMLop.setVisible(true);
        SinhVienLop svl = chiTietDMLop.getSVL();
        if(svl != null) {
            dssv.add(svl);
            viewTable();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        try {
            int selectedRow = this.tblSVLop.getSelectedRow();
            SinhVienLop sv = dssv.get(selectedRow);
            
            ChiTietDonMuaLop chiTietDMLop = new ChiTietDonMuaLop((java.awt.Frame)this.getParent(), true, dssv, sv);
            chiTietDMLop.setEditMode();
            chiTietDMLop.setVisible(true);
            
            SinhVienLop svl = chiTietDMLop.getSVL();
            if(svl != null) {
                sv.setMaSV(svl.getMaSV());
                sv.setTenSV(svl.getTenSV());
                sv.setTenKhoa(svl.getTenKhoa());
                viewTable();
            }
        }catch(IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 sinh viên để sửa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int selectedRow = this.tblSVLop.getSelectedRow();
        if(selectedRow != -1 && selectedRow < dssv.size()) {
            int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sinh viên này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION) {
                dssv.remove(selectedRow);
                viewTable();
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 sinh viên để xóa!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuaActionPerformed
        // TODO add your handling code here:
        if(!this.setReults()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                if (checkDonHopLe()) {
                    int donGia = Integer.parseInt(txtDonGia.getText().trim());
                    int soSV = tblSVLop.getRowCount();
                    int tongTien = donGia * soSV;
                    TTDonMuaLop donMuaLop = new TTDonMuaLop(maDonLop, maSV, maSach, tenSach, soSV, donGia, tongTien);
                    
                    DonMuaLopController.saveDonMuaLopInfo(donMuaLop);
                    
                    dssv.clear();
                    JOptionPane.showMessageDialog(this, "Mua thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    reloadForm();
                }
            } catch (Exception ex) {
                Logger.getLogger(DonMuaLop.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnMuaActionPerformed

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public List<SinhVienLop> getDssv() {
        return dssv;
    }

    public void setDssv(List<SinhVienLop> dssv) {
        this.dssv = dssv;
    }

    public String getMaDonLop() {
        return maDonLop;
    }

    public void setMaDonLop(String maDonLop) {
        this.maDonLop = maDonLop;
    }

    public boolean checkDonHopLe() throws Exception {
        if (dssv.isEmpty()) {
            throw new Exception("Danh sách sinh viên rỗng");
        }

        String maSach = txtMaSach.getText().trim();
        if (maSach.isEmpty()) {
            throw new Exception("Mã sách không được để trống");
        }

        List<SinhVienLop> svl = this.getDssv();
        Set<SinhVienLop> setSvl = new HashSet<>(svl);
        if (svl.size() != setSvl.size()) {
            throw new Exception("Có sinh viên trùng lặp trong danh sách");
        }

        return true;
    }
    
    public boolean setReults() {
        this.maDonLop = sinhMaDonLop();
        this.maSV = FakeData.layMaSV_Test();
        this.tenSach = cboTenSach.getSelectedItem().toString();
        this.maSach = txtMaSach.getText().trim();

        if (this.tenSach == null || this.tenSach.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sách!", "Message", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (this.maSach == null || this.maSach.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã sách không được để trống!", "Message", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            int donGia = Integer.parseInt(txtDonGia.getText().trim());
            int soLuongSV = tblSVLop.getRowCount();
            int tongTien = donGia * soLuongSV;
            txtTongTien.setText(String.valueOf(tongTien));
            if (tongTien <= 0) {
                JOptionPane.showMessageDialog(this, "Tổng tiền phải lớn hơn 0!", "Message", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Đơn giá phải là số hợp lệ!", "Message", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
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
            java.util.logging.Logger.getLogger(DonMuaLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DonMuaLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DonMuaLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DonMuaLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DonMuaLop dialog = new DonMuaLop(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboTenSach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSVLop;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
