module ru.avalon.devj {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.avalon.devj to javafx.fxml;
    exports ru.avalon.devj;
}