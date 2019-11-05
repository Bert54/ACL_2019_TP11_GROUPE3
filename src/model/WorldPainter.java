package model;

import engine.GamePainter;

import game.Drawable;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class WorldPainter implements GamePainter {

    /**
     * la taille des cases
     */
    protected static final int WIDTH = 500;
    protected static final int HEIGHT = 500;

    public WorldPainter() {
        drawables = new ArrayList<Drawable>();
    }

    public void submit(Drawable drawable) {
        drawables.add(drawable);
    }

    @Override
    public void draw(BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();
        crayon.setColor(Color.lightGray);

        // dessiner les bords du labyrinthe
        crayon.fillRect(0,0,WIDTH/50,HEIGHT);
        crayon.fillRect(0,0,WIDTH,HEIGHT/50);
        crayon.fillRect(WIDTH-WIDTH/50,0,WIDTH/50,HEIGHT);
        crayon.fillRect(0,HEIGHT-HEIGHT/50,WIDTH,HEIGHT/50);

        // dessiner les obstacles
        crayon.fillRect(100,100,50,50);
        crayon.fillRect(200,200,50,50);
        crayon.fillRect(350,350,25,25);
        crayon.fillRect(450,350,25,25);
        crayon.fillRect(350,450,25,25);

        for(Drawable drawable : drawables) {
            drawable.draw(image);
        }
        drawables.clear();
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }
    private List<Drawable> drawables;
}
