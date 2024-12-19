/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FakeData;
import model.TTDonMua;

/**
 *
 * @author HP
 */
public class TKDSDonTheoSV {
    public static List<TTDonMua> listDon = FakeData.taoDSDonMua_Test();
    static Map<String, List<TTDonMua>> mapDon = new HashMap<>();
    
    public static void tongHopTheoSV() {
        for(TTDonMua don : listDon) {
            String maSV = don.getMaSV();
            if(!mapDon.containsKey(maSV)) {
                mapDon.put(maSV, new ArrayList<>());
            }
            mapDon.get(maSV).add(don);
        }
    }
    
    public static List<TTDonMua> dsDonTheoMaSV(String masv) {
        mapDon.clear();
        tongHopTheoSV();
        List<TTDonMua> donMua = new ArrayList<>();
        for(Map.Entry<String, List<TTDonMua>> entry : mapDon.entrySet()) {
            if(entry.getKey().equals(masv)) {
                List<TTDonMua> ds = entry.getValue();
                for(TTDonMua don : ds) {
                    if(don.getMaSV().equals(masv)) {
                        donMua.add(don);
                    }
                }
            }
        }
        return donMua;
    } 
}
