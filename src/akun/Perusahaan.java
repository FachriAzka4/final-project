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
class Perusahaan extends Nasabah{

    public StringProperty nib;
    
    public String getNib() {
        return nib.get();
    }

    public void setNib(String nib) {
        this.nib.set(nib);
    }

    public Perusahaan(StringProperty nama, StringProperty alamat, ArrayList<Rekening> rekening, StringProperty nib) {
        super(nama, alamat, rekening);
        this.nib = nib;
    }
    
    public StringProperty nibProperty(){
        return nib;
    }
  
}
