package game.entities;

import engine.Texture;
import game.level.Camera;
import game.level.CollisionResolver;
import game.level.TextureFactory;
import game.level.Vec2;
import game.tiles.Coin;

import java.awt.image.BufferedImage;
import java.awt.*;

public class Hero extends GameEntity {

    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    public static int direction = RIGHT;

    private Texture[] textureArr;

    public Hero(Camera camera, Vec2 position, Vec2 box) {
        super(position, box);
        this.textureArr = new Texture[6];
        this.textureArr[0] = TextureFactory.get("player.png");
        this.textureArr[1] = TextureFactory.get("player_hit.png");
        this.textureArr[2] = TextureFactory.get("player_inv.png");
        this.textureArr[3] = TextureFactory.get("player_2.png");
        this.textureArr[4] = TextureFactory.get("player_hit_2.png");
        this.textureArr[5] = TextureFactory.get("player_inv_2.png");
        this.camera = camera;
        this.health = HEROMAXHEALTH;
    }

    public void update() {
        if(health <= 0) {
            lose = true;
        }
        controller.onUpdate();
    }

    @Override
    public void touchObstacle() {

    }

    public void move(Vec2 translation) {
        translation.x = translation.x * 3;
        translation.y = translation.y * 3;
        if (this.speedFrames > 0) {
            translation.x = (int)(translation.x * SWIFTSPEEDMODIFIER);
            translation.y = (int)(translation.y * SWIFTSPEEDMODIFIER);
            this.speedFrames -= 1;
        }
        if (this.slowedFrames > 0) {
            translation.x = (int)(translation.x / GLUEDIVIDESPEED);
            translation.y = (int)(translation.y / GLUEDIVIDESPEED);
            this.slowedFrames -= 1;
        }
        nextPosition.x += translation.x;
        nextPosition.y += translation.y;
    }

    public void collectCoin(Coin c) {
        win = true;
    }

    public void applyMovement(CollisionResolver c) {
        super.applyMovement(c);
        //center the camera
        camera.position.x = (position.x - camera.scissor.x) / 2;
        camera.position.y = (position.y - camera.scissor.y) / 2;
    }

    public void draw(BufferedImage image, Camera camera) {
        int i;
        if (direction == RIGHT) {
            if (this.isHit) {
                i = 1;
            } else if (this.invincibilityFrames > 0) {
                i = 2;
            } else {
                i = 0;
            }
        }
        else {
            if (this.isHit) {
                i = 4;
            } else if (this.invincibilityFrames > 0) {
                i = 5;
            } else {
                i = 3;
            }
        }
        textureArr[i].draw(image, position.x - camera.position.x, position.y - camera.position.y, box.x, box.y);
        Graphics2D graphics = (Graphics2D)image.getGraphics();
        graphics.drawString("Health : "+health, position.x - camera.position.x, position.y - camera.position.y);
    }

    private Camera camera;
}
