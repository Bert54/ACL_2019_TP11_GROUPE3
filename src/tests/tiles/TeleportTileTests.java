package tests.tiles;

import exceptions.TeleportNegativeCoordinatesException;
import game.tiles.TeleportTile;
import game.tiles.Tile;
import game.level.Vec2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TeleportTileTests {


    @Test
    void negativeDestinationCoordinatesTest() {
        assertThrows(TeleportNegativeCoordinatesException.class, () -> {

            Tile t = new TeleportTile(new Vec2(10, 10), new Vec2(10, 10), new Vec2(100, -100));

        });
    }

    @Test
    void OnEnterNullTest() {
        Tile t = new TeleportTile(new Vec2(10, 10), new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow(() -> {
            t.onEnter(null);
        });

    }

    @Test
    void OnTileNullTest() {
        Tile t = new TeleportTile(new Vec2(10, 10), new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow(() -> {
            t.onTile(null);
        });

    }

    @Test
    void OnExitNullTest() {
        Tile t = new TeleportTile(new Vec2(10, 10), new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow(() -> {
            t.onExit(null);
        });

    }

}
