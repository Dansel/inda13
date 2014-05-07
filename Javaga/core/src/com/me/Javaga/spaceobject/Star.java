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
		xPos = random.nextFloat() * Gdx.graphics.getWidth();
		yPos = Gdx.graphics.getHeight();

		spriteSetUp(FILENAME);

		//Set scalefactor
		setScale(0.2f);

		dY = -random.nextFloat() * 30 + 10;
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
		}

	}

	@Override
	public boolean checkHealthy() {
		return isHealthy;
	}

	@Override
	public boolean checkForCollision(ArrayList<Bullet> bullets) {
		return false;
	}
}
