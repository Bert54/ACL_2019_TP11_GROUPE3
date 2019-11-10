package game;

import engine.Cmd;

import model.WorldController;
import java.util.List;

public class HeroController implements EntityController {
    public HeroController(Hero hero, WorldController controller) {
        this.hero = hero;
        this.controller = controller;
    }

    public void onUpdate() {
        List<Cmd> commands = controller.getCommands();
        for(Cmd command : commands) {
            switch(command) {
                case RIGHT:
                    hero.move(new Vec2(5, 0));
                    break;
                case UP:
                    hero.move(new Vec2(0, -5));
                    break;
                case LEFT:
                    hero.move(new Vec2(-5, 0));
                    break;
                case DOWN:
                    hero.move(new Vec2(0, 5));
                    break;
            }
        }
    }

    private Hero hero;
    private WorldController controller;
}
