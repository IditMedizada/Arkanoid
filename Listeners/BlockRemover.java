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
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * Constructor.
     *
     * @param game          Game object
     * @param removedBlocks number of blocks that have been removed.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * Blocks that are hit should be removed from the game.
     * @param beingHit Block
     * @param hitter Ball
     */
@Override
    public void hitEvent(Block beingHit, Ball hitter) {
       beingHit.removeHitListener(this);
       beingHit.removeFromGame(game);
       //hitter.getGameEnvironment().removeCollodable(beingHit);
       this.remainingBlocks.decrease(1);
    }
}