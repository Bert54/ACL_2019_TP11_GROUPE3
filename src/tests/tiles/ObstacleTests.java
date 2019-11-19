package tests.tiles;

import game.Obstacle;
import game.Tile;
import game.Vec2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ObstacleTests {

    @Test
    void OnEnterNullTest() {
        Tile t = new Obstacle(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow(() -> {
            t.onEnter(null);
        });

    }

    @Test
    void OnTileNullTest() {
        Tile t = new Obstacle(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow(() -> {
            t.onTile(null);
        });

    }

    @Test
    void OnExitNullTest() {
        Tile t = new Obstacle(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow(() -> {
            t.onExit(null);
        });

    }

}
