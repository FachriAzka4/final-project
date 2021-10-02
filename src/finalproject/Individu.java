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
}