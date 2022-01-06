package com.example.kuis2pbo2_1972006;

import com.example.kuis2pbo2_1972006.DAO.anggotaDAO;
import com.example.kuis2pbo2_1972006.entity.Anggota;
import com.example.kuis2pbo2_1972006.entity.Buku;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MemberController {

    @FXML
    private Button btnSave;

    @FXML
    private TableColumn<Anggota, String> col1;

    @FXML
    private TableColumn<Anggota, String> col2;

    @FXML
    private TableColumn<Anggota, String> col3;

    @FXML
    private TableColumn<Anggota, String> col4;

    @FXML
    private TableColumn<Anggota, String> col5;

    @FXML
    private DatePicker dateBirth;

    @FXML
    private DatePicker dateEntry;

    @FXML
    private TableView<Anggota> tableView;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;
    private com.example.kuis2pbo2_1972006.DAO.anggotaDAO anggotaDAO;
    private ObservableList<Anggota> anggotas;
    private MainController controller;
    public void setControllerMember (MainController controller){
        tableView.setItems(controller.getAnggotas());
        this.controller = controller;
    }
    void alerts(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText("Isi dengan benar");
        alert.showAndWait();
    }
    @FXML
    void shwSave(ActionEvent event) {
        Anggota anggota = new Anggota();
        if(txtId.getText().isEmpty() || txtName.getText().isEmpty() ){
            alerts();
        }else {
            Anggota anggotae = new Anggota();
            anggotae.setId(Integer.parseInt(txtId.getText()));
            anggotae.setNama(String.valueOf(txtName.getText()));
            anggotaDAO angdao = new anggotaDAO();
            angdao.addData(anggota);
            controller.getAnggotas().clear();
            controller.getAnggotas().addAll(angdao.showData());

            tableView.refresh();
        }
    }
    public void initialize(){
        anggotaDAO = new anggotaDAO();
        anggotas = (ObservableList<Anggota>) anggotaDAO.showData();
        tableView.setItems(anggotas);

        col1.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getId())));
        col2.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getNama())));
        col3.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getNotelpon())));
        col4.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTglLahir())));
        col5.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTglMasuk())));
    }
}
