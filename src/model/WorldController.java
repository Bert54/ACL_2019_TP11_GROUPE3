package model;

import engine.Cmd;
import engine.GameController;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.util.List;
import java.util.ArrayList;

import game.entities.Hero;
import game.level.Vec2;

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
                Hero.direction = Hero.RIGHT;
                break;
            case 'a':
            case 'A':
                commandBuffer.add(Cmd.LEFT);
                Hero.direction = Hero.LEFT;
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

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        commandBuffer.add(Cmd.SHOOT);
    }

    public Vec2 getDirection() {
        Point p = MouseInfo.getPointerInfo().getLocation();
        return new Vec2(p.x, p.y);
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean status) {

        this.start = status;

    }

    public boolean isInstruction() {
        return instruction;
    }

    public void setInstruction(boolean status) {

        this.instruction = status;

    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    private List<Cmd> commandBuffer;
    private boolean start;
    private boolean instruction;
    private boolean pause;
}
