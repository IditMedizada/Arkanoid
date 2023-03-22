package Interfaces;

import SpriteAndCollidable.Ball;
import SpriteAndCollidable.Block;

/**
 * HitListener interface.
 *
 * @author Idit Medizada iditm9@gmail.com
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