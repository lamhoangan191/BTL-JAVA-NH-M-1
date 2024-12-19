/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author HP
 */
public class SachCuaKhoa {
    private String maSach;
    private String tenSach;
    private int donGia;

    public SachCuaKhoa() {
    }

    public SachCuaKhoa(String maSach, String tenSach, int donGia) {
        this.maSach = maSach;
        this.tenSach = tenSach;
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

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.maSach);
        hash = 11 * hash + Objects.hashCode(this.tenSach);
        hash = 11 * hash + this.donGia;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SachCuaKhoa other = (SachCuaKhoa) obj;
        if (this.donGia != other.donGia) {
            return false;
        }
        if (!Objects.equals(this.maSach, other.maSach)) {
            return false;
        }
        return Objects.equals(this.tenSach, other.tenSach);
    }

    

    
    public static List<SachCuaKhoa> readSachFromFile(String filePath) {
        List<SachCuaKhoa> dsSach = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 3) {
                    SachCuaKhoa sach = new SachCuaKhoa();
                    sach.setMaSach(parts[0]);
                    sach.setTenSach(parts[1]);
                    
                    dsSach.add(sach);
                }
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
        return dsSach;
    }

    @Override
    public String toString() {
        return "SachCuaKhoa{" + "maSach=" + maSach + ", tenSach=" + tenSach + ", donGia=" + donGia + '}';
    }

    
    
    
}
