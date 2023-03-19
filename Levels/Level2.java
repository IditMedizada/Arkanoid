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
import SpriteAndCollidable.FillCircle;
import SpriteAndCollidable.Line;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * WideEasy class.
 *
 * @author Idit Medizada iditm9@gmail.com
 * @version 1.6 (current version number of program).
 * @since 2022-04-13 (the version of the package this class was first added to).
 */
public class Level2 implements LevelInformation {
    static final int BALLS_NUMBER = 5;
    static final int BLACKS_NUMBER = 15;

    @Override
    public int numberOfBalls() {
        return initialBallVelocities().size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        for (int i = 0; i < BALLS_NUMBER; i++) {
            velocities.add(new Velocity(-i / 2, -3));
        }
        for (int i = 0; i < BALLS_NUMBER; i++) {
            velocities.add(new Velocity(i / 2, -3));
        }
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 2;
    }

    @Override
    public int paddleWidth() {
        return 600;
    }

    @Override
    public String levelName() {
        return "Level 2";
    }

    @Override
    public Sprite getBackground() {
        return new Block(new Rectangle(new Point(0, 0), 800, 600), Color.white);
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        for (int j = 0; j < 15; j++) {
            blocks.add(new Block(new Rectangle(new Point(25 + (j * 50), 250), 50, 20)));
            blocks.get(j).setColor(chooseColor(j));
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }

    @Override
    public Color getColorBackground() {
        return Color.white;
    }

    @Override
    public SpriteCollection createBackground() {
        SpriteCollection collection = new SpriteCollection();
        int space = 5;
        for (int i = 0; i < 10; i++) {
            collection.addSprite(new Line(100 + (space * i), 100, 650 + (space * i), 250,new Color(241, 225, 105)));
            collection.addSprite(new Line(100 + (space * i), 100, 600 + (space * i), 250,new Color(243, 229, 122)));
            collection.addSprite(new Line(100 + (space * i), 100, 550 + (space * i), 250,new Color(243, 229, 122)));
            collection.addSprite(new Line(100 + (space * i), 100, 500 + (space * i), 250,new Color(234, 225, 152)));
            collection.addSprite(new Line(100 + (space * i), 100, 450 + (space * i), 250,new Color(234, 225, 152)));
            collection.addSprite(new Line(100 + (space * i), 100, 400 + (space * i), 250,new Color(234, 225, 152)));
            collection.addSprite(new Line(100 + (space * i), 100, 350 + (space * i), 250,new Color(234, 225, 152)));
            collection.addSprite(new Line(100 + (space * i), 100, 300 + (space * i), 250,new Color(234, 225, 152)));
            collection.addSprite(new Line(100 + (space * i), 100, 250 + (space * i), 250,new Color(234, 225, 152)));
            collection.addSprite(new Line(100 + (space * i), 100, 200 + (space * i), 250,new Color(234, 225, 152)));
            collection.addSprite(new Line(100 + (space * i), 100, 150 + (space * i), 250,new Color(234, 225, 152)));
            collection.addSprite(new Line(150 + (space * i), 100, 100 + (space * i), 250,new Color(234, 225, 152)));

            collection.addSprite(new Line(140 + (space * i), 100, 50 + (space * i), 250,new Color(243, 229, 122)));

        }
        collection.addSprite(new FillCircle(150, 100, 50, new Color(236, 224, 144)));
        collection.addSprite(new FillCircle(150, 100, 40, new Color(234, 215, 86)));
        collection.addSprite(new FillCircle(150, 100, 30, new Color(236, 213, 54)));


        return collection;
    }

    public Color chooseColor(int i) {
        if (i >= 0 && i <= 1) {
            return Color.RED;
        }
        if ((i >= 2 && i <= 3)) {
            return Color.orange;
        }
        if (i >= 4 && i <= 5) {
            return Color.YELLOW;
        }
        if (i >= 6 && i <= 8) {
            return Color.green;
        }
        if (i >= 9 && i <= 10) {
            return Color.BLUE;
        }
        if (i >= 11 && i <= 12) {
            return Color.pink;
        }
        return Color.CYAN;
    }
}
