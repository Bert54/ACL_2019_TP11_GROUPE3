package game.entities;

import engine.Texture;
import game.level.Camera;
import game.tiles.Coin;
import game.level.TextureFactory;
import game.level.Vec2;

import java.awt.image.BufferedImage;
import java.awt.*;

public class Projectile extends GameEntity {
    public Projectile(GameEntity owner, Vec2 position, Vec2 box, Vec2 direction) {
        super(position, box);
        this.owner = owner;
        this.direction = direction;
        controller = new ProjectileController(this);
    }

    public void update() {
        controller.onUpdate();
    }

    public void onHit(GameEntity e) {
        if(e != owner) {
            disposable = true;
        }
    }

    public void collectCoin(Coin c) {
        disposable = true;
    }

    public void moveProjectile() {
        nextPosition.x += direction.x;
        nextPosition.y += direction.y;
    }

    public void draw(BufferedImage image, Camera camera) {
        Graphics2D g2d = (Graphics2D)image.getGraphics();
        g2d.setColor(Color.red);
        g2d.fillOval(position.x - camera.position.x, position.y - camera.position.y, box.x, box.y);
    }

    private Vec2 direction;
    private GameEntity owner;
}