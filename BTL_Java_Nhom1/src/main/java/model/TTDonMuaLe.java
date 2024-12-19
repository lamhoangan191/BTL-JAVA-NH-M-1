/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP
 */
public class TTDonMuaLe {
    private String maDonMuaLe;
    private String maSV;
    private String tenSach;
    private String maSach;
    private int donGia;
    private int soLuong;
    private int tongTien;

    public TTDonMuaLe() {
    }

    public TTDonMuaLe(String maDonMuaLe, String maSV, String tenSach, String maSach, int soLuong, int donGia, int tongTien) {
        this.maDonMuaLe = maDonMuaLe;
        this.maSV = maSV;
        this.tenSach = tenSach;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tongTien = tongTien;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
    
    public String getMaDonMuaLe() {
        return maDonMuaLe;
    }

    public void setMaDonMuaLe(String maDonMuaLe) {
        this.maDonMuaLe = maDonMuaLe;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return maDonMuaLe + "," + maSV + "," + tenSach + "," + maSach + "," + soLuong + "," + donGia + "," + tongTien;
    }

    

}
