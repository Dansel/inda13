package com.me.Javaga.spaceobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.gamestate.levels.BulletDescription;

import java.util.ArrayList;

/**
 * For projectiles
 * Created by Dansel on 2014-04-30.
 */
public class Bullet extends SpaceObject {


	//private final static float ROTATION = 30;
	protected BulletDescription description;
	protected long startTime;

	public Bullet(float xPos, float yPos, float degree, BulletDescription description) {
		super(xPos, yPos);
		this.description = description;
		dX = (float) Math.cos(Math.toRadians(degree)) * description.getSpeed();
		dY = (float) Math.sin(Math.toRadians(degree)) * description.getSpeed();
		HEIGHT = Gdx.graphics.getHeight();
		WIDTH = Gdx.graphics.getWidth();
		init();
		sprite.rotate(degree - 90);
		startTime = System.currentTimeMillis();
	}

	@Override
	public void init() {
		setScale(description.getScale());
		spriteSetUp(description.getFilename());
	}

	@Override
	public void update() {
		if (isHealthy) {
			yPos += dY;
			xPos += dX;
			xCenter = xPos + sprite.getWidth() / 2;
			yCenter = yPos + sprite.getHeight() / 2;
			//sprite.rotate(ROTATION);
			sprite.setX(xPos);
			sprite.setY(yPos);
			hitbox.setCenter(xCenter, yCenter);
			wrap();
			if (System.currentTimeMillis() - startTime > description.getLifeTime()) {
				isHealthy = false;
			}
		} else {
			hurt();
		}
	}

	@Override
	protected void hurt() {
		if (disposeIndex > 50) {
			isDisposable = true;
		} else {
			disposeIndex++;
			if (disposeIndex % 10 == 0) {
				if (draw) {
					draw = false;
				} else {
					draw = true;
				}
			}
		}
	}

	@Override
	public void wrap() {
		if ((xCenter - sWidth / 2 + 100 < 0) || (xCenter + sWidth / 2 - 100 > WIDTH)
				|| (yCenter - sHeight / 2 + 20 < 0) || (yCenter + sHeight / 2 - 20 > HEIGHT)) {
			isHealthy = false;
			isDisposable = true;
		}
	}

	public float getDamage() {
		return description.getDamage();
	}

	public boolean isIndestructable() {
		return description.isIndestructable();
	}

	@Override
	public boolean checkForCollision(ArrayList<Bullet> bullets) {
		return false;
	}
}
