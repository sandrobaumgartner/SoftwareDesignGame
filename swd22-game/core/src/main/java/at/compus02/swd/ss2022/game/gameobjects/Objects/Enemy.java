package at.compus02.swd.ss2022.game.gameobjects.Objects;

import at.compus02.swd.ss2022.game.AssetRepo.AssetRepository;
import at.compus02.swd.ss2022.game.Observer.PlayerObserver;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemy implements GameObject, PlayerObserver {
    private Texture image;
    private Sprite sprite;
    private boolean following;

    public Enemy(boolean following) {
        image = AssetRepository.getInstance().getTexture("goblin.png");
        sprite = new Sprite(image);
        this.following = following;
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

    @Override
    public void update(String text, float posX, float posY) {
        if(this.following) {
            this.follow(posX, posY);
        } else {
            this.runAway(posX, posY);
        }
    }

    public void follow(float playerX, float playerY) {
        float right = this.sprite.getX() + 32;
        float left = this.sprite.getX() - 32;
        float up = this.sprite.getY() + 32;
        float down = this.sprite.getY() - 32;

        if(Math.abs(playerX - right) < Math.abs(playerX - left)) {
            this.setPosition(right, this.sprite.getY());
        } else if (Math.abs(playerX - right) > Math.abs(playerX - left)){
            this.setPosition(left, this.sprite.getY());
        }

        if(Math.abs(playerY - up) < Math.abs(playerY - down)) {
            this.setPosition(this.sprite.getX(), up);
        } else if (Math.abs(playerY - up) > Math.abs(playerY - down)) {
            this.setPosition(this.sprite.getX(), down);
        }
    }

    public void runAway(float playerX, float playerY) {
        float right = this.sprite.getX() + 32;
        float left = this.sprite.getX() - 32;
        float up = this.sprite.getY() + 32;
        float down = this.sprite.getY() - 32;

        if(Math.abs(playerX - right) > Math.abs(playerX - left)) {
            this.setPosition(right, this.sprite.getY());
        } else if (Math.abs(playerX - right) < Math.abs(playerX - left)){
            this.setPosition(left, this.sprite.getY());
        }

        if(Math.abs(playerY - up) > Math.abs(playerY - down)) {
            this.setPosition(this.sprite.getX(), up);
        } else if (Math.abs(playerY - up) < Math.abs(playerY - down)) {
            this.setPosition(this.sprite.getX(), down);
        }
    }

    public float getX() {
        return sprite.getX();
    }

    public float getY() {
        return sprite.getY();
    }
}
