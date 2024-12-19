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
public class TableDonMuaLe extends AbstractTableModel{
    private String Name[] = {"Mã đơn mua lẻ","Mã sinh viên","Tên sách" ,"Mã sách","Số lượng", "Đơn giá","Tổng tiền"};
    
    private Class classess[]  = {String.class,String.class,String.class,String.class,
        Integer.class,Integer.class,Integer.class};
    ArrayList<TTDonMuaLe> dsDML = new ArrayList<TTDonMuaLe>();
    
    public TableDonMuaLe(ArrayList<TTDonMuaLe> don) {
        dsDML = don;
    }
    
    @Override
     public int getRowCount() {
         return dsDML.size();
     }

    @Override
    public int getColumnCount() {
        return Name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return dsDML.get(rowIndex).getMaDonMuaLe();
            
            case 1: return dsDML.get(rowIndex).getMaSV();
            
            case 2: return dsDML.get(rowIndex).getTenSach();
             
            case 3: return dsDML.get(rowIndex).getMaSach();
            
            case 4: return dsDML.get(rowIndex).getSoLuong();
            
            case 5: return dsDML.get(rowIndex).getDonGia();
            
            case 6: return dsDML.get(rowIndex).getTongTien();
            
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
