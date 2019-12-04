package game.tiles;

import engine.Texture;
import game.level.Camera;
import game.entities.GameEntity;
import game.level.TextureFactory;
import game.level.Vec2;

import java.awt.image.BufferedImage;

public class SwiftTile extends Tile {

    public static final int SPEEDBONUSDURATION = 15;

    private Texture texture;

    public SwiftTile(Vec2 position, Vec2 box) {

        super(position, box);
        texture = TextureFactory.get("swift.jpg");

    }

    @Override
    public void onEnter(GameEntity e) {
        if (e != null) {
            e.setSpeedFrames(SPEEDBONUSDURATION);
            e.setOnSpecialTile(true);
        }
    }

    @Override
    public void onTile(GameEntity e) {
        if (e != null) {
            e.setSpeedFrames(SPEEDBONUSDURATION);
        }

    }

    public void onExit(GameEntity e) {
        if (e != null) {
            e.setOnSpecialTile(false);
        }
    }

    @Override
    public void draw(BufferedImage image, Camera camera) {

        //Graphics2D crayon = (Graphics2D) image.getGraphics();
        //crayon.setColor(Color.cyan);
        //crayon.fillOval(position.x - camera.position.x, position.y - camera.position.y, box.x, box.y);
        texture.draw(image, position.x - camera.position.x, position.y - camera.position.y, box.x, box.y);


    }
}
