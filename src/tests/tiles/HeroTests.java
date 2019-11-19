package tests.tiles;

import game.GameEntity;
import game.Hero;
import game.Vec2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class HeroTests {

    @Test
    void collectCoinNullTest() {

        GameEntity hero = new Hero(new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow( () -> {
            hero.collectCoin(null);
        });

    }

}
