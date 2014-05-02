package com.me.Javaga.spaceobject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Dansel on 2014-05-02.
 */
public class Enemy extends SpaceObject {

	public Enemy(float xPos, float yPos, int ID){
		super(xPos,yPos);

	}

	@Override
	public void init() {

	}

	@Override
	public void update() {

	}

	@Override
	public void draw(SpriteBatch batch) {

	}

	@Override
	public void setScale(float scaleFactor) {

	}

	@Override
	public void wrap() {

	}

	@Override
	public boolean checkHealthy() {
		return false;
	}

	@Override
	public boolean overlap(SpaceObject obj) {
		return false;
	}

	@Override
	public Rectangle getHitbox() {
		return hitbox;
	}
}
