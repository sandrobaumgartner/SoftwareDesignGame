package at.compus02.swd.ss2022.game.AssetRepo;

import com.badlogic.gdx.graphics.Texture;
import org.w3c.dom.Text;

import java.util.ArrayList;

public final class AssetRepository {
    private static AssetRepository instance;
    private ArrayList<Texture> textures;

    private AssetRepository() {
        textures = new ArrayList<>();
    }

    public static AssetRepository getInstance() {
        if(instance == null) {
            instance = new AssetRepository();
        }
        return instance;
    }

    public Texture getTexture(String textureName){
        for (Texture texture : textures) {
            if(texture.toString().equals(textureName)) {
                return texture;
            }
        }
        Texture texture = new Texture(textureName);
        textures.add(texture);
        return texture;
    }

    public void dispose() {
        for (Texture texture : textures) {
            texture.dispose();
        }
    }
}
