//318879293 Idit Medizada
package Game;

import BasicClasses.Counter;
import BasicClasses.Velocity;
import BasicShapes.Point;
import BasicShapes.Rectangle;
import Collection.GameEnvironment;
import Collection.SpriteCollection;
import Interfaces.Animation;
import Interfaces.Collidable;
import Interfaces.LevelInformation;
import Interfaces.Sprite;
import Listeners.BallRemover;
import Listeners.BlockRemover;
import Listeners.ScoreTrackingListener;
import SpriteAndCollidable.Ball;
import SpriteAndCollidable.Block;
import SpriteAndCollidable.Paddle;
import SpriteAndCollidable.ScoreIndicator;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Game class.
 *
 * @author Idit Medizada iditm9@gmail.com
 * @version 1.6 (current version number of program).
 * @since 2022-04-13 (the version of the package this class was first added to).
 */
public class GameLevel implements Animation {

    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter remainedBlocks;
    private Counter remainedBalls;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;
    private CountdownAnimation countdownAnimation;
    //finals
    static final java.awt.Color COLOR = Color.white;
    static final int RADIUS = 6;
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    static final int WIDTH_BLOCK = 25;
    static final int HEIGHT_BLOCK = 20;


    /**
     * Constructor.
     *
     * @param level LevelInformation
     */
    public GameLevel(LevelInformation level, KeyboardSensor keyboard, AnimationRunner animationRunner, Counter score) {
        levelInformation = level;
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        remainedBlocks = new Counter();
        remainedBalls = new Counter();
        this.score = score;
        this.gui = animationRunner.getGui();
        this.runner = animationRunner;
        this.keyboard = keyboard;

    }

    /**
     * AddCollidable function.
     *
     * @param c the collidable object that we need to add.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * AddSprite function.
     *
     * @param s the sprite object that we need to add.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle) and add them to the game.
     */
    public void initialize() {
        this.levelInformation.getBackground().addToGame(this);
        createBackground();
        BlockRemover blockRemover = new BlockRemover(this, remainedBlocks);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(score);
        System.out.println(this.levelInformation.levelName());
        BallRemover ballRemover = new BallRemover(this, remainedBalls);
        createBall(this.levelInformation.initialBallVelocities());
        createPaddle();
        frameBlocks(ballRemover, this.levelInformation.getColorBackground());
        createBlocks(this.levelInformation.blocks(), blockRemover, scoreTrackingListener);
        ScoreIndicator scoreIndicator = new ScoreIndicator(score, this.levelInformation.levelName());
        this.sprites.addSprite(scoreIndicator);
        countdownAnimation = new CountdownAnimation(2, 3, this.sprites);

    }


    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        this.running = true;
        this.runner.run(this);
    }

    /**
     * Create the blocks frame.
     *
     * @param ballRemover BallRemover type
     */
    public void frameBlocks(BallRemover ballRemover, Color color) {
        Block[] blocks = new Block[4];
        blocks[0] = new Block(new Rectangle(new Point(0, HEIGHT - 5), WIDTH, HEIGHT_BLOCK));
        blocks[0].setColor(color);
        blocks[0].addHitListener(ballRemover);
        blocks[1] = new Block(new Rectangle(new Point(0, 0), WIDTH_BLOCK, HEIGHT + HEIGHT_BLOCK));
        blocks[2] = new Block(new Rectangle(new Point(WIDTH - WIDTH_BLOCK, 0), WIDTH_BLOCK, HEIGHT));
        blocks[3] = new Block(new Rectangle(new Point(0, 20), WIDTH, 25));

        for (Block block : blocks) {
            this.sprites.addSprite(block);
            environment.addCollidable(block);
        }

    }

    public void createBlocks(List<Block> blocks, BlockRemover blockRemover,
                             ScoreTrackingListener scoreTrackingListener) {
        for (int i = 0; i < blocks.size(); i++) {
            blocks.get(i).addToGame(this);
            this.sprites.addSprite(blocks.get(i));
            this.environment.addCollidable(blocks.get(i));
            blocks.get(i).addHitListener(blockRemover);
            blocks.get(i).addHitListener(scoreTrackingListener);
            //increase the num of blocks in the counter
            remainedBlocks.increase(1);
        }
    }


    /**
     * Create Balls.
     * And add them to the game.
     */
    public void createBall(List<Velocity> velocities) {
        Ball[] balls = new Ball[velocities.size()];
        for (int i = 0; i < velocities.size(); i++) {
            balls[i] = new Ball(new Point(400, 560), RADIUS, COLOR);
            balls[i].setBottom(HEIGHT);
            balls[i].setRight(WIDTH);
            balls[i].setVelocity(velocities.get(i));
            balls[i].setGameEnvironment(this.environment);
            balls[i].addToGame(this);
            this.sprites.addSprite(balls[i]);
            remainedBalls.increase(1);

        }

    }

    /**
     * Create paddle and add him to the game.
     */
    public void createPaddle() {
        Paddle paddle = new Paddle(gui, this.levelInformation.paddleSpeed(), this.levelInformation.paddleWidth());
        paddle.addToGame(this);
        this.sprites.addSprite(paddle);
        this.environment.addCollidable(paddle);
    }

    /**
     * Removing a block from the GameEnvironment.
     *
     * @param c Collidable- one block.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollodable(c);
    }

    /**
     * Removing a block from the SpriteCollection.
     *
     * @param s Sprite-one block.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }


    @Override
    public void doOneFrame(DrawSurface d) {
        d.fillRectangle(0, 0, WIDTH, HEIGHT);
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        //If the user press p- we pause the game
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new PauseScreen(this.keyboard));
        }
        //If all the blocks removed
        if (this.remainedBlocks.getValue() == 0) {
            this.score.increase(100);
            this.running = false;
        }
        //If all the balls removed
        if (this.remainedBalls.getValue() == 0) {
            this.running = false;
        }
    }


    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    public int getNumOfBalls() {
        return this.remainedBalls.getValue();
    }

    public int getNumOfBlocks() {
        return this.remainedBlocks.getValue();
    }

    public void createBackground() {
        SpriteCollection spriteCollection = this.levelInformation.createBackground();
        spriteCollection.drawAllOn(this.gui.getDrawSurface());
        for(int i=0; i<spriteCollection.getSize(); i++){
            spriteCollection.getSprite(i).addToGame(this);
        }
    }
}