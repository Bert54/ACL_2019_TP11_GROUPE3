package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LavaTile extends Tile {

    public static final int LAVADAMAGE = 1;

    public LavaTile(Vec2 position, Vec2 box) {
        super(position, box);
    }

    @Override
    public void onEnter(GameEntity e) {
        e.health -= LAVADAMAGE;
    }

    @Override
    public void draw(BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();
        crayon.setColor(Color.red);
        crayon.fillOval(position.x, position.y, box.x, box.y);
    }
}
