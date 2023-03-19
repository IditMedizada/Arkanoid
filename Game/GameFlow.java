package Game;

import BasicClasses.Counter;
import Interfaces.LevelInformation;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private GUI gui;
    private Counter score;

    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        gui = ar.getGui();
        this.score = new Counter();

    }

    public void runLevels(List<LevelInformation> levels) {

        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, score);
            level.initialize();

            while (level.getNumOfBalls() > 0 && level.getNumOfBlocks() > 0) {
                level.run();
            }
            if (level.getNumOfBalls() == 0) {
                GameOver game = new GameOver(this.keyboardSensor, score);
                this.animationRunner.run(game);
                if (game.shouldStop()) {
                    gui.close();
                }
            }
        }
        Win win = new Win(this.keyboardSensor, score);
        this.animationRunner.run(win);
        if (win.shouldStop()) {
            gui.close();
        }
    }
}