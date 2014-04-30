package com.me.Javaga;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.gamestate.GameState;
import com.me.Javaga.managers.GameInputProcessor;
import com.me.Javaga.managers.GameKeys;
import com.me.Javaga.managers.GameStateManager;

import java.util.Random;

public class JavagaMain extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
    OrthographicCamera camera;
    float WIDTH;
    float HEIGHT;
    Random rand;
    GameStateManager manager;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
        rand = new Random();

        //Set Res
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();

        //Initiate camera + window.
        camera = new OrthographicCamera(WIDTH,HEIGHT);
        camera.translate(WIDTH / 2, HEIGHT / 2);
        camera.update();

        //Initiate managers.
        manager = new GameStateManager();

        //Select input processor to our custom one.
        Gdx.input.setInputProcessor(new GameInputProcessor());
    }

	@Override
	public void render () {
        //Draw a black screen.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Update the game state
        manager.update();
		GameKeys.update();
        camera.update();

		//Tell the game manager to initiate drawing of sprites and other elements
        batch.begin();
		manager.draw(batch);
        batch.end();

	}
}
