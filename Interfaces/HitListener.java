// 318879293 Idit Medizada
package Interfaces;

import SpriteAndCollidable.Ball;
import SpriteAndCollidable.Block;

/**
 * HitListener interface.
 *
 * @author Idit Medizada iditm9@gmail.com
 * @version 1.2 (current version number of program).
 * @since 2022-04-13 (the version of the package this class was first added to).
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit Block
     * @param hitter Ball
     */

    void hitEvent(Block beingHit, Ball hitter);
}