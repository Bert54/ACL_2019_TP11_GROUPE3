package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class InvincibilityTile extends Tile {

    public static final int INVINCIBILITYFRAMESAMOUNT = 15;
    public static final int INVINCIBLEHEALTH = 9999999;

    public InvincibilityTile(Vec2 position, Vec2 box) {
        super(position, box);
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
        Graphics2D crayon = (Graphics2D) image.getGraphics();
        crayon.setColor(Color.GREEN);
        crayon.fillOval(position.x - camera.position.x, position.y - camera.position.y, box.x, box.y);
    }
}
