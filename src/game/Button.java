package game;

import controllers.StartGameMouseController;
import engine.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class Button extends JPanel implements Drawable {

    private Vec2 position;
    private Vec2 box;
    private String text;

    public Button() {
        super();
        this.setEnabled(false);
    }

    public void setButton(String text, Vec2 position, Vec2 box, JFrame f) {
        this.position = position;
        this.box = box;
        this.text = text;
        this.setLocation(this.position.x, this.position.y);
        this.setSize(box.x, box.y);
        this.setEnabled(true);
        f.add(this);

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

