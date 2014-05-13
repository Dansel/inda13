package com.me.Javaga.spaceobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Lukas on 2014-05-05.
 */
public class Star extends SpaceObject {

	private final static String FILENAME = "star.png";
	private Random random;


	public Star() {
		super(0, 0);
		init();
	}

	@Override
	public void init() {
		random = new Random();
		xCenter = random.nextFloat() * Gdx.graphics.getWidth();
		yCenter = Gdx.graphics.getHeight();

		setScale(0.3f);
		spriteSetUp(FILENAME);
		dY = -(random.nextFloat() * 20 + 5);
	}

	@Override
	public void update() {
		yPos += dY;
		yCenter = yPos + sprite.getHeight() / 2;
		sprite.setY(yPos);
		wrap();
	}

	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}

	@Override
	public void wrap() {
		if ((yCenter - sHeight / 2 < 0)) {
			isHealthy = false;
			isDisposable = true;
		}

	}

	@Override
	public boolean checkForCollision(ArrayList<Bullet> bullets) {
		return false;
	}
}
