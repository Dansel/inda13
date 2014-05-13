package com.me.Javaga.gamestate.levels;

import com.me.Javaga.spaceobject.Bullet;

/**
 * Created by Lukas on 2014-05-12.
 */
public enum BulletDescription {
	Type1(
			"bullet.png", // filename
			2f,//scale
			3, // speed
			2000,
			1,
			false
	),

	Type2(
			"bullet.png",
			4f,
			0.5f,
			3000,
			1,
			false
	),
	Type3(
			"bullet.png",
			1f,
			10,
			200,
			1,
			false
	),

	Type4(
			"missile.gif",
			1f,
			10,
			1000,
			10,
			true
	),

	Type5(
			"missile.gif",
			1.5f,
			3,
			3000,
			10,
			true
	);

	private String filename;
	private float scale;
	private float speed;
	private long time;
	private int damage;
	private boolean indestructable;

	private BulletDescription(String filename, float scale, float speed,
	                          long time, int damage, boolean indesctructable) {
		this.filename = filename;
		this.scale = scale;
		this.speed = speed;
		this.time = time;
		this.damage = damage;
		this.indestructable = indesctructable;
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

	public long getTime() {
		return this.time;
	}

	public int getDamage() {
		return this.damage;
	}

	public boolean isIndestructable() {
		return this.indestructable;
	}

	public static BulletDescription getType(int type) {
		if (type == 1) {
			return Type1;
		} else if (type == 2) {
			return Type2;
		} else if (type == 3) {
			return Type3;
		} else if (type == 4) {
			return Type4;
		} else if (type == 5) {
			return Type5;
		} else {
			return Type1;
		}
	}
}
