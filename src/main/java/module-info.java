module ukf.sk.casovac {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens ukf.sk.casovac to javafx.fxml;
    exports ukf.sk.casovac;
}