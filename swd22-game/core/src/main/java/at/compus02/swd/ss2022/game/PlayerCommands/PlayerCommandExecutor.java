package at.compus02.swd.ss2022.game.PlayerCommands;

import at.compus02.swd.ss2022.game.gameobjects.Player.Player;

public class PlayerCommandExecutor {

    private Player player;

    public PlayerCommandExecutor(Player player) {
        this.player = player;
    }

    public void executePlayerCommand(PlayerCommand command) {
        command.executeCommand(player);
    }
}
