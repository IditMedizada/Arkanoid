// 318879293 Idit Medizada
package SpriteAndCollidable;

import BasicClasses.Velocity;
import BasicShapes.Point;
import BasicShapes.Rectangle;
import Game.GameLevel;
import Interfaces.Collidable;
import Interfaces.Sprite;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * Paddle class.
 *
 * @author Idit Medizada iditm9@gmail.com
 * @version 1.6 (current version number of program).
 * @since 2022-03-22 (the version of the package this class was first added to).
 */

public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle paddle;
    private java.awt.Color color;
    private int speed;
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    static final int HEIGHT_PADDLE = 10;
    static final int HEIGHT_BLOCK = 20;
    static final int WIDTH_BLOCK = 20;
    static final int WIDTH_PADDLE = 100;
    static final int STEPS = 3;
    static final double EPS = 0.000001;


    /**
     * Constructor.
     *
     * @param gui GUI
     */
    public Paddle(GUI gui, int speed, int width) {
        this.keyboard = gui.getKeyboardSensor();
        this.paddle = new Rectangle(new Point((WIDTH / 2) - (width / 2), HEIGHT - HEIGHT_PADDLE - HEIGHT_BLOCK),
                width, HEIGHT_PADDLE);
        this.color = Color.yellow;
        this.speed = speed;
    }

    /**
     * Move the paddle left 5 steps.
     */
    public void moveLeft() {
        Point point = new Point(this.paddle.getUpperLeft().getX() - this.speed, this.paddle.getUpperLeft().getY());
        if (point.getX() > WIDTH_BLOCK) {
            this.paddle.setUpperLeft(point);
        }
    }

    /**
     * Move the paddle right 3 steps.
     */
    public void moveRight() {
        Point point = new Point(this.paddle.getUpperLeft().getX() + this.speed, this.paddle.getUpperLeft().getY());
        if (point.getX() + this.paddle.getWidth() < WIDTH - WIDTH_BLOCK) {
            this.paddle.setUpperLeft(point);
        }
    }


    /*
    Sprite Interface
     */

    /**
     * timePassed function.
     * if the user press left-moveLeft function
     * if the user press right-moveRight function
     */
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * Draw the paddle on the given DrawSurface.
     *
     * @param d -the drawSurface
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.paddle.getUpperLeft().getX(),
                (int) this.paddle.getUpperLeft().getY(), (int) this.paddle.getWidth(),
                (int) this.paddle.getHeight());
        d.setColor(this.color);
        d.fillRectangle((int) this.paddle.getUpperLeft().getX(),
                (int) this.paddle.getUpperLeft().getY(), (int) this.paddle.getWidth(),
                (int) this.paddle.getHeight());
    }

    /*
     Collidable Interface
     */

    /**
     * GetCollisionRectangle function.
     *
     * @return CollisionRectangle
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.paddle;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Point upperLeftRec = this.paddle.getUpperLeft();

        if (Math.abs(upperLeftRec.getX() - collisionPoint.getX()) < EPS
                || Math.abs(upperLeftRec.getX() + this.paddle.getWidth() - collisionPoint.getX()) < EPS) {
            currentVelocity.setDx(currentVelocity.getDx() * (-1));
        }
        if (Math.abs(upperLeftRec.getY() - collisionPoint.getY()) < EPS
                || Math.abs(upperLeftRec.getY() + this.paddle.getHeight() - collisionPoint.getY()) < EPS) {
            if (collisionPoint.getX() >= upperLeftRec.getX()
                    && collisionPoint.getX() <= upperLeftRec.getX() + paddle.getWidth() * 0.2) {
                currentVelocity = Velocity.fromAngleAndSpeed(300, currentVelocity.speed(currentVelocity));
            } else if (collisionPoint.getX() > upperLeftRec.getX() + paddle.getWidth() * 0.2
                    && collisionPoint.getX() <= upperLeftRec.getX() + paddle.getWidth() * 0.4) {
                currentVelocity = Velocity.fromAngleAndSpeed(330, currentVelocity.speed(currentVelocity));
            } else if (collisionPoint.getX() > upperLeftRec.getX() + paddle.getWidth() * 0.6
                    && collisionPoint.getX() <= upperLeftRec.getX() + paddle.getWidth() * 0.8) {
                currentVelocity = Velocity.fromAngleAndSpeed(30, currentVelocity.speed(currentVelocity));

            } else if (collisionPoint.getX() > upperLeftRec.getX() + paddle.getWidth() * 0.8
                    && collisionPoint.getX() <= upperLeftRec.getX() + paddle.getWidth()) {
                currentVelocity = Velocity.fromAngleAndSpeed(60, currentVelocity.speed(currentVelocity));

            } else {
                currentVelocity.setDy(currentVelocity.getDy() * (-1));
            }
        }
        return currentVelocity;
    }


    /**
     * Add this paddle to the game.
     *
     * @param g Game object
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}