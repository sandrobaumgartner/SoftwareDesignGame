package at.compus02.swd.ss2022.game.gameobjects.Tiles;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.Objects.GameObjectFactory;
import com.badlogic.gdx.utils.Array;

import java.lang.reflect.InvocationTargetException;

public class NormalTileFactory implements GameObjectFactory {
    @Override
    public Array<GameObject> createStartObjects(GameObject gameObject, int height, int width) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Array<GameObject> tileObjects = new Array<>();
        for(int i = -height/2; i < height/2; i+=tilePixels) {
            for(int j = -width/2; j < width/2; j+=tilePixels) {
                GameObject tileObjectNew = gameObject.getClass().getDeclaredConstructor().newInstance();
                tileObjectNew.setPosition(i, j);
                tileObjects.add(tileObjectNew);
            }
        }
        return tileObjects;
    }
}
