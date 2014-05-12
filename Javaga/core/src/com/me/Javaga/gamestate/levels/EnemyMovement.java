package com.me.Javaga.gamestate.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

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
			}
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
			}
	);

	private Vector2 startCoordinate;
	private Vector2 startDirection;
	private Vector2[] coordinates;


	private EnemyMovement(Vector2 startCoordinates, Vector2 startDirection,
	                      Vector2[] cordinates) {
		this.startCoordinate = startCoordinates;
		this.startDirection = startDirection;
		this.coordinates = cordinates;

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

	public static EnemyMovement getType(int type) {
		if (type == 1) {
			return Type1;
		} else if (type == 2) {
			return Type2;
		} else {
			return Type1;
		}
	}
}
