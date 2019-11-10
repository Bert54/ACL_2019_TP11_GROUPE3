package game;

import java.util.Objects;

public class Vec2 {
    public Vec2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vec2(Vec2 vector) {
        x = vector.x;
        y = vector.y;
    }

    public boolean equals(Vec2 v) {

        boolean res = false;
        if (this.x == v.x && this.y == v.y){
            res = true;
        }
        return res;
    }

    public int x, y;
}
