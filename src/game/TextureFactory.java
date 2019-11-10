package game;

import engine.Texture;

import java.util.Map;
import java.util.HashMap;

public class TextureFactory {
    TextureFactory() {
    }

    static Texture get(String name) {
        Texture t = textures.get(name);
        if(t != null) {
            return t;
        }
        t = new Texture(name);
        textures.put(name, t);
        return t;
    }

    private static Map<String, Texture> textures = new HashMap<String, Texture>();
}