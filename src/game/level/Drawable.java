package game.level;

import game.level.Camera;

import java.awt.image.BufferedImage;
    
public interface Drawable {
    public void draw(BufferedImage image, Camera camera);
}
