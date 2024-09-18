module com.example.pro2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pro2 to javafx.fxml;
    exports com.example.pro2;
    exports pro2;
    opens pro2 to javafx.fxml;
}