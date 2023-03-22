package Collection;

import Interfaces.Sprite;
import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * SpriteCollection class.
 *
 * @author Idit Medizada iditm9@gmail.com
 */
public class SpriteCollection {
    private List<Sprite> spriteList;

    /**
     * Constructor.
     */
    public SpriteCollection() {
        spriteList = new ArrayList<>();
    }

    /**
     * Add new sprite to the arrayList.
     *
     * @param s the sprite we want to add.
     */
    public void addSprite(Sprite s) {
        spriteList.add(s);
    }

    public int getSize() {
        return spriteList.size();
    }

    public Sprite getSprite(int i) {
        return this.spriteList.get(i);
    }

    /**
     * Remove a chosen sprite from the arrayList.
     *
     * @param s the sprite we want to remove
     */
    public void removeSprite(Sprite s) {
        List<Sprite> tempList = new ArrayList<>(this.spriteList);
        for (Sprite sprite : tempList) {
            if (s.equals(sprite)) {
                spriteList.remove(s);

            }
        }

    }

    /**
     * NotifyAllTimePassed function.
     * Call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> tempList = new ArrayList<>(this.spriteList);

        for (Sprite sprite : tempList) {
            sprite.timePassed();
        }
    }

    /**
     * DrawAllOn function.
     * Call drawOn(d) on all sprites.
     *
     * @param d DrawSurface
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : spriteList) {
            sprite.drawOn(d);
        }
    }
}