package game;

import model.WorldController;

import java.util.ArrayList;
import java.util.List;

public class LabyrintheBuilder {

    private TileBuilder tileBuilder;
    private List<Tile> tiles;
    private EntityBuilder builder;
    private List<GameEntity> entities;

    public LabyrintheBuilder(WorldController controller) {

        entities = new ArrayList<GameEntity>();
        tiles = new ArrayList<Tile>();
        builder = new EntityBuilder(controller);
        tileBuilder = new TileBuilder();
        entities.add(builder.buildHero());
        entities.add(builder.buildMonster());
        tiles.add(tileBuilder.buildEdgeLeft());
        tiles.add(tileBuilder.buildEdgeRight());
        tiles.add(tileBuilder.buildEdgeTop());
        tiles.add(tileBuilder.buildEdgeBottom());
        tiles.add(tileBuilder.buildGoal());

        for(int i = 0; i < 5; i++){

            tiles.add(tileBuilder.buildObstacles().get(i));
        }
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public List<GameEntity> getEntities() {
        return entities;
    }
}
