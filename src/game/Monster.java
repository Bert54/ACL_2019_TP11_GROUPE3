package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Monster extends GameEntity {
    public Monster(Vec2 position, Vec2 box) {
        super(position, box);
        this.pv = 50;
    }

    public void update() {
        controller.onUpdate();
    }

    public void draw(BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();
		crayon.setColor(Color.blue);
		crayon.fillOval(position.x, position.y, 30, 30);
    }

    @Override
    public boolean isHero() {
        return super.isHero();
    }

    @Override
    public void setPv(int pv) {
        super.setPv(pv);
    }

    @Override
    public int getPv() {
        return super.getPv();
    }
}
