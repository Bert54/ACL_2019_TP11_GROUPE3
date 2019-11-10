package game;

import model.WorldController;

public class EntityBuilder {
    public EntityBuilder(WorldController controller) {
        this.controller = controller;
    }

    public Hero buildHero(Vec2 pos) {
        Hero hero = new Hero(pos, new Vec2(50, 50));
        hero.setController(new HeroController(hero, controller));
        return hero;
    }

    public Monster buildMonster() {
        Monster monster = new Monster(new Vec2(200, 200), new Vec2(50, 50));
        monster.setController(new MonsterDefaultController(monster));
        return monster;
    }


    private WorldController controller;
}
