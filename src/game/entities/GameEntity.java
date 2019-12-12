package game.entities;

import game.level.Camera;
import game.level.CollisionResolver;
import game.level.Drawable;
import game.level.Vec2;
import game.tiles.Coin;

import java.awt.image.BufferedImage;

import java.util.ArrayList;
import java.util.List;

public abstract class GameEntity implements Drawable {

    public static final float GLUEDIVIDESPEED = 2f;
    public static final int HITINVINCIBILITYFRAMES = 15;
    public static final float SWIFTSPEEDMODIFIER = 2.5f;
    public static final int HEROMAXHEALTH = 5;

    public GameEntity(Vec2 position, Vec2 box) {
        this.position = position;
        this.box = box;
        health = 3;
        nextPosition = new Vec2(position);
        this.invincibilityFrames = 0;
        this.slowedFrames = 0;
        this.speedFrames = 0;
        this.isHit = false;
	owned = new ArrayList<GameEntity>();
	direction = new Vec2();
    }

    public abstract void update();
    public abstract void touchObstacle();
    
    public void applyMovement(CollisionResolver collisionResolver) {
        position = new Vec2(nextPosition);
        if (this.invincibilityFrames > 0 ) {
            this.invincibilityFrames -= 1;
            if (this.invincibilityFrames <= 0) {
                if (this.previousHealth != 0) {
                    this.health = this.previousHealth;
                    this.previousHealth = 0;
                }
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
            System.out.println(translation.x);
            System.out.println(translation.y);
            translation.x = (int)(translation.x / GLUEDIVIDESPEED);
            translation.y = (int)(translation.y / GLUEDIVIDESPEED);
            System.out.println(translation.x);
            System.out.println(translation.y);
            this.slowedFrames -= 1;
        }

        nextPosition.x += (translation.x * 1.5);
        nextPosition.y += (translation.y * 1.5);
	direction.x = nextPosition.x - position.x;
	direction.y = nextPosition.y - position.y;
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

    public void onHit(GameEntity e) {
        if (this.invincibilityFrames <= 0 && !owned.contains(e)) {
			cancelMovement();
            --health;
            this.isHit = true;
            this.invincibilityFrames = HITINVINCIBILITYFRAMES;
        }
    }

    public boolean isProjectile() {
        return false;
    }

    public abstract void collectCoin(Coin c);

    public boolean isWin() {
        return win;
    }

	public void addSubEntity(GameEntity e) {
		owned.add(e);
	}

    public int getHealth() {
        return health;
    }

    public static int getHEALTHMAX() {
        return HEROMAXHEALTH;
    }

    public int getInvincibilityFrames() {
        return this.invincibilityFrames;
    }

    public boolean isLose() {
        return lose;
    }

    public void setSlowedFrames(int sf) {
        this.slowedFrames = sf;
    }

    public void setSpeedFrames(int sf) {
        this.speedFrames = sf;
    }

    public void setInvincibilityFrames(int ifs) {
        this.invincibilityFrames = ifs;
    }

    public void setOnSpecialTile(boolean onST) {
        this.onSpecialTile = onST;
    }

    public void setIsHit(boolean hit) {
        this.isHit = hit;
    }

    public void setHealth(int nh) {
        this.health = nh;
    }

    public void setPreviousHealth(int ph) {
        this.previousHealth = ph;
    }

    public void setDisposable(boolean newState) {
        this.disposable = newState;
    }

    public boolean isDisposable() {
        return disposable;
    }

    public Vec2 getDirection() {
	return direction;
    }

    public abstract void draw(BufferedImage image, Camera camera);

    protected EntityController controller;
    protected Vec2 position;
    protected Vec2 nextPosition;
    protected Vec2 direction;
    protected Vec2 box;

    public boolean onSpecialTile;

    protected int previousHealth;
    protected int health;
    protected int invincibilityFrames;
    protected boolean isHit;

	protected List<GameEntity> owned;

    protected int slowedFrames;

    protected int speedFrames;
  
    protected boolean win;
    protected boolean lose;
    protected boolean disposable;
}
