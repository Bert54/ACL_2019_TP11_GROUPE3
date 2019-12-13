package tests.entities;

import game.entities.GameEntity;
import game.entities.Monster;
import game.level.Maze;
import game.level.Vec2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {



    @Test
    void onHitNullTest() {
        GameEntity monstre = new Monster(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow( () -> {
            monstre.onHit(monstre);
        });
    }

    @Test
    void collectCoinNullTest() {
        GameEntity monstre = new Monster(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow( () -> {
            monstre.collectCoin(null);
        });
    }
 


}