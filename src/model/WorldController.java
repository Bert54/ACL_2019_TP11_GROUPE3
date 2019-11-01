package model;

import engine.Cmd;
import engine.GameController;

import java.awt.event.KeyEvent;

public class WorldController implements GameController {

    /**
     * commande en cours
     */
    private Cmd commandeEnCours;

    public WorldController() {

        this.commandeEnCours = Cmd.IDLE;
    }

    @Override
    public Cmd getCommand() {

        return this.commandeEnCours;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyChar()) {

            case 'r':
            case 'R':
                this.commandeEnCours = Cmd.RIGHT;
                break;
            case 'l':
            case 'L':
                this.commandeEnCours = Cmd.LEFT;
                break;
            case 'u':
            case 'U':
                this.commandeEnCours = Cmd.UP;
                break;
            case 'd':
            case 'D':
                this.commandeEnCours = Cmd.DOWN;
                break;
            case 'q':
            case 'Q':
                System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        this.commandeEnCours = Cmd.IDLE;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
