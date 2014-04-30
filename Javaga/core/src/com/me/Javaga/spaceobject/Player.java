package com.me.Javaga.spaceobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.managers.GameKeys;

/**
 * Created by Dansel on 2014-04-30.
 */
public class Player extends SpaceObject {

	private static final String FILENAME = "snilsson.png";

	public Player(float xPos, float yPos) {
		super(xPos, yPos);
		init();
	}

	@Override
	public void init() {
		sprite = new Sprite(new Texture(Gdx.files.internal(FILENAME)));
	}

	@Override
	public void update() {
		if(GameKeys.isDown(GameKeys.UP)) {
			yPos += 10;
		}
		if(GameKeys.isDown(GameKeys.DOWN)) {
			yPos -= 10;
		}
		if(GameKeys.isDown(GameKeys.LEFT)) {
			xPos -= 10;
		}
		if(GameKeys.isDown(GameKeys.RIGHT)) {
			xPos += 10;
		}
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(sprite, xPos, yPos);
	}
}
