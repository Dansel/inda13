package com.me.Javaga.spaceobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Dansel on 2014-04-30.
 */
public class Bullet extends SpaceObject {


	private static final String FILENAME = "snilsson.png";
	private float degree;
	private float dX;
	private float dY;
	private final static float SPEED = 50;
	private final static float ROTATION = 30;

	public Bullet(float xPos,float yPos, float degree) {
		super(xPos, yPos);
		this.degree = degree;
		dX = (float) Math.cos(Math.toRadians(degree)) * SPEED;
		dY = (float) Math.sin(Math.toRadians(degree)) * SPEED;
		init();
	}

	@Override
	public void init() {
		sprite = new Sprite(new Texture(Gdx.files.internal(FILENAME)));
		setScale(0.1f);

		//Find the sprites dimensions.
		sWidth = sprite.getWidth()*SCALEFACTOR;
		sHeight = sprite.getHeight()*SCALEFACTOR;

		xCenter = xPos + sprite.getWidth()/2;
		yCenter = yPos + sprite.getHeight()/2;
	}

	@Override
	public void update() {
		yPos += dY;
		xPos += dX;
		xCenter = xPos + sprite.getWidth()/2;
		yCenter = yPos + sprite.getHeight()/2;
		sprite.rotate(ROTATION);
		sprite.setX(xPos);
		sprite.setY(yPos);
	}

	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}

	@Override
	public void setScale(float scaleFactor) {
		SCALEFACTOR = scaleFactor;
		sprite.setScale(SCALEFACTOR);
	}

	@Override
	public boolean checkHealthy() {
		return true;
	}
}
