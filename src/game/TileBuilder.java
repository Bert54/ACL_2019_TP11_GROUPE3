package game;

import java.util.ArrayList;

public class TileBuilder {
    Obstacle buildObstacle(Vec2 pos, Vec2 box) {
        return new Obstacle(pos, box);
    }

    Coin buildCoin(Vec2 pos, Vec2 box) {
        return new Coin(pos, box);
    }

    TeleportTile buildTeleportTile(Vec2 position, Vec2 box, Vec2 exit) {
        return new TeleportTile(position, box, exit);
    }
}
