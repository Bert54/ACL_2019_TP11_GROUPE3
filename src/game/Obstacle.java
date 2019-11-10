package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Obstacle extends Tile {

    public Obstacle(Vec2 position, Vec2 box) {
        super(position, box);
    }

    public void onEnter(GameEntity e) {
        e.cancelMovement();
    }

    @Override
    public void draw(BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();
        crayon.setColor(Color.black);
        crayon.fillRect(position.x, position.y, box.x, box.y);
    }
}
