package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameEntity implements Drawable {
    public GameEntity(Vec2 position, Vec2 box) {
        this.position = position;
        this.box = box;
        nextPosition = new Vec2(position);
        this.isHero = false;
    }

    public abstract void update();
    
    public void applyMovement() {
        position = new Vec2(nextPosition);
    }

    public void cancelMovement() {
        nextPosition = new Vec2(position);
    }

    public void setController(EntityController controller) {
        this.controller = controller;
    }

    public EntityController getController() {
        return controller;
    }

    public void move(Vec2 translation) {
        nextPosition.x += translation.x;
        nextPosition.y += translation.y;
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

    public boolean isHero(){
        return isHero;
    }

    protected boolean isHero;
    protected EntityController controller;
    protected Vec2 position;
    protected Vec2 nextPosition;
    protected Vec2 box;
}
