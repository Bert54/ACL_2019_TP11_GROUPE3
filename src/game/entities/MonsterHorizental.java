package game.entities;

import engine.Texture;
import game.level.Camera;
import game.level.TextureFactory;
import game.level.Vec2;
import game.tiles.Coin;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MonsterHorizental extends GameEntity{
    private Texture texture;

    public MonsterHorizental(Vec2 position, Vec2 box) {
        super(position, box);
        texture = TextureFactory.get("monster_2.png");
    }

    public void update() {
        if (health <= 0) {
            disposable = true;
        }
        controller.onUpdate();
    }

    @Override
    public void touchObstacle() {
        ((MonsterHorController)controller).iverseDirection();

    }

    public void collectCoin(Coin c) {
        cancelMovement();
    }

    public void draw(BufferedImage image, Camera camera) {

        texture.draw(image, position.x - camera.position.x, position.y - camera.position.y, box.x, box.y);
        Graphics2D graphics = (Graphics2D)image.getGraphics();
        graphics.drawString("Health : "+health, position.x - camera.position.x, position.y - camera.position.y);

    }
    public void onHit(GameEntity e) {
        super.onHit(e);
        ((MonsterHorController)controller).iverseDirection();

    }


}
