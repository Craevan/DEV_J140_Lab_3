package ru.avalon.devj.controller;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import ru.avalon.devj.Main;
import ru.avalon.devj.model.User;
import ru.avalon.devj.repo.Repository;
import ru.avalon.devj.view.PersonStage;

public class FXMLDocumentController implements Initializable {
    @FXML
    private Label labelWelcome;
    @FXML
    private Label labelUserName;
    @FXML
    private TextField textFieldUserName;
    @FXML
    private Label labelPassword;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button btn;
    @FXML
    private HBox addButton;
    @FXML
    private Text actionText;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelWelcome.setFont(Font.font("Arial", FontWeight.BOLD, 26));

        btn.setOnAction(ActionEvent -> {
            List<User> users = new Repository().getUsers();
            for (User user : users) {
                if (textFieldUserName.getText().equals(user.getLogin())
                        && passwordField.getText().equals(user.getPassword())) {
                    try {
                        new PersonStage().init();
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    actionText.setFill(Color.RED);
                    actionText.setText("Пароль или логин не верный");
                }
            }
        });
    }
}
