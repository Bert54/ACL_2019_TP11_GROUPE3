package game.entities;

import engine.Texture;
import game.level.Camera;
import game.level.TextureFactory;
import game.level.Vec2;
import game.tiles.Coin;

import java.awt.image.BufferedImage;

public class MonsterHorizental extends GameEntity{
    private Texture texture;

    public MonsterHorizental(Vec2 position, Vec2 box) {
        super(position, box);
        texture = TextureFactory.get("monster_basic.png");
    }

    public void update() {
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

    }
    public void onHit(GameEntity e) {
        super.onHit(e);
        ((MonsterHorController)controller).iverseDirection();
    }

}
