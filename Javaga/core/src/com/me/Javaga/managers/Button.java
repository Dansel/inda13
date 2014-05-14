package com.me.Javaga.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * A button which reacts to user input
 * Created by Lukas on 2014-05-06.
 */
public class Button {


	protected float xPos;
	protected float yPos;
	protected Sprite sprite;
	protected GameStateManager gameStateManager;
	protected Rectangle rectangle;
	protected boolean initialized;

	protected float HEIGHT;
	protected float WIDTH;

	protected float sWidth;
	protected float sHeight;

	protected float xCenter;
	protected float yCenter;

	protected float SCALEFACTOR;

	public Button(float xPos, float yPos, GameStateManager gameStateManager) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.gameStateManager = gameStateManager;
	}

	/**
	 * Set the sprite of button, this method should be overriden when a button object is created
	 *
	 * @param filename
	 */
	//Should be overriden by all objects
	public void setSprite(String filename) {
		sprite = new Sprite(new Texture(Gdx.files.internal(filename)));
		init();
	}

	/**
	 * Initialize all fields and components
	 */
	public void init() {
		// Does the usuall initializations
		if (sprite != null) {
			setScale(1f); // If we want to scale
			sWidth = sprite.getWidth() * SCALEFACTOR;
			sHeight = sprite.getHeight() * SCALEFACTOR;

			//shift position down and to the left so we draw the sprite centered.
			xPos -= sprite.getWidth() / 2;
			yPos -= sprite.getHeight() / 2;

			xCenter = xPos + sprite.getWidth() / 2;
			yCenter = yPos + sprite.getHeight() / 2;

			rectangle = new Rectangle();
			rectangle.setHeight(sHeight).setWidth(sWidth).setCenter(xCenter, yCenter);

			sprite.setX(xPos);
			sprite.setY(yPos);
		}
	}

	/**
	 * Preform an action of some sort when the button is pressed,
	 * this method should be overriden and implemented when a button
	 * object is created and added to a buttonContainer
	 */
	public void preformAction() {
		// Overide this in all objects
	}

	/**
	 * Check if the mouse is hovering over the mouse
	 *
	 * @return true if the button is hovering over the button
	 */
	public boolean isHovering() {
		return rectangle.contains((float) GameKeys.xMouse(), (float) GameKeys.yMouse());
	}

	public void setSelected(boolean selected) {
		if (selected) {
			sprite.setColor(Color.BLUE);
		} else {
			sprite.setColor(Color.WHITE);
		}
	}

	/**
	 * Set the scale of the button
	 *
	 * @param scaleFactor
	 */
	public void setScale(float scaleFactor) {
		SCALEFACTOR = scaleFactor;
		sprite.setScale(SCALEFACTOR);
	}

	/**
	 * Draw the button onto the canvas
	 *
	 * @param batch
	 */
	public void draw(SpriteBatch batch) {
		if (sprite != null) {
			sprite.draw(batch);
		}
	}

	/**
	 * Dispose the button properly when it isn't used anymore
	 */
	public void dispose() {
		sprite.getTexture().dispose();
	}

}
