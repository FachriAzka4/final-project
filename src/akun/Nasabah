/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akun;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public abstract class Nasabah {
    
    protected String nama, alamat;
    protected ArrayList<Rekening> rekening;
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public ArrayList<Rekening> getRekening(){
        return rekening;
    }
    
    public void setRekening(ArrayList<Rekening> rekening){
        this.rekening = rekening;
    }

    public Nasabah(String nama, String alamat, ArrayList<Rekening> rekening) {
        this.nama = nama;
        this.alamat = alamat;
        this.rekening = rekening;
    }

    public void tambahRekening(Rekening rek){
        rekening.add(rek);
    }
    
    abstract public void print();
}
