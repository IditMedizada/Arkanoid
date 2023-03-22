package Interfaces;

import biuoop.DrawSurface;
/**
 * Animation interface.
 *
 * @author Idit Medizada iditm9@gmail.com
 */
public interface Animation {
    /**
     * This function is in charge of the logic.
     * @param d DrawSurface
     */
    void doOneFrame(DrawSurface d);

    /**
     * This function is in charge of stopping condition.
     * @return boolean type- if the game should stop or not.
     */
     boolean shouldStop();
}