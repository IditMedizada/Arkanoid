package Levels;

import BasicClasses.Velocity;
import BasicShapes.Point;
import BasicShapes.Rectangle;
import Collection.SpriteCollection;
import Interfaces.LevelInformation;
import Interfaces.Sprite;
import SpriteAndCollidable.Block;
import SpriteAndCollidable.Circle;
import SpriteAndCollidable.FillCircle;
import SpriteAndCollidable.Line;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * Level4 class.
 *
 * @author Idit Medizada iditm9@gmail.com
 */
public class Level4 implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return initialBallVelocities().size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        velocityList.add(new Velocity(0, -2));
        velocityList.add(new Velocity(-2, -2));
        velocityList.add(new Velocity(2, -2));

        return velocityList;
    }

    @Override
    public int paddleSpeed() {
        return 3;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Level 4";
    }

    @Override
    public Sprite getBackground() {
        Color color = new Color(69, 174, 213);
        ;
        return new Block(new BasicShapes.Rectangle(new Point(0, 0), 800, 600), color);
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        java.awt.Color[] colors = new java.awt.Color[]{Color.YELLOW, Color.PINK, Color.GREEN,
                Color.RED, Color.ORANGE, Color.MAGENTA, Color.BLUE, Color.ORANGE};
        int numOfBlocks = 0;
        //num of lines
        for (int i = 0; i < 7; i++) {
            //num of blocks for each line
            for (int j = 0; j < 15; j++) {
                blocks.add(new Block(new Rectangle(new Point(25 + (j * 50), 100 + (20 * i)), 50, 20)));
                blocks.get(numOfBlocks).setColor(colors[i]);
                numOfBlocks++;
            }
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }

    @Override
    public Color getColorBackground() {
        return new Color(69, 174, 213);

    }

    @Override
    public SpriteCollection createBackground() {
        SpriteCollection collection = new SpriteCollection();
        int space = 9;
        for (int i = 0; i < 10; i++) {
            collection.addSprite(new Line(100 + (space * i), 400, 50 + (space * i), 650, Color.white));

        }
        collection.addSprite(new FillCircle(110, 400, 30, new Color(172, 175, 175)));
        collection.addSprite(new FillCircle(160, 410, 35, new Color(186, 189, 189)));
        collection.addSprite(new FillCircle(90, 420, 30, new Color(190, 192, 192)));
        collection.addSprite(new FillCircle(140, 430, 25, new Color(168, 171, 171)));
        collection.addSprite(new FillCircle(120, 440, 20, new Color(176, 180, 180)));

        for (int i = 0; i < 10; i++) {
            collection.addSprite(new Line(610 + (space * i), 450, 590 + (space * i), 650, Color.white));

        }
        collection.addSprite(new FillCircle(610, 450, 30, new Color(172, 175, 175)));
        collection.addSprite(new FillCircle(660, 460, 35, new Color(186, 189, 189)));
        collection.addSprite(new FillCircle(690, 470, 30, new Color(190, 192, 192)));
        collection.addSprite(new FillCircle(640, 480, 25, new Color(168, 171, 171)));
        collection.addSprite(new FillCircle(670, 500, 20, new Color(176, 180, 180)));
        return collection;
    }


}