package game;

import engine.Texture;

import java.awt.*;
import java.awt.image.BufferedImage;

public class InvincibilityTile extends Tile {

    public static final int INVINCIBILITYFRAMESAMOUNT = 30;
    public static final int INVINCIBLEHEALTH = 9999999;

    private Texture texture;

    public InvincibilityTile(Vec2 position, Vec2 box) {
        super(position, box);
        texture = TextureFactory.get("invincible.jpg");
    }

    @Override
    public void onEnter(GameEntity e) {
        if (e != null) {
            if (e.invincibilityFrames <= 0) {
                e.previousHealth = e.health;
                e.health = INVINCIBLEHEALTH;
            }
            e.invincibilityFrames = INVINCIBILITYFRAMESAMOUNT;
            e.onSpecialTile = true;
        }
    }

    @Override
    public void onTile(GameEntity e) {
        if (e != null) {
            e.invincibilityFrames = INVINCIBILITYFRAMESAMOUNT;
        }
    }

    public void onExit(GameEntity e) {
        if (e != null) {
            e.onSpecialTile = false;
        }
    }

    @Override
    public void draw(BufferedImage image, Camera camera) {
        texture.draw(image, position.x - camera.position.x, position.y - camera.position.y, box.x, box.y);
    }
}
