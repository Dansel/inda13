package com.me.Javaga.gamestate.levels;

/**
 * The enum contains a description of all the levels and all the different stages in the game
 * Created by Dansel on 2014-05-05.
 */
public enum Level {

	LEVEL1(
			new StageDescription[]{
					new StageDescription(true, 10),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT1, 3, -1),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT8, 3, 0),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT9, 3, -1),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT3, 5, 0),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT4, 5, -1),
					new StageDescription(EnemyDescription.BIG_SNILSSON,
							EnemyMovement.MOVEMENT8, 5, 0),
					new StageDescription(EnemyDescription.BIG_SNILSSON,
							EnemyMovement.MOVEMENT9, 5, 10),
					new StageDescription(EnemyDescription.SHIP_BOSS,
							EnemyMovement.MOVEMENT7, 1, -1)
			}
	),
	LEVEL2(
			new StageDescription[]{new StageDescription(EnemyDescription.UFO2,
					EnemyMovement.MOVEMENT7, 1, 20),
					new StageDescription(EnemyDescription.UFO2,
							EnemyMovement.MOVEMENT8, 1, 20),
					new StageDescription(EnemyDescription.UFO2,
							EnemyMovement.MOVEMENT9, 1, -1),
					new StageDescription(EnemyDescription.SNILSSON,
							EnemyMovement.MOVEMENT1, 3, 0),
					new StageDescription(EnemyDescription.SNILSSON,
							EnemyMovement.MOVEMENT3, 3, 0),
					new StageDescription(EnemyDescription.SNILSSON,
							EnemyMovement.MOVEMENT4, 3, -1),
					new StageDescription(EnemyDescription.UFO2,
							EnemyMovement.MOVEMENT7, 1, 5),
					new StageDescription(EnemyDescription.UFO2,
							EnemyMovement.MOVEMENT3, 1, 3),
					new StageDescription(EnemyDescription.UFO2,
							EnemyMovement.MOVEMENT4, 1, -1),
					new StageDescription(EnemyDescription.BIG_SNILSSON,
							EnemyMovement.MOVEMENT1, 3, 0),
					new StageDescription(EnemyDescription.BIG_SNILSSON,
							EnemyMovement.MOVEMENT3, 3, 0),
					new StageDescription(EnemyDescription.BIG_SNILSSON,
							EnemyMovement.MOVEMENT4, 3, -1),
					new StageDescription(EnemyDescription.UFO2,
							EnemyMovement.MOVEMENT3, 1, 0),
					new StageDescription(EnemyDescription.UFO2,
							EnemyMovement.MOVEMENT4, 1, -1),
					new StageDescription(EnemyDescription.SHIP_BOSS2,
							EnemyMovement.MOVEMENT6, 1, -1)
			}
	),
	LEVEL3(
			new StageDescription[]{new StageDescription(EnemyDescription.UFO,
					EnemyMovement.MOVEMENT1, 1, 2),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT1, 3, 2),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT1, 5, 2),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT1, 7, 2),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT1, 9, -1),
					new StageDescription(EnemyDescription.SNILSSON,
							EnemyMovement.MOVEMENT1, 1, 2),
					new StageDescription(EnemyDescription.SNILSSON,
							EnemyMovement.MOVEMENT1, 3, 2),
					new StageDescription(EnemyDescription.SNILSSON,
							EnemyMovement.MOVEMENT1, 5, 2),
					new StageDescription(EnemyDescription.SNILSSON,
							EnemyMovement.MOVEMENT1, 7, 2),
					new StageDescription(EnemyDescription.SNILSSON,
							EnemyMovement.MOVEMENT1, 9, -1),
					new StageDescription(EnemyDescription.UFO2,
							EnemyMovement.MOVEMENT8, 2, 10),
					new StageDescription(EnemyDescription.UFO2,
							EnemyMovement.MOVEMENT9, 2, 10),
					new StageDescription(EnemyDescription.BIG_SNILSSON,
							EnemyMovement.MOVEMENT1, 10, -1),
					new StageDescription(EnemyDescription.SHIP_BOSS3,
							EnemyMovement.MOVEMENT6, 1, -1)
			}
	),
	LEVEL4(
			new StageDescription[]{
					new StageDescription(EnemyDescription.SHIELD_UFO,
							EnemyMovement.MOVEMENT1, 1, 0),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT1, 1, 2),
					new StageDescription(EnemyDescription.SHIELD_UFO,
							EnemyMovement.MOVEMENT1, 3, 0),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT1, 3, 2),
					new StageDescription(EnemyDescription.SHIELD_UFO,
							EnemyMovement.MOVEMENT1, 5, 0),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT1, 5, 2),
					new StageDescription(EnemyDescription.SHIELD_UFO,
							EnemyMovement.MOVEMENT1, 7, 0),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT1, 7, 30),
					new StageDescription(EnemyDescription.UFO2,
							EnemyMovement.MOVEMENT10, 1, 10),
					new StageDescription(EnemyDescription.UFO2,
							EnemyMovement.MOVEMENT10, 2, 0),
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
			new StageDescription[]{
					new StageDescription(EnemyDescription.SHIELD_UFO,
							EnemyMovement.MOVEMENT8, 1, 0),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT8, 1, 0),
					new StageDescription(EnemyDescription.SHIELD_UFO,
							EnemyMovement.MOVEMENT9, 1, 0),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT9, 1, 20),
					new StageDescription(EnemyDescription.SHIELD_UFO,
							EnemyMovement.MOVEMENT8, 3, 0),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT8, 3, 0),
					new StageDescription(EnemyDescription.SHIELD_UFO,
							EnemyMovement.MOVEMENT9, 3, 0),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT9, 3, 20),
					new StageDescription(EnemyDescription.SHIELD_UFO,
							EnemyMovement.MOVEMENT8, 5, 0),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT8, 5, 0),
					new StageDescription(EnemyDescription.SHIELD_UFO,
							EnemyMovement.MOVEMENT9, 5, 0),
					new StageDescription(EnemyDescription.UFO,
							EnemyMovement.MOVEMENT9, 5, 20),
					new StageDescription(EnemyDescription.SHIELD5,
							EnemyMovement.MOVEMENT6, 1, 0),
					new StageDescription(EnemyDescription.SHIELD5,
							EnemyMovement.MOVEMENT6, 1, 0),
					new StageDescription(EnemyDescription.SHIP_BOSS5,
							EnemyMovement.MOVEMENT6, 1, -1)
			}
	);

	private StageDescription[] stages;
	public static final int NUMBER_OF_LEVELS = 5;

	/**
	 * @param stages an array consisting of stageDescriptiont which describes the level
	 */
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

		/**
		 * @param enemyType       An EnemyDescription object which describes the enemy type
		 *                        (if you wish to spawn several different enemies, simply create a new stage and set this time to 0)
		 * @param movementType    An EnemyMovement object which describes the movement of the enemywave
		 * @param numberOfEnemies the number of enemies which should be spawned during this wave
		 * @param time            The time it should take for the follow
		 *                        enemy squad to spawn, in seconds or -1
		 *                        if all enemies in the current squad needs to be defeated beforde
		 *                        the next wave is launched
		 */
		public StageDescription(EnemyDescription enemyType, EnemyMovement movementType,
		                        int numberOfEnemies, int time) {
			this.enemyType = enemyType;
			this.movementType = movementType;
			this.numberOfEnemies = numberOfEnemies;
			this.time = time;
		}


		/**
		 * If you want to show that the game is now over, use this constructor
		 *
		 * @param gameOver true if the game is over
		 */
		public StageDescription(boolean gameOver) {
			this.gameOver = gameOver;
		}

		/**
		 * If you want the game to take a pause during a specified time without spawning enemies, use this constructor
		 *
		 * @param rest true if the game should rest
		 * @param time the amount of the the rest should take, in seconds
		 */
		public StageDescription(boolean rest, int time) {
			this.rest = rest;
			this.time = time;
		}

		/**
		 * Return the enemyDescription
		 *
		 * @return EnemyDescription
		 */
		public EnemyDescription getEnemyType() {
			return this.enemyType;
		}

		/**
		 * An EnenemyMovement object which specifies the movement pattern of the enemie
		 *
		 * @return An EnemyMovement Object
		 */
		public EnemyMovement getMovementType() {
			return this.movementType;
		}

		/**
		 * The number of enemies whish should be spawned during this stage
		 *
		 * @return number of enemies
		 */
		public int getNumberOfEnemies() {
			return this.numberOfEnemies;
		}

		/**
		 * True if the game is over
		 *
		 * @return true if the game is over, otherwise false
		 */
		public boolean isGameOver() {
			return this.gameOver;
		}

		/**
		 * True if the game should take a rest without spawning any enemies
		 *
		 * @return true if rest, othervise false
		 */
		public boolean rest() {
			return this.rest;
		}

		/**
		 * Retunr the time it should take for the next enemy squad to appear, in seconds
		 *
		 * @return and int stating the time for the next spawning to occur
		 */
		public int time() {
			return this.time;
		}

	}

	/**
	 * Returns the level based on the input number, 1 returns level 1 etc.
	 *
	 * @param level the number of the level
	 * @return The level with that specified number
	 */
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

	/**
	 * Get a specific stage in the level
	 *
	 * @param index
	 * @return A StageDescription
	 */

	public StageDescription getStage(int index) {
		return stages[index];
	}

	/**
	 * Returns the amount of stages which the level contains
	 *
	 * @return
	 */
	public int getLevelLength() {
		return stages.length;
	}
}

