package com.me.Javaga.spaceobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.managers.GameKeys;

/**
 * Class for the Players unit. Contains parameters for position as well as the sprite used to draw to canvas.
 *
 * Created by Dansel on 2014-04-30.
 */
public class Player extends SpaceObject {

	private static final String FILENAME = "snilsson.png";

	//Call the super-class's constructor
	public Player(float xPos, float yPos) {
		super(xPos, yPos);
		init();
	}

	@Override
	public void init() {
		//Create the sprite with some texture
		sprite = new Sprite(new Texture(Gdx.files.internal(FILENAME)));

		//Set scalefactor
		sprite.setScale(0.4f);
	}

	/**
	 * Checks for keypresses and updates the sprite position
	 */
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

		//Update position
		sprite.setX(xPos);
		sprite.setY(yPos);
	}

	/**
	 * Draws the players sprite to the canvas at designated xPos and yPos.
	 * @param batch     SpriteBatch
	 */
	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}
}
