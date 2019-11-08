package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Edge extends Tile {

    public Edge(Vec2 position, Vec2 box) {
        super(position, box);
    }

    @Override
    public void draw(BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();
        crayon.setColor(Color.lightGray);
        crayon.fillRect(position.x,position.y,box.x,box.y);
    }
}
