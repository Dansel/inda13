package com.me.Javaga.spaceobject;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Dansel on 2014-04-30.
 */
public abstract class SpaceObject {

	protected float xPos;
	protected float yPos;
	protected Sprite sprite;


	public SpaceObject(float xPos, float yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}


	public abstract void init();

	public abstract void update();

	public abstract void draw(SpriteBatch batch);

	public abstract void setScale(float scaleFactor);
}
