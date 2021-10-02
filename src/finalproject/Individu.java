/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.ArrayList;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;

/**
 *
 * @author theen
 */
public class Individu extends Nasabah {
    LongProperty nik;
    LongProperty npwp;

    public Individu(Long nik, Long npwp, String nama, Integer idNasabah, String alamat, ArrayList<Rekening> rekening) {
        super(nama, idNasabah, alamat, rekening);
        this.nik = new SimpleLongProperty(nik);
        this.npwp = new SimpleLongProperty(npwp);
    }
    public Individu(Long nik, Long npwp, String nama, Integer idNasabah, String alamat, Rekening rekening) {
        super(nama, idNasabah, alamat, rekening);
        this.nik = new SimpleLongProperty(nik);
        this.npwp = new SimpleLongProperty(npwp);
    }
    
    public Long getNik() {
        return nik.get();
    }

    public void setNik(Long nik) {
        this.nik.set(nik);
    }

    public Long getNpwp() {
        return npwp.get();
    }

    public void setNpwp(Long npwp) {
        this.npwp.set(npwp);
    }
    
    public LongProperty nikProperty(){
        return nik;
    }
    public LongProperty npwpProperty(){
        return npwp;
    }
    public void print() {
        System.out.println("Nama: " + getNama());
        System.out.println("Alamat: " + getAlamat());
        System.out.println("NIK: " + getNik());
        System.out.println("NPWP: "+ getNpwp());
        System.out.println("===========================================");
        String infoRekening=String.format("No Rekening"+"%26s","Saldo");
        System.out.println(infoRekening);
        System.out.println("===========================================");
        for(Rekening rekening : getRekening()){
            System.out.printf("%s%34.2f\n",rekening.getNoRekening(),rekening.getSaldo());
        }
    }
}
