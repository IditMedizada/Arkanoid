//318879293 Idit Medizada
package Interfaces;

import Game.GameLevel;
import biuoop.DrawSurface;

/**
 * Sprite Interface.
 * Spirit object can be drawn on the screen, and can be notified that time has passed.
 */
public interface Sprite {

    /**
     * Draw the sprite to the screen.
     *
     * @param d DrawSurface
     */
    void drawOn(DrawSurface d);

    /**
     * Notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * addToGame.
     * @param g Game object
     */
    void addToGame(GameLevel g);
}