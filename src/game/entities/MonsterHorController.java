package game.entities;

import game.level.Vec2;

import java.util.Random;

public class MonsterHorController implements EntityController{
    private MonsterHorizental monsterHorizental;

    private Vec2 deplacement;
    private Random rng;
    private int direction =1;


    public MonsterHorController(MonsterHorizental monsterHorizental){
        this.monsterHorizental = monsterHorizental;
        rng = new Random();

    }

    @Override
    public void onUpdate() {


        monsterHorizental.move(new Vec2(5*direction, 0*direction));

    }
    public void iverseDirection(){

        direction*=-1;
    }
}
