//318879293 Idit Medizada
package Listeners;


import BasicClasses.Counter;
import Interfaces.HitListener;
import SpriteAndCollidable.Ball;
import SpriteAndCollidable.Block;

/**
 * ScoreTrackingListener class.
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 *
 * @author Idit Medizada iditm9@gmail.com
 * @version 1.6 (current version number of program).
 * @since 2022-05-21 (the version of the package this class was first added to).
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * Constructor.
     *
     * @param scoreCounter Counter type
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }


    /**
     * Increase the points in every block hit.
     *
     * @param beingHit Block
     * @param hitter   Ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}