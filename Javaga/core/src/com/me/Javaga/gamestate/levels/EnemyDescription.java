package com.me.Javaga.gamestate.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Lukas on 2014-05-12.
 */
public enum EnemyDescription {
	Type1(
			"snilsson.png", // filename
			0.5f, //scale
			1, //speed
			15, //accuracy
			1, //bullet type
			2,
			false
	),
	Type2(
			"snilsson.png",
			0.3f,
			0.1f,
			0,
			2,
			1,
			false
	),
	Type3(
			"ufo.png",
			2f,
			0.5f,
			60,
			2,
			1,
			false
	),
	Type4(
			"ufo.png",
			5f,
			0.5f,
			0,
			5,
			20,
			true
	);


	private String filename;
	private float speed;
	private float scale;
	private float accuracy;
	private int bulletType;
	private int health;
	private boolean isBoss;

	private EnemyDescription(String filename, float scale,
	                         float speed, float accuracy, int bulletType, int health, boolean isBoss) {
		this.filename = filename;
		this.scale = scale;
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

	public float getSpeed() {
		return this.speed;
	}


	public float getAccuracy() {
		return this.accuracy;
	}

	public int getHealth() {
		return this.health;
	}

	public int getBulletType() {
		return this.bulletType;
	}

	public boolean isBoss() {
		return this.isBoss;
	}

	public static EnemyDescription getType(int type) {
		if (type == 1) {
			return Type1;
		} else if (type == 2) {
			return Type2;
		} else if (type == 3) {
			return Type3;
		} else if (type == 4) {
			return Type4;
		} else {
			return Type1;
		}
	}

	public static boolean isBoss(int type) {
		if (type == 1) {
			return Type1.isBoss();
		} else if (type == 2) {
			return Type2.isBoss();
		} else if (type == 3) {
			return Type3.isBoss();
		} else if (type == 4) {
			return Type4.isBoss();
		} else {
			return Type1.isBoss();
		}
	}
}
