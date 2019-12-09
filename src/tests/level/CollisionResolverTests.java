package tests.level;

import game.entities.GameEntity;
import game.entities.Hero;
import game.entities.Monster;
import game.entities.Projectile;
import game.level.Camera;
import game.level.CollisionResolver;
import game.level.Vec2;
import game.tiles.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CollisionResolverTests {

    CollisionResolver cr = new CollisionResolver();

    @Test
    void emptyListsTest() {
        assertDoesNotThrow(() -> {

            cr.resolve(new ArrayList<>(), new ArrayList<>());

        });
    }

    @Test
    void sameEntityInListTest() {
        GameEntity gn = new Hero(new Camera(), new Vec2(0, 0), new Vec2(30, 30));
        List<GameEntity> gnList = new ArrayList<>();
        gnList.add(gn);
        gnList.add(gn);
        gnList.add(gn);
        assertDoesNotThrow(() -> {

            cr.resolve(gnList, new ArrayList<>());

        });

    }

    @Test
    void sameTileInListTest() {
        Tile t = new Obstacle(new Vec2(0, 0), new Vec2(50, 50));
        List<Tile> tList = new ArrayList<>();
        tList.add(t);
        tList.add(t);
        tList.add(t);
        assertDoesNotThrow(() -> {

            cr.resolve(new ArrayList<>(), tList);

        });

    }

    @Test
    void sameTileButDifAdressesInListTest() {
        Tile t = new Obstacle(new Vec2(0, 0), new Vec2(50, 50));
        List<Tile> tList = new ArrayList<>();
        tList.add(t);
        t = new Obstacle(new Vec2(0, 0), new Vec2(50, 50));
        tList.add(t);
        assertDoesNotThrow(() -> {

            cr.resolve(new ArrayList<>(), tList);

        });
    }

    @Test
    void sameEntityButDifAdressesInListTest() {
        GameEntity gn = new Hero(new Camera(), new Vec2(0, 0), new Vec2(30, 30));
        List<GameEntity> gnList = new ArrayList<>();
        gnList.add(gn);
        gn = new Hero(new Camera(), new Vec2(0, 0), new Vec2(30, 30));
        gnList.add(gn);
        assertDoesNotThrow(() -> {

            cr.resolve(gnList, new ArrayList<>());

        });
    }

    @Test
    void hugeEntityAmountTest() {
        int amount = 100000;
        GameEntity gn = new Hero(new Camera(), new Vec2(0, 0), new Vec2(30, 30));
        List<GameEntity> gnList = new ArrayList<>(amount);
        for (int i = 0 ; i < amount ; i++) {
            gnList.add(gn);
        }
        assertDoesNotThrow(() -> {

            cr.resolve(gnList, new ArrayList<>());

        });
    }

    @Test
    void hugeEntityAmountWithTilesTest() {
        int entityAmount = 50000;
        int tileAmount = 25000;
        GameEntity gn = new Hero(new Camera(), new Vec2(0, 0), new Vec2(30, 30));
        Tile t = new Obstacle(new Vec2(0, 0), new Vec2(50, 50));
        List<GameEntity> gnList = new ArrayList<>(entityAmount);
        List<Tile> tList = new ArrayList<>(tileAmount);
        for (int i = 0 ; i < entityAmount ; i++) {
            gnList.add(gn);
        }
        for (int i = 0 ; i < tileAmount ; i++) {
            tList.add(t);
        }
        assertDoesNotThrow(() -> {

            cr.resolve(gnList, tList);

        });
    }

    @Test
    void differentEntitiesAndDifferentTilesTest() {
        GameEntity ge1 = new Hero(new Camera(), new Vec2(0, 0), new Vec2(30, 30));
        GameEntity ge2 = new Monster(new Vec2(0, 0), new Vec2(30, 30));
        GameEntity ge3 = new Projectile(ge1, new Vec2(0, 0), new Vec2(30, 30), new Vec2(0, 0));
        Tile t1 = new Obstacle(new Vec2(0, 0), new Vec2(50, 50));
        Tile t2 = new GlueTile(new Vec2(0, 0), new Vec2(50, 50));
        Tile t3 = new SwiftTile(new Vec2(0, 0), new Vec2(50, 50));
        Tile t4 = new LavaTile(new Vec2(0, 0), new Vec2(50, 50));
        List<GameEntity> geList = new ArrayList<>();
        List<Tile> tList = new ArrayList<>();
        geList.add(ge1);
        geList.add(ge2);
        geList.add(ge3);
        tList.add(t1);
        tList.add(t2);
        tList.add(t3);
        tList.add(t4);
        assertDoesNotThrow(() -> {

            cr.resolve(geList, tList);

        });
    }

    @Test
    void differentEntitiesAndDifferentTilesTestWithRemoval() {
        GameEntity ge1 = new Hero(new Camera(), new Vec2(0, 0), new Vec2(30, 30));
        GameEntity ge2 = new Monster(new Vec2(0, 0), new Vec2(30, 30));
        GameEntity ge3 = new Projectile(ge1, new Vec2(0, 0), new Vec2(30, 30), new Vec2(0, 0));
        Tile t1 = new Obstacle(new Vec2(0, 0), new Vec2(50, 50));
        Tile t2 = new GlueTile(new Vec2(0, 0), new Vec2(50, 50));
        Tile t3 = new SwiftTile(new Vec2(0, 0), new Vec2(50, 50));
        Tile t4 = new LavaTile(new Vec2(0, 0), new Vec2(50, 50));
        List<GameEntity> geList = new ArrayList<>();
        List<Tile> tList = new ArrayList<>();
        geList.add(ge1);
        geList.add(ge2);
        geList.add(ge3);
        tList.add(t1);
        tList.add(t2);
        tList.add(t3);
        tList.add(t4);
        geList.remove(ge3);
        tList.remove(t2);
        assertDoesNotThrow(() -> {

            cr.resolve(geList, tList);

        });
    }

}
