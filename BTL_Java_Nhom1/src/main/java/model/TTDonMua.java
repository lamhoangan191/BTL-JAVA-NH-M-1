/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP
 */
public class TTDonMua {
    private String maDon;
    private String maSV;
    private String maSach;
    private String tenSach;
    private String loaiDon;
    private int soLuong;
    private int donGia;
    private int tongTien;

    public TTDonMua() {
    }

    public TTDonMua(String maDon, String maSV, String maSach, String tenSach, String loaiDon, int soLuong, int donGia, int tongTien) {
        this.maDon = maDon;
        this.maSV = maSV;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.loaiDon = loaiDon;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tongTien = tongTien;
    }

    public String getMaDon() {
        return maDon;
    }

    public void setMaDon(String maDon) {
        this.maDon = maDon;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getLoaiDon() {
        return loaiDon;
    }

    public void setLoaiDon(String loaiDon) {
        this.loaiDon = loaiDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "TTDonMua{" + "maDon=" + maDon + ", maSV=" + maSV + ", maSach=" + maSach + ", tenSach=" + tenSach + ", loaiDon=" + loaiDon + ", soLuong=" + soLuong + ", donGia=" + donGia + ", tongTien=" + tongTien + '}';
    }
}
