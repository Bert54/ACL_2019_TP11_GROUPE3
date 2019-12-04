package tests.tiles;

import game.tiles.SwiftTile;
import game.tiles.Tile;
import game.level.Vec2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class SwiftTileTests {

    @Test
    void OnEnterNullTest() {
        Tile t = new SwiftTile(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow(() -> {
            t.onEnter(null);
        });

    }

    @Test
    void OnTileNullTest() {
        Tile t = new SwiftTile(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow(() -> {
            t.onTile(null);
        });

    }

    @Test
    void OnExitNullTest() {
        Tile t = new SwiftTile(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow(() -> {
            t.onExit(null);
        });

    }

}
