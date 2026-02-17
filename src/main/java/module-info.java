module org.example.kmahjongg {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.kmahjongg to javafx.fxml;
    exports org.example.kmahjongg;
}