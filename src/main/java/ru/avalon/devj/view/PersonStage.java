package ru.avalon.devj.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.avalon.devj.repo.IRepository;
import ru.avalon.devj.repo.Repository;

import java.io.IOException;
import java.util.Objects;

public class PersonStage extends Stage {

    public PersonStage() {
        IRepository repository = new Repository();
    }

    public void init() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/PersonStage.fxml")));
        Scene scene = new Scene(root);
        setTitle("Persons");
        setScene(scene);
        show();
    }
}
