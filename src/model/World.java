package model;

import controllers.ExitAppMouseController;
import controllers.InstructionMouseController;
import controllers.RetourMouseController;
import controllers.StartGameMouseController;
import engine.Game;

import engine.Texture;
import game.level.*;
import game.entities.GameEntity;
import game.level.Button;
import game.tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class World implements Game {
    public World(WorldPainter painter, WorldController controller, JFrame f) {
        renderWindow = painter;
        this.controller = controller;

        this.maze = new Maze(controller, renderWindow.getCamera(), renderWindow.getWidth() + 200, renderWindow.getHeight() + 200);
        collisionResolver = new CollisionResolver();

        this.frame = f;
    }

    @Override
    public boolean isStart() {
        return false;
    }

    @Override
    public void evolve() {

        int Wsquare = 210;
        int Hsquare = 45;

        Button jouer = new Button();
        Button instruction = new Button();
        Button quitter = new Button();
        Button retour = new Button();

        if (!controller.isStart() && !controller.isInstruction()) {

            Texture texture = TextureFactory.get("maze.bmp");
            Background background = new Background(texture, new Vec2(renderWindow.getWidth(), renderWindow.getHeight()));
            renderWindow.submit(background);

            jouer.setButton("Jouer", new Vec2((renderWindow.getWidth() / 2) - (Wsquare / 2), renderWindow.getHeight() - (Hsquare * 4)), new Vec2(Wsquare, Hsquare), this.frame);
            instruction.setButton("Instructions", new Vec2((renderWindow.getWidth() / 2) - (Wsquare / 2), renderWindow.getHeight() - (Hsquare * 3)), new Vec2(Wsquare, Hsquare), this.frame);
            quitter.setButton("Quitter", new Vec2((renderWindow.getWidth() / 2) - (Wsquare / 2), renderWindow.getHeight() - (Hsquare * 2)), new Vec2(Wsquare, Hsquare), this.frame);

            StartGameMouseController startGameMouseController = new StartGameMouseController(this.controller, jouer, instruction, quitter, retour);
            InstructionMouseController instructionMouseController = new InstructionMouseController(this.controller, jouer, instruction, quitter, retour);
            ExitAppMouseController exitAppMouseController = new ExitAppMouseController(this.controller);

            jouer.addMouseListener(startGameMouseController);
            instruction.addMouseListener(instructionMouseController);
            quitter.addMouseListener(exitAppMouseController);

            renderWindow.submit(jouer);
            renderWindow.submit(instruction);
            renderWindow.submit(quitter);

        }else if (!controller.isStart() && controller.isInstruction()){

            Drawable drawable = new Drawable() {
                @Override
                public void draw(BufferedImage image, Camera c) {
                    Graphics2D crayon = (Graphics2D) image.getGraphics();
                    crayon.setColor(Color.BLACK);
                    crayon.fillRect(0, 0, renderWindow.getWidth(), renderWindow.getHeight());
                    crayon.setColor(Color.WHITE);
                    crayon.setFont(new Font(Font.SERIF, Font.BOLD, 20));
                    ArrayList<String> text = new ArrayList<>();
                    text.add("Deplacement a droite : D ou d");
                    text.add("Deplacement a gauche : A ou a");
                    text.add("Deplacement vers le haut : W ou w");
                    text.add("Deplacement vers le bas : S ou s");
                    text.add("Quitter le jeu : Q ou q");
                    int Xcentre = (int) ((renderWindow.getWidth() - crayon.getFontMetrics().getStringBounds(text.get(0), crayon).getWidth()) / 2);
                    int Ycentre = (int) ((renderWindow.getHeight() - crayon.getFontMetrics().getStringBounds(text.get(0), crayon).getHeight()) / 3);
                    int shift = (int) crayon.getFontMetrics().getStringBounds(text.get(0), crayon).getHeight();
                    for(int i = 0; i < 5; i++){

                        crayon.drawString(text.get(i), Xcentre, Ycentre + shift * i);
                    }
                }
            };

            retour.setButton("Retour", new Vec2((renderWindow.getWidth() / 2) - (Wsquare / 2), renderWindow.getHeight() - Hsquare), new Vec2(Wsquare, Hsquare), this.frame);
            retour.addMouseListener(new RetourMouseController(this.controller));

            renderWindow.submit(drawable);
            renderWindow.submit(retour);

        }else if (controller.isStart()){

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
    private JFrame frame;
}
