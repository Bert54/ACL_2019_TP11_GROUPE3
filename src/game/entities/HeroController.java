package game.entities;

import engine.Cmd;

import game.level.Vec2;
import game.level.Maze;
import model.WorldController;
import java.util.List;

public class HeroController implements EntityController {
    public HeroController(Maze maze, Hero hero, WorldController controller) {
        this.maze = maze;
        this.hero = hero;
        this.controller = controller;
    }

    public void onUpdate() {
        List<Cmd> commands = controller.getCommands();
        for (int i = 0 ; i < commands.size() ; i++) {
            Cmd command =  commands.get(i);
            switch(command) {
                case RIGHT:
                    hero.move(new Vec2(1, 0));
                    break;
                case UP:
                    hero.move(new Vec2(0, -1));
                    break;
                case LEFT:
                    hero.move(new Vec2(-1, 0));
                    break;
                case DOWN:
                    hero.move(new Vec2(0, 1));
                    break;
                case SHOOT:
                    maze.spawnProjectile(hero);
                    break;
            }
        }
        controller.clearCommands();
    }

    private Hero hero;
    private WorldController controller;
    private Maze maze;
}
