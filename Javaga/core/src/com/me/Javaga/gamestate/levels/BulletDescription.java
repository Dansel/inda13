package com.me.Javaga.gamestate.levels;

import com.me.Javaga.spaceobject.Bullet;

/**
 * Created by Lukas on 2014-05-12.
 */
public enum BulletDescription {
	BULLETS(
			"bullet.png", // filename
			2f,//scale
			3, // speed
			2000, // shootlimit in millisecond
			10000, //life time in millseconds
			1, // damage
			false, // indesctructable
			false // motion seeker
	),

	BIG_BULLETS(
			"bullet.png",
			4f,
			0.5f,
			3000,
			5000,
			1,
			false,
			false
	),
	SMALL_BULLETS(
			"bullet.png",
			1f,
			10,
			200,
			3000,
			1,
			false,
			false
	),

	MISSILES(
			"missile.gif",
			1f,
			10,
			1000,
			10000,
			10,
			true,
			false
	),

	HUGE_MISSILES(
			"missile.gif",
			1.5f,
			3,
			3000,
			10000,
			10,
			true,
			false
	),

	MOTION_MISSILES(
			"missile.gif",
			1f,
			8f,
			2000,
			5000,
			3,
			true,
			true
	),
	FAST_BULLETS(
			"bullet.png",
			2f,
			10,
			20,
			3000,
			0.1f,
			false,
			false
	);

	private String filename;
	private float scale;
	private float speed;
	private long shootLimit;
	private long lifeTime;
	private float damage;
	private boolean indestructable;
	private boolean motionSeeker;

	private BulletDescription(String filename, float scale, float speed,
	                          long shootLimit, long lifeTime, float damage, boolean indesctructable, boolean motionSeeker) {
		this.filename = filename;
		this.scale = scale;
		this.speed = speed;
		this.shootLimit = shootLimit;
		this.lifeTime = lifeTime;
		this.damage = damage;
		this.indestructable = indesctructable;
		this.motionSeeker = motionSeeker;
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

	public long getShootLimit() {
		return this.shootLimit;
	}

	public long getLifeTime() {
		return this.lifeTime;
	}

	public float getDamage() {
		return this.damage;
	}

	public boolean isIndestructable() {
		return this.indestructable;
	}

	public boolean isMotionSeeker() {
		return this.motionSeeker;
	}

}