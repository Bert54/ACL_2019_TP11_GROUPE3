package game;

import engine.Cmd;

import model.WorldController;
import java.util.List;
public class HeroController implements EntityController {
    public HeroController(Hero hero, WorldController controller) {
        this.hero = hero;
        this.controller = controller;
        this.stopLeft = false;
        this.stopRight = false;
        this.stopTop = false;
        this.stopBottom = false;
    }

    public void onUpdate() {
        List<Cmd> commands = controller.getCommands();
        for(Cmd command : commands) {
            switch(command) {
                case RIGHT:
                    if (this.stopRight == false) {
                        hero.move(new Vec2(5, 0));
                    }
                break;
                case UP:
                    if (this.stopTop == false) {
                        hero.move(new Vec2(0, -5));
                    }
                    this.stopTop = false;
                break;
                case LEFT:
                    if (this.stopLeft == false) {
                        hero.move(new Vec2(-5, 0));
                    }
                    this.stopLeft = false;
                break;
                case DOWN:
                    if (this.stopBottom == false) {
                        hero.move(new Vec2(0, 5));
                    }
                    this.stopBottom = false;
                break;
            }
        }
    }

    public void setStopLeft(boolean stopLeft) {
        this.stopLeft = stopLeft;
    }

    public void setStopRight(boolean stopRight) {
        this.stopRight = stopRight;
    }

    public void setStopTop(boolean stopTop) {
        this.stopTop = stopTop;
    }

    public void setStopBottom(boolean stopBottom) {
        this.stopBottom = stopBottom;
    }

    private boolean stopLeft;
    private boolean stopRight;
    private boolean stopTop;
    private boolean stopBottom;
    private Hero hero;
    private WorldController controller;
}
