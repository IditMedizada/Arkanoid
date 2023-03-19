// 318879293 Idit Medizada
package SpriteAndCollidable;

import BasicClasses.CollisionInfo;
import BasicClasses.Velocity;
import BasicShapes.Line;
import BasicShapes.Point;
import Collection.GameEnvironment;
import Game.GameLevel;
import Interfaces.Sprite;
import biuoop.DrawSurface;

import java.awt.*;


/**
 * Ball class.
 *
 * @author Idit Medizada iditm9@gmail.com
 * @version 1.6 (current version number of program).
 * @since 2022-03-22 (the version of the package this class was first added to).
 */

public class Ball implements Sprite {
    static final int WIDTH = 200;
    static final int RADIUS = 10;
    static final int VELOCITY = -2;
    static final int WIDTH_FRAME = 60;

    private double x;
    private double y;
    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;
    //Boundaries of the frame
    private int left;
    private int right;
    private int top;
    private int bottom;

    /**
     * Constructor.
     *
     * @param x     value of the center point of a ball
     * @param y     value of the center point of a ball
     * @param r     radius of a ball
     * @param color of a ball
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.color = color;
        setY(y);
        setX(x);
        setRight(WIDTH);
        setLeft(0);
        setTop(0);
        setBottom(WIDTH);
        setSize(r);
        setVelocity(VELOCITY, VELOCITY);
    }

    /**
     * Constructor.
     *
     * @param center the center point of a ball.
     * @param r      radius of a ball
     * @param color  of a ball
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.color = color;
        setRight(WIDTH);
        setLeft(0);
        setTop(0);
        setBottom(WIDTH);
        setSize(r);
        setVelocity(VELOCITY, VELOCITY);
        setX(center.getX());
        setY(center.getY());

    }

    /**
     * Setter.
     *
     * @param gameEnvironment set the game environment of a ball.
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * Setter.
     *
     * @param bottom set the value of the bottom border
     */
    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    /**
     * Setter.
     *
     * @param right set the value of the right border
     */
    public void setRight(int right) {
        this.right = right;
    }

    /**
     * Getter.
     *
     * @return GameEnvironment
     */
    public GameEnvironment getGameEnvironment() {
        return gameEnvironment;
    }

    /**
     * Setter.
     *
     * @param left set the value of the left border
     */
    public void setLeft(int left) {
        this.left = left;
    }

    /**
     * Setter.
     *
     * @param top set the value of the top border
     */
    public void setTop(int top) {
        this.top = top;
    }

    /**
     * Getter.
     *
     * @return the value of x
     */
    public int getX() {
        return (int) x;
    }

    /**
     * Getter.
     *
     * @return the value of y
     */
    public int getY() {
        return (int) y;
    }

    /**
     * Getter.
     *
     * @return the radius size of a ball.
     */
    public int getSize() {
        return radius;
    }

    /**
     * Setter.
     *
     * @param size of the radius
     */

    public void setSize(int size) {
        if ((size > (this.bottom - this.top)) || (size > (this.right - this.left))) {
            this.radius = RADIUS;
        } else if (size <= 0) {
            this.radius = RADIUS;
        } else {
            this.radius = size;
        }
    }


    /**
     * Setter.
     *
     * @param x value
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Setter.
     *
     * @param y value
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Getter.
     *
     * @return the color of a ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Draw the ball on the given DrawSurface.
     *
     * @param surface -the drawSurface
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
        surface.setColor(Color.black);
        surface.drawCircle(this.getX(), this.getY(), this.getSize());
    }

    /**
     * Setter.
     *
     * @param v set the velocity of a ball with a velocity object
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Setter-set the velocity of a ball with dx and dy parameters.
     *
     * @param dx from velocity class
     * @param dy from velocity class
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * Getter.
     *
     * @return the velocity of a ball
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * The function moves the ball in space according to the boundaries.
     * Change the direction if the ball hits one of the borders.
     */
    public void moveOneStep() {
        Line trajectory = new Line(getX(), getY(), getX() + getVelocity().getDx(),
                getY() + getVelocity().getDy());
        if (this.gameEnvironment != null) {
            CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(trajectory);
            if (collisionInfo != null) {
                setVelocity(collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(),
                        this.velocity));
            }
        }
        //Create a new point
        Point point = new Point(this.x, this.y);
        /*
         * Checks the position of the ball- DX.
         * Left and right borders.
         */
        //Checks if the ball is out of frame and changes its position
        if (point.getX() - this.radius < this.left || point.getX() + this.radius > this.right) {
            point.setX((double) (this.right + this.left) / 2);
        }

        /*
         * Checks the position of the ball- DY
         * Top and bottom borders.
         */
        //Checks if the ball is out of frame and changes its position
        if (point.getY() - this.radius < this.top || point.getY() + this.radius > this.bottom) {
            point.setY((double) this.bottom + WIDTH_FRAME);
        }
        point = this.getVelocity().applyToPoint(point);
        setX(point.getX());
        setY(point.getY());
    }

    /**
     * TimePassed function.
     * move the ball one step.
     */
    @Override
    public void timePassed() {
        moveOneStep();

    }

    /**
     * Add the ball to the game.
     *
     * @param g Game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Remove the ball from the game.
     * @param game Game type
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }


}