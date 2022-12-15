package ru.avalon.devj.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.avalon.devj.model.table.DomainTable;
import ru.avalon.devj.repo.IRepository;
import ru.avalon.devj.repo.Repository;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import static ru.avalon.devj.controller.PersonStageController.person;

public class DomainStageController implements Initializable {
    @FXML
    private TableView<DomainTable> table;
    @FXML
    private TableColumn<DomainTable, Integer> id;
    @FXML
    private TableColumn<DomainTable, String> webName;
    @FXML
    private TableColumn<DomainTable, String> domainName;
    @FXML
    private TableColumn<DomainTable, String> ip;
    @FXML
    private TableColumn<DomainTable, Timestamp> registerDate;
    @FXML
    private TableColumn<DomainTable, String> country;

    private final IRepository repository;


    public DomainStageController() {
        repository = new Repository();
        PersonStageController personStageController = new PersonStageController();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<DomainTable> observableList = FXCollections.observableArrayList();

        repository.getDomainByPerson(person).forEach(domain -> observableList.add(new DomainTable(
                domain.getId(),
                domain.getWebName(),
                domain.getDomainName(),
                domain.getIpAddress(),
                domain.getRegisterDate(),
                domain.getCountry())));

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        webName.setCellValueFactory(new PropertyValueFactory<>("webName"));
        domainName.setCellValueFactory(new PropertyValueFactory<>("domainName"));
        ip.setCellValueFactory(new PropertyValueFactory<>("ip"));
        registerDate.setCellValueFactory(new PropertyValueFactory<>("registerDate"));
        country.setCellValueFactory(new PropertyValueFactory<>("country"));

        table.setItems(observableList);
    }
}
