package com.example.kuis2pbo2_1972006;

import com.example.kuis2pbo2_1972006.DAO.anggotaDAO;
import com.example.kuis2pbo2_1972006.DAO.bukuDAO;
import com.example.kuis2pbo2_1972006.DAO.peminjamanDAO;
import com.example.kuis2pbo2_1972006.entity.Anggota;
import com.example.kuis2pbo2_1972006.entity.Buku;
import com.example.kuis2pbo2_1972006.entity.Peminjaman;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Member;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<Buku> cmbBook;

    @FXML
    private ComboBox<?> cmbLanguage;

    @FXML
    private ComboBox<Anggota> cmbMember;

    @FXML
    private TableColumn<Peminjaman, String> col1;

    @FXML
    private TableColumn<Peminjaman, String> col2;

    @FXML
    private TableColumn<Peminjaman, String> col3;

    @FXML
    private TableColumn<Peminjaman, String> col4;

    @FXML
    private TableColumn<Peminjaman, String> col5;

    @FXML
    private DatePicker dateBorrowing;

    @FXML
    private DatePicker dateReturn;

    @FXML
    private Menu btnEdit;

    @FXML
    private Menu btnFile;
    @FXML
    private MenuItem btnShwBookManagement;

    @FXML
    private MenuItem btnShwMemberManagement;

    @FXML
    private MenuItem btnExit;

    @FXML
    private TableView<Peminjaman> tableView;

    @FXML
    private TextField txtId;
    private peminjamanDAO peminjamanDAO ;
    ObservableList<Buku> bukus;
    private ObservableList<Peminjaman> peminjamans;
    ObservableList<Anggota> anggotas;
    private BookController controllerbook;

    public ObservableList<Anggota> getAnggotas(){
        return anggotas;
    }

    public ObservableList<Buku> getBukus(){
        return bukus;
    }
    @FXML
    void ShwBookManagement(ActionEvent event) throws IOException {
        Stage new_stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("bookManagement.fxml"));
        Parent root = fxmlLoader.load();
        BookController controllerbook = fxmlLoader.getController();
        controllerbook.setControllerbook(this);

        Scene new_scene = new Scene(root);
        new_stage.setScene(new_scene);
        new_stage.initModality(Modality.WINDOW_MODAL);
        new_stage.setTitle("Book Management");
        new_stage.show();
    }

    @FXML
    void shwExit(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    void ShwMemberManagement(ActionEvent event) throws IOException {
        Stage new_stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MemberManagement.fxml"));
        Parent root = fxmlLoader.load();
        MemberController c3 = fxmlLoader.getController();
        c3.setControllerMember(this);

        Scene new_scene = new Scene(root);
        new_stage.setScene(new_scene);
        new_stage.initModality(Modality.WINDOW_MODAL);
        new_stage.setTitle("Member Management");
        new_stage.show();
    }
    @FXML
    void shwFile(ActionEvent event) {

    }
    @FXML
    void shwEdit(ActionEvent event) {

    }



    @FXML
    void shwDelete(ActionEvent event) {
        Peminjaman selected;
        selected = (Peminjaman) tableView.getSelectionModel().getSelectedItem();
        System.out.println(selected);
        peminjamanDAO peminjamanDAOs = new peminjamanDAO();
        int result = peminjamanDAOs.delData(selected);
        if (result != 0){
            System.out.println("Delete Berhasil");
        }
        peminjamans.clear();
        peminjamans.addAll(peminjamanDAO.showData());
        tableView.refresh();
        btnSave.setDisable(false);
        btnReset.setDisable(false);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
        txtId.setDisable(false);
        txtId.clear();
        dateBorrowing.setValue(null);
        dateReturn.setValue(null);
        cmbBook.setValue(null);
        cmbMember.setValue(null);
    }

    @FXML
    void shwReset(ActionEvent event) {

    }

    @FXML
    void shwSave(ActionEvent event) {
        Peminjaman peminjaman =new Peminjaman();
        peminjaman.setId(Integer.valueOf(txtId.getText()));
        peminjaman.setTanggalPinjam(Date.valueOf(dateBorrowing.getValue()));
        peminjaman.setTanggalPengembalian(Date.valueOf(dateReturn.getValue()));
        peminjaman.setAnggotaByAnggotaId(cmbMember.getValue());
        peminjaman.setBukuByBukuId(cmbBook.getValue());
        peminjamanDAO peminjamanDAO = new peminjamanDAO();
        peminjamanDAO.addData(peminjaman);
        peminjamans.clear();
        peminjamans.addAll(peminjamanDAO.showData());
        tableView.refresh();
        txtId.setText("");
        dateBorrowing.setValue(null);
        dateReturn.setValue(null);
        cmbBook.setValue(null);
        cmbMember.setValue(null);
    }

    @FXML
    void shwUpdate(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        anggotaDAO anggotaDAO = new anggotaDAO();
        bukuDAO bookDAO = new bukuDAO();
        peminjamanDAO peminjamanDAO = new peminjamanDAO();
        anggotas =(ObservableList<Anggota>)anggotaDAO.showData();
        bukus = (ObservableList<Buku>)bookDAO.showData();
        peminjamans = (ObservableList<Peminjaman>) peminjamanDAO.showData();
        tableView.setItems(peminjamans);
        cmbMember.setItems(anggotas);
        cmbBook.setItems(bukus);
        col1.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getId())));
        col2.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getAnggotaByAnggotaId().getNama())));
        col3.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getBukuByBukuId().getJudul())));
        col4.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTanggalPinjam())));
        col5.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTanggalPengembalian())));
    }
}