package com.me.Javaga;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class JavagaMain extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
    OrthographicCamera camera;
    float WIDTH;
    float HEIGHT;
    Random rand;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
        rand = new Random();

        camera = new OrthographicCamera(WIDTH,HEIGHT);
        camera.translate(WIDTH / 2, HEIGHT / 2);
        camera.update();
    }

	@Override
	public void render () {
        Gdx.gl.glFlush();
        GameState.update();
        camera.update();




        batch.begin();

        batch.draw(img, 0 , 0);


		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            Gdx.gl.glClearColor(rand.nextFloat(),rand.nextFloat(),rand.nextFloat(), 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            //camera.update();
            batch.draw(img, 250, 250);

        }
        batch.end();

	}
}
