/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;
import finalproject.db.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author theen
 */

public class NasabahDataModel {
    public final Connection conn;

    public NasabahDataModel(String driver) throws SQLException {
        this.conn = DBHelper.getConnection(driver);
    }
    public void addNasabah(Individu nasabah) throws SQLException{
        String insertNasabah = "INSERT INTO Nasabah (idNasabah, nama, alamat)"
                + " VALUES (?,?,?)";
        String insertIndividu = "INSERT INTO Individu (idNasabah, nik, npwp)"
                + " VALUES (?,?,?)";
        String insertRekening = "INSERT INTO Rekening (noRekening, saldo, idNasabah)"
                + " VALUES (?,?,?)";
        PreparedStatement stmtNasabah = conn.prepareStatement(insertNasabah);
        stmtNasabah.setInt(1, nasabah.getIdNasabah());
        stmtNasabah.setString(2, nasabah.getNama());
        stmtNasabah.setString(3, nasabah.getAlamat());
        stmtNasabah.execute();
        
        PreparedStatement stmtIndividual = conn.prepareStatement(insertIndividu);
        stmtIndividual.setInt(1, nasabah.getIdNasabah());
        stmtIndividual.setLong(2, nasabah.getNik());
        stmtIndividual.setLong(3, nasabah.getNpwp());
        stmtIndividual.execute();
        
        PreparedStatement stmtRekening = conn.prepareStatement(insertRekening);
        stmtRekening.setInt(1, nasabah.getRekening().get(0).getNoRekening());
        stmtRekening.setDouble(2, nasabah.getRekening().get(0).getSaldo());
        stmtRekening.setInt(3, nasabah.getIdNasabah());
        stmtRekening.execute();
        
    }
    public void addNasabah(Perusahaan perusahaan) throws SQLException{
        String insertNasabah = "INSERT INTO Nasabah (idNasabah, nama, alamat)"
                + " VALUES (?,?,?)";
        String insertPerusahaan = "INSERT INTO Perusahaan (idNasabah, nib)"
                + " VALUES (?,?)";
        String insertRekening = "INSERT INTO Rekening (noRekening, saldo, idNasabah)" 
                + " VALUES (?,?,?)";
        PreparedStatement stmtNasabah = conn.prepareStatement(insertNasabah);
        stmtNasabah.setInt(1, perusahaan.getIdNasabah());
        stmtNasabah.setString(2, perusahaan.getNama());
        stmtNasabah.setString(3, perusahaan.getAlamat());
        stmtNasabah.execute();
        
        PreparedStatement stmtPerusahaan = conn.prepareStatement(insertPerusahaan);
        stmtPerusahaan.setInt(1, perusahaan.getIdNasabah());
        stmtPerusahaan.setLong(2, perusahaan.getNib());
        stmtPerusahaan.execute();
        
        PreparedStatement stmtRekening = conn.prepareStatement(insertRekening);
        stmtRekening.setInt(1, perusahaan.getRekening().get(0).getNoRekening());
        stmtRekening.setDouble(2, perusahaan.getRekening().get(0).getSaldo());
        stmtRekening.setInt(3, perusahaan.getIdNasabah());
        stmtRekening.execute();
    }
   public ObservableList<Individu> getIndividu(){
       ObservableList<Individu> data = FXCollections.observableArrayList();
       String sql="SELECT `nik`, `npwp`, `nama`, `idNasabah`, `alamat` "
               + "FROM `Nasabah` NATURAL JOIN `Individu` "
               + "ORDER BY nama";
       try {
           ResultSet rs = conn.createStatement().executeQuery(sql);
           while (rs.next()){
               String sqlRekening = "SELECT noRekening, saldo "
                       + "FROM Rekening WHERE idNasabah="+rs.getInt(1);
               ResultSet rsRekening = conn.createStatement().executeQuery(sqlRekening);
               ArrayList<Rekening> dataRekening = new ArrayList<>();
               while (rsRekening.next()){
                   dataRekening.add(new Rekening(rsRekening.getInt(1),rsRekening.getDouble(2)));
               }
               data.add(new Individu(rs.getLong(1), rs.getLong(2), rs.getString(3), rs.getInt(4), rs.getString(5), dataRekening));
           }
       } catch (SQLException ex) {
           Logger.getLogger(NasabahDataModel.class.getName()).log(Level.SEVERE, null, ex);
       }
       return data;
   }
   public ObservableList<Perusahaan> getPerusahaan(){
       ObservableList<Perusahaan> data = FXCollections.observableArrayList();
       String sql="SELECT `nib`, `nama`, `idNasabah`, `alamat` "
               + "FROM `Nasabah` NATURAL JOIN `Perusahaan` "
               + "ORDER BY nama";
       try {
           ResultSet rs = conn.createStatement().executeQuery(sql);
           while (rs.next()){
               String sqlRekening = "SELECT noRekening, saldo "
                   + "FROM Rekening WHERE idNasabah="+rs.getInt(1);
               ResultSet rsRekening = conn.createStatement().executeQuery(sqlRekening);
               ArrayList<Rekening> dataRekening = new ArrayList<>();
               while (rsRekening.next()){
                   dataRekening.add(new Rekening(rsRekening.getInt(1),rsRekening.getDouble(2)));
               }
               data.add(new Perusahaan(rs.getLong(1),rs.getString(2),rs.getInt(3),rs.getString(4), dataRekening));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(NasabahDataModel.class.getName()).log(Level.SEVERE, null, ex);
       }
       return data;
   }
   public ObservableList<Rekening> getRekening(int Rekening){
       ObservableList<Rekening> data = FXCollections.observableArrayList();
       String sql="SELECT `noRekening`, `saldo` "
               + "FROM `Rekening` "
               + "WHERE idNasabah="+Rekening;
       try {
           ResultSet rs = conn.createStatement().executeQuery(sql);
           while (rs.next()){
               data.add(new Rekening(rs.getInt(1),rs.getDouble(2)));
           }
       } catch (SQLException ex) {
           Logger.getLogger(NasabahDataModel.class.getName()).log(Level.SEVERE, null, ex);
       }
       return data;
   }
   public int nextId() throws SQLException{
       String sql="SELECT MAX(idNasabah) from Nasabah";
       ResultSet rs = conn.createStatement().executeQuery(sql);
       while (rs.next()){
               return rs.getInt(1)==0?1000001:rs.getInt(1)+1;
           }
       return 1000001;
   }
   public int nextRekeningNumber(int idNasabah) throws SQLException{
       String sql="SELECT MAX(noRekening) FROM Rekening WHERE idNasabah="+idNasabah;
       ResultSet rs = conn.createStatement().executeQuery(sql);
       while (rs.next()){
               return rs.getInt(1)+1;
           }
       return 0;
   }
   
   public void addRekening(int idNasabah, Rekening acc) throws SQLException{
       String insertNasabah = "INSERT INTO Rekening (noRekening, idNasabah, saldo)"
               + " VALUES (?,?,?)";
 
       PreparedStatement stmtPerusahaan = conn.prepareStatement(insertNasabah);
       stmtPerusahaan.setInt(2, idNasabah);
       stmtPerusahaan.setInt(1, acc.getNoRekening());
       stmtPerusahaan.setDouble(3, acc.getSaldo());
       stmtPerusahaan.execute();
       
   }
   public void tambahSaldo(Rekening rek, double jumlah) throws SQLException{
        String insertNasabah = "UPDATE Rekening "
                + "SET saldo = ? "
                + "WHERE noRekening = ?";
        
        PreparedStatement stmtNasabah = conn.prepareStatement(insertNasabah);
        stmtNasabah.setDouble(1, (rek.getSaldo() + jumlah));
        stmtNasabah.setInt(2, rek.getNoRekening());
        stmtNasabah.execute();
    }
    
    public void tarikSaldo(Rekening rek, double jumlah) throws SQLException{
        String insertNasabah = "UPDATE Rekening "
                + "SET saldo = ? "
                + "WHERE noRekening = ?";
        
        PreparedStatement stmtNasabah = conn.prepareStatement(insertNasabah);
        stmtNasabah.setDouble(1, (rek.getSaldo() - jumlah));
        stmtNasabah.setInt(2, rek.getNoRekening());
        stmtNasabah.execute();
    }
}