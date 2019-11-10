package model;

import engine.Cmd;
import engine.Game;
import engine.GameController;

import game.*;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class World implements Game {
    public World(WorldPainter painter, WorldController controller) {
        renderWindow = painter;
        this.controller = controller;

        this.labyrintheBuilder = new LabyrintheBuilder(controller);
        collisionResolver = new CollisionResolver();
    }

    @Override
    public void evolve() {

        Iterator<GameEntity> iterator = labyrintheBuilder.getEntities().iterator();
        while ( iterator.hasNext() ) {
            GameEntity gameEntity = iterator.next();
            if (!gameEntity.isHero() && gameEntity.getPv() <= 0) {
                // On supprime l'élément courant de la liste d'entites
                iterator.remove();
            }
        }

        for(Tile t : labyrintheBuilder.getTiles()) {
            renderWindow.submit(t);
        }

        for(GameEntity e : labyrintheBuilder.getEntities()) {

            e.update();
        }

        collisionResolver.resolve(labyrintheBuilder.getEntities(), labyrintheBuilder.getTiles());

        for(GameEntity e : labyrintheBuilder.getEntities()) {
            e.applyMovement(collisionResolver);
            renderWindow.submit(e);
        }

    }

    @Override
    public boolean isFinished() {

        boolean res = false;
        for(GameEntity e : labyrintheBuilder.getEntities()) {

            if (e.isHero() && e.getPv() <= 0) {
                res = true;
            }
        }

        return res;
    }

    private WorldPainter renderWindow;
    private WorldController controller;
    private CollisionResolver collisionResolver;
    private LabyrintheBuilder labyrintheBuilder;
}
