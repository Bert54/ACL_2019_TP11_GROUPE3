package model;

import engine.Game;

import engine.Texture;
import game.*;


public class World implements Game {
    public World(WorldPainter painter, WorldController controller) {
        renderWindow = painter;
        this.controller = controller;

        this.maze = new Maze(controller, renderWindow.getWidth(), renderWindow.getHeight());
        collisionResolver = new CollisionResolver();
    }

    @Override
    public boolean isStart() {
        return false;
    }

    @Override
    public void evolve() {

        if (!controller.isStart()) {
            Texture texture = TextureFactory.get("maze.bmp");
            Background background = new Background(texture, new Vec2(renderWindow.getWidth(), renderWindow.getHeight()));
            renderWindow.submit(background);

            int Wsquare = 210;
            int Hsquare = 45;
            Button jouer = new Button("Jouer", new Vec2((renderWindow.getWidth()/2)-(Wsquare/2), renderWindow.getHeight()-(Hsquare*3)), new Vec2(Wsquare, Hsquare));
            renderWindow.submit(jouer);

            Button instruction = new Button("Instructions", new Vec2((renderWindow.getWidth()/2)-(Wsquare/2), renderWindow.getHeight()-(Hsquare + Hsquare/2)), new Vec2(Wsquare, Hsquare));
            renderWindow.submit(instruction);
        }else {

            for (Tile t : maze.getTiles()) {
                renderWindow.submit(t);
            }

            for (GameEntity e : maze.getEntities()) {
                e.update();
            }

            collisionResolver.resolve(maze.getEntities(), maze.getTiles());

            for (GameEntity e : maze.getEntities()) {
                e.applyMovement(collisionResolver);
                renderWindow.submit(e);
            }
        }
    }

    @Override
    public boolean isFinished() {

        boolean res = false;
        Texture texture;

        for (GameEntity e : maze.getEntities()) {
            if (e.isWin()){
                texture = TextureFactory.get("goodjob.bmp");
                Background background = new Background(texture, new Vec2(renderWindow.getWidth(), renderWindow.getHeight()));
                renderWindow.submit(background);
                res = true;
            }else if(e.isLose()){
                texture = TextureFactory.get("gameover.bmp");
                Background background = new Background(texture, new Vec2(renderWindow.getWidth(), renderWindow.getHeight()));
                renderWindow.submit(background);
                res = true;
            }
        }
        return res;
    }

    private WorldPainter renderWindow;
    private WorldController controller;
    private CollisionResolver collisionResolver;
    private Maze maze;
}
