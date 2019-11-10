package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Coin extends Tile {
    public Coin(Vec2 position) {
        super(position, new Vec2(30, 30));
    }

    public void onEnter(GameEntity e) {
        e.collectCoin(this);
    }

    public void draw(BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();
        crayon.setColor(Color.green);
        crayon.fillOval(position.x, position.y, box.x, box.y);
    }

}
