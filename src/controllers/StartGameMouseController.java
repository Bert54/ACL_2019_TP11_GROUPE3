package controllers;

import engine.GameController;
import model.WorldController;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StartGameMouseController implements MouseListener {

    private GameController worldController;
    private JPanel startGameButton;
    private JPanel instructionGameButton;
    private JPanel closeGameButton;
    private JPanel retourGameButton;

    public StartGameMouseController(GameController gc, JPanel sgb, JPanel igb, JPanel cgb, JPanel rgb) {

        this.worldController = gc;
        this.startGameButton = sgb;
        this.instructionGameButton = igb;
        this.closeGameButton = cgb;
        this.retourGameButton = rgb;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!((WorldController)worldController).isStart() && !((WorldController)worldController).isInstruction()) {
            ((WorldController)worldController).setStart(true);
            this.startGameButton.setEnabled(false);
            this.instructionGameButton.setEnabled(false);
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
