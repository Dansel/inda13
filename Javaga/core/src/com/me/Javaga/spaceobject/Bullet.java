package com.me.Javaga.spaceobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * For projectiles
 * Created by Dansel on 2014-04-30.
 */
public class Bullet extends SpaceObject {


	private static final String FILENAME = "snilsson.png";
	private final static float SPEED = 10;
	private final static float ROTATION = 30;
	private float degree;

	public Bullet(float xPos, float yPos, float degree) {
		super(xPos, yPos);
		this.degree = degree;
		dX = (float) Math.cos(Math.toRadians(degree)) * SPEED;
		dY = (float) Math.sin(Math.toRadians(degree)) * SPEED;
		HEIGHT = Gdx.graphics.getHeight();
		WIDTH = Gdx.graphics.getWidth();
		init();
	}

	@Override
	public void init() {
		setScale(0.1f);
		spriteSetUp(FILENAME);
	}

	@Override
	public void update() {
		yPos += dY;
		xPos += dX;
		xCenter = xPos + sprite.getWidth() / 2;
		yCenter = yPos + sprite.getHeight() / 2;
		sprite.rotate(ROTATION);
		sprite.setX(xPos);
		sprite.setY(yPos);
		hitbox.setCenter(xCenter, yCenter);
		wrap();
	}

	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}

	@Override
	public void wrap() {
		if ((xCenter - sWidth / 2 < 0) || (xCenter + sWidth / 2 > WIDTH)
				|| (yCenter - sHeight / 2 < 0) || (yCenter + sHeight / 2 > HEIGHT)) {
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
