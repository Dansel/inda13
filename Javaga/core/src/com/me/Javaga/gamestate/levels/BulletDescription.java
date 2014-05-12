package com.me.Javaga.gamestate.levels;

import com.me.Javaga.spaceobject.Bullet;

/**
 * Created by Lukas on 2014-05-12.
 */
public enum BulletDescription {
	Type1(
			"bullet.png",
			3f,
			10,
			200,
			false
	),

	Type2(
			"bullet.png",
			5f,
			5,
			1000,
			false
	),

	Type3(
			"missile.gif",
			1f,
			10,
			1000,
			true
	);

	private String filename;
	private float scale;
	private float speed;
	private long time;
	private boolean indestructable;

	private BulletDescription(String filename, float scale, float speed,
	                          long time, boolean indesctructable) {
		this.filename = filename;
		this.scale = scale;
		this.speed = speed;
		this.time = time;
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
		} else {
			return Type1;
		}
	}
}
