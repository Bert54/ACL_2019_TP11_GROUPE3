package game;

import java.awt.*;
import java.awt.image.BufferedImage;

import engine.Texture;
import exceptions.TeleportNegativeCoordinatesException;

public class TeleportTile extends Tile {

    public TeleportTile(Vec2 position, Vec2 box, Vec2 exit) {
        super(position, box);

        if (exit.x < 0 || exit.y < 0) {
            throw new TeleportNegativeCoordinatesException();
        }

        this.exit = exit;
    }

    public void onEnter(GameEntity e) {
        if (e != null) {
            e.moveTo(exit);
        }
    }

    @Override
    public void onTile(GameEntity e) {
        if (e != null) {
            // stub
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
        crayon.setColor(Color.pink);
        crayon.fillOval(position.x, position.y, box.x, box.y);
    }

    private Vec2 exit;
}
