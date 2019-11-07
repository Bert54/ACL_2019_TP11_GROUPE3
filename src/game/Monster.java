package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Monster extends GameEntity {
    public Monster(Vec2 position, Vec2 box) {
        super(position, box);
    }

    public void update() {
        controller.onUpdate();
    }

    public void draw(BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();
		crayon.setColor(Color.blue);
		crayon.fillOval(position.x, position.y, 30, 30);
    }
}
