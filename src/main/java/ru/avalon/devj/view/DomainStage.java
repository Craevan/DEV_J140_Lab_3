package ru.avalon.devj.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DomainStage extends Stage {

    public DomainStage() {
    }

    public void init() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/DomainStage.fxml")));
        initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        setTitle("Domain");
        setScene(scene);
        show();
    }
}
