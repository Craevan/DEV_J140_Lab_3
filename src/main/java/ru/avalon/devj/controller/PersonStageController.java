package ru.avalon.devj.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.LoggerFactory;
import ru.avalon.devj.model.Domain;
import ru.avalon.devj.model.Person;
import ru.avalon.devj.model.table.PersonTable;
import ru.avalon.devj.repo.IRepository;
import ru.avalon.devj.repo.Repository;
import ru.avalon.devj.view.DomainStage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PersonStageController implements Initializable {
    @FXML
    private TableView<PersonTable> table;
    @FXML
    private TableColumn<PersonTable, Integer> id;
    @FXML
    private TableColumn<PersonTable, String> job;
    @FXML
    private TableColumn<PersonTable, String> fullName;
    @FXML
    private TableColumn<PersonTable, String> phoneColumn;
    @FXML
    private TableColumn<PersonTable, String> emailColumn;
    @FXML
    private TableColumn<PersonTable, Integer> numberOfDomains;

    static Person person;
    private final IRepository repository;

    public PersonStageController() {
        repository = new Repository();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<PersonTable> observableList = FXCollections.observableArrayList();
        repository.getPersons().forEach(person -> {
            List<Domain> domainListOfPerson = new Repository().getDomainByPerson(person);
            int numberOfDomain = repository.getDomainByPerson(person).size();
            observableList.add(new PersonTable(person.getId(),
                    person.getJob(),
                    person.getFullName(),
                    person.getPhone(),
                    person.getEmail(),
                    numberOfDomain));
        });

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        job.setCellValueFactory(new PropertyValueFactory<>("job"));
        fullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        numberOfDomains.setCellValueFactory(new PropertyValueFactory<>("numberOfDomains"));

        table.setItems(observableList);

        table.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                try {
                    person = repository.getPersonById(table.getSelectionModel().getSelectedItem().getId());
                    new DomainStage().init();
                } catch (IOException ex) {
                    LoggerFactory.getLogger(PersonStageController.class).error("I/O Exception " + ex);
                }
            }
        });
    }
}
