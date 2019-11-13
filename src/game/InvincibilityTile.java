package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class InvincibilityTile extends Tile {

    public static final int INVINCIBILITYFRAMESAMOUNT = 15;
    public static final int INVINCIBLEHEALTH = 9999999;

    public InvincibilityTile(Vec2 position, Vec2 box) {
        super(position, box);
    }

    @Override
    public void onEnter(GameEntity e) {
        e.invincibilityFrames = INVINCIBILITYFRAMESAMOUNT;
        e.previousHealth = e.health;
        e.health = INVINCIBLEHEALTH;
    }

    @Override
    public void draw(BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();
        crayon.setColor(Color.GREEN);
        crayon.fillOval(position.x, position.y, box.x, box.y);
    }
}
