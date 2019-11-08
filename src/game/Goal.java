package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Goal extends Tile{


    public Goal(Vec2 position,Vec2 box){
        super(position, box);


    }
    public Vec2 getPosition() {
        return position;
    }

    public void draw(BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();
        crayon.setColor(Color.green);
        crayon.fillOval(position.x, position.y, 30, 30);
    }

}
