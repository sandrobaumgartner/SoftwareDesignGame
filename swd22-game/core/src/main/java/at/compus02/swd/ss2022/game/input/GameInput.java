package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.PlayerCommands.*;
import at.compus02.swd.ss2022.game.gameobjects.Objects.Enemy;
import at.compus02.swd.ss2022.game.gameobjects.Player.Player;
import com.badlogic.gdx.InputAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameInput extends InputAdapter {
    private PlayerCommandExecutor playerCommandExecutor;
    private MoveUp up = new MoveUp();
    private MoveDown down = new MoveDown();
    private MoveLeft left = new MoveLeft();
    private MoveRight right = new MoveRight();
    private KillNearestEnemy kill;

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            // Arrow keys
            case 19: playerCommandExecutor.executePlayerCommand(up); break;
            case 20: playerCommandExecutor.executePlayerCommand(down); break;
            case 21: playerCommandExecutor.executePlayerCommand(left); break;
            case 22: playerCommandExecutor.executePlayerCommand(right); break;
            // Space key
            case 62: playerCommandExecutor.executePlayerCommand(kill); break;
        }
        return true;
    }

    public void setPlayer(Player player) {
        playerCommandExecutor = new PlayerCommandExecutor(player);
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        kill = new KillNearestEnemy(enemies);
    }
}
