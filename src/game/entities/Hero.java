package game.entities;

import engine.Texture;
import game.level.Camera;
import game.level.CollisionResolver;
import game.level.TextureFactory;
import game.level.Vec2;
import game.tiles.Coin;

import java.awt.image.BufferedImage;
import java.awt.*;

public class Hero extends GameEntity {

    private Texture texture;
    private Texture textureHit;
    private Texture textureInv;

    public Hero(Camera camera, Vec2 position, Vec2 box) {
        super(position, box);
        texture = TextureFactory.get("player.png");
        textureHit = TextureFactory.get("player_hit.png");
        textureInv = TextureFactory.get("player_inv.png");
        this.camera = camera;
        this.health = HEROMAXHEALTH;
    }

    public void update() {
        if(health <= 0) {
            lose = true;
        }
        controller.onUpdate();
    }

    @Override
    public void touchObstacle() {

    }

    public void collectCoin(Coin c) {
        win = true;
    }

    public void applyMovement(CollisionResolver c) {
        super.applyMovement(c);
        //center the camera
        camera.position.x = (position.x - camera.scissor.x) / 2;
        camera.position.y = (position.y - camera.scissor.y) / 2;
    }

    public void draw(BufferedImage image, Camera camera) {
        if (this.isHit) {
            textureHit.draw(image, position.x - camera.position.x, position.y - camera.position.y, box.x, box.y);
        }
        else if (this.invincibilityFrames > 0) {
            textureInv.draw(image, position.x - camera.position.x, position.y - camera.position.y, box.x, box.y);
        }
        else {
            texture.draw(image, position.x - camera.position.x, position.y - camera.position.y, box.x, box.y);
        }
        Graphics2D graphics = (Graphics2D)image.getGraphics();
        graphics.drawString("Health : "+health, position.x - camera.position.x, position.y - camera.position.y);
    }

    private Camera camera;
}
