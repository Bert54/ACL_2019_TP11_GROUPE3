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
        if (e != null) {
            e.speedFrames = SPEEDBONUSDURATION;
            e.onSpecialTile = true;
        }
    }

    @Override
    public void onTile(GameEntity e) {
        if (e != null) {
            e.speedFrames = SPEEDBONUSDURATION;
        }

    }

    public void onExit(GameEntity e) {
        if (e != null) {
            e.onSpecialTile = false;
        }
    }

    @Override
    public void draw(BufferedImage image, Camera camera) {

        Graphics2D crayon = (Graphics2D) image.getGraphics();
        crayon.setColor(Color.cyan);
        crayon.fillOval(position.x - camera.position.x, position.y - camera.position.y, box.x, box.y);

    }
}
