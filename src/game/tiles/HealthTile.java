package game.tiles;

import java.awt.image.BufferedImage;

import engine.Texture;
import game.level.Camera;
import game.level.TextureFactory;
import game.level.Vec2;
import game.entities.GameEntity;

public class HealthTile extends Tile {

    public HealthTile(Vec2 position, Vec2 box) {
        super(position, box);
        texture = TextureFactory.get("health.bmp");
		active = true;
    }

    public void onEnter(GameEntity e) {
		if(active) {
			e.setHealth(5);
			active = false;
		}
    }

    @Override
    public void onTile(GameEntity e) {
        if (e != null) {
            //stub
        }
    }

    public void onExit(GameEntity e) {
        if (e != null) {
            //stub
        }
    }

    @Override
    public void draw(BufferedImage image, Camera camera) {
        texture.draw(image, position.x - camera.position.x, position.y - camera.position.y, box.x, box.y);
    }

    private Texture texture;
    private boolean active;
}
