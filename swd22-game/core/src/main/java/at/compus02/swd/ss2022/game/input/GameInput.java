package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.gameobjects.Player.Player;
import com.badlogic.gdx.InputAdapter;

public class GameInput extends InputAdapter {
    private Player player;

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case 19: player.setPosition(player.getX(), player.getY() + 32); break;
            case 20: player.setPosition(player.getX(), player.getY() - 32); break;
            case 21: player.setPosition(player.getX() - 32, player.getY()); break;
            case 22: player.setPosition(player.getX() + 32, player.getY()); break;
        }
        return true;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
