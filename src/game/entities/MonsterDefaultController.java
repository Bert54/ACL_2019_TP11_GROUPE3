package game.entities;

import game.level.Vec2;

import java.util.Random;

public class MonsterDefaultController implements EntityController {
    public MonsterDefaultController(Monster monster) {
        this.monster = monster;
        rng = new Random();
    }

    public void onUpdate() {
        int x = rng.nextInt(6);
        int y = rng.nextInt(6);
        int sx = rng.nextInt(2) == 0 ? 1 : -1;
        int sy = rng.nextInt(2) == 0 ? 1 : -1;
        monster.move(new Vec2(x * sx, y * sx));
    }

    private Random rng;
    private Monster monster;
}
