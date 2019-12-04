package game.tiles;

import game.level.Vec2;

public class TileBuilder {

    public Obstacle buildObstacle(Vec2 pos, Vec2 box) {
        return new Obstacle(pos, box);
    }

    public Coin buildCoin(Vec2 pos, Vec2 box) {
        return new Coin(pos, box);
    }

    public TeleportTile buildTeleportTile(Vec2 position, Vec2 box, Vec2 exit) {
        return new TeleportTile(position, box, exit);
    }

    public LavaTile buildLavaTile(Vec2 location, Vec2 area) {
        return new LavaTile(location, area);
    }

    public SwiftTile buildSpeedTile(Vec2 location, Vec2 area) {
        return new SwiftTile(location, area);
    }

    public GlueTile buildGlueTile(Vec2 location, Vec2 area) {
        return new GlueTile(location, area);
    }

    public InvincibilityTile buildInvTile(Vec2 location, Vec2 area) {
        return new InvincibilityTile(location, area);
    }

    public RegularTile buildRegularTile(Vec2 location, Vec2 area) {
        return new RegularTile(location, area);
    }

}
