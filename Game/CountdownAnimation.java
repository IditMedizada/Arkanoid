package Game;

import Collection.SpriteCollection;
import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.*;

// The CountdownAnimation will display the given gameScreen,
// for numOfSeconds seconds, and on top of them it will show
// a countdown from countFrom back to 1, where each number will
// appear on the screen for (numOfSeconds / countFrom) seconds, before
// it is replaced with the next one.
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private Sleeper sleeper;
    private boolean stop;
    private double sleepTime;
    private boolean isFirst;

    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.numOfSeconds = numOfSeconds;
        this.sleeper = new Sleeper();
        this.stop = false;
        this.sleepTime = (numOfSeconds / (double) countFrom);
        this.isFirst=true;
    }

    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.YELLOW);
        d.drawText(400, 400, "" + countFrom, 50);
        if (this.countFrom == 0) {
            this.stop = true;
        }
        if(!isFirst) {
            sleeper.sleepFor((long) ((long) 1000 * this.sleepTime));
        }
        this.isFirst=false;
        this.countFrom--;
    }

    public boolean shouldStop() {
        return this.stop;
    }
}