package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class Button extends JButton implements Drawable, MouseListener {

    private Vec2 position;
    private Vec2 box;
    private String text;

    public Button(String text, Vec2 position, Vec2 box) {
        this.position = position;
        this.box = box;
        this.text = text;
        this.addMouseListener(this);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("a");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("b");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("c");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("d");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("e");
    }
}

