package game;

import engine.Texture;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LavaTile extends Tile {

    public static final int LAVADAMAGE = 1;
    public static final int LAVAINVINCIBILITY = 30;

    private Texture texture;

    public LavaTile(Vec2 position, Vec2 box) {
        super(position, box);
        texture = TextureFactory.get("lava.jpg");
    }

    @Override
    public void onEnter(GameEntity e) {
        if (e != null) {
            if (e.invincibilityFrames <= 0) {
                e.health -= LAVADAMAGE;
                e.onSpecialTile = true;
                e.isHit = true;
                e.invincibilityFrames = LAVAINVINCIBILITY;
            }
        }
    }

    @Override
    public void onTile(GameEntity e) {
        if (e != null) {
            if (e.invincibilityFrames <= 0) {
                e.health -= LAVADAMAGE;
                e.invincibilityFrames = LAVAINVINCIBILITY;
                e.isHit = true;
            }
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
