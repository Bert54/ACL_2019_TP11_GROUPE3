package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SpeedTile extends Tile {

    public static final int SPEEDBONUSAMOUNT = 2;
    public static final int SPEEDBONUSDURATION = 10;

    public SpeedTile(Vec2 position, Vec2 box) {

        super(position, box);

    }

    @Override
    public void onEnter(GameEntity e) {
        //TODO add an attribute somewhere which sets the speed of the entity
        e.onSpecialTile = true;
    }

    @Override
    public void onTile(GameEntity e) {

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
