package com.me.Javaga.spaceobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Create object of this class to spawn enemies.
 * Created by Dansel on 2014-05-02.
 */
public class Enemy extends SpaceObject {
	private static String FILENAME;

	public Enemy(float xPos, float yPos, int type) {
		super(xPos, yPos);
		HEIGHT = Gdx.graphics.getHeight();
		WIDTH = Gdx.graphics.getWidth();
		FILENAME = "sprite" + type + ".png";
		init();
	}

	@Override
	public void init() {
        setScale(1);
		spriteSetUp(FILENAME);
		dX = 4;
	}

	@Override
	public void update() {
		xPos += dX;
		sprite.setX(xPos);
        xCenter = xPos + sprite.getWidth() / 2;
		wrap();
        hitbox.setCenter(xCenter, yCenter);
	}

	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}

	@Override
	public void wrap() {
		if (xPos > WIDTH * 0.8f || xPos < WIDTH * 0.2f) {
			dX = -dX;
		}
	}

	@Override
	public boolean checkHealthy() {
		return isHealthy;
	}

	@Override
	public boolean checkForCollision(ArrayList<Bullet> bullets) {
		for (Bullet bullet : bullets) {
			if (overlap(bullet)){
				System.out.println("COLLISION!");
				return true;
			}
		}
		return false;
	}
}
