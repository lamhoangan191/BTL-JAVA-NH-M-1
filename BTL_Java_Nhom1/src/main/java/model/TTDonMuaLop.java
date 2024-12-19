/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author HP
 */
public class TTDonMuaLop {
    private String maDonMuaLop;
    private String maSV;
    private String tenSach;
    private String maSach;
    private int donGia;
    private int soSV;
    private int tongTien;
    private List<SinhVienLop> dssv;

    public TTDonMuaLop() {
    }

    public TTDonMuaLop(String maDonMuaLop, String maSV, String maSach, String tenSach, int soSV,int donGia, int tongTien) {
        this.maDonMuaLop = maDonMuaLop;
        this.maSV = maSV;
        this.tenSach = tenSach;
        this.maSach = maSach;
        this.soSV = soSV;
        this.donGia = donGia;
        this.tongTien = tongTien;
    }

    public String getMaDonMuaLop() {
        return maDonMuaLop;
    }

    public void setMaDonMuaLop(String maDonMuaLop) {
        this.maDonMuaLop = maDonMuaLop;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

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

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoSV() {
        return soSV;
    }

    public void setSoSV(int soSV) {
        this.soSV = soSV;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public List<SinhVienLop> getDssv() {
        return dssv;
    }

    public void setDssv(List<SinhVienLop> dssv) {
        this.dssv = dssv;
    }
    
    public void addSVL(SinhVienLop svl) {
        dssv.add(svl);
    }
    
    @Override
    public String toString() {
        return maDonMuaLop + "," + maSV + "," + maSach + "," + tenSach + "," + soSV + "," + donGia + "," + tongTien;
    }

  
}
