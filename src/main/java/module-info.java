module com.example.projektkalkulator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projektkalkulator to javafx.fxml;
    exports com.example.projektkalkulator;
}