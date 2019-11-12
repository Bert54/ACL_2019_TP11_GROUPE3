package game;

import java.awt.*;
import java.awt.image.BufferedImage;

import engine.Texture;

public class TeleportTile extends Tile {
    public TeleportTile(Vec2 position, Vec2 box, Vec2 exit) {
        super(position, box);
        this.exit = exit;
    }

    public void onEnter(GameEntity e) {
        e.moveTo(exit);
    }

    @Override
    public void draw(BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();
        crayon.setColor(Color.pink);
        crayon.fillOval(position.x, position.y, box.x, box.y);
    }

    private Vec2 exit;
}
