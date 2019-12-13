package tests.entities;

import game.entities.GameEntity;
import game.entities.MonsterVertical;
import game.level.Vec2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterVerticalTest {

    @Test
    void onHitNullTest() {
        GameEntity monstre = new MonsterVertical(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow( () -> {
            monstre.onHit(monstre);
        });
    }

    @Test
    void collectCoinNullTest() {
        GameEntity monstre = new MonsterVertical(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow( () -> {
            monstre.collectCoin(null);
        });
    }
}