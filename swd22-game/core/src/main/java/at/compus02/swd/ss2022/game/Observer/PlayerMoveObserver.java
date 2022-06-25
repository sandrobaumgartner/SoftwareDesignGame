package at.compus02.swd.ss2022.game.Observer;

public class PlayerMoveObserver implements PlayerObserver{

    @Override
    public void update(String text, float posX, float posY) {
        System.out.println("Player is moving " + text);
    }
}
