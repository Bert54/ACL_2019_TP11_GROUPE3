package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Hero extends GameEntity {
    public Hero(Vec2 position, Vec2 box) {
        super(position, box);
        this.isHero = true;
    }

    public void update() {
        controller.onUpdate();
    }

    public void draw(BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();
		crayon.setColor(Color.red);
		crayon.fillOval(position.x, position.y, 30, 30);
    }
}
