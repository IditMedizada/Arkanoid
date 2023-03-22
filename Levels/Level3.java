//318879293 Idit Medizada
package Levels;

import BasicClasses.Velocity;
import BasicShapes.Point;
import BasicShapes.Rectangle;
import Collection.SpriteCollection;
import Interfaces.LevelInformation;
import Interfaces.Sprite;
import SpriteAndCollidable.Block;
import SpriteAndCollidable.FillCircle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Green3 class.
 *
 * @author Idit Medizada iditm9@gmail.com
 * @version 1.6 (current version number of program).
 * @since 2022-04-13 (the version of the package this class was first added to).
 */
public class Level3 implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return initialBallVelocities().size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        velocityList.add(new Velocity(-2, -2));
        velocityList.add(new Velocity(3, -3));
        return velocityList;
    }

    @Override
    public int paddleSpeed() {
        return 2;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Level 3";
    }

    @Override
    public Sprite getBackground() {
        //Color color = new Color(43, 89, 6);
        //Color color= Color.BLACK;
        return new Block(new Rectangle(new Point(0, 0), 800, 600), Color.BLACK);
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        java.awt.Color[] colors = new java.awt.Color[]{Color.YELLOW, Color.PINK, Color.GREEN,
                Color.RED, Color.ORANGE, Color.MAGENTA, Color.BLUE, Color.ORANGE};
        int numOfBlocks = 0;
        //num of lines
        for (int i = 7; i> 0; i--) {
            //num of blocks for each line
            for (int j = 1; j < 14 - i; j++) {
                blocks.add(new Block(new Rectangle(new Point(775 - (j * 50), 100 + (20 * i)), 50, 20)));
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
        //return new Color(43, 89, 6);
        return Color.BLACK;
    }
    @Override
    public SpriteCollection createBackground() {
        SpriteCollection collection = new SpriteCollection();
        for(int i=0; i<90; i++) {
            collection.addSprite(new FillCircle(getRandomNumber(), getRandomNumber(), 3, new Color(199, 201, 201)));
        }
        collection.addSprite(new FillCircle(80, 100, 40, Color.WHITE));
        collection.addSprite(new FillCircle(90, 100, 35, Color.BLACK));


        return collection;
    }
    public int getRandomNumber() {
        return (int) ((Math.random() * (1000)) + 0);
    }

}