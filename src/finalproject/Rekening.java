/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akun;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;

/**
 *
 * @author theen
 */
public class Rekening {
    private IntegerProperty noRekening;
    private DoubleProperty saldo;

    public Rekening(IntegerProperty noRekening, DoubleProperty saldo) {
        this.noRekening = noRekening;
        this.saldo = saldo;
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
    
    public void tambahSaldo(double jumlah){
        this.setSaldo(getSaldo() + jumlah);
    }
    public void tarikTunai(double jumlah){
        this.setSaldo(getSaldo() - jumlah);
    }
}
