package engine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.io.File;

public class Texture {
    public Texture(String filepath) {
        try {
            texture = ImageIO.read(getClass().getClassLoader().getResourceAsStream(filepath));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(BufferedImage image, int x, int y, int w, int h) {
        image.getGraphics().drawImage(texture, x, y, w, h, null);
    }

    private BufferedImage texture;
}