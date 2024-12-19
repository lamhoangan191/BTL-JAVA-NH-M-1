/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP
 */
public class SinhVienLop {
    private String maSV;
    private String tenSV;
    private String tenKhoa;

    public SinhVienLop() {
    }

    public SinhVienLop(String maSV, String tenSV, String tenKhoa) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.tenKhoa = tenKhoa;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }
    
    
    
    public String toString() {
        return maSV + ", " + tenSV + ", " + tenKhoa;
    }
}


