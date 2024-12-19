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
import model.TTDonMuaLe;

/**
 *
 * @author HP
 */
public class DonMuaLeController {

    public static void saveDonMuaLeInfo(TTDonMuaLe dml) {
        try (BufferedWriter writer = new BufferedWriter
        (new OutputStreamWriter(new FileOutputStream
        ("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\DSDonMuaLe.txt", true), "UTF-8"))) {
            writer.write(dml.toString());
            writer.newLine();  // Thêm dòng mới để cách biệt giữa các bản ghi
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void updateAll(ArrayList<TTDonMuaLe> dsDon) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter
        (new FileOutputStream("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\DSDonMuaLe.txt", false), "UTF-8"))) {
            for (TTDonMuaLe dml : dsDon) {
                writer.write(dml.getMaDonMuaLe() + "," + dml.getMaSV() + "," + dml.getTenSach() + "," + dml.getMaSach() + "," + dml.getDonGia() + "," + dml.getSoLuong() + "," + dml.getTongTien());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
