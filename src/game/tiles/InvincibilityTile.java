package game.tiles;

import engine.Texture;
import game.level.Camera;
import game.entities.GameEntity;
import game.level.TextureFactory;
import game.level.Vec2;

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
            if (e.getInvincibilityFrames() <= 0) {
                e.setPreviousHealth(e.getHealth());
                e.setHealth(INVINCIBLEHEALTH);
            }
            e.setInvincibilityFrames(INVINCIBILITYFRAMESAMOUNT);
            e.setOnSpecialTile(true);
        }
    }

    @Override
    public void onTile(GameEntity e) {
        if (e != null) {
            e.setInvincibilityFrames(INVINCIBILITYFRAMESAMOUNT);
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
