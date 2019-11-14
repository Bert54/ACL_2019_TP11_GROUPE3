package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GlueTile extends Tile {

    public static final int GLUEFRAMESAM = 1;

    public GlueTile(Vec2 position, Vec2 box) {
        super(position, box);
    }

    @Override
    public void onEnter(GameEntity e) {
        e.slowedFrames = GLUEFRAMESAM;
        e.onSpecialTile = true;
    }

    @Override
    public void onTile(GameEntity e) {
        e.slowedFrames = GLUEFRAMESAM;
    }

    public void onExit(GameEntity e) {
        e.onSpecialTile = false;
    }

    @Override
    public void draw(BufferedImage image) {

        Graphics2D crayon = (Graphics2D) image.getGraphics();
        crayon.setColor(Color.darkGray);
        crayon.fillOval(position.x, position.y, box.x, box.y);

    }
}
