package game;

import model.WorldController;

public class EntityBuilder {
    public EntityBuilder(WorldController controller) {
        this.controller = controller;
    }

    public Hero buildHero(Vec2 pos, Vec2 box) {
        Hero hero = new Hero(pos, new Vec2(box.x, box.y));
        hero.setController(new HeroController(hero, controller));
        return hero;
    }

    public Monster buildMonster(Vec2 pos, Vec2 box) {
        Monster monster = new Monster(pos, box);
        monster.setController(new MonsterDefaultController(monster));
        return monster;
    }


    private WorldController controller;
}
