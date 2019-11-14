package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SwiftTile extends Tile {

    public static final int SPEEDBONUSDURATION = 15;

    public SwiftTile(Vec2 position, Vec2 box) {

        super(position, box);

    }

    @Override
    public void onEnter(GameEntity e) {
        e.speedFrames = SPEEDBONUSDURATION;
        e.onSpecialTile = true;
    }

    @Override
    public void onTile(GameEntity e) {

        e.speedFrames = SPEEDBONUSDURATION;

    }

    public void onExit(GameEntity e) {
        e.onSpecialTile = false;
    }

    @Override
    public void draw(BufferedImage image) {

        Graphics2D crayon = (Graphics2D) image.getGraphics();
        crayon.setColor(Color.cyan);
        crayon.fillOval(position.x, position.y, box.x, box.y);

    }
}
