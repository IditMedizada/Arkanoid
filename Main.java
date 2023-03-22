
import Game.AnimationRunner;
import Game.GameFlow;
import Game.GameLevel;
import Interfaces.LevelInformation;
import Levels.Level1;
import Levels.Level2;
import Levels.Level3;
import Levels.Level4;
import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**

 * Main class.
 * @author Idit Medizada iditm9@gmail.com
 */
public class Main {
    /**
     * Main function.
     * A game object, initializes and runs it.
     * @param args String array.
     */
    public static void main(String[] args) {

        GUI gui=new GUI("Game",800,600);
        AnimationRunner animationRunner=new AnimationRunner(gui);
        GameFlow gameFlow = new GameFlow(animationRunner, gui.getKeyboardSensor());
        gameFlow.runLevels(levels());
    }

    public static List<LevelInformation> levels() {
        List<LevelInformation> levels = new ArrayList<>();
        levels.add(new Level1());
        levels.add(new Level2());
        levels.add(new Level3());
        levels.add(new Level4());
        return levels;
    }
}