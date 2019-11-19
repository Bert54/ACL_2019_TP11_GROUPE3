package tests.tiles;

import game.GlueTile;
import game.Tile;
import game.Vec2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class GlueTileTests {

    @Test
    void OnEnterNullTest() {
        Tile t = new GlueTile(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow(() -> {
            t.onEnter(null);
        });

    }

    @Test
    void OnTileNullTest() {
        Tile t = new GlueTile(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow(() -> {
            t.onTile(null);
        });

    }

    @Test
    void OnExitNullTest() {
        Tile t = new GlueTile(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow(() -> {
            t.onExit(null);
        });

    }



}
