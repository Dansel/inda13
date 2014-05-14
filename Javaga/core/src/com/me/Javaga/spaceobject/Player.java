package com.me.Javaga.spaceobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.gamestate.levels.BulletDescription;
import com.me.Javaga.managers.GameKeys;
import com.me.Javaga.managers.GameStateManager;
import com.me.Javaga.managers.InformationDrawer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class for the Players unit. Contains parameters for position as well as the sprite used to draw to canvas.
 * <p/>
 * Created by Dansel on 2014-04-30.
 */
public class Player extends SpaceObject {

	private static final String FILENAME = "ship.png";
	private static long time;
	//private float rotation;
	//private float scale;
	private ArrayList<Bullet> bullets;
	private Sound sound;
	private BulletDescription bulletType;
	private long shootLimit;

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
		health = 3;
		bulletType = BulletDescription.FAST_BULLETS;
		shootLimit = bulletType.getShootLimit();
		//Set scalefactor
		setScale(0.4f);
		spriteSetUp(FILENAME);
		hitbox.setHeight(sHeight * 0.3f).setWidth(sWidth * 0.3f).setCenter(xCenter, yCenter);
		//Create the sprite with some texture
		sound = Gdx.audio.newSound(Gdx.files.internal("lazer.mp3"));
	}

	/**
	 * Checks for keypresses and updates the sprite position
	 */
	@Override
	public void update() {
		if (!isHealthy) {
			hurt();
		}

		if (GameKeys.isDown(GameKeys.UP)) {
			yPos += 10;
		}
		if (GameKeys.isDown(GameKeys.DOWN)) {
			yPos -= 10;
		}
		if (GameKeys.isDown(GameKeys.LEFT)) {
			xPos -= 10;
		}
		if (GameKeys.isDown(GameKeys.RIGHT)) {
			xPos += 10;
		}

		if (GameKeys.isDown(GameKeys.SPACE)) {
			if (System.currentTimeMillis() - time > shootLimit) {
				time = System.currentTimeMillis();
				fire();
			}
		}

		xCenter = xPos + sprite.getWidth() / 2;
		yCenter = yPos + sprite.getHeight() / 2;
		//Update position
		wrap();
		sprite.setX(xPos);
		sprite.setY(yPos);
		//Update hitbox
		hitbox.setCenter(xCenter, yCenter);
		InformationDrawer.setRemainingLife(health - 1);
	}

	@Override
	public boolean checkForCollision(ArrayList<Bullet> enemyBullets) {
		Iterator<Bullet> iterator = enemyBullets.iterator();
		while (iterator.hasNext()) {
			Bullet bullet = iterator.next();
			if (overlap(bullet)) {
				health--;
				isHealthy = false;
				if (!bullet.isIndestructable() || health > 0) {
					bullet.dispose();
					iterator.remove();
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Makes sure the players sprite may not move outside the window.
	 */
	public void wrap() {
		if (xCenter - sWidth / 2 < 0) {
			xCenter = 0 + sWidth / 2;
			xPos = xCenter - sprite.getWidth() / 2;
		}

		if (xCenter + sWidth / 2 > WIDTH) {
			xCenter = WIDTH - sWidth / 2;
			xPos = xCenter - sprite.getWidth() / 2;
		}

		if (yCenter - sHeight / 2 < 0) {
			yCenter = 0 + sHeight / 2;
			yPos = yCenter - sprite.getHeight() / 2;
		}

		if (yCenter + sHeight / 2 > HEIGHT) {
			yCenter = HEIGHT - sHeight / 2;
			yPos = yCenter - sprite.getHeight() / 2;
		}
		//Okay, so, since the scaling of the sprite doesn't change the boundingbox of it we must
		//manually find the center of the sprite and from that number derive the new edges (the visible edges).
	}

	/**
	 * Fire a bullet straight forward
	 */
	private void fire() {
		sound.play(GameStateManager.getEffectVolume()); // play lazer
		bullets.add(new Bullet(xCenter, yCenter + sWidth / 2, 90, bulletType));
	}


	/**
	 * Reset the players health
	 */
	public void resetHealth() {
		this.health = 3;
	}

	@Override
	public void dispose() {
		super.dispose();
		sound.dispose();
	}
}

