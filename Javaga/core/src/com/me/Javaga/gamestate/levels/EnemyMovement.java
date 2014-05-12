package com.me.Javaga.gamestate.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Lukas on 2014-05-12.
 */
public enum EnemyMovement {
	Type1(new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() + 100),

			new Vector2(0, -1),

			new Vector2[]{
					new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2),
					new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 - 100),
					new Vector2(Gdx.graphics.getWidth() / 2 + 100, Gdx.graphics.getHeight() / 2 - 100),
					new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 - 100),
					new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 100),
					new Vector2(Gdx.graphics.getWidth() / 2, -100),
			},
			3
	),
	Type2(new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 100),

			new Vector2(0, 0),

			new Vector2[]{
					new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2),
					new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 - 100),
					new Vector2(Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 - 100),
					new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 - 100),
					new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 100),
					new Vector2(Gdx.graphics.getWidth() / 2, -100),
			},
			3
	);

	private Vector2 startCoordinate;
	private Vector2 startDirection;
	private Vector2[] coordinates;
	private float speed;

	private EnemyMovement(Vector2 startCoordinates, Vector2 startDirection,
	                      Vector2[] cordinates, float speed) {
		this.startCoordinate = startCoordinates;
		this.startDirection = startDirection;
		this.coordinates = cordinates;
		this.speed = speed;
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

	public float getSpeed() {
		return this.speed;
	}
}
