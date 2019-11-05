package model;

import engine.Cmd;
import engine.Game;
import engine.GameController;

import game.Hero;
import game.HeroController;
import game.Vec2; 

public class World implements Game {
    public World(WorldPainter painter, GameController controller) {
        renderWindow = painter;

        hero = new Hero(new Vec2(0, 0), new Vec2(0, 0));
        hero.setController(new HeroController(hero, controller));
    }

    @Override
    public void evolve(Cmd userCmd) {
        hero.update();
        renderWindow.submit(hero);
        System.out.println("Execute "+userCmd);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
    private WorldPainter renderWindow;
    private Hero hero;
}
