package com.me.Javaga.spaceobject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

/**
 *
 * Created by Dansel on 2014-05-02.
 */
public class Enemy extends SpaceObject {
	private int ID;
    protected ArrayList<Enemy> enemies;

	public Enemy(float xPos, float yPos, ArrayList<Enemy> list){
		super(xPos,yPos);
        this.enemies = list;
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
	public void wrap() {

	}

	@Override
	public boolean checkHealthy() {
		return false;
	}
}
