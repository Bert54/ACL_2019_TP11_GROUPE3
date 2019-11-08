package model;

import engine.Cmd;
import engine.Game;
import engine.GameController;

import game.*;

import java.util.List;
import java.util.ArrayList;

public class World implements Game {
    public World(WorldPainter painter, WorldController controller) {
        renderWindow = painter;
        this.controller = controller; 
        
        entities = new ArrayList<GameEntity>();
        tiles = new ArrayList<Tile>();
        builder = new EntityBuilder(controller);
        tileBuilder = new TileBuilder();
        collisionResolver = new CollisionResolver();
        entities.add(builder.buildHero());
        entities.add(builder.buildMonster());
        tiles.add(tileBuilder.buildEdgeLeft());
        tiles.add(tileBuilder.buildEdgeRight());
        tiles.add(tileBuilder.buildEdgeTop());
        tiles.add(tileBuilder.buildEdgeBottom());
        for(int i = 0; i < 5; i++){

            tiles.add(tileBuilder.buildObstacles().get(i));
        }
    }

    @Override
    public void evolve() {
        for(Tile t : tiles) {
            renderWindow.submit(t);
        }

        for(GameEntity e : entities) {
            e.update();
        }

        collisionResolver.resolve(entities, tiles);

        for(GameEntity e : entities) {
            e.applyMovement();
            renderWindow.submit(e);
        }

    }

    @Override
    public boolean isFinished() {
        return false;
    }

    private TileBuilder tileBuilder;
    private List<Tile> tiles;
    private WorldPainter renderWindow;
    private WorldController controller;
    private EntityBuilder builder;
    private CollisionResolver collisionResolver;
    private List<GameEntity> entities;
}
