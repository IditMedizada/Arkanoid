package Game;

import BasicClasses.Counter;
import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

public class Win implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter score;

    public Win (KeyboardSensor k, Counter score){
        this.keyboard=k;
        this.stop=false;
        this.score=score;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10,400,"You Win!",32);
        d.drawText(10,480,"Your score is: "+this.score.getValue(),32);

        if(this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)){
            this.stop=true;
        }

    }


    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}