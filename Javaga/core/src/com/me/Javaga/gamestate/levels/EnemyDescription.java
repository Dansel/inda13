package com.me.Javaga.gamestate.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Lukas on 2014-05-12.
 */
public enum EnemyDescription {
	Type1(
			"snilsson.png",
			0.5f,
			3,
			15,
			1
	),
	Type2(
			"snilsson.png",
			0.3f,
			0.1f,
			0,
			2
	),
	Type3(
			"ufo.png",
			2f,
			0.5f,
			60,
			3
	);


	private String filename;
	private float speed;
	private float scale;
	private float accuracy;
	private int bulletType;

	private EnemyDescription(String filename, float scale,
	                         float speed, float accuracy, int bulletType) {
		this.filename = filename;
		this.scale = scale;
		this.speed = speed;
		this.accuracy = accuracy;
		this.bulletType = bulletType;
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

	public int getBulletType() {
		return this.bulletType;
	}

	public static EnemyDescription getType(int type) {
		if (type == 1) {
			return Type1;
		} else if (type == 2) {
			return Type2;
		} else if (type == 3) {
			return Type3;
		} else {
			return Type1;
		}
	}
}
