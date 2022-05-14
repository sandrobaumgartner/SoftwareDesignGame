package at.compus02.swd.ss2022.game.gameobjects;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import com.badlogic.gdx.utils.Array;

import java.lang.reflect.InvocationTargetException;

public interface GameObjectFactory {
    int tilePixels = 32;
    int playerX = 0;
    int playerY = 0;
    int amountStones = 30;

    Array<GameObject> createStartObjects(GameObject gameObject, int height, int width) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}