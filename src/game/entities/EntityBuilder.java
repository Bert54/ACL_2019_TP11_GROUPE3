package game.entities;

import game.level.Camera;
import game.level.Vec2;
import game.level.Maze;
import model.WorldController;

public class EntityBuilder {
    public EntityBuilder(Maze maze, WorldController controller) {
        this.controller = controller;
        this.maze = maze;
    }

    public Hero buildHero(Camera camera, Vec2 pos, Vec2 box) {
        camera.position = new Vec2(pos);
        Hero hero = new Hero(camera, pos, new Vec2(box.x, box.y));
        hero.setController(new HeroController(maze, hero, controller));
        return hero;
    }

    public Monster buildMonster(Vec2 pos, Vec2 box) {
        Monster monster = new Monster(pos, box);
        monster.setController(new MonsterDefaultController(monster));
        return monster;
    }
    public MonsterVertical buildMonsterVer(Vec2 pos, Vec2 box){
        MonsterVertical monsterVertical = new MonsterVertical(pos, box);
        monsterVertical.setController(new MonsterVerController(monsterVertical));
        return monsterVertical;
    }

    public MonsterHorizental buildMonsterHor(Vec2 pos, Vec2 box){
        MonsterHorizental monsterHorizental = new MonsterHorizental(pos, box);
        monsterHorizental.setController(new MonsterHorController(monsterHorizental));
        return monsterHorizental;
    }

    private WorldController controller;
    private Maze maze;
}
