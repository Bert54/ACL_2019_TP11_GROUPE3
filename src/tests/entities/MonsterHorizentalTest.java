package tests.entities;

import game.entities.GameEntity;
import game.entities.MonsterHorizental;
import game.level.Vec2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterHorizentalTest {

    @Test
    void onHitNullTest() {
        GameEntity monstre = new MonsterHorizental(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow( () -> {
            monstre.onHit(monstre);
        });
    }

    @Test
    void collectCoinNullTest() {
        GameEntity monstre = new MonsterHorizental(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow( () -> {
            monstre.collectCoin(null);
        });
    }
}