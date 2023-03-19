//318879293 Idit Medizada
package Interfaces;

import biuoop.DrawSurface;
/**
 * Animation interface.
 *
 * @author Idit Medizada iditm9@gmail.com
 * @version 1.2 (current version number of program).
 * @since 2022-04-13 (the version of the package this class was first added to).
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