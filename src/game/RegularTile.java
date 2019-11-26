package game;

import engine.Texture;

import java.awt.image.BufferedImage;

public class RegularTile extends Tile {

    private Texture texture;

    public RegularTile(Vec2 position, Vec2 box) {
        super(position, box);
        texture = TextureFactory.get("regular.png");
    }

    @Override
    public void onEnter(GameEntity e) {

    }

    @Override
    public void onTile(GameEntity e) {

    }

    @Override
    public void onExit(GameEntity e) {

    }

    @Override
    public void draw(BufferedImage image, Camera camera) {
        texture.draw(image, position.x - camera.position.x, position.y - camera.position.y, box.x, box.y);
    }
}
