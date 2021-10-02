/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author theen
 */
public class Rekening {
    private IntegerProperty noRekening;
    private DoubleProperty saldo;

    public Rekening(Integer noRekening, Double saldo) {
        this.noRekening = new SimpleIntegerProperty(noRekening);
        this.saldo = new SimpleDoubleProperty(saldo);
    }

    public Integer getNoRekening() {
        return noRekening.get();
    }

    public void setNoRekening(Integer noRekening) {
        this.noRekening.set(noRekening);
    }

    public Double getSaldo() {
        return saldo.get();
    }

    public void setSaldo(Double saldo) {
        this.saldo.set(saldo);
    }
    
    public void tambahSaldo(Double jumlah){
        this.setSaldo(getSaldo() + jumlah);
    }
    public void tarikTunai(Double jumlah){
        this.setSaldo(getSaldo() - jumlah);
    }
}
