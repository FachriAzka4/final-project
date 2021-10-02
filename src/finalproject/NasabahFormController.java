/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author theen
 */
public class NasabahFormController implements Initializable {

@FXML
    private TextField tfId;

    @FXML
    private TextField tfNama;

    @FXML
    private TextField tfAlamat;

    @FXML
    private TextField tfNik;

    @FXML
    private TextField tfNpwp;

    @FXML
    private Button btAddNasabah;

    @FXML
    private Button btReload;

    @FXML
    private Button btClear;

    @FXML
    private TextField tfNoRek;

    @FXML
    private TextField tfSaldo;

    @FXML
    private TableView<Individu> tbNasabah;

    @FXML
    private TableColumn<Individu, Integer> cIId;

    @FXML
    private TableColumn<Individu, Integer> clNoRek;

    @FXML
    private TableColumn<Individu, String> clNama;

    @FXML
    private TableColumn<Individu, String> clAlamat;

    @FXML
    private TableColumn<Individu, Integer> clNik;

    @FXML
    private TableColumn<Individu, Integer> clNpwp;

    @FXML
    private TableView<Rekening> tblRekening;

    @FXML
    private TableColumn<Nasabah, Integer> clNoRek0;

    @FXML
    private TableColumn<Nasabah, Double> colSaldo;

    @FXML
    private TextField tfNewId;

    @FXML
    private TextField tfNewNoRek;

    @FXML
    private TextField tfNewSaldo;

    @FXML
    private Button btAddRek;

    @FXML
    private TextField tfId1;

    @FXML
    private TextField tfNama1;

    @FXML
    private TextField tfAlamat1;

    @FXML
    private TextField tfNib;

    @FXML
    private TextField tfNoRek1;

    @FXML
    private TextField tfSaldo1;

    @FXML
    private Button btAddNasabah1;

    @FXML
    private Button btReload1;

    @FXML
    private Button btClear1;

    @FXML
    private Label lblSaveStatusP;

    @FXML
    private TableView<Perusahaan> tblNasabahP;

    @FXML
    private TableColumn<Perusahaan, Perusahaan> cIdNasabah1;

    @FXML
    private TableColumn<Perusahaan, Integer> clNoRek1;

    @FXML
    private TableColumn<Perusahaan, String> clNama1;

    @FXML
    private TableColumn<Perusahaan, String> clAlamat1;

    @FXML
    private TableColumn<Perusahaan, Long> clNib;

    @FXML
    private TableView<Rekening> tblRekeningP;

    @FXML
    private TableColumn<Nasabah, Integer> clNoRek2;

    @FXML
    private TableColumn<Nasabah, Double> clSaldo1;

    @FXML
    private TextField tfNewId1;

    @FXML
    private TextField tfNewNoRek1;

    @FXML
    private TextField tfNewSaldo1;

    @FXML
    private Button btAddRek1;

    @FXML
    private Label lblDBStatus;
    
    NasabahDataModel nfc;
    
   @FXML
    void handleAddAccountButton(ActionEvent event) {
        try {
            Rekening rek =  new Rekening(Integer.parseInt(tfNewNoRek.getText()),
                            Double.parseDouble(tfNewSaldo.getText()));
            
            nfc.addRekening(Integer.parseInt(tfNewId.getText()), rek);          
            viewDataRekening(Integer.parseInt(tfNewId.getText()));
            btReload.fire();
            tfNewSaldo.setText("");
            
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleAddHolderButton(ActionEvent event) {
        Individu i = new Individu(
                Long.parseLong(tfNik.getText()),
                Long.parseLong(tfNpwp.getText()),        
                tfNama.getText(),
                Integer.parseInt(tfId.getText()),
                tfAlamat.getText(),
                new Rekening(Integer.parseInt(tfNoRek.getText()), Double.parseDouble(tfSaldo.getText()))
                
                );
        try {
            nfc.addNasabah(i);
            btReload.fire();
            btClear.fire();
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    void handleClearButton(ActionEvent event) {
        try {
            tfId.setText("" + nfc.nextId());
            tfNoRek.setText(tfId.getText() + "01");
            tfNama.setText("");
            tfAlamat.setText("");
            tfNik.setText("");
            tfNpwp.setText("");
            tfSaldo.setText("");
            
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    @FXML
    void handleReloadButton(ActionEvent event) {
        ObservableList<Individu> data = nfc.getIndividu();
        clNik.setCellValueFactory(new PropertyValueFactory<>("nik"));
        clNpwp.setCellValueFactory(new PropertyValueFactory<>("npwp"));
        clNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        clAlamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        cIId.setCellValueFactory(new PropertyValueFactory<>("idNasabah"));
        tbNasabah.setItems(null);
        tbNasabah.setItems(data);
        btAddRek.setDisable(true);
    }
    
    //corp
    @FXML
    void handleAddCorpAccountButton(ActionEvent event) {
//        try {
//            Rekening rek =  new Rekening(Integer.parseInt(tfNoRek1.getText()),
//                            Double.parseDouble(tfSaldo1.getText()));
//            
//            nfc.addRekening(Integer.parseInt(tfId1.getText()), rek);          
//            viewDataRekening(Integer.parseInt(tfId1.getText()));
//            btReload1.fire();
//            tfSaldo1.setText("");
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @FXML
    void handleAddCorpHolderButton(ActionEvent event) {
//        Perusahaan p = new Perusahaan(Integer.parseInt(tfIdNasabahP.getText()),
//                tfNamaP.getText(),
//                tfAlamatP.getText(),
//                new Rekening(Integer.parseInt(tfNoRekeningP.getText()), Double.parseDouble(tfSaldoP.getText())),
//                tfNib.getText());
//        try {
//            nfc.tambahNasabah(p);
//            lblSaveStatusP.setText("Rekening berhasil dibuat");
//            btnReloadP.fire();
//            btnClearP.fire();
//        } catch (SQLException ex) {
//            lblSaveStatusP.setText("Rekening gagal dibuat");
//            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @FXML
    void handleCorpClearButton(ActionEvent event) {
//        try {
//            tfIdNasabahP.setText("" + nfc.nextIdNasabah());
//            tfNoRekeningP.setText(tfIdNasabahP.getText() + "01");
//            tfNamaP.setText("");
//            tfAlamatP.setText("");
//            tfNib.setText("");
//            tfSaldoP.setText("");
//        } catch (SQLException ex) {
//            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
//        }
            
    }

    @FXML
    void handleCorpReloadButton(ActionEvent event) {
//        ObservableList<Perusahaan> data = nfc.getPerusahaan();
//        colIdNasabahP.setCellValueFactory(new PropertyValueFactory<>("IdNasabah"));
//        colNamaP.setCellValueFactory(new PropertyValueFactory<>("nama"));
//        colAlamatP.setCellValueFactory(new PropertyValueFactory<>("alamat"));
//        colNib.setCellValueFactory(new PropertyValueFactory<>("nib"));
//        colNumRekeningP.setCellValueFactory(new PropertyValueFactory<>("numRekening"));
//        tblNasabahP.setItems(null);
//        tblNasabahP.setItems(data);
//        btnTambahRekeningP.setDisable(true);
    }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            nfc = new NasabahDataModel("SQLITE");
            lblDBStatus.setText(nfc.conn == null ? "Not Connected" : "Connected");
            btClear.fire();
            btReload.fire();
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tbNasabah.getSelectionModel().selectedIndexProperty().addListener(listener->{
            if (tbNasabah.getSelectionModel().getSelectedItem()!=null){
                Individu holder =  tbNasabah.getSelectionModel().getSelectedItem();
                viewDataRekening(holder.getIdNasabah());
                btAddRek.setDisable(false);
                tfNewId.setText(""+holder.getIdNasabah());
                try {
                    tfNewNoRek.setText(""+nfc.nextRekeningNumber(holder.getIdNasabah()));
                } catch (SQLException ex) {
                    Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void viewDataRekening(int idNasabah){
        ObservableList<Rekening> data = nfc.getRekening(idNasabah);
        clNoRek.setCellValueFactory(new PropertyValueFactory<>("noRekening"));
        colSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        tblRekening.setItems(null);
        tblRekening.setItems(data);
    }
    
    public void viewDataRekeningP(int idNasabah){
        ObservableList<Rekening> data = nfc.getRekening(idNasabah);
        clNoRek1.setCellValueFactory(new PropertyValueFactory<>("noRekening"));
        clSaldo1.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        tblRekeningP.setItems(null);
        tblRekeningP.setItems(data);
    }
}
