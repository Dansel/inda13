package com.me.Javaga.gamestate.levels;

/**
 * Created by Dansel on 2014-05-05.
 */
public enum Level {

	LEVEL1(
			new StageDescription[]{
					new StageDescription(true, 10),
					new StageDescription(EnemyDescription.SHIP_BOSS4,
							EnemyMovement.MOVEMENT5, 1, -1),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT1, 3, -1),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT3, 3, 0),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT4, 5, 10),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT3, 3, 0),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT4, 3, -1),
					new StageDescription(EnemyDescription.BIG_SNILSSON,
							EnemyMovement.MOVEMENT3, 5, 0),
					new StageDescription(EnemyDescription.BIG_SNILSSON,
							EnemyMovement.MOVEMENT4, 5, 10),
					new StageDescription(EnemyDescription.SHIP_BOSS,
							EnemyMovement.MOVEMENT5, 1, -1)
			}
	),
	LEVEL2(
			new StageDescription[]{new StageDescription(EnemyDescription.UFO,
					EnemyMovement.MOVEMENT1, 5, 10),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT3, 5, 0),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT4, 5, -1),
					new StageDescription(EnemyDescription.SNILSSON,
							EnemyMovement.MOVEMENT1, 3, 0),
					new StageDescription(EnemyDescription.SNILSSON,
							EnemyMovement.MOVEMENT3, 3, 0),
					new StageDescription(EnemyDescription.SNILSSON,
							EnemyMovement.MOVEMENT4, 3, -1),
					new StageDescription(EnemyDescription.BIG_SNILSSON,
							EnemyMovement.MOVEMENT1, 3, 0),
					new StageDescription(EnemyDescription.BIG_SNILSSON,
							EnemyMovement.MOVEMENT3, 3, 0),
					new StageDescription(EnemyDescription.BIG_SNILSSON,
							EnemyMovement.MOVEMENT4, 3, -1),
					new StageDescription(EnemyDescription.SHIP_BOSS3,
							EnemyMovement.MOVEMENT1, 1, -1)
			}
	),
	LEVEL3(
			new StageDescription[]{new StageDescription(EnemyDescription.UFO,
					EnemyMovement.MOVEMENT1, 5, 10),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT3, 5, 0),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT4, 5, -1),
					new StageDescription(EnemyDescription.SNILSSON,
							EnemyMovement.MOVEMENT1, 3, 0),
					new StageDescription(EnemyDescription.SNILSSON,
							EnemyMovement.MOVEMENT3, 3, 0),
					new StageDescription(EnemyDescription.SNILSSON,
							EnemyMovement.MOVEMENT4, 3, -1),
					new StageDescription(EnemyDescription.BIG_SNILSSON,
							EnemyMovement.MOVEMENT1, 3, 0),
					new StageDescription(EnemyDescription.BIG_SNILSSON,
							EnemyMovement.MOVEMENT3, 3, 0),
					new StageDescription(EnemyDescription.BIG_SNILSSON,
							EnemyMovement.MOVEMENT4, 3, -1),
					new StageDescription(EnemyDescription.SHIP_BOSS3,
							EnemyMovement.MOVEMENT1, 1, -1)
			}
	),
	LEVEL4(
			new StageDescription[]{new StageDescription(EnemyDescription.UFO,
					EnemyMovement.MOVEMENT5, 5, 10),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT3, 5, 0),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT4, 5, -1),
					new StageDescription(EnemyDescription.SNILSSON,
							EnemyMovement.MOVEMENT1, 3, 0),
					new StageDescription(EnemyDescription.SNILSSON,
							EnemyMovement.MOVEMENT3, 3, 0),
					new StageDescription(EnemyDescription.SNILSSON,
							EnemyMovement.MOVEMENT4, 3, -1),
					new StageDescription(EnemyDescription.BIG_SNILSSON,
							EnemyMovement.MOVEMENT1, 3, 0),
					new StageDescription(EnemyDescription.BIG_SNILSSON,
							EnemyMovement.MOVEMENT3, 3, 0),
					new StageDescription(EnemyDescription.BIG_SNILSSON,
							EnemyMovement.MOVEMENT4, 3, -1),
					new StageDescription(EnemyDescription.SHIP_BOSS3,
							EnemyMovement.MOVEMENT1, 1, -1)
			}
	),
	LEVEL5(
			new StageDescription[]{new StageDescription(EnemyDescription.UFO,
					EnemyMovement.MOVEMENT5, 5, 10),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT3, 5, 0),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT4, 5, -1),
					new StageDescription(EnemyDescription.SNILSSON,
							EnemyMovement.MOVEMENT1, 3, 0),
					new StageDescription(EnemyDescription.SNILSSON,
							EnemyMovement.MOVEMENT3, 3, 0),
					new StageDescription(EnemyDescription.SNILSSON,
							EnemyMovement.MOVEMENT4, 3, -1),
					new StageDescription(EnemyDescription.BIG_SNILSSON,
							EnemyMovement.MOVEMENT1, 3, 0),
					new StageDescription(EnemyDescription.BIG_SNILSSON,
							EnemyMovement.MOVEMENT3, 3, 0),
					new StageDescription(EnemyDescription.BIG_SNILSSON,
							EnemyMovement.MOVEMENT4, 3, -1),
					new StageDescription(EnemyDescription.SHIP_BOSS3,
							EnemyMovement.MOVEMENT1, 1, -1)
			}
	);

	private StageDescription[] stages;
	public static final int NUMBER_OF_LEVELS = 5;

	private Level(StageDescription[] stages) {
		this.stages = stages;
	}

	public static class StageDescription {
		private EnemyDescription enemyType;
		private EnemyMovement movementType;
		private int numberOfEnemies;
		private int time;
		private boolean gameOver;
		private boolean rest;

		public StageDescription(EnemyDescription enemyType, EnemyMovement movementType,
		                        int numberOfEnemies, int time) {
			this.enemyType = enemyType;
			this.movementType = movementType;
			this.numberOfEnemies = numberOfEnemies;
			this.time = time;
		}


		public StageDescription(boolean gameOver) {
			this.gameOver = gameOver;
		}

		public StageDescription(boolean rest, int time) {
			this.rest = rest;
			this.time = time;
		}

		public EnemyDescription getEnemyType() {
			return this.enemyType;
		}

		public EnemyMovement getMovementType() {
			return this.movementType;
		}

		public int getNumberOfEnemies() {
			return this.numberOfEnemies;
		}

		public boolean isGameOver() {
			return this.gameOver;
		}

		public boolean rest() {
			return this.rest;
		}

		public int time() {
			return this.time;
		}

	}

	public static Level getLevel(int level) {
		if (level == 1) {
			return LEVEL1;
		} else if (level == 2) {
			return LEVEL2;
		} else if (level == 3) {
			return LEVEL3;
		} else if (level == 4) {
			return LEVEL4;
		} else if (level == 5) {
			return LEVEL5;
		} else {
			return LEVEL1;
		}
	}

	public StageDescription getStage(int index) {
		return stages[index];
	}

	public int getLevelLenght() {
		return stages.length;
	}
}

