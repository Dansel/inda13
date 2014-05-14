package com.me.Javaga.gamestate.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Lukas on 2014-05-12.
 */
public enum EnemyMovement {
	MOVEMENT1(
			new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() + 100), // startposition

			new Vector2(0, -1), // start direction

			new Vector2[]{ // Coordinates
					new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2),
					new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 - 100),
					new Vector2(Gdx.graphics.getWidth() / 2 + 100, Gdx.graphics.getHeight() / 2 - 100),
					new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 - 100),
					new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 100),
					new Vector2(Gdx.graphics.getWidth() / 2, -100),
			},

			0, // dY
			Gdx.graphics.getWidth() //dX
	),
	MOVEMENT2(
			new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 100),

			new Vector2(0, 0),

			new Vector2[]{
					new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2),
					new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 - 100),
					new Vector2(Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 - 100),
					new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 - 100),
					new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 100),
					new Vector2(Gdx.graphics.getWidth() / 2, -100),
			},
			0,
			Gdx.graphics.getWidth()
	),
	MOVEMENT3(
			new Vector2(-20, Gdx.graphics.getHeight() / 2),

			new Vector2(0, 0),

			new Vector2[]{
					new Vector2(Gdx.graphics.getWidth() / 2 - 50, Gdx.graphics.getHeight() / 2),
					new Vector2(Gdx.graphics.getWidth() / 2 - 50, Gdx.graphics.getHeight() / 4),
					new Vector2(Gdx.graphics.getWidth() + 100, Gdx.graphics.getHeight() / 4)
			},

			Gdx.graphics.getHeight() / 2,
			0
	),

	MOVEMENT4(
			new Vector2(Gdx.graphics.getWidth() + 20, 3 * Gdx.graphics.getHeight() / 4),

			new Vector2(0, 0),

			new Vector2[]{
					new Vector2(Gdx.graphics.getWidth() / 2 + 50, 3 * Gdx.graphics.getHeight() / 4),
					new Vector2(Gdx.graphics.getWidth() / 2 + 50, 2 * Gdx.graphics.getHeight() / 4),
					new Vector2(-100, 2 * Gdx.graphics.getHeight() / 4)
			},

			Gdx.graphics.getHeight() / 2,
			0
	),
	MOVEMENT5(
			new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() + 200),

			new Vector2(0, 0),

			new Vector2[]{
					new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() - 20),
					new Vector2(Gdx.graphics.getWidth() - 20, Gdx.graphics.getHeight() / 2),
					new Vector2(Gdx.graphics.getWidth() / 2, 20),
					new Vector2(20, Gdx.graphics.getHeight() / 2)
			},

			Gdx.graphics.getHeight() / 2,
			Gdx.graphics.getWidth() / 2
	),
	MOVEMENT6(
			new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() + 200),

			new Vector2(0, 0),

			new Vector2[]{
					new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 100),
					new Vector2(Gdx.graphics.getWidth() / 2 + 100, Gdx.graphics.getHeight() / 2 + 100),
					new Vector2(Gdx.graphics.getWidth() / 2 + 100, Gdx.graphics.getHeight() / 2 - 100),
					new Vector2(Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 - 100),
					new Vector2(Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 + 100),
			},

			0,
			Gdx.graphics.getWidth() / 2
	),
	MOVEMENT7(
			new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() + 200),

			new Vector2(0, 0),

			new Vector2[]{
					new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 100),
					new Vector2(Gdx.graphics.getWidth() / 2 + 100, Gdx.graphics.getHeight() / 2 + 100),
					new Vector2(Gdx.graphics.getWidth() / 2 + 100, Gdx.graphics.getHeight() / 2 - 100),
					new Vector2(Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 - 100),
					new Vector2(Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 + 100),
					new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() + 200)
			},

			0,
			Gdx.graphics.getWidth() / 2
	);


	private Vector2 startCoordinate;
	private Vector2 startDirection;
	private Vector2[] coordinates;
	private float dY;
	private float dX;


	private EnemyMovement(Vector2 startCoordinates, Vector2 startDirection,
	                      Vector2[] coordinates, float dY, float dX) {
		this.startCoordinate = startCoordinates;
		this.startDirection = startDirection;
		this.coordinates = coordinates;
		this.dY = dY;
		this.dX = dX;

	}

	public Vector2[] getCoordinates() {
		return this.coordinates;
	}

	public Vector2 getStartCoordinate() {
		return this.startCoordinate;
	}

	public Vector2 getStartDirection() {
		return this.startDirection;
	}

	public float getdY() {
		return this.dY;
	}

	public float getdX() {
		return this.dX;
	}

}
