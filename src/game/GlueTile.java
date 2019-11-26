package game;

import engine.Texture;

import java.awt.image.BufferedImage;

public class GlueTile extends Tile {

    public static final int GLUEFRAMESAM = 1;
    private Texture texture;

    public GlueTile(Vec2 position, Vec2 box) {
        super(position, box);
        texture = TextureFactory.get("glue.png");
    }

    @Override
    public void onEnter(GameEntity e) {
        if (e != null) {
            e.slowedFrames = GLUEFRAMESAM;
            e.onSpecialTile = true;
        }
    }

    @Override
    public void onTile(GameEntity e) {
        if (e != null) {
            e.slowedFrames = GLUEFRAMESAM;
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
