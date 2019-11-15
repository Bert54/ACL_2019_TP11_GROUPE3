package controllers;

import engine.GameController;
import model.WorldController;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StartGameMouseController implements MouseListener {

    private GameController worldController;
    private JPanel startGameButton;
    private JPanel closeGameButton;

    public StartGameMouseController(GameController gc, JPanel sgb, JPanel cgb) {

        this.worldController = gc;
        this.startGameButton = sgb;
        this.closeGameButton = cgb;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!((WorldController)worldController).isStart()) {
            ((WorldController)worldController).setStart(true);
            this.startGameButton.setEnabled(false);
            this.closeGameButton.setEnabled(false);
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
