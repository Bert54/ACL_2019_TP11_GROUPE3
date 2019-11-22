package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Hero extends GameEntity {

    public Hero(Camera camera, Vec2 position, Vec2 box) {
        super(position, box);
        this.camera = camera;
    }

    public void update() {
        if(health <= 0) {
            lose = true;
            //System.exit(0);
        }
        controller.onUpdate();
    }

    public void collectCoin(Coin c) {
        win = true;
        //System.exit(0);
    }

    public void applyMovement(CollisionResolver c) {
        super.applyMovement(c);
        //center the camera
        camera.position.x = position.x - camera.scissor.x / 2;
        camera.position.y = position.y - camera.scissor.y / 2;
    }

    public void draw(BufferedImage image, Camera camera) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();
        if (this.invincibilityFrames > 0) {
            Color c = new Color(255, 0, 0, 130);
            crayon.setColor(c);
        }
        else {
            crayon.setColor(Color.red);
        }
        crayon.fillOval(position.x - camera.position.x, position.y - camera.position.y, box.x, box.y);
    }

    private Camera camera;
}
