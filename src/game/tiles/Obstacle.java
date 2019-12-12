package game.tiles;

import engine.Texture;
import game.entities.GameEntity;
import game.level.Camera;
import game.level.TextureFactory;
import game.level.Vec2;

import java.awt.image.BufferedImage;

public class Obstacle extends Tile {

    private Texture texture;

    public Obstacle(Vec2 position, Vec2 box) {
        super(position, box);
        texture = TextureFactory.get("box.bmp");
    }

    @Override
    public void onEnter(GameEntity e) {
        if (e != null) {
            if (e.isProjectile()) {
                this.disposable = true;
                e.setDisposable(true);
            }
            else {
                e.cancelMovement();
                e.touchObstacle();
            }
        }
    }

    @Override
    public void onTile(GameEntity e) {

    }

    @Override
    public void onExit(GameEntity e) {

    }

    @Override
    public void draw(BufferedImage image, Camera camera) {
        texture.draw(image, position.x - camera.position.x, position.y - camera.position.y, box.x, box.y);
    }
}
