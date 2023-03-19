package SpriteAndCollidable;

import BasicClasses.Counter;
import Game.GameLevel;
import Interfaces.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

import BasicShapes.Rectangle;
import BasicShapes.Point;

/**
 * ScoreIndicator class.
 *
 * @author Idit Medizada iditm9@gmail.com
 * @version 1.6 (current version number of program).
 * @since 2022-03-22 (the version of the package this class was first added to).
 */
public class ScoreIndicator implements Sprite {
    private Rectangle scoreBlock;
    private java.awt.Color color;
    private Counter score;
    private String levelName;


    /**
     * Constructor.
     *
     * @param score Counter type.
     * @param levelName string
     */

    public ScoreIndicator(Counter score, String levelName) {
        this.score = score;
        scoreBlock = new Rectangle(new Point(0, 0), 800, 20);
        this.color = Color.lightGray;
        this.levelName = levelName;
    }

    /**
     * Constructor.
     * @param score Counter
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
        scoreBlock = new Rectangle(new Point(0, 0), 800, 20);
        this.color = Color.lightGray;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.scoreBlock.getUpperLeft().getX(),
                (int) this.scoreBlock.getUpperLeft().getY(), (int) this.scoreBlock.getWidth(),
                (int) this.scoreBlock.getHeight());

        d.setColor(this.color);
        d.fillRectangle((int) this.scoreBlock.getUpperLeft().getX(),
                (int) this.scoreBlock.getUpperLeft().getY(), (int) this.scoreBlock.getWidth(),
                (int) this.scoreBlock.getHeight());
        d.setColor(Color.black);
        d.drawText(250, 17, "Level Name:" + this.levelName +"     "+ "Score:" + this.score.getValue(), 19);

    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}