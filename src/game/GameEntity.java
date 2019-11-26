package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameEntity implements Drawable {

    public static final int GLUEDIVIDESPEED = 2;
    public static final int HITINVINCIBILITYFRAMES = 15;
    public static final float SWIFTSPEEDMODIFIER = 2.5f;

    public GameEntity(Vec2 position, Vec2 box) {
        this.position = position;
        this.box = box;
        health = 3;
        nextPosition = new Vec2(position);
        this.invincibilityFrames = 0;
        this.slowedFrames = 0;
        this.speedFrames = 0;
        this.isHit = false;
    }

    public abstract void update();
    
    public void applyMovement(CollisionResolver collisionResolver) {
        position = new Vec2(nextPosition);
        if (this.invincibilityFrames > 0) {
            this.invincibilityFrames -= 1;
            if (this.invincibilityFrames <= 0 && this.previousHealth != 0) {
                this.health = this.previousHealth;
                this.previousHealth = 0;
                this.isHit = false;
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
        if (this.speedFrames > 0) {
            translation.x = (int)(translation.x * SWIFTSPEEDMODIFIER);
            translation.y = (int)(translation.y * SWIFTSPEEDMODIFIER);
            this.speedFrames -= 1;
        }
        if (this.slowedFrames > 0) {
            translation.x = translation.x / GLUEDIVIDESPEED;
            translation.y = translation.y / GLUEDIVIDESPEED;
            this.slowedFrames -= 1;
        }
        nextPosition.x += (translation.x * 1.5);
        nextPosition.y += (translation.y * 1.5);
    }

    public void moveTo(Vec2 pos) {
        nextPosition.x = pos.x;
        nextPosition.y = pos.y;
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
        if (this.invincibilityFrames <= 0) {
            --health;
            this.isHit = true;
            this.invincibilityFrames = HITINVINCIBILITYFRAMES;
        }
    }

    public abstract void collectCoin(Coin c);

    public boolean isWin() {
        return win;
    }

    public int getHealth() {
        return health;
    }

    public boolean isLose() {
        return lose;
    }

    public abstract void draw(BufferedImage image, Camera camera);

    protected EntityController controller;
    protected Vec2 position;
    protected Vec2 nextPosition;
    protected Vec2 box;

    protected boolean onSpecialTile;

    protected int previousHealth;
    protected int health;
    protected int invincibilityFrames;
    protected boolean isHit;

    protected int slowedFrames;

    protected int speedFrames;
  
    protected boolean win;
    protected boolean lose;
}
