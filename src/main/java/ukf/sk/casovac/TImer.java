package ukf.sk.casovac;

import javafx.animation.AnimationTimer;

public class TImer extends AnimationTimer {
    AutoSemafor AS;
    int point;

    public TImer(AutoSemafor AS) {
        this.AS = AS;
        point = 0;
    }

    @Override
    public void handle(long now) {
        point = (point + 1) % 60;
        if (point == 0) AS.zmenastavu();
    }
}