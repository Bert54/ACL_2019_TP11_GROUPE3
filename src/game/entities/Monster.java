package game.entities;

import engine.Texture;
import game.level.Camera;
import game.tiles.Coin;
import game.level.TextureFactory;
import game.level.Vec2;

import java.awt.image.BufferedImage;
import java.awt.*;

public class Monster extends GameEntity {

    private Texture texture;

    public Monster(Vec2 position, Vec2 box) {
        super(position, box);
        texture = TextureFactory.get("monster_basic.png");
    }

    public void update() {
        if(health <= 0) {
            disposable = true;
        }
        controller.onUpdate();
    }

    public void onHit(GameEntity e) {
        cancelMovement();
        super.onHit(e);
    }

    public void collectCoin(Coin c) {
        cancelMovement();
    }

    public void draw(BufferedImage image, Camera camera) {
        texture.draw(image, position.x - camera.position.x, position.y - camera.position.y, box.x, box.y);
        Graphics2D graphics = (Graphics2D)image.getGraphics();
        graphics.drawString("Health : "+health, position.x - camera.position.x, position.y - camera.position.y);
    }
}
