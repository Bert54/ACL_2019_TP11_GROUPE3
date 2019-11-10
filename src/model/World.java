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

        this.maze = new Maze(controller, renderWindow.getWidth(), renderWindow.getHeight());
        collisionResolver = new CollisionResolver();
    }

    @Override
    public void evolve() {
        for(Tile t : maze.getTiles()) {
            renderWindow.submit(t);
        }

        for(GameEntity e : maze.getEntities()) {
            e.update();
        }

        collisionResolver.resolve(maze.getEntities(), maze.getTiles());

        for(GameEntity e : maze.getEntities()) {
            e.applyMovement(collisionResolver);
            renderWindow.submit(e);
        }

    }

    @Override
    public boolean isFinished() {
        return false;
    }

    private WorldPainter renderWindow;
    private WorldController controller;
    private CollisionResolver collisionResolver;
    private Maze maze;
}
