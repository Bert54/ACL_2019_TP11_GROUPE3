package game.entities;
import game.level.Vec2;

import java.util.Random;




public class MonsterVerController implements EntityController{

    private MonsterVertical monsterVertical;

    private Vec2 deplacement;
    private Random rng;
    private int direction=1;


    public MonsterVerController(MonsterVertical monsterVertical){
        this.monsterVertical = monsterVertical;
        deplacement=new Vec2(0,3);
        rng = new Random();

    }
    public void inverseDirection(){

        direction*=-1;
    }

    @Override
    public void onUpdate() {
        monsterVertical.move(new Vec2(0*direction, 6*direction));

    }
}
