package game.level;

import java.lang.Math;

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
    
    public void normalize() {
        double len = Math.sqrt(x * x + y * y);
        x /= len;
        y /= len;
    }

    public int x, y;
}
