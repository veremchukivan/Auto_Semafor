package ukf.sk.casovac;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {

    static boolean isAutomatic = true; // Початковий режим - автоматичний
    private TImer timer; // Додайте змінну для таймера

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        AutoSemafor s = new AutoSemafor();

        VBox root = new VBox(10);
        HBox buttons = new HBox(10);

        Button manualButton = new Button("Manual");
        Button automaticButton = new Button("Automatic");

        manualButton.setOnAction(e -> switchToManual(s));
        automaticButton.setOnAction(e -> switchToAutomatic(s));


        buttons.getChildren().addAll(manualButton, automaticButton);
        root.getChildren().addAll(buttons,s);

        Scene scene = new Scene(root, 200, 300);
        stage.setScene(scene);
        stage.show();

        timer = new TImer(s);
        timer.start();
    }

    private void switchToManual(AutoSemafor s) {
        isAutomatic = false;
        timer.stop();
        s.zmenastavu();
    }

    private void switchToAutomatic(AutoSemafor s) {
        isAutomatic = true;
        timer.start();
    }
}
