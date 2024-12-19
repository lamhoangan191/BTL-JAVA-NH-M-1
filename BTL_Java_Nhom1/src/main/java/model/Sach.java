/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP
 */
public class Sach {
    private String maSach;
    private String tenSach;
    private String maKhoa;
    private int donGia;

    public Sach() {
    }

    public Sach(String maSach, String tenSach, String maKhoa, int donGia) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.maKhoa = maKhoa;
        this.donGia = donGia;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
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

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

     public String toCSV() {
        //return tenSach + "," + maKhoa + "," + maSach + "," + donGia;
        return  maSach + "," + tenSach + "," + maKhoa + "," + donGia;
    }

    @Override
    public String toString() {
        return  maSach + "," + tenSach + "," + maKhoa + "," + donGia;
    }

    
    
    
}
