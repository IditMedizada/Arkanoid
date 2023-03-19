//318879293 Idit Medizada
package Game;

import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * PauseScreen class.
 *
 * @author Idit Medizada iditm9@gmail.com
 * @version 1.6 (current version number of program).
 * @since 2022-04-13 (the version of the package this class was first added to).
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * Constructor.
     *
     * @param k KeyboardSensor
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * The function pause the screen by pressing p and continue by pressing space.
     *
     * @param d DrawSurface
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /**
     * Checks if the animation should stop.
     *
     * @return boolean type.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}