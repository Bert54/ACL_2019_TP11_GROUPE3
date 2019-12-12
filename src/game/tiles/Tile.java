package game.tiles;

import game.level.Camera;
import game.level.Drawable;
import game.entities.GameEntity;
import game.level.Vec2;

import java.awt.image.BufferedImage;

public abstract class Tile implements Drawable {
    public Tile(Vec2 position, Vec2 box) {
        this.position = position;
        this.box = box;
        this.disposable = false;
    }

    public Vec2 getPosition() {
        return position;
    }

    public Vec2 getBox() {
        return box;
    }

    public boolean isDisposable() {
        return disposable;
    }

    public abstract void onEnter(GameEntity e);

    public abstract void onTile(GameEntity e);

    public abstract void onExit(GameEntity e);

    public abstract void draw(BufferedImage image, Camera camera);

    protected Vec2 position;
    protected Vec2 box;
    protected boolean disposable;
}
