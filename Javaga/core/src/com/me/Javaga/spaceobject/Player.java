package com.me.Javaga.spaceobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.managers.GameKeys;

import java.util.ArrayList;

/**
 * Class for the Players unit. Contains parameters for position as well as the sprite used to draw to canvas.
 *
 * Created by Dansel on 2014-04-30.
 */
public class Player extends SpaceObject {

	private static final String FILENAME = "snilsson.png";
	//private float rotation;
	//private float scale;
	private ArrayList<Bullet> bullets;


	//Call the super-class's constructor
	public Player(float xPos, float yPos, ArrayList<Bullet> bullets) {
		super(xPos, yPos);
		HEIGHT = Gdx.graphics.getHeight();
		WIDTH = Gdx.graphics.getWidth();
		this.bullets = bullets;
		init();
	}

	@Override
	public void init() {

		//Create the sprite with some texture
		sprite = new Sprite(new Texture(Gdx.files.internal(FILENAME)));

		//Set scalefactor
		setScale(0.4f);

		//Find the sprites dimensions.
		sWidth = sprite.getWidth()*SCALEFACTOR;
		sHeight = sprite.getHeight()*SCALEFACTOR;

		xCenter = xPos + sprite.getWidth()/2;
		yCenter = yPos + sprite.getHeight()/2;
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

		if(GameKeys.isPressed(GameKeys.SPACE)) {
			fire();
		}

		xCenter = xPos + sprite.getWidth()/2;
		yCenter = yPos + sprite.getHeight()/2;
		//Update position
		wrap();
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

	@Override
	public void setScale(float scaleFactor) {
		SCALEFACTOR = scaleFactor;
		sprite.setScale(SCALEFACTOR);
	}

	@Override
	public boolean checkHealthy() {
		return false;
	}

	/**
	 * Makes sure the players sprite may not move outside the window.
	 */
	public void wrap() {
		if(xCenter - sWidth / 2 < 0) {
			xCenter = 0 + sWidth/2;
			xPos = xCenter - sprite.getWidth()/2;
		}

		if(xCenter + sWidth/2> WIDTH) {
			xCenter = WIDTH - sWidth/2;
			xPos = xCenter - sprite.getWidth() / 2;
		}

		if(yCenter - sHeight / 2 < 0) {
			yCenter = 0 + sHeight/2;
			yPos = yCenter - sprite.getHeight()/2;
		}

		if(yCenter + sHeight/2 > HEIGHT) {
			yCenter = HEIGHT - sHeight/2;
			yPos = yCenter - sprite.getHeight()/2;
		}
		//Okay, so, since the scaling of the sprite doesn't change the boundingbox of it we must
		//manually find the center of the sprite and from that number derive the new edges (the visible edges).
	}

	private void fire() {
		bullets.add(new Bullet(xCenter, yCenter + sHeight / 2, 90));
	}
}
