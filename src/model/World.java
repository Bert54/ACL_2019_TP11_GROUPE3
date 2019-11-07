package model;

import engine.Cmd;
import engine.Game;
import engine.GameController;

import game.EntityBuilder;
import game.Vec2; 
import game.GameEntity;
import game.CollisionResolver;

import java.util.List;
import java.util.ArrayList;

public class World implements Game {
    public World(WorldPainter painter, WorldController controller) {
        renderWindow = painter;
        this.controller = controller; 
        
        entities = new ArrayList<GameEntity>();
        builder = new EntityBuilder(controller);
        collisionResolver = new CollisionResolver();
        entities.add(builder.buildHero());
        entities.add(builder.buildMonster());
    }

    @Override
    public void evolve() {
        for(GameEntity e : entities) {
            e.update();
        }

        collisionResolver.resolve(entities);

        for(GameEntity e : entities) {
            e.applyMovement();
            renderWindow.submit(e);
        }
        
        
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    private WorldPainter renderWindow;
    private WorldController controller;
    private EntityBuilder builder;
    private CollisionResolver collisionResolver;
    private List<GameEntity> entities;
}
