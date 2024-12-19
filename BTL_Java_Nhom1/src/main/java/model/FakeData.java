/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class FakeData {
    public static String layMaSV_Test() {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\LichSuDN.txt"))) {
            String line = br.readLine();
            if (line != null) {
                return line.trim();
            } else {
                System.out.println("File is empty");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<String> layDSKhoa() {
        List<String> dsTenKhoa = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\DanhSachKhoa.txt"), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split(",");
                    if(parts.length == 2) {
                        dsTenKhoa.add(parts[1].trim());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dsTenKhoa;
    }
    public static List<SachCuaKhoa> laySachtheoKhoa(String maKhoa) {
        List<SachCuaKhoa> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader
        (new FileReader("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\Sach.txt", StandardCharsets.UTF_8));
            String line;
            while((line = br.readLine()) != null) {
                if(!line.trim().isEmpty()) {
                    String[] x = line.split(",");
                    if(maKhoa.equals(x[0])) {
                        int donGia = Integer.parseInt(x[3].trim());
                        SachCuaKhoa sach = new SachCuaKhoa(x[1], x[2], donGia);
                        //sach.setMaKhoa(x[0]);
                        list.add(sach);
                    }
                }
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static int layDonGiaTheoTen(String tenSach) {
        int donGia = -1;
        try {
            BufferedReader br = new BufferedReader
        (new FileReader("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\Sach.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] x = line.split(",");
                    if (tenSach.equals(x[2].trim())) {
                        donGia = Integer.parseInt(x[3].trim());
                        break; // Dừng việc đọc file sau khi tìm thấy sách
                    }
                }
            }
            br.close(); // Đóng luồng đọc sau khi hoàn tất
        } catch (IOException e) {
            e.printStackTrace();
        }
        return donGia;
    }
    
    public static String layMaTheoTen(String tenSach) {
        String maSach = "";
        try {
            BufferedReader br = new BufferedReader
        (new FileReader("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\Sach.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] x = line.split(",");
                    if (tenSach.equals(x[2].trim())) {
                        maSach = x[1];
                        break; // Dừng việc đọc file sau khi tìm thấy sách
                    }
                }
            }
            br.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
        return maSach;
    }
    
    public static List<TTDonMuaLop> layDSDonMuaLop_Test() {
        List<TTDonMuaLop> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\DSDonMuaLop.txt", StandardCharsets.UTF_8));
            String line;
            while((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if(tokens.length < 7) {
                    continue;
                }
                
                String maDonMuaLop = tokens[0];
                String maSV = tokens[1];
                String maSach = tokens[2];
                String tenSach = tokens[3];
                int donGia = Integer.parseInt(tokens[4]);
                int soSV = Integer.parseInt(tokens[5]);
                int tongTien = Integer.parseInt(tokens[6]);
                
                List<SinhVienLop> dssv = new ArrayList<>();
                for(int i = 7; i < tokens.length - 1; i += 3) {
                    if(i + 2 < tokens.length) {
                        String masv = tokens[i];
                        String tenSV = tokens[i + 1];
                        String tenKhoa = tokens[i + 2];
                        dssv.add(new SinhVienLop(masv, tenSV, tenKhoa));
                    }
                }
                
                TTDonMuaLop donMuaLop = new TTDonMuaLop(maDonMuaLop, maSV, tenSach, maSach, donGia, soSV, tongTien);
                list.add(donMuaLop);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static List<TTDonMuaLe> layDSDonMuaLe_Test() {
        List<TTDonMuaLe> listDML = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\DSDonMuaLe.txt", StandardCharsets.UTF_8));
            String line;
            while((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if(tokens.length < 7) {
                    continue;
                }
                
                int donGia = Integer.parseInt(tokens[4]);
                int soLuong = Integer.parseInt(tokens[5]);
                int tong = Integer.parseInt(tokens[6]);
                TTDonMuaLe don = new TTDonMuaLe(tokens[0], tokens[1], tokens[2], tokens[3], donGia, soLuong, tong);
                listDML.add(don);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
        return listDML;
    }
    
    public static List<TTDonMua> taoDSDonMua_Test() {
        List<TTDonMua> listDonMua = new ArrayList<>();
        
        try {
            List<TTDonMuaLe> dsMuaLe = layDSDonMuaLe_Test();
            for(TTDonMuaLe dml : dsMuaLe) {
                String maDon = dml.getMaDonMuaLe();
                String maSV = dml.getMaSV();
                String maSach = dml.getMaSach();
                String tenSach = dml.getTenSach();
                String loaiDon = "Đơn lẻ";
                int sl = dml.getSoLuong();
                int dgia = dml.getDonGia();
                int tong = dml.getTongTien();
                TTDonMua donMua = new TTDonMua(maDon, maSV, maSach, tenSach, loaiDon, dgia, sl, tong);
                listDonMua.add(donMua);
            }
            
            List<TTDonMuaLop> dsMuaLop = layDSDonMuaLop_Test();
            for(TTDonMuaLop dl : dsMuaLop) {
                String maDon = dl.getMaDonMuaLop();
                String maSV = dl.getMaSV();
                String maSach = dl.getMaSach();
                String tenSach = dl.getTenSach();
                String loaiDon = "Đơn lớp";
                int sosv = dl.getSoSV();
                int dgia = dl.getDonGia();
                int tong = dl.getTongTien();
                TTDonMua donMua = new TTDonMua(maDon, maSV, tenSach, maSach, loaiDon, sosv, dgia, tong);
                listDonMua.add(donMua);
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return listDonMua;
    }
    public static List<String> layDSTenSach() {
    List<String> dsTenSach = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\Sach.txt"), StandardCharsets.UTF_8))) {
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    dsTenSach.add(parts[2].trim());
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return dsTenSach;
}
    public static ArrayList<Sach> loadSachFromFile() {
       ArrayList<Sach> dsS = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\Sach.txt"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(","); // Giả sử các thuộc tính được phân tách bởi dấu phẩy
                if (data.length == 4) {
                    try {
                        String maSach = data[0].trim();
                        String tenSach = data[1].trim();
                        String maKhoa = data[2].trim();
                        int donGia = Integer.parseInt(data[3].trim());
                        Sach sach = new Sach(maSach, tenSach, maKhoa, donGia);
                        dsS.add(sach);
                    } catch (NumberFormatException e) {
                        System.err.println("Lỗi đọc dữ liệu: Đơn giá không hợp lệ.");
                    }
                } else {
                    System.err.println("Lỗi đọc dữ liệu: Dòng không đúng định dạng.");
                }
            }
        } catch (IOException e) {
            System.err.println("Lỗi đọc file: " + e.getMessage());
        }
        return dsS;
    }
    public static ArrayList<TTDonMuaLe> readDonMuaLeInfo() {
        ArrayList<TTDonMuaLe> dsDonMuaLe = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader
        (new FileReader("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\DSDonMuaLe.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7) {
                    String maDonMuaLe = data[0];
                    String maSV = data[1];
                    String tenSach = data[2];
                    String maSach = data[3];
                    int soLuong = Integer.parseInt(data[4]);
                    int donGia = Integer.parseInt(data[5]);
                    int tongTien = Integer.parseInt(data[6]);
                    TTDonMuaLe donMuaLe = new TTDonMuaLe(maDonMuaLe, maSV, tenSach, maSach, (int) donGia, soLuong, (int) tongTien);
                    dsDonMuaLe.add(donMuaLe);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dsDonMuaLe;
    }
    public static ArrayList<TTDonMuaLop> readDonMuaLopInfo() {
        ArrayList<TTDonMuaLop> dsDonMuaLop = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader
        (new FileReader("D:\\LapTrinhJava\\BTL\\Java Nhom 1\\BTL_Java_Nhom1\\src\\main\\java\\data\\DSDonMuaLop.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7) {
                    String maDonMuaLop = data[0];
                    String maSV = data[1];
                    String maSach = data[2];
                    String tenSach = data[3];
                    int donGia = Integer.parseInt(data[4]);
                    int soSV = Integer.parseInt(data[5]);
                    int tongTien = Integer.parseInt(data[6]);
                    TTDonMuaLop donMuaLop = new TTDonMuaLop(maDonMuaLop, maSV, maSach, tenSach, donGia, soSV, tongTien);
                    dsDonMuaLop.add(donMuaLop);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dsDonMuaLop;
    }
   public static boolean isMaSachExist(String maSach) {
    ArrayList<Sach> dsS = loadSachFromFile();
    for (Sach sach : dsS) {
        if (sach.getMaSach().equals(maSach)) {
            return true; // Nếu mã sách đã tồn tại trong danh sách, trả về true
        }
    }
    return false; // Nếu không tìm thấy mã sách trong danh sách, trả về false
}

}
