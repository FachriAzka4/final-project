/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.ArrayList;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author theen
 */
public abstract class Nasabah {
    private StringProperty nama;
    private IntegerProperty idNasabah;
    private StringProperty alamat;
    ArrayList <Rekening> rekening = new ArrayList<Rekening>();

    public Nasabah(String nama, Integer idNasabah, String alamat, ArrayList<Rekening> rekening) {
        this.nama = new SimpleStringProperty(nama);
        this.idNasabah = new SimpleIntegerProperty(idNasabah);
        this.alamat = new SimpleStringProperty(alamat);
        this.rekening = rekening;
    }
    public Nasabah(String nama, Integer idNasabah, String alamat, Rekening rekening) {
        this.nama = new SimpleStringProperty(nama);
        this.idNasabah = new SimpleIntegerProperty(idNasabah);
        this.alamat = new SimpleStringProperty(alamat);
        this.rekening.add(rekening);
    }
    
    public String getNama() {
        return nama.get();
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public Integer getIdNasabah() {
        return idNasabah.get();
    }

    public void setIdNasabah(Integer idNasabah) {
        this.idNasabah.set(idNasabah);
    }

    public String getAlamat() {
        return alamat.get();
    }

    public void setAlamat(String alamat) {
        this.alamat.set(alamat);
    }

    public ArrayList<Rekening> getRekening() {
        return rekening;
    }

    public void setRekening(ArrayList<Rekening> rekening) {
        this.rekening = rekening;
    }
    
    public void tambahRekening(){
        
    }

    public StringProperty namaProperty(){
        return nama;
    }
    
    public IntegerProperty idNasabahProperty(){
        return idNasabah;
    }
    
    public StringProperty alamatProperty(){
        return alamat;
    }
    
    public void tambahRekening(Rekening rek){
        this.rekening.add(rek);
    }
    public void print() {
        System.out.println("Nama: " + getNama());
        System.out.println("Alamat: " + getAlamat());
        System.out.println("NIB: " + getNib());
        System.out.println("===========================================");
        String infoRekening=String.format("No Rekening"+"%26s","Saldo");
        System.out.println(infoRekening);
        System.out.println("===========================================");
        for(Rekening rekening : getRekening()){
            System.out.printf("%s%34.2f\n",rekening.getNoRekening(),rekening.getSaldo());
        }

    }
}
