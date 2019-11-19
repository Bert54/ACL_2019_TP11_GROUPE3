package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LavaTile extends Tile {

    public static final int LAVADAMAGE = 1;
    public static final int LAVAINVINCIBILITY = 30;

    public LavaTile(Vec2 position, Vec2 box) {
        super(position, box);
    }

    @Override
    public void onEnter(GameEntity e) {
        if (e != null) {
            if (e.invincibilityFrames <= 0) {
                e.health -= LAVADAMAGE;
                e.onSpecialTile = true;
                e.invincibilityFrames = LAVAINVINCIBILITY;
            }
        }
    }

    @Override
    public void onTile(GameEntity e) {
        if (e != null) {
            if (e.invincibilityFrames <= 0) {
                e.health -= LAVADAMAGE;
                e.invincibilityFrames = LAVAINVINCIBILITY;
            }
        }
    }

    public void onExit(GameEntity e) {
        if (e != null) {
            e.onSpecialTile = false;
        }
    }

    @Override
    public void draw(BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();
        crayon.setColor(Color.red);
        crayon.fillOval(position.x, position.y, box.x, box.y);
    }
}
