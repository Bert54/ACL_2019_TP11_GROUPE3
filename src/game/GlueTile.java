package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GlueTile extends Tile {

    public GlueTile(Vec2 position, Vec2 box) {
        super(position, box);
    }

    @Override
    public void onEnter(GameEntity e) {
        e.isGlued = true;
    }

    @Override
    public void draw(BufferedImage image) {

        Graphics2D crayon = (Graphics2D) image.getGraphics();
        crayon.setColor(Color.darkGray);
        crayon.fillOval(position.x, position.y, box.x, box.y);

    }
}
