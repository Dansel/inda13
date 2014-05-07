package com.me.Javaga.spaceobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

/**
 *
 * Created by Dansel on 2014-05-02.
 */
public class Enemy extends SpaceObject {
	private int ID;
	private static String FILENAME;
    protected ArrayList<Enemy> enemies;
	private float dX;
	private float dY;

	public Enemy(float xPos, float yPos, ArrayList<Enemy> list, int type){
		super(xPos,yPos);
		HEIGHT = Gdx.graphics.getHeight();
		WIDTH = Gdx.graphics.getWidth();
        this.enemies = list;
		FILENAME = type + ".png";
		init();
	}

	@Override
	public void init() {
		spriteSetUp(FILENAME);
		setScale(1);
		dX = 8;
	}

	@Override
	public void update() {
		xPos += dX;
		sprite.setX(xPos);
		wrap();
	}

	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}

	@Override
	public void wrap() {
		if (xPos > WIDTH - WIDTH*0.2 || xPos > WIDTH*0.2) {
			dX = -dX;
		}
	}

	@Override
	public boolean checkHealthy() {
		return true;
	}
}
