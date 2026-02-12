module org.example.kmahjongg {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.kmahjongg to javafx.fxml;
    exports org.example.kmahjongg;
}