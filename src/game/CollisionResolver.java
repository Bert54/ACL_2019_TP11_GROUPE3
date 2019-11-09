package game;

import java.util.List;

public class CollisionResolver {
    public void resolve(List<GameEntity> entities) {
    public CollisionResolver() {}

    public void resolve(List<GameEntity> entities, List<Tile> tiles) {
        for(int i = 0; i < entities.size(); ++i) {
            //bounds
            /*Vec2 pos = entities.get(i).getPosition();
            if(pos.x < 0 || pos.y < 0|| pos.x > width || pos.y > height) {

            }*/

            for(int j = i + 1; j < entities.size(); ++j) {
                Vec2 pos1 = entities.get(i).getNextPosition();
                Vec2 pos2 = entities.get(j).getNextPosition();

                Vec2 box1 = entities.get(i).getBox();
                Vec2 box2 = entities.get(j).getBox();

                if(pos1.x + box1.x > pos2.x &&
                pos1.x < pos2.x + box2.x &&
                pos1.y + box1.y > pos2.y &&
                pos1.y < pos2.y + box2.y
                ) {
                    collision(entities.get(i), entities.get(j));
                }
            }

            /*if(entities.get(i).isHero() == true) {

                for (int j = 0; j < tiles.size(); j++) {
                    Vec2 pos1 = entities.get(i).getPosition();
                    Vec2 pos2 = tiles.get(j).getPosition();

                    Vec2 box1 = entities.get(i).getBox();
                    Vec2 box2 = tiles.get(j).getBox();

                    if (pos1.x + box1.x >= pos2.x &&
                            pos1.x <= pos2.x + box2.x &&
                            pos1.y + box1.y >= pos2.y &&
                            pos1.y <= pos2.y + box2.y) {

                        entities.get(i).controller.setStopRight(true);
                    }else{
                        entities.get(i).controller.setStopRight(false);
                    }
                }
            }*/
        }
    }

    private void collision(GameEntity e1, GameEntity e2) {
        e1.cancelMovement();
        e2.cancelMovement();
    }
}