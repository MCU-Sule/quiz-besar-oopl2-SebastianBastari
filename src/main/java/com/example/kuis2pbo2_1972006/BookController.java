package com.example.kuis2pbo2_1972006;
import com.example.kuis2pbo2_1972006.DAO.bukuDAO;
import com.example.kuis2pbo2_1972006.entity.Buku;
import com.example.kuis2pbo2_1972006.entity.Peminjaman;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
public class BookController {

    @FXML
    private Button btnSave;

    @FXML
    private TableColumn<Buku, String> col1;

    @FXML
    private TableColumn<Buku, String> col2;

    @FXML
    private TableColumn<Buku, String> col3;

    @FXML
    private TableColumn<Buku, String> col4;

    @FXML
    private TableColumn<Buku, String> col5;

    @FXML
    private TableColumn<Buku, String> col6;

    @FXML
    private TableView<Buku> tableView;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookType;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtPublication;

    @FXML
    private TextField txtPublisher;

    @FXML
    private TextField txtTitle;
    private com.example.kuis2pbo2_1972006.DAO.bukuDAO bukuDAO;
    private ObservableList<Buku> bukus;
    private MainController controller;

    public void initialize(){
        bukuDAO = new bukuDAO();
        bukus = (ObservableList<Buku>) bukuDAO.showData();
        tableView.setItems(bukus);

        col1.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getId())));
        col2.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getJudul())));
        col3.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getPenerbit())));
        col4.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTahunTerbit())));
        col5.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getPengarang())));
        col6.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getJenisBuku())));

    }
    @FXML
    void shwSave(ActionEvent event) {

    }


    public void setControllerbook (MainController controller){
        tableView.setItems(controller.getBukus());
        this.controller = controller;
    }
}
