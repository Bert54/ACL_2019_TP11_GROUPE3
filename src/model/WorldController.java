package model;

import engine.Cmd;
import engine.GameController;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.awt.event.KeyEvent;

import java.util.List;
import java.util.ArrayList;

public class WorldController implements GameController {
    public WorldController() {
        commandBuffer = new ArrayList<>();
    }

    @Override
    public List<Cmd> getCommands() {
        return commandBuffer;
    }

    public void clearCommands() {
        commandBuffer.clear();
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'd':
            case 'D':
                commandBuffer.add(Cmd.RIGHT);
                break;
            case 'a':
            case 'A':
                commandBuffer.add(Cmd.LEFT);
                break;
            case 'w':
            case 'W':
                commandBuffer.add(Cmd.UP);
                break;
            case 's':
            case 'S':
                commandBuffer.add(Cmd.DOWN);
                break;
            case KeyEvent.VK_ENTER:
                start = true;
                break;
            case 'q':
            case 'Q':
                System.exit(0);
        }
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean status) {

        this.start = status;

    }

    private List<Cmd> commandBuffer;
    private boolean start;
}
