/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import model.TTDonMuaLop;

/**
 *
 * @author HP
 */
public class DonMuaLopController {
    public static void saveDonMuaLopInfo(TTDonMuaLop dl) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter
        (new FileOutputStream("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\DSDonMuaLop.txt", true), "UTF-8"))) {
            writer.write(dl.toString());
            writer.newLine();  // Thêm dòng mới để cách biệt giữa các bản ghi
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void saveAllDonMuaLopInfo(ArrayList<TTDonMuaLop> dsDonMuaLop) {
        try (BufferedWriter writer = new BufferedWriter
        (new OutputStreamWriter
        (new FileOutputStream("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\DSDonMuaLop.txt"), "UTF-8"))) {
            for (TTDonMuaLop dl : dsDonMuaLop) {
                writer.write(dl.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }

}
