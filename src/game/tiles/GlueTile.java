package game.tiles;

import engine.Texture;
import game.level.Camera;
import game.entities.GameEntity;
import game.level.TextureFactory;
import game.level.Vec2;

import java.awt.image.BufferedImage;

public class GlueTile extends Tile {

    public static final int GLUEFRAMESAM = 3;
    private Texture texture;

    public GlueTile(Vec2 position, Vec2 box) {
        super(position, box);
        texture = TextureFactory.get("glue.png");
    }

    @Override
    public void onEnter(GameEntity e) {
        if (e != null) {
            e.setSlowedFrames(GLUEFRAMESAM);
            e.setOnSpecialTile(true);
        }
    }

    @Override
    public void onTile(GameEntity e) {
        if (e != null) {
            e.setSlowedFrames(GLUEFRAMESAM);
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
