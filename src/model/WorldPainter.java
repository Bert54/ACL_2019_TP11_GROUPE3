package model;

import engine.GamePainter;

import game.Drawable;
import game.Camera;

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

    public WorldPainter(Camera camera) {
        this.camera = camera;
        camera.scissor.x = 200;
        camera.scissor.y = 200;
        drawables = new ArrayList<Drawable>();
    }

    public void submit(Drawable drawable) {
        drawables.add(drawable);
    }

    @Override
    public void draw(BufferedImage image) {
        if(camera.position.x  < 0) {
            camera.position.x = 0;
        }
        else if(camera.position.x + camera.scissor.x > WIDTH) {
            camera.position.x = WIDTH - camera.scissor.x;
        }
        if(camera.position.y < 0) {
            camera.position.y = 0;
        }
        else if(camera.position.y + camera.scissor.y > HEIGHT) {
            camera.position.y = HEIGHT - camera.scissor.y;
        }

        for(Drawable drawable : drawables) {
            drawable.draw(image, camera);
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

    public Camera getCamera() {
        return camera;
    }

    private List<Drawable> drawables;
    private Camera camera;
}
