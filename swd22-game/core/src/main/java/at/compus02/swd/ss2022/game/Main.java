package at.compus02.swd.ss2022.game;

import at.compus02.swd.ss2022.game.AssetRepo.AssetRepository;
import at.compus02.swd.ss2022.game.Observer.PlayerMoveObserver;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.Objects.Enemy;
import at.compus02.swd.ss2022.game.gameobjects.Objects.NormalGameObjectFactory;
import at.compus02.swd.ss2022.game.gameobjects.Objects.Stone;
import at.compus02.swd.ss2022.game.gameobjects.Player.Player;
import at.compus02.swd.ss2022.game.gameobjects.Tiles.NormalTileFactory;
import at.compus02.swd.ss2022.game.gameobjects.Tiles.TileGrass;
import at.compus02.swd.ss2022.game.input.GameInput;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import java.util.ArrayList;
import java.util.List;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
	private SpriteBatch batch;

	private ExtendViewport viewport = new ExtendViewport(480.0f, 480.0f, 480.0f, 480.0f);
	private GameInput gameInput = new GameInput();

	private Array<GameObject> gameObjects = new Array<>();

	private final float updatesPerSecond = 60;
	private final float logicFrameTime = 1 / updatesPerSecond;
	private float deltaAccumulator = 0;
	private BitmapFont font;

	private final int windowHeight = 480;
	private final int windowWidth = 480;
	private NormalTileFactory normalTileFactory = new NormalTileFactory();
	private NormalGameObjectFactory normalGameObjectFactory = new NormalGameObjectFactory();

	@Override
	public void create() {
		batch = new SpriteBatch();
		try {
			gameObjects = (normalTileFactory.createStartObjects(new TileGrass(), windowHeight, windowWidth));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			gameObjects.addAll(normalGameObjectFactory.createStartObjects(new Stone(), windowHeight, windowWidth));
			Player player = normalGameObjectFactory.getPlayer();
			player.addObserver(new PlayerMoveObserver());
			ArrayList<Enemy> enemies = getEnemiesOfList(gameObjects);
			for (Enemy enemy : enemies) {
				player.addObserver(enemy);
			}
			gameInput.setPlayer(player);
		} catch (Exception e) {
			e.printStackTrace();
		}
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		Gdx.input.setInputProcessor(this.gameInput);
	}

	private void act(float delta) {
		for(GameObject gameObject : gameObjects) {
			gameObject.act(delta);
		}
	}

	private void draw() {
		batch.setProjectionMatrix(viewport.getCamera().combined);
		batch.begin();
		for(GameObject gameObject : gameObjects) {
			gameObject.draw(batch);
		}
		//font.draw(batch, "Hello Game", -220, -220);
		batch.end();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		float delta = Gdx.graphics.getDeltaTime();
		deltaAccumulator += delta;
		while(deltaAccumulator > logicFrameTime) {
			deltaAccumulator -= logicFrameTime;
			act(logicFrameTime);
		}
		draw();
	}

	@Override
	public void dispose() {
		batch.dispose();
		AssetRepository.getInstance().dispose();
	}

	@Override
	public void resize(int width, int height){
		viewport.update(width,height);
	}

	public ArrayList<Enemy> getEnemiesOfList(Array<GameObject> gameObjectList) {
		ArrayList<Enemy> enemies = new ArrayList<>();
		for (GameObject go : gameObjectList) {
		    if(go instanceof Enemy) {
				enemies.add((Enemy) go);
			}
		}
		return enemies;
	}
}