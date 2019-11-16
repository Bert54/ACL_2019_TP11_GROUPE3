package controllers;

import engine.GameController;
import model.WorldController;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RetourMouseController implements MouseListener {

    private GameController worldController;
    /*private JPanel startGameButton;
    private JPanel instructionGameButton;
    private JPanel closeGameButton;*/

    public RetourMouseController(GameController gc/*, JPanel sgb, JPanel igb, JPanel cgb*/) {

        this.worldController = gc;
        /*this.startGameButton = sgb;
        this.instructionGameButton = igb;
        this.closeGameButton = cgb;*/
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (((WorldController)worldController).isInstruction()) {
            ((WorldController)worldController).setInstruction(false);
            /*this.startGameButton.setEnabled(true);
            this.instructionGameButton.setEnabled(true);
            this.closeGameButton.setEnabled(true);*/
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
