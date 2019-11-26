package game;

import engine.Texture;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Coin extends Tile {

    private Texture texture;

    public Coin(Vec2 position, Vec2 box) {
        super(position, box);
        texture = TextureFactory.get("coin.png");
    }

    public void onEnter(GameEntity e) {
        if (e != null) {
            e.collectCoin(this);
        }
    }

    @Override
    public void onTile(GameEntity e) {
        if (e != null) {

        }
    }

    public void onExit(GameEntity e) {

    }

    public void draw(BufferedImage image, Camera camera) {
        texture.draw(image, position.x - camera.position.x, position.y - camera.position.y, box.x, box.y);

    }

}
