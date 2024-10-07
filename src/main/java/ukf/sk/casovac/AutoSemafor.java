package ukf.sk.casovac;

import com.sun.tools.javac.Main;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public class AutoSemafor extends Canvas {
    private int stav;
    private GraphicsContext gc;
    private boolean isAutomatic;

    public AutoSemafor() {
        super(200, 250);
        gc = this.getGraphicsContext2D();
        stav = 0;
        vykresli();
        this.setOnMouseClicked(e -> {
            if (!this.isAutomatic) {
                zmenastavu();
            }
        });
    }
    public void setAutomaticMode(boolean isAutomatic) {
        this.isAutomatic = isAutomatic;
    }

    public void zmenastavu() {
        switch (stav) {
            case 0:
                stav = 1;
                break;
            case 1:
                stav = 2;
                break;
            case 2:
                stav = 3;
                break;
            case 3:
                stav = 0;
                break;
        }
        vykresli();
    }

    public void vykresli() {
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.setFill(Color.DARKSLATEGRAY);
        gc.setEffect(new DropShadow(10, Color.BLACK));
        gc.fillRoundRect(20, 20, 60, 180, 20, 20);
        gc.setFill(Color.DARKSLATEGRAY);
        gc.fillRoundRect(120, 20, 60, 120, 20, 20);
        gc.setEffect(null);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeOval(30, 30, 40, 40);
        gc.strokeOval(30, 90, 40, 40);
        gc.strokeOval(30, 150, 40, 40);
        gc.strokeOval(130, 30, 40, 40);
        gc.strokeOval(130, 90, 40, 40);

        switch (stav) {
            case 0:
                gc.setFill(Color.RED);
                gc.fillOval(30, 30, 40, 40);
                drawHumanGray(150, 30);
                drawHumanGreen(150, 90);
                break;
            case 1:
                gc.setFill(Color.RED);
                gc.fillOval(30, 30, 40, 40);
                gc.setFill(Color.ORANGE);
                gc.fillOval(30, 90, 40, 40);
                drawHumanRed(150, 30);
                drawHumanGray(150, 90);
                break;
            case 2:
                gc.setFill(Color.GREEN);
                gc.fillOval(30, 150, 40, 40);
                drawHumanRed(150, 30);
                drawHumanGray(150, 90);
                break;
            case 3:
                gc.setFill(Color.ORANGE);
                gc.fillOval(30, 90, 40, 40);
                drawHumanRed(150, 30);
                drawHumanGray(150, 90);
                break;
        }
    }

    private void drawHumanRed(double x, double y) {
        gc.setStroke(Color.RED);
        gc.setLineWidth(2);
        gc.strokeOval(x - 5, y + 10, 10, 10);
        gc.strokeLine(x, y + 20, x, y + 30);
        gc.strokeLine(x, y + 23, x - 5, y + 28);
        gc.strokeLine(x, y + 23, x + 5, y + 28);
        gc.strokeLine(x, y + 30, x - 3, y + 35);
        gc.strokeLine(x, y + 30, x + 3, y + 35);
    }

    private void drawHumanGreen(double x, double y) {
        gc.setStroke(Color.GREEN);
        gc.setLineWidth(2);
        gc.strokeOval(x - 5, y + 10, 10, 10);
        gc.strokeLine(x, y + 20, x, y + 30);
        gc.strokeLine(x, y + 23, x - 5, y + 28);
        gc.strokeLine(x, y + 23, x + 5, y + 28);
        gc.strokeLine(x, y + 30, x - 3, y + 35);
        gc.strokeLine(x, y + 30, x + 3, y + 35);
    }

    private void drawHumanGray(double x, double y) {
        gc.setStroke(Color.DARKGRAY);
        gc.setLineWidth(1);
        gc.strokeOval(x - 5, y + 10, 10, 10);
        gc.strokeLine(x, y + 20, x, y + 30);
        gc.strokeLine(x, y + 23, x - 5, y + 28);
        gc.strokeLine(x, y + 23, x + 5, y + 28);
        gc.strokeLine(x, y + 30, x - 3, y + 35);
        gc.strokeLine(x, y + 30, x + 3, y + 35);
    }
}
