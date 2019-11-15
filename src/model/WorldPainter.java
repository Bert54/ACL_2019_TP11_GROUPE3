package model;

import engine.GamePainter;

import game.Drawable;

import javax.swing.*;
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

    @Override
    public void setFrame(JFrame f) {

    }

    private List<Drawable> drawables;
}
