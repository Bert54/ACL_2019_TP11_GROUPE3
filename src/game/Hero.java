package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Hero extends GameEntity {
    public Hero(Vec2 position, Vec2 box) {
        super(position, box);
    }

    public void update() {
        if(health <= 0) {
            System.exit(0);
        }
        controller.onUpdate();
    }

    public void collectCoin(Coin c) {
        System.exit(0);
    }

    public void draw(BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();
        crayon.setColor(Color.red);
        crayon.fillOval(position.x, position.y, box.x, box.y);
    }
}
