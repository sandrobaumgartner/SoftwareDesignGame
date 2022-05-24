package at.compus02.swd.ss2022.game.gameobjects.Player;

import at.compus02.swd.ss2022.game.Observer.PlayerObserver;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class Player implements GameObject {
    private Texture image;
    private Sprite sprite;
    private List<PlayerObserver> observerList = new ArrayList<>();

    public Player() {
        image = new Texture("player.png");
        sprite = new Sprite(image);
    }

    public void addObserver(PlayerObserver observer) {
        this.observerList.add(observer);
    }

    public void removeObserver(PlayerObserver observer) {
        this.observerList.remove(observer);
    }

    public void setPosition(float x, float y, String text) {
        this.setPosition(x, y);
        for (PlayerObserver observer : observerList) {
            observer.update(text);
        }
    }

    @Override
    public void act(float delta) {

    }

    @Override
    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public float getX() {
        return sprite.getX();
    }

    public float getY() {
        return sprite.getY();
    }
}
