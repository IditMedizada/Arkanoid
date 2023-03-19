package SpriteAndCollidable;

import Game.GameLevel;
import Interfaces.Sprite;
import biuoop.DrawSurface;

import java.awt.*;

public class Line implements Sprite {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private Color color;

    public Line(int x1, int y1, int x2, int y2, Color color) {
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        this.color=color;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.drawLine(this.x1,this.y1, this.x2,this.y2);

    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);

    }
}