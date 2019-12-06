package controllers;

import engine.GameController;
import model.WorldController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PauseMouseController implements MouseListener {

    private GameController worldController;

    public PauseMouseController(GameController gc) {

        this.worldController = gc;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!((WorldController)worldController).isPause()) {
            ((WorldController)worldController).setPause(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
