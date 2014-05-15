package com.me.Javaga.gamestate.levels;

/**
 * This enum contains a description of all enemy classes
 * Created by Lukas on 2014-05-12.
 */
public enum EnemyDescription {
	STANDARD_ENEMY(
			"evil1.png", // filename
			1f, // scale
			0.9f, // hitbox scale
			2f, // speed
			60, // accyracy
			BulletDescription.BULLETS, // bullet type
			1, // health
			false // is boss
	),
	BOMB_ENEMY(
			"evil1.png",
			1f,
			0.9f,
			0.5f,
			0,
			BulletDescription.BIG_BULLETS,
			1,
			false
	),
	HEAVY_ENEMY(
			"evil6.png",
			1.2f,
			0.9f,
			0.5f,
			60,
			BulletDescription.MISSILES,
			1,
			false
	),
	FAST_ENEMY(
			"evil6.png",
			1f,
			0.9f,
			5f,
			0,
			BulletDescription.FAST_BULLETS,
			1,
			false
	),
	BOSS1(
			"Boss2.png",
			1f,
			0.9f,
			3f,
			0,
			BulletDescription.FAST_BULLETS,
			20,
			true
	),
	BOSS2(
			"Boss3.png",
			0.8f,
			0.6f,
			0.5f,
			0,
			BulletDescription.MOTION_MISSILES,
			30,
			true
	),
	BOSS3(
			"Boss4.png",
			1f,
			1f,
			0.5f,
			0,
			BulletDescription.MOTION_MISSILES,
			40,
			true
	),
	BOSS4(
			"Boss5.png",
			1.5f,
			0.6f,
			0.5f,
			0,
			BulletDescription.MOTION_MISSILES,
			40,
			true
	),
	BOSS5(
			"snilsson.png",
			1.5f,
			1f,
			0.5f,
			0,
			BulletDescription.MOTION_MISSILES,
			50,
			true
	),
	STANDARD_SHIELD(
			"shield.png",
			0.8f,
			0.8f,
			2f, // speed
			60, // accyracy
			BulletDescription.ENERGY_BLAST, // bullet type
			2, // health
			false // is boss
	),
	HEAVY_SHIELD(
			"shield.png",
			0.8f,
			0.8f,
			0.5f,
			0,
			BulletDescription.ENERGY_BLAST,
			5,
			false
	),
	BOMB_SHIELD(
			"shield.png",
			0.8f,
			0.8f,
			0.5f,
			0,
			BulletDescription.ENERGY_BLAST,
			5,
			false
	),
	BOSS_SHIELD(
			"shield.png",
			3.5f,
			0.8f,
			0.5f,
			0,
			BulletDescription.ENERGY_BLAST,
			80,
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

	/**
	 * Create a description of an enemy type
	 *
	 * @param filename    The file name of the sprite for the enemy
	 * @param scale       A float specifying the scale of the sprite
	 * @param hitBoxScale A float specifying how the hitbox should be scaled(compared to the scaled sprite
	 * @param speed       The speed if the enemy
	 * @param accuracy    How accurate the enemys aiming should be, 0 is perfect and 360 is the worst
	 * @param bulletType  A bullet type
	 * @param health      How much healt the enemy should have
	 * @param isBoss      A boolean stating if the enemy is a boss or a normal enemy
	 */
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

	/**
	 * Get the file name of sprite file
	 *
	 * @return String filename
	 */
	public String getFilename() {
		return this.filename;
	}

	/**
	 * Get the scale of the enemy
	 *
	 * @return float scale
	 */
	public float getScale() {
		return this.scale;
	}


	/**
	 * Get the scale of the hitbox
	 *
	 * @return float hitbox scale
	 */
	public float getHitBoxScale() {
		return this.hitBoxScale;
	}

	/**
	 * Get the speed
	 *
	 * @return float speed
	 */
	public float getSpeed() {
		return this.speed;
	}


	/**
	 * Get the enemey accuracy
	 *
	 * @return float accuracy, 0 is perfect and 360 is horrible
	 */
	public float getAccuracy() {
		return this.accuracy;
	}

	/**
	 * Get the health this enemy type have
	 *
	 * @return int health
	 */
	public int getHealth() {
		return this.health;
	}

	/**
	 * The type of bullet this enemy type has, is specified in the BulletDescription enum
	 *
	 * @return A BulletDescription
	 */
	public BulletDescription getBulletType() {
		return this.bulletType;
	}

	/**
	 * States if the enemy is a boss or not
	 *
	 * @return True if the enemy type is a boss, otherwise false
	 */
	public boolean isBoss() {
		return this.isBoss;
	}
}
