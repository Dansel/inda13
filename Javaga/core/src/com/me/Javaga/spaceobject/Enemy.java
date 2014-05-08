package com.me.Javaga.spaceobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.managers.GameStateManager;

import java.util.ArrayList;

/**
 * Create object of this class to spawn enemies.
 * Created by Dansel on 2014-05-02.
 */
public class Enemy extends SpaceObject {
	private static String FILENAME;
	private ArrayList<Bullet> enemyBullets;
	private Sound sound;
	private Player player;
	private long time;

	public Enemy(float xPos, float yPos, int type,
	             ArrayList<Bullet> enemyBullets, Player player) {
		super(xPos, yPos);
		HEIGHT = Gdx.graphics.getHeight();
		WIDTH = Gdx.graphics.getWidth();
		FILENAME = "sprite" + type + ".png";
		this.enemyBullets = enemyBullets;
		this.player = player;
		this.time = System.currentTimeMillis();
		init();
	}

	@Override
	public void init() {
		setScale(1);
		spriteSetUp(FILENAME);
		dX = 4;
		sound = Gdx.audio.newSound(Gdx.files.internal("lazer.mp3"));
	}

	@Override
	public void update() {
		xPos += dX;
		sprite.setX(xPos);
		xCenter = xPos + sprite.getWidth() / 2;
		wrap();
		hitbox.setCenter(xCenter, yCenter);
		if (System.currentTimeMillis() - time > 1000) {
			fire();
			time = System.currentTimeMillis();
		}
	}

	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}

	@Override
	public void wrap() {
		if (xPos > WIDTH * 0.8f || xPos < WIDTH * 0.2f) {
			dX = -dX;
		}
	}

	@Override
	public boolean checkHealthy() {
		return isHealthy;
	}

	@Override
	public boolean checkForCollision(ArrayList<Bullet> bullets) {
		for (Bullet bullet : bullets) {
			if (overlap(bullet)) {
				System.out.println("COLLISION!");
				return true;
			}
		}
		return false;
	}

	public void fire() {
		float dX = xCenter - player.getX();
		float dY = yCenter - player.getY();

		if (yCenter - player.getY() >= 0) {
			double radian = Math.atan(dX / dY);
			float degree = (float) (270 - Math.toDegrees(radian));
			sound.play(GameStateManager.getEffectVolume()); // play lazer
			enemyBullets.add(new Bullet(xCenter, yCenter - sHeight / 2, degree));
		}
	}
}
