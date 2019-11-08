package game;

import model.WorldController;

public class EntityBuilder {

    /**
     * la taille des cases
     */
    protected static final int WIDTH = 500;
    protected static final int HEIGHT = 500;

    public EntityBuilder(WorldController controller) {
        this.controller = controller;
    }

    public Hero buildHero() {
        Hero hero = new Hero(new Vec2((WIDTH/100)+1, (HEIGHT/100)+1), new Vec2(30, 30));
        hero.setController(new HeroController(hero, controller));
        return hero;
    }

    public Monster buildMonster() {
        Monster monster = new Monster(new Vec2(200, 200), new Vec2(30, 30));
        monster.setController(new MonsterDefaultController(monster));
        return monster;
    }

    private WorldController controller;
}
