package game;

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

    LavaTile buildLavaTile(Vec2 location, Vec2 area) {
        return new LavaTile(location, area);
    }

    SwiftTile buildSpeedTile(Vec2 location, Vec2 area) {
        return new SwiftTile(location, area);
    }

    GlueTile buildGlueTile(Vec2 location, Vec2 area) {
        return new GlueTile(location, area);
    }

    InvincibilityTile buildInvTile(Vec2 location, Vec2 area) {
        return new InvincibilityTile(location, area);
    }

}
