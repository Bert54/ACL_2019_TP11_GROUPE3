package game;

import java.awt.image.BufferedImage;

public abstract class Tile implements Drawable {
    public Tile(Vec2 position, Vec2 box) {
        this.position = position;
        this.box = box;
    }

    public Vec2 getPosition() {
        return position;
    }

    public Vec2 getBox() {
        return box;
    }

    public abstract void onEnter(GameEntity e);

    public abstract void onTile(GameEntity e);

    public abstract void onExit(GameEntity e);

    public abstract void draw(BufferedImage image, Camera camera);

    protected Vec2 position;
    protected Vec2 box;
}
