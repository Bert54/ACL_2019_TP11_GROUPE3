package tests.tiles;

import game.Coin;
import game.Tile;
import game.Vec2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CoinTileTests {

    @Test
    void OnEnterNullTest() {
        Tile t = new Coin(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow(() -> {
            t.onEnter(null);
        });

    }

    @Test
    void OnTileNullTest() {
        Tile t = new Coin(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow(() -> {
            t.onTile(null);
        });

    }

    @Test
    void OnExitNullTest() {
        Tile t = new Coin(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow(() -> {
            t.onExit(null);
        });
    }
}
