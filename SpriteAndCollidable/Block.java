package SpriteAndCollidable;

import BasicClasses.Velocity;
import BasicShapes.Point;
import BasicShapes.Rectangle;
import Game.GameLevel;
import Interfaces.Collidable;
import Interfaces.HitListener;
import Interfaces.HitNotifier;
import Interfaces.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Block class.
 *
 * @author Idit Medizada iditm9@gmail.com
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle collisionRectangle;
    private java.awt.Color color;
    private List<HitListener> hitListeners;
    static final double EPS = 0.000000000000001;

    /**
     * Constructor.
     *
     * @param rec Rectangle
     */
    public Block(Rectangle rec) {
        this.collisionRectangle = rec;
        this.color = Color.gray;
        hitListeners = new ArrayList<>();
    }

    /**
     * Constructor.
     *
     * @param rec   Rectangle
     * @param color Rectangle color.
     */
    public Block(Rectangle rec, Color color) {
        this.collisionRectangle = rec;
        this.color = color;
        hitListeners = new ArrayList<>();
    }

    /**
     * Setter.
     *
     * @param color the block color we want to change to.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Getter.
     *
     * @return Color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * getCollisionRectangle.
     *
     * @return the "collision shape" of the object.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.collisionRectangle;
    }

    /**
     * @param collisionPoint  the collision point between block and another object.
     * @param currentVelocity current velocity(before the hitting)
     * @return new velocity
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Point upperLeftRec = this.collisionRectangle.getUpperLeft();
        //Facing with the top block
        if (collisionPoint.getY() <= 45) {
            currentVelocity.setDy(currentVelocity.getDy() * (-1));
            this.notifyHit(hitter);
            return currentVelocity;
        }
        //checks if the ball fall from the screen
        if (collisionPoint.getY() >= 600) {
            this.notifyHit(hitter);
        }
        if (Math.abs(upperLeftRec.getX() - collisionPoint.getX()) < EPS
                || Math.abs(upperLeftRec.getX() + this.collisionRectangle.getWidth() - collisionPoint.getX()) < EPS) {
            currentVelocity.setDx(currentVelocity.getDx() * (-1));
        }
        if (Math.abs(upperLeftRec.getY() - collisionPoint.getY()) < EPS
                || Math.abs((upperLeftRec.getY()
                + this.collisionRectangle.getHeight()) - collisionPoint.getY()) < EPS) {
            currentVelocity.setDy(currentVelocity.getDy() * (-1));
        }
        this.notifyHit(hitter);
        return currentVelocity;
    }

    /**
     * Draw the blocks on the given DrawSurface.
     *
     * @param surface -the drawSurface
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.collisionRectangle.getUpperLeft().getX(),
                (int) this.collisionRectangle.getUpperLeft().getY(), (int) this.collisionRectangle.getWidth(),
                (int) this.collisionRectangle.getHeight());
        if (!(this.collisionRectangle.getUpperLeft().getY() == 595)) {
            surface.setColor(Color.BLACK);

        }
        surface.drawRectangle((int) this.collisionRectangle.getUpperLeft().getX(),
                (int) this.collisionRectangle.getUpperLeft().getY(), (int) this.collisionRectangle.getWidth(),
                (int) this.collisionRectangle.getHeight());
    }

    @Override
    public void timePassed() {

    }

    /**
     * Add the block to the game.
     *
     * @param g Game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * Remove block from the game.
     *
     * @param game Game type
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        List<HitListener> tempList = new ArrayList<>(this.hitListeners);

        for (HitListener hitListener : tempList) {
            if (hl.equals(hitListener)) {
                this.hitListeners.remove(hl);
            }
        }

    }

    /**
     * notifyHit.
     *
     * @param hitter Ball type.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

}