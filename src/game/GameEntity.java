package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameEntity implements Drawable {
    public GameEntity(Vec2 position, Vec2 box) {
        this.position = position;
        this.box = box;
        health = 3;
        nextPosition = new Vec2(position);
        this.invincibilityFrames = 0;
        this.isGlued = false;
    }

    public abstract void update();
    
    public void applyMovement(CollisionResolver collisionResolver) {
        position = new Vec2(nextPosition);
        if (this.invincibilityFrames > 0) {
            this.invincibilityFrames -= 1;
            if (this.invincibilityFrames <= 0) {
                this.health = this.previousHealth;
            }
        }
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
        if (this.isGlued) {
            translation.x = translation.x / 5;
            translation.y = translation.y / 5;
        }
        nextPosition.x += translation.x;
        nextPosition.y += translation.y;
    }

    public void moveTo(Vec2 pos) {
        nextPosition.x += pos.x;
        nextPosition.y += pos.y;
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

    public void onHit() {
        cancelMovement();
        --health;
    }

    public abstract void collectCoin(Coin c);

    public abstract void draw(BufferedImage image);

    protected EntityController controller;
    protected Vec2 position;
    protected Vec2 nextPosition;
    protected Vec2 box;

    protected int previousHealth;
    protected int health;
    protected int invincibilityFrames;

    protected boolean isGlued;
}
