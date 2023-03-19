package SpriteAndCollidable;

import Game.GameLevel;
import Interfaces.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

public class Circle implements Sprite {
    private int x;
    private int y;
    private int radius;
    private Color color;

    public Circle(int x,int y,int radius, Color color){
        this.x=x;
        this.y=y;
        this.radius=radius;
        this.color=color;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.drawCircle(this.x, this.y, this.radius);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}