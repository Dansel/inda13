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
	private BulletDescription description;

	public Bullet(float xPos, float yPos, float degree, int type) {
		super(xPos, yPos);
		this.description = BulletDescription.getType(type);
		dX = (float) Math.cos(Math.toRadians(degree)) * description.getSpeed();
		dY = (float) Math.sin(Math.toRadians(degree)) * description.getSpeed();
		HEIGHT = Gdx.graphics.getHeight();
		WIDTH = Gdx.graphics.getWidth();
		init();
		sprite.rotate(degree - 90);
	}

	@Override
	public void init() {
		setScale(description.getScale());
		spriteSetUp(description.getFilename());
	}

	@Override
	public void update() {
		yPos += dY;
		xPos += dX;
		xCenter = xPos + sprite.getWidth() / 2;
		yCenter = yPos + sprite.getHeight() / 2;
		//sprite.rotate(ROTATION);
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
		if ((xCenter - sWidth / 2 + 100 < 0) || (xCenter + sWidth / 2 - 100 > WIDTH)
				|| (yCenter - sHeight / 2 + 20 < 0) || (yCenter + sHeight / 2 - 20 > HEIGHT)) {
			isHealthy = false;
		}
	}

	public boolean isIndestructable() {
		return description.isIndestructable();
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
