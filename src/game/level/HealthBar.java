package game.level;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HealthBar implements Drawable {

    private String text;
    private int width;
    private int height;
    private int healthBarWidth;

    public HealthBar() {

        super();
        this.width = 150;
        this.height = 20;
        this.healthBarWidth = this.width;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWidth() {
        return width;
    }

    public void setHealthBarWidth(int healthBarWidth) {
        this.healthBarWidth = healthBarWidth;
    }

    @Override
    public void draw(BufferedImage image, Camera camera) {

        Graphics2D crayon = (Graphics2D) image.getGraphics();
        int Xcentre = (int) (this.width - crayon.getFontMetrics().getStringBounds(this.text, crayon).getWidth())/2;
        int Ycentre = (int) (this.height - crayon.getFontMetrics().getStringBounds(this.text, crayon).getHeight()/2);

        int x = (int) crayon.getFontMetrics().getStringBounds("Health : ", crayon).getWidth();

        crayon.setColor(Color.LIGHT_GRAY);
        crayon.fillRect(x, 0, this.width, this.height);
        crayon.setColor(Color.WHITE);
        crayon.drawString("Health : ", 0, Ycentre);
        crayon.setColor(Color.RED);
        crayon.fillRect(x, 0, this.healthBarWidth, this.height);

        crayon.setColor(Color.BLACK);
        crayon.drawString(this.text, Xcentre + x, Ycentre);
    }
}
