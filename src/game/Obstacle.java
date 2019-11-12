package game;

import java.awt.*;
import java.awt.image.BufferedImage;

import engine.Texture;

public class Obstacle extends Tile {

    public Obstacle(Vec2 position, Vec2 box) {
        super(position, box);
        texture = TextureFactory.get("box.bmp");
    }

    public void onEnter(GameEntity e) {
        e.cancelMovement();
    }

    @Override
    public void draw(BufferedImage image) {
        texture.draw(image, position.x, position.y, box.x, box.y);
    }

    private Texture texture;
}
