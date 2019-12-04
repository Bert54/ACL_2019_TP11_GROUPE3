package game.entities;

import engine.Cmd;

import game.level.Vec2;
import model.WorldController;
import java.util.List;

public class HeroController implements EntityController {
    public HeroController(Hero hero, WorldController controller) {
        this.hero = hero;
        this.controller = controller;
    }

    public void onUpdate() {
        List<Cmd> commands = controller.getCommands();
        for (int i = 0 ; i < commands.size() ; i++) {
            Cmd command =  commands.get(i);
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
            controller.clearCommands();
        }
    }

    private Hero hero;
    private WorldController controller;
}
