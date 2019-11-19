package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Coin extends Tile {
    public Coin(Vec2 position, Vec2 box) {
        super(position, box);
    }

    public void onEnter(GameEntity e) {
        if (e != null) {
            e.collectCoin(this);
        }
    }

    @Override
    public void onTile(GameEntity e) {
        if (e != null) {

        }
    }

    public void onExit(GameEntity e) {

    }

    public void draw(BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();
        crayon.setColor(Color.yellow);
        crayon.fillOval(position.x, position.y, box.x, box.y);
    }

}
