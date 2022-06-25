package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.PlayerCommands.*;
import at.compus02.swd.ss2022.game.gameobjects.Player.Player;
import com.badlogic.gdx.InputAdapter;

public class GameInput extends InputAdapter {
    private PlayerCommandExecutor playerCommandExecutor;
    private MoveUp up = new MoveUp();
    private MoveDown down = new MoveDown();
    private MoveLeft left = new MoveLeft();
    private MoveRight right = new MoveRight();

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case 19: playerCommandExecutor.executePlayerCommand(up); break;
            case 20: playerCommandExecutor.executePlayerCommand(down); break;
            case 21: playerCommandExecutor.executePlayerCommand(left); break;
            case 22: playerCommandExecutor.executePlayerCommand(right); break;
        }
        return true;
    }

    public void setPlayer(Player player) {
        playerCommandExecutor = new PlayerCommandExecutor(player);
    }
}
