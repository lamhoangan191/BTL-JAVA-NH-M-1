/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP
 */
public class TableDonMuaLop extends AbstractTableModel {
    private String Name[] = {"Mã đơn mua lớp","Mã SV Đăng Ký Phiếu","Mã sách","Tên sách" ,"Số Sinh viên đăng ký","Đơn giá","Tổng tiền" };
    
    private Class classess[]  = {String.class,String.class,String.class,
        Integer.class,Integer.class,Integer.class , String.class};
    ArrayList<TTDonMuaLop> dsML = new ArrayList<TTDonMuaLop>();
    
    public TableDonMuaLop(ArrayList<TTDonMuaLop> donml) {
        dsML = donml;
    }
    
    @Override
     public int getRowCount() {
         return dsML.size();
     }

    @Override
    public int getColumnCount() {
        return Name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return dsML.get(rowIndex).getMaDonMuaLop();
            
            case 1: return dsML.get(rowIndex).getMaSV();
            
            case 2: return dsML.get(rowIndex).getMaSach();
             
            case 3: return dsML.get(rowIndex).getTenSach();
            
            case 4: return dsML.get(rowIndex).getSoSV();
            
            case 5: return dsML.get(rowIndex).getDonGia();
            
            case 6: return dsML.get(rowIndex).getTongTien();
            
            
            default : return null;
        }
    }
    public Class getColumnClass(int columnIndex){
        return classess[columnIndex];
    }
    
    public String getColumnName(int column){
        return Name[column];
    }
}
