module ukf.sk.casovac {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jdk.compiler;


    opens ukf.sk.casovac to javafx.fxml;
    exports ukf.sk.casovac;
}