package tests.entities;

import game.level.Camera;
import game.entities.GameEntity;
import game.entities.Hero;
import game.level.Vec2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class HeroTests {

    @Test
    void collectCoinNullTest() {

        GameEntity hero = new Hero(new Camera(), new Vec2(10, 10), new Vec2(10, 10));
        assertDoesNotThrow( () -> {
            hero.collectCoin(null);
        });

    }

}
