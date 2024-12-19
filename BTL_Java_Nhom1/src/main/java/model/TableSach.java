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
public class TableSach extends AbstractTableModel {
    private String Name[] = {"Tên Sách","Mã Khoa","Mã Sách " ,"Đơn giá"};
    
    private Class classess[]  = {String.class,String.class,String.class,Integer.class};
    
    ArrayList<Sach> dsS = new ArrayList<Sach>();
    
    public TableSach(ArrayList<Sach> sach) {
        dsS = sach;
    }
    public Sach getSachAt(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < dsS.size()) {
            return dsS.get(rowIndex);
        }
        return null;
    }
    @Override
     public int getRowCount() {
         return dsS.size();
     }

    @Override
    public int getColumnCount() {
        return Name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return dsS.get(rowIndex).getTenSach();
            
            case 1: return dsS.get(rowIndex).getMaKhoa();
            
            case 2: return dsS.get(rowIndex).getMaSach();
             
            case 3: return dsS.get(rowIndex).getDonGia();
            
            
            
            
            default : return null;
        }
    }
    public Class getColumnClass(int columnIndex){
        return classess[columnIndex];
    }
    
    public String getColumnName(int column){
        return Name[column];
    }
    public void btnXoa(int rowIndex) {
    if (rowIndex >= 0 && rowIndex < dsS.size()) {
        dsS.remove(rowIndex); // Xóa đối tượng Sach tại vị trí rowIndex trong dsS
        fireTableRowsDeleted(rowIndex, rowIndex); // Thông báo cho TableModel biết rằng dòng đã bị xóa
    }
}
}
