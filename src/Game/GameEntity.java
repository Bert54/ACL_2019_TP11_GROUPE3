package game;

public abstract class GameEntity {
    public GameEntity(Vec2 position, Vec2 box) {
        this.position = position;
        this.box = box;
    }

    public abstract void update();

    public void setController(EntityController controller) {
        this.controller = controller;
    }

    public void move(Vec2 translation) {
        position.x += translation.x;
        position.y += translation.y;
    }

    public Vec2 getPosition() {
        return position;
    }

    public Vec2 getBox() {
        return box;
    }

    protected EntityController controller;
    protected Vec2 position;
    protected Vec2 box;
}
