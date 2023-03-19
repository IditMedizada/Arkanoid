//318879293 Idit Medizada
package Levels;

import BasicClasses.Velocity;
import BasicShapes.Point;
import BasicShapes.Rectangle;
import Collection.SpriteCollection;
import Interfaces.LevelInformation;
import Interfaces.Sprite;
import SpriteAndCollidable.Block;
import SpriteAndCollidable.Circle;
import SpriteAndCollidable.Line;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * DirectHit class.
 *
 * @author Idit Medizada iditm9@gmail.com
 * @version 1.6 (current version number of program).
 * @since 2022-04-13 (the version of the package this class was first added to).
 */
public class Level1 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return initialBallVelocities().size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        velocityList.add(new Velocity(0, -0.7));
        return velocityList;
    }

    @Override
    public int paddleSpeed() {
        return 1;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Level 1";
    }

    @Override
    public Sprite getBackground() {
        return new Block(new Rectangle(new Point(0, 0), 800, 600),
                Color.black);
    }

    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        Block block = new Block(new Rectangle(new Point(390, 135), 20, 20));
        block.setColor(Color.red);
        blockList.add(block);
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }

    /**
     * Getter.
     *
     * @return the background color.
     */
    public Color getColorBackground() {
        return Color.black;
    }

    public SpriteCollection createBackground() {
        SpriteCollection collection = new SpriteCollection();
        collection.addSprite(new Circle(400, 145, 70, Color.blue));
        collection.addSprite(new Circle(400, 145, 50, Color.blue));
        collection.addSprite(new Circle(400, 145, 100, Color.blue));
        collection.addSprite(new Line(400,45,400,280,Color.blue));
        collection.addSprite(new Line(250,145,550,145,Color.blue));
        return collection;
    }

}