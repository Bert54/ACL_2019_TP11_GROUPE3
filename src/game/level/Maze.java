package game.level;

import exceptions.NoHeroException;
import game.entities.EntityBuilder;
import game.entities.GameEntity;
import game.entities.Projectile;
import game.tiles.Tile;
import game.tiles.TileBuilder;
import model.WorldController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Maze {

    private TileBuilder tileBuilder;
    private List<Tile> tiles;
    private EntityBuilder builder;
    private List<GameEntity> entities;
    private List<GameEntity> pending;

    public Maze(WorldController controller, Camera camera, int windowWidth, int windowHeight) {
        if (controller == null | camera == null) {
            throw new RuntimeException();
        }
        else {
            this.controller = controller;
            entities = new ArrayList<GameEntity>();
            pending = new ArrayList<GameEntity>();
            tiles = new ArrayList<Tile>();
            tileBuilder = new TileBuilder();
            //ugly
            builder = new EntityBuilder(this, controller);

            String chemin = "res/Maze.txt";
            File file = new File(chemin);

            int teleportDestX = -1;
            int teleportDestY = -1;

            if (file.exists() && file.isFile()) {

                try {

                    FileReader fileReader = new FileReader(chemin);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    String line;
                    int x = 0;
                    int y = 0;

                    //tiles.add(tileBuilder.buildObstacle(new Vec2(0, 0), new Vec2(windowWidth, 10)));
                    //tiles.add(tileBuilder.buildObstacle(new Vec2(0, 0), new Vec2(10, windowHeight)));
                    //tiles.add(tileBuilder.buildObstacle(new Vec2(windowHeight-10, 0), new Vec2(10, windowHeight)));
                    //tiles.add(tileBuilder.buildObstacle(new Vec2(0, windowWidth-10), new Vec2(windowWidth, 10)));

                    while ((line = bufferedReader.readLine()) != null) {

                        x = 0;

                        for (int i = 0; i < line.length(); i++) {

                            switch (line.charAt(i)) {
                                case 'D':
                                    tiles.add(tileBuilder.buildRegularTile(new Vec2(x, y), new Vec2(50, 50)));
                                    teleportDestX = x;
                                    teleportDestY = y;
                                    break;
                            }

                            x += 50;

                        }

                        y += 50;



                    /*String[] decompose = line.split(" ");

                    String[] coordinates = decompose[1].split(",");
                    int x = Integer.parseInt(coordinates[0]);
                    int y = Integer.parseInt(coordinates[1]);

                    String[] dimension = decompose[2].split(",");
                    int w = Integer.parseInt(dimension[0]);
                    int h = Integer.parseInt(dimension[1]);

                    switch (decompose[0]){
                        case "Hero":

                            entities.add(builder.buildHero(camera, new Vec2(x, y), new Vec2(w,h)));
                            break;
                        case "Monster":

                            entities.add(builder.buildMonster(new Vec2(x,y), new Vec2(w,h)));
                            break;
                        case "Coin":

                            tiles.add(tileBuilder.buildCoin(new Vec2(x,y), new Vec2(w,h)));
                            break;
                        case "TeleportTile":

                            String[] exitCoordinate = decompose[3].split(",");
                            int exitX = Integer.parseInt(exitCoordinate[0]);
                            int exitY = Integer.parseInt(exitCoordinate[1]);

                            tiles.add(tileBuilder.buildTeleportTile(new Vec2(x,y), new Vec2(w,h), new Vec2(exitX, exitY)));
                            break;
                        case "LavaTile":

                            tiles.add(tileBuilder.buildLavaTile(new Vec2(x, y), new Vec2(w, h)));
                            break;
                        case "SwiftTile":

                            tiles.add(tileBuilder.buildSpeedTile(new Vec2(x, y), new Vec2(w, h)));
                            break;
                        case "GlueTile":

                            tiles.add(tileBuilder.buildGlueTile(new Vec2(x, y), new Vec2(w, h)));
                            break;
                        case "InvincibilityTile":

                            tiles.add(tileBuilder.buildInvTile(new Vec2(x, y), new Vec2(w, h)));
                            break;
                        case "Obstacle":

                            tiles.add(tileBuilder.buildObstacle(new Vec2(x,y), new Vec2(w, h)));
                            break;
                        case "TopWall":

                            tiles.add(tileBuilder.buildObstacle(new Vec2(x, y), new Vec2(windowWidth, h)));
                            break;
                        case "LeftWall":

                            tiles.add(tileBuilder.buildObstacle(new Vec2(x, y), new Vec2(w, windowHeight)));
                            break;
                        case "RightWall":

                            tiles.add(tileBuilder.buildObstacle(new Vec2(windowWidth - x, y), new Vec2(w, windowHeight)));
                            break;
                        case "BottomWall":

                            tiles.add(tileBuilder.buildObstacle(new Vec2(x, windowHeight - y), new Vec2(windowWidth, h)));
                            break;
                    }*/
                    }


                } catch (FileNotFoundException e) {

                    e.printStackTrace();
                } catch (IOException e) {

                    e.printStackTrace();
                }

                try {
                    FileReader fileReader = new FileReader(chemin);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    String line;
                    int x = 0;
                    int y = 0;
                    boolean hasHero = false;

                    while ((line = bufferedReader.readLine()) != null) {

                        x = 0;

                        for (int i = 0; i < line.length(); i++) {
                            switch (line.charAt(i)) {
                                case '*':
                                    tiles.add(tileBuilder.buildObstacle(new Vec2(x, y), new Vec2(50, 50)));
                                    break;
                                case 'H':
                                    if (!hasHero) {
                                        tiles.add(tileBuilder.buildRegularTile(new Vec2(x, y), new Vec2(50, 50)));
                                        entities.add(builder.buildHero(camera, new Vec2(x, y), new Vec2(20, 20)));
                                        hasHero = true;
                                    }
                                    break;
                                case 'C':
                                    tiles.add(tileBuilder.buildRegularTile(new Vec2(x, y), new Vec2(50, 50)));
                                    tiles.add(tileBuilder.buildCoin(new Vec2(x, y), new Vec2(50, 50)));
                                    break;
                                case 'L':
                                    tiles.add(tileBuilder.buildLavaTile(new Vec2(x, y), new Vec2(50, 50)));
                                    break;
                                case 'G':
                                    tiles.add(tileBuilder.buildRegularTile(new Vec2(x, y), new Vec2(50, 50)));
                                    tiles.add(tileBuilder.buildGlueTile(new Vec2(x, y), new Vec2(50, 50)));
                                    break;
                                case 'T':
                                    tiles.add(tileBuilder.buildRegularTile(new Vec2(x, y), new Vec2(50, 50)));
                                    tiles.add(tileBuilder.buildTeleportTile(new Vec2(x, y), new Vec2(50, 50), new Vec2(teleportDestX, teleportDestY)));
                                    break;
                                case 'S':
                                    tiles.add(tileBuilder.buildSpeedTile(new Vec2(x, y), new Vec2(50, 50)));
                                    break;
                                case 'I':
                                    tiles.add(tileBuilder.buildInvTile(new Vec2(x, y), new Vec2(50, 50)));
                                    break;
                                case '+':
                                    tiles.add(tileBuilder.buildRegularTile(new Vec2(x, y), new Vec2(50, 50)));
                                    entities.add(builder.buildMonster(new Vec2(x, y), new Vec2(30, 30)));
                                    break;
                                case '-':
                                    tiles.add(tileBuilder.buildRegularTile(new Vec2(x, y), new Vec2(50, 50)));
                                    break;
                                default:

                            }

                            x += 50;

                        }

                        y += 50;

                    }

                    if (!hasHero) {
                        throw new NoHeroException();
                    }

                } catch (FileNotFoundException e) {

                    e.printStackTrace();
                } catch (IOException e) {

                    e.printStackTrace();
                } catch (NoHeroException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void cleanup() {
        Iterator<GameEntity> it = entities.iterator();
        while(it.hasNext()) {
            GameEntity e = it.next();
            if(e.isDisposable()) {
                it.remove();
            }
        }
        for(GameEntity e : pending) {
            entities.add(e);
        }
        pending.clear();
    }

    public  void spawnProjectile(GameEntity entity) {
        Vec2 direction = new Vec2(entity.getNextPosition());
        direction.x -= entity.getPosition().x + 1;
        direction.y -= entity.getPosition().y + 1;
        /*direction.x = entity.getPosition().x - controller.getDirection().x;
        direction.y = entity.getPosition().y - controller.getDirection().y;
        //direction.normalize();
        */
        Vec2 position = new Vec2(entity.getPosition());
        position.x += 5;
        position.y += 5;
        pending.add(new Projectile(entity, position, entity.getBox(), direction));
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public List<GameEntity> getEntities() {
        return entities;
    }

    private WorldController controller;
}
