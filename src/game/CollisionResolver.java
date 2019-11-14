package game;

import java.util.List;

public class CollisionResolver {
    public CollisionResolver() {
    }

    public void resolve (List <GameEntity> entities, List <Tile> tiles) {

        for (int i = 0; i < entities.size(); ++i) {
            for (int j = i + 1; j < entities.size(); ++j) {
                Vec2 pos1 = entities.get(i).getNextPosition();
                Vec2 pos2 = entities.get(j).getNextPosition();

                Vec2 box1 = entities.get(i).getBox();
                Vec2 box2 = entities.get(j).getBox();

                if ((pos1.x + box1.x > pos2.x &&
                        pos1.x < pos2.x + box2.x &&
                        pos1.y + box1.y > pos2.y &&
                        pos1.y < pos2.y + box2.y)
                    ) {
                    collision(entities.get(i), entities.get(j));
                }
            }

            for(int j = 0; j < tiles.size(); ++j) {
                Vec2 pos1 = entities.get(i).getNextPosition();
                Vec2 pos2 = tiles.get(j).getPosition();

                Vec2 box1 = entities.get(i).getBox();
                Vec2 box2 = tiles.get(j).getBox();

                if ((pos1.x + box1.x > pos2.x &&
                        pos1.x < pos2.x + box2.x &&
                        pos1.y + box1.y > pos2.y &&
                        pos1.y < pos2.y + box2.y)
                    ) {
                    collision(entities.get(i), tiles.get(j));
                }
                else {
                    if (entities.get(i).onSpecialTile) {
                        noCollision(entities.get(i), tiles.get(j));
                    }
                }
            }
        }
    }

    private void collision(GameEntity e1, GameEntity e2){
        e1.onHit();
        e2.onHit();
    }

    private void collision(GameEntity e1, Tile t){
        if (e1.onSpecialTile) {
            t.onTile(e1);
        }
        else {

            t.onEnter(e1);
        }
    }

    private void noCollision(GameEntity e, Tile t) {
        t.onExit(e);
    }
}
