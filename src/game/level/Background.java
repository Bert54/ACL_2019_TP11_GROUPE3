package game.level;

import engine.Texture;

import java.awt.image.BufferedImage;

public class Background implements Drawable {

    private Texture texture;
    private Vec2 box;

    public Background(Texture texture, Vec2 box) {
        this.texture = texture;
        this.box = box;
    }

    @Override
    public void draw(BufferedImage image, Camera camera) {

        texture.draw(image, 0, 0, box.x, box.y);
    }
}
