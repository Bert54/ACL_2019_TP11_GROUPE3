package game;

import java.awt.image.BufferedImage;

public abstract class Tile implements Drawable {

    protected Vec2 position;
    protected Vec2 nextPosition;
    protected Vec2 box;

    public Tile(Vec2 position, Vec2 box) {
        this.position = position;
        this.box = box;
        nextPosition = new Vec2(position);
    }

    public Vec2 getPosition() {
        return position;
    }

    public Vec2 getNextPosition() {
        return nextPosition;
    }

    public Vec2 getBox() {
        return box;
    }

    public abstract void draw(BufferedImage image);
}
