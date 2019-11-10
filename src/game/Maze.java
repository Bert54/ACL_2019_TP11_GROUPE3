package game;

import model.WorldController;

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
        entities.add(builder.buildHero(new Vec2(300, 300)));
        entities.add(builder.buildMonster());

        tiles.add(tileBuilder.buildObstacle(new Vec2(0, 0), new Vec2(width, 10)));
        tiles.add(tileBuilder.buildObstacle(new Vec2(0, 0), new Vec2(10, height)));
        tiles.add(tileBuilder.buildObstacle(new Vec2(width - 10, 0), new Vec2(10, height)));
        tiles.add(tileBuilder.buildObstacle(new Vec2(0, height - 10), new Vec2(width, 10)));
        tiles.add(tileBuilder.buildCoin(new Vec2(10, 10)));

        tiles.add(tileBuilder.buildObstacle(new Vec2(400, 400), new Vec2(50, 50)));

    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public List<GameEntity> getEntities() {
        return entities;
    }
}
