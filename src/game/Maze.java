package game;

import model.WorldController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Maze {

    private TileBuilder tileBuilder;
    private List<Tile> tiles;
    private EntityBuilder builder;
    private List<GameEntity> entities;

    public Maze(WorldController controller, int width, int height) {
        entities = new ArrayList<GameEntity>();
        tiles = new ArrayList<Tile>();
        builder = new EntityBuilder(controller);
        tileBuilder = new TileBuilder();

        String chemin = "res/Maze.txt";
        File file = new File(chemin);

        if (file.exists() && file.isFile()){

            try {

                FileReader fileReader = new FileReader(chemin);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line;

                while((line = bufferedReader.readLine()) != null){

                    String[] decompose = line.split(" ");

                    String[] coordinates = decompose[1].split(",");
                    int x = Integer.parseInt(coordinates[0]);
                    int y = Integer.parseInt(coordinates[1]);

                    String[] dimension = decompose[2].split(",");
                    int w = Integer.parseInt(dimension[0]);
                    int h = Integer.parseInt(dimension[1]);

                    switch (decompose[0]){
                        case "Hero":

                            entities.add(builder.buildHero(new Vec2(x, y), new Vec2(w,h)));
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
                        case "Obstacle":

                            tiles.add(tileBuilder.buildObstacle(new Vec2(x,y), new Vec2(w, h)));
                            break;
                        case "TopWall":

                            tiles.add(tileBuilder.buildObstacle(new Vec2(x, y), new Vec2(width, h)));
                            break;
                        case "LeftWall":

                            tiles.add(tileBuilder.buildObstacle(new Vec2(x, y), new Vec2(w, height)));
                            break;
                        case "RightWall":

                            tiles.add(tileBuilder.buildObstacle(new Vec2(width - x, y), new Vec2(w, height)));
                            break;
                        case "BottomWall":

                            tiles.add(tileBuilder.buildObstacle(new Vec2(x, height - y), new Vec2(width, h)));
                            break;
                    }
                }

            }catch (FileNotFoundException e){

                e.printStackTrace();
            }catch (IOException e){

                e.printStackTrace();
            }
        }
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public List<GameEntity> getEntities() {
        return entities;
    }
}
