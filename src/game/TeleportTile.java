package game;

import java.awt.*;
import java.awt.image.BufferedImage;

import engine.Texture;
import exceptions.TeleportNegativeCoordinatesException;

public class TeleportTile extends Tile {

    private Texture texture;

    public TeleportTile(Vec2 position, Vec2 box, Vec2 exit) {
        super(position, box);

        if (exit.x < 0 || exit.y < 0) {
            throw new TeleportNegativeCoordinatesException();
        }
        texture = TextureFactory.get("teleport.png");
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
    public void draw(BufferedImage image, Camera camera) {
        texture.draw(image, position.x - camera.position.x, position.y - camera.position.y, box.x, box.y);
    }

    private Vec2 exit;
}
