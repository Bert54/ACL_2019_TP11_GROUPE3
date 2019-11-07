package game;

public class MonsterDefaultController implements EntityController {
    public MonsterDefaultController(Monster monster) {
        this.monster = monster;
    }

    public void onUpdate() {
        
    }

    private Monster monster;
}
