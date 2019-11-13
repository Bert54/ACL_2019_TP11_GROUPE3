package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Button implements Drawable{

    private Vec2 position;
    private Vec2 box;
    private String text;

    public Button(String text, Vec2 position, Vec2 box) {
        this.position = position;
        this.box = box;
        this.text = text;
    }

    @Override
    public void draw(BufferedImage image) {

        Graphics2D crayon = (Graphics2D) image.getGraphics();
        crayon.setColor(Color.BLACK);
        crayon.fillRect(position.x, position.y, box.x, box.y);
        crayon.setColor(Color.WHITE);
        crayon.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        int Xcentre = (int) (position.x + (box.x - crayon.getFontMetrics().getStringBounds(this.text, crayon).getWidth())/2);
        int Ycentre = (int) (position.y + (box.y - crayon.getFontMetrics().getStringBounds(this.text, crayon).getHeight()/3));
        crayon.drawString(this.text, Xcentre, Ycentre);
    }

    public Vec2 getBox() {
        return box;
    }
}

