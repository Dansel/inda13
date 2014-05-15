package com.me.Javaga.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Draws information for the player onto the screen
 * Created by Lukas on 2014-05-14.
 */
public class InformationDrawer {

	private static final String FILENAME = "ship.png";
	private static Sprite sprite;
	private static BitmapFont font;
	private static float spriteWidth;
	private static float remainingLife;
	private static int currentLevel;
	private static long points;
	private static long time;
	private static boolean showInfo;

	static {
		remainingLife = 3;
		currentLevel = 1;
		points = 0;
		sprite = new Sprite(new Texture(Gdx.files.internal(FILENAME)));
		sprite.setScale(0.2f);
		spriteWidth = sprite.getWidth() * 0.2f;
		font = new BitmapFont(Gdx.files.internal("white.fnt"), Gdx.files.internal("white_0.png"), false);
		font.setScale(0.6f);
	}

	/**
	 * Update the information drawer
	 */
	public static void update() {
		if (showInfo) {
			if (System.currentTimeMillis() - time > 10000) {
				showInfo = false;
			}
		}
		handleInput();
	}

	/**
	 * Draw the information to the canvas, this
	 * method should probably be called last of
	 * all draw method sense this should be in the foreground
	 *
	 * @param batch A SpriteBatch
	 */
	public static void draw(SpriteBatch batch) {
		sprite.setY(-sprite.getHeight() / 2 + 20);
		for (float i = 0, x = -sprite.getWidth() / 2 + 20; i < remainingLife; i++) {
			sprite.setX(x);
			sprite.draw(batch);
			x += spriteWidth;
		}

		font.draw(batch, "Points: " + Long.toString(points), 0, 120);
		font.draw(batch, "Current Level: " + Integer.toString(currentLevel), 0, 100);

		if (showInfo) {
			font.draw(batch, "Use the arrow keys to navigate", Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 3 + 40);
			font.draw(batch, "   Use the space key to fire  ", Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 3 + 20);
			font.draw(batch, "      Try to survive!!!       ", Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 3);

		}
	}

	/**
	 * Set the players remaining lifes
	 *
	 * @param life An int stating the amount of lifes the player have left
	 */
	public static void setRemainingLife(float life) {
		remainingLife = life;
	}

	/**
	 * Set the current level of the game
	 *
	 * @param level current level number
	 */
	public static void setCurretLevel(int level) {
		currentLevel = level;
	}

	/**
	 * Add more point to the players score
	 *
	 * @param point Number of points
	 */
	public static void updatePoints(int point) {
		points += point;
	}

	/**
	 * Reset all the fields
	 */
	public static void reset() {
		points = 0;
		currentLevel = 1;
		remainingLife = 2;
	}

	public static void showInfo() {
		showInfo = true;
		time = System.currentTimeMillis();
	}

	public static void handleInput() {
		if (showInfo) {
			if (GameKeys.isPressed(GameKeys.ENTER) || GameKeys.isPressed(GameKeys.H)) {
				showInfo = false;
			}
		} else if (GameKeys.isPressed(GameKeys.H)) {
			showInfo = true;
			time = System.currentTimeMillis();
		}
	}


}
