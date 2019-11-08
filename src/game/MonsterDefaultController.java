package game;

public class MonsterDefaultController implements EntityController {
    public MonsterDefaultController(Monster monster) {
        this.monster = monster;
    }

    public void onUpdate() {
        
    }

    @Override
    public void setStopLeft(boolean stopLeft) {

    }

    @Override
    public void setStopRight(boolean stopRight) {

    }

    @Override
    public void setStopTop(boolean stopTop) {

    }

    @Override
    public void setStopBottom(boolean stopBottom) {

    }

    private Monster monster;
}
