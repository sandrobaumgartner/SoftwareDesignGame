package at.compus02.swd.ss2022.game.gameobjects.Objects;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.Player.Player;
import com.badlogic.gdx.utils.Array;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class NormalGameObjectFactory implements GameObjectFactory {
    @Override
    public Array<GameObject> createStartObjects(GameObject gameObject, int height, int width) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Random rand = new Random();
        Array<GameObject> gameObjects = new Array<>();
        int minWidth = -width/2;
        int maxWidth = width/2;
        int minHeight = -height/2;
        int maxHeight = height/2;

        for(int i = 0; i < amountStones; i++) {
            int posX = rand.nextInt(maxWidth-minWidth) + minWidth;
            int posY = rand.nextInt(maxHeight-minHeight) + minHeight;
            if(!isInPlayerRadius(posX, posY)) {
                GameObject go = gameObject.getClass().getDeclaredConstructor().newInstance();
                go.setPosition(posX, posY);
                gameObjects.add(go);
            } else {
                i--;
            }
        }

        for(int i = 0; i < amountEnemies; i++) {
            int posX = rand.nextInt(maxWidth-minWidth) + minWidth;
            int posY = rand.nextInt(maxHeight-minHeight) + minHeight;
            if(!isInPlayerRadius(posX, posY)) {
                GameObject go;
                if(i < amountEnemies/2) {
                    go = new Enemy(true);
                } else {
                    go = new Enemy(false);
                }
                go.setPosition(posX, posY);
                gameObjects.add(go);
            } else {
                i--;
            }
        }

        player.setPosition(playerX, playerY);
        gameObjects.add(player);

        return gameObjects;
    }

    private boolean isInPlayerRadius(int x, int y) {
        int tolerance = tilePixels*2;
        int xLeft = playerX - tolerance;
        int xRight = playerX + tolerance;
        int yUp = playerY + tolerance;
        int yDown = playerY - tolerance;

        if(x > xLeft && x < xRight && y < yUp && y > yDown) {
            return true;
        }
        return false;
    }

    public Player getPlayer() {
        return player;
    }
}
