package com.me.Javaga.gamestate.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.me.Javaga.spaceobject.Bullet;

import java.util.ArrayList;

/**
 * Created by Lukas on 2014-05-12.
 */
public enum EnemyDescription {
	BIG_SNILSSON(
			"snilsson.png", // filename
			0.5f,
			1f,
			2f,
			60,
			BulletDescription.BULLETS,
			1,
			false
	),
	SNILSSON(
			"snilsson.png",
			0.3f,
			1f,
			0.5f,
			0,
			BulletDescription.BIG_BULLETS,
			1,
			false
	),
	UFO(
			"ufo.png",
			2f,
			1f,
			0.5f,
			60,
			BulletDescription.BULLETS,
			1,
			false
	),
	UFO2(
			"ufo2.png",
			1f,
			1f,
			5f,
			0,
			BulletDescription.FAST_BULLETS,
			1,
			false
	),
	SHIP_BOSS(
			"ufo.png",
			5f,
			0.9f,
			3f,
			0,
			BulletDescription.HUGE_MISSILES,
			20,
			true
	),
	SHIP_BOSS2(
			"Boss2.png",
			0.8f,
			0.9f,
			3f,
			0,
			BulletDescription.FAST_BULLETS,
			20,
			true
	),
	SHIP_BOSS3(
			"Boss3.png",
			0.8f,
			0.6f,
			0.5f,
			0,
			BulletDescription.MOTION_MISSILES,
			30,
			true
	),
	SHIP_BOSS4(
			"Boss4.png",
			1.5f,
			0.6f,
			0.2f,
			0,
			BulletDescription.MOTION_MISSILES,
			40,
			true
	),
	SHIELD_UFO(
			"shield.png",
			0.2f,
			0.8f,
			0.5f,
			0,
			BulletDescription.ENERGY_BLAST,
			20,
			false
	),
	SHIELD4(
			"shield.png",
			0.8f,
			0.8f,
			0.2f,
			0,
			BulletDescription.ENERGY_BLAST,
			50,
			true
	);

	private String filename;
	private float scale;
	private float hitBoxScale;
	private float speed;
	private float accuracy;
	private BulletDescription bulletType;
	private int health;
	private boolean isBoss;

	private EnemyDescription(String filename, float scale, float hitBoxScale,
	                         float speed, float accuracy, BulletDescription bulletType, int health, boolean isBoss) {
		this.filename = filename;
		this.scale = scale;
		this.hitBoxScale = hitBoxScale;
		this.speed = speed;
		this.accuracy = accuracy;
		this.bulletType = bulletType;
		this.health = health;
		this.isBoss = isBoss;
	}

	public String getFilename() {
		return this.filename;
	}

	public float getScale() {
		return this.scale;
	}

	public float getHitBoxScale() {
		return this.hitBoxScale;
	}

	public float getSpeed() {
		return this.speed;
	}


	public float getAccuracy() {
		return this.accuracy;
	}

	public int getHealth() {
		return this.health;
	}

	public BulletDescription getBulletType() {
		return this.bulletType;
	}

	public boolean isBoss() {
		return this.isBoss;
	}
}
