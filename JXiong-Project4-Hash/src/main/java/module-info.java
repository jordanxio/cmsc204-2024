module org.example.priject4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.priject4 to javafx.fxml;
    exports org.example.priject4;
}