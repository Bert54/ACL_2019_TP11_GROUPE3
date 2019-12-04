package game.tiles;

import engine.Texture;
import game.level.Camera;
import game.entities.GameEntity;
import game.level.TextureFactory;
import game.level.Vec2;

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
            if (e.getInvincibilityFrames() <= 0) {
                e.setHealth(e.getHealth() - LAVADAMAGE);
                e.setOnSpecialTile(true);
                e.setIsHit(true);
                e.setInvincibilityFrames(LAVAINVINCIBILITY);
            }
        }
    }

    @Override
    public void onTile(GameEntity e) {
        if (e != null) {
            if (e.getInvincibilityFrames() <= 0) {
                e.setHealth(e.getHealth() - LAVADAMAGE);
                e.setInvincibilityFrames(LAVAINVINCIBILITY);
                e.setIsHit(true);
            }
        }
    }

    public void onExit(GameEntity e) {
        if (e != null) {
            e.setOnSpecialTile(false);
        }
    }

    @Override
    public void draw(BufferedImage image, Camera camera) {
        texture.draw(image, position.x - camera.position.x, position.y - camera.position.y, box.x, box.y);
    }
}
