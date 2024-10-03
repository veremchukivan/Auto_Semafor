package ukf.sk.casovac;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;

public class AutoSemafor extends Canvas {
    private int stav;
    GraphicsContext gc;

    public AutoSemafor() {
        // Збільшимо розмір канви
        super(100, 250);
        gc = this.getGraphicsContext2D();
        stav = 0;
        vykresli();
    }

    public void zmenastavu() {
        stav = (stav + 1) % 3;  // Перемикаємо стан
        vykresli();
    }

    public void vykresli() {
        gc.clearRect(0, 0, getWidth(), getHeight());  // Очищуємо канву перед малюванням

        // Малюємо корпус світлофора
        gc.setFill(Color.DARKSLATEGRAY);
        gc.setEffect(new DropShadow(10, Color.BLACK));  // Тінь для корпусу
        gc.fillRoundRect(20, 20, 60, 180, 20, 20);  // Центруємо корпус

        gc.setEffect(null);  // Видаляємо ефект тіні після малювання корпусу

        // Малюємо місця для трьох лампочок
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeOval(30, 30, 40, 40);  // Червона лампочка
        gc.strokeOval(30, 90, 40, 40);  // Жовта лампочка
        gc.strokeOval(30, 150, 40, 40); // Зелена лампочка

        // Логіка перемикання ламп через switch-case
        switch (stav) {
            case 0:  // Червоне світло
                drawLight(gc, 30, 30, Color.RED);
                break;
            case 1:  // Жовте світло
                drawLight(gc, 30, 90, Color.ORANGE);
                break;
            case 2:  // Зелене світло
                drawLight(gc, 30, 150, Color.GREEN);
                break;
        }
    }

    // Метод для малювання лампочки з градієнтом
    private void drawLight(GraphicsContext gc, int x, int y, Color color) {
        RadialGradient gradient = new RadialGradient(
                0, 0.1, x + 20, y + 20, 20, false,
                javafx.scene.paint.CycleMethod.NO_CYCLE,
                new Stop(0, Color.WHITE), new Stop(1, color)
        );
        gc.setFill(gradient);
        gc.fillOval(x, y, 40, 40);
    }
}
