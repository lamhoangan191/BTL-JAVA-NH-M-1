/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import model.FakeData;
import model.Sach;

/**
 *
 * @author HP
 */
public class PhatHanhSachController {
    public static void saveSachInfo(Sach sach) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream
        ("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\Sach.txt", true), "UTF-8"))) {
            writer.write(sach.toString());
            writer.newLine();  // Thêm dòng mới để cách biệt giữa các bản ghi
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void saveTableDataToSachFile(ArrayList<Sach> dsSach) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter
        ("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\Sach.txt"))) {
            for (Sach sach : dsSach) {
                writer.write(sach.toCSV());
                writer.newLine();  // Thêm dòng mới để cách biệt giữa các bản ghi
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     public static void xoaSach(Sach sach) throws IOException {
        ArrayList<Sach> dsSach = new ArrayList<>();
        // Đọc toàn bộ danh sách sách từ tệp tin
        try (BufferedReader reader = new BufferedReader(new FileReader
        ("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\Sach.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Sach s = new Sach(data[0], data[1], data[2], Integer.parseInt(data[3]));
                dsSach.add(s);
            }
        }
        // Tìm và xóa sách cần xóa từ danh sách
        for (int i = 0; i < dsSach.size(); i++) {
            Sach s = dsSach.get(i);
            if (s.getMaSach().equals(sach.getMaSach())) {
                dsSach.remove(i);
                break;
            }
        }
        // Ghi lại danh sách sách đã cập nhật vào tệp tin
        try (BufferedWriter writer = new BufferedWriter(new FileWriter
        ("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\Sach.txt"))) {
            for (Sach s : dsSach) {
                writer.write(s.toCSV());
                writer.newLine();
            }
        }
    }
}
