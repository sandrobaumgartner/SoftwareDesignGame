package at.compus02.swd.ss2022.game.PlayerCommands;

import at.compus02.swd.ss2022.game.Main;
import at.compus02.swd.ss2022.game.gameobjects.Objects.Enemy;
import at.compus02.swd.ss2022.game.gameobjects.Player.Player;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Vector;

public class KillNearestEnemy implements PlayerCommand{
    private ArrayList<Enemy> enemies;

    public KillNearestEnemy(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }

    @Override
    public void executeCommand(Player player) {
        // Range 64 pixels
        Vector2 playerVector = new Vector2(player.getX(), player.getY());
        float smallestDistance = Integer.MAX_VALUE;
        Enemy deletionEnemy = new Enemy(false);

        for (Enemy enemy : enemies) {
            Vector2 enemyVector = new Vector2(enemy.getX(), enemy.getY());
            float distance = playerVector.dst(enemyVector);
            if(distance < smallestDistance && distance <= 64) {
                smallestDistance = distance;
                deletionEnemy = enemy;
            }
        }

        enemies.remove(deletionEnemy);
        Main.getGameObjects().removeValue(deletionEnemy, true);
    }
}
