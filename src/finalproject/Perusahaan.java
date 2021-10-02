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
public class Perusahaan extends Nasabah {
    LongProperty nib;

    public Perusahaan(Long nib, String nama, Integer idNasabah, String alamat, ArrayList<Rekening> rekening) {
        super(nama, idNasabah, alamat, rekening);
        this.nib = new SimpleLongProperty(nib);
    }
    public Perusahaan(Long nib, String nama, Integer idNasabah, String alamat, Rekening rekening) {
        super(nama, idNasabah, alamat, rekening);
        this.nib = new SimpleLongProperty(nib);
    }

    public Long getNib() {
        return nib.get();
    }

    public void setNib(Long nib) {
        this.nib.set(nib);
    }
    
    public LongProperty nibProperty(){
        return nib;
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