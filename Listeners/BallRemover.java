//318879293 Idit Medizada
package Listeners;

import BasicClasses.Counter;
import Game.GameLevel;
import Interfaces.HitListener;
import SpriteAndCollidable.Ball;
import SpriteAndCollidable.Block;

/**
 * BlockRemover class.
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 *
 * @author Idit Medizada iditm9@gmail.com
 * @version 1.6 (current version number of program).
 * @since 2022-05-21 (the version of the package this class was first added to).
 */

public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * Constructor.
     * @param game Game
     * @param removedBalls counter
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(game);
        this.remainingBalls.decrease(1);
    }
}