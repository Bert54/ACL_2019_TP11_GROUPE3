package tests.tiles;

import game.tiles.Wall;
import game.tiles.Tile;
import game.level.Vec2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ObstacleTests {

    @Test
    void OnEnterNullTest() {
        Tile t = new Wall(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow(() -> {
            t.onEnter(null);
        });

    }

    @Test
    void OnTileNullTest() {
        Tile t = new Wall(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow(() -> {
            t.onTile(null);
        });

    }

    @Test
    void OnExitNullTest() {
        Tile t = new Wall(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow(() -> {
            t.onExit(null);
        });

    }

}
