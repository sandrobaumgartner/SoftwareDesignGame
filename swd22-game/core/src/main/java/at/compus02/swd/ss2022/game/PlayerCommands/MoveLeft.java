package at.compus02.swd.ss2022.game.PlayerCommands;

import at.compus02.swd.ss2022.game.gameobjects.Player.Player;

public class MoveLeft implements PlayerCommand{
    @Override
    public void executeCommand(Player player) {
        player.setPosition(player.getX() - 32, player.getY());
    }
}
