/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akun;

import java.util.ArrayList;
import javafx.beans.property.StringProperty;  
/**
 *
 * @author ASUS
 */
public abstract class Nasabah {
    
    protected StringProperty nama, alamat;
    protected ArrayList<Rekening> rekening;
    
    public String getNama() {
        return nama.get();
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public String getAlamat() {
        return alamat.get();
    }

    public void setAlamat(String alamat) {
        this.alamat.set(alamat);
    }

    public ArrayList<Rekening> getRekening(){
        return rekening;
    }
    
    public void setRekening(ArrayList<Rekening> rekening){
        this.rekening = rekening;
    }

    public Nasabah(StringProperty nama, StringProperty alamat, ArrayList<Rekening> rekening) {
        this.nama = nama;
        this.alamat = alamat;
        this.rekening = rekening;
    }

    public void tambahRekening(Rekening rek){
        rekening.add(rek);
    }
    
    abstract public void print();
}
