package game;

import engine.Cmd;
import engine.GameController;

public class HeroController implements EntityController {
    public HeroController(Hero hero, GameController controller) {
        this.hero = hero;
        this.controller = controller;
    }

    public void onUpdate() {
        Cmd command = controller.getCommand();
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

    private Hero hero;
    private GameController controller;
}
