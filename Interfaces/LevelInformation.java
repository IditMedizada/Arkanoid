package Interfaces;

import BasicClasses.Velocity;
import Collection.SpriteCollection;
import SpriteAndCollidable.Block;

import java.awt.*;
import java.util.List;

/**
 * LevelInformation interface.
 *
 * @author Idit Medizada iditm9@gmail.com
 */
public interface LevelInformation {
    /**
     * The function returns the number of balls in specific level.
     *
     * @return int type
     */
    int numberOfBalls();

    /**
     * The initial velocity of each ball.
     *
     * @return List of velocity type.
     */
    List<Velocity> initialBallVelocities();

    /**
     * Returns the paddle speed.
     *
     * @return int
     */
    int paddleSpeed();

    /**
     * Returns the paddle width.
     *
     * @return int
     */
    int paddleWidth();


    /**
     * levelName.
     * the level name will be displayed at the top of the screen
     *
     * @return String
     */
    String levelName();


    /**
     * getBackground.
     *
     * @return a sprite with the background of the level
     */
    Sprite getBackground();


    /**
     * The Blocks that make up this level, each block contains.
     * its size, color and location.
     *
     * @return List of blocks
     */
    List<Block> blocks();

    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();

    /**
     * Number of blocks that should be removed.
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     *
     * @return int
     */
    int numberOfBlocksToRemove();

    /**
     * Getter.
     *
     * @return return the background color.
     */
    Color getColorBackground();

     SpriteCollection createBackground();

}