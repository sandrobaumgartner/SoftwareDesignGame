package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.PlayerCommands.*;
import at.compus02.swd.ss2022.game.gameobjects.Player.Player;
import com.badlogic.gdx.InputAdapter;

public class GameInput extends InputAdapter {
    private PlayerCommandExecutor playerCommandExecutor;

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case 19: playerCommandExecutor.executePlayerCommand(new MoveUp()); break;
            case 20: playerCommandExecutor.executePlayerCommand(new MoveDown()); break;
            case 21: playerCommandExecutor.executePlayerCommand(new MoveLeft()); break;
            case 22: playerCommandExecutor.executePlayerCommand(new MoveRight()); break;
        }
        return true;
    }

    public void setPlayer(Player player) {
        playerCommandExecutor = new PlayerCommandExecutor(player);
    }
}
