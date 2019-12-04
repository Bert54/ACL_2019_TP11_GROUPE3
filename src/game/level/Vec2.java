package game.level;

public class Vec2 {
    public Vec2() {
    }
    
    public Vec2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vec2(Vec2 vector) {
        x = vector.x;
        y = vector.y;
    }
    
    public int x, y;
}
