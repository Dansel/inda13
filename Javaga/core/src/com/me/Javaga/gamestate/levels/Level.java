package com.me.Javaga.gamestate.levels;

/**
 * Created by Dansel on 2014-05-05.
 */
public class Level {
	private StageDescription[][] levels;
	private int numOfLevels;
	private int numOfStages;
	private int currentLevel;
	private int currentStage;

	public Level() {
		numOfLevels = 2;
		numOfStages = 10;
		currentLevel = 0;
		currentStage = 0;
		init();
	}

	public static class StageDescription {
		private int enemyType;
		private int movementType;
		private int numberOfEnemies;
		private int time;
		private boolean gameOver;

		public StageDescription(int enemyType, int movementType, int numberOfEnemies, int time) {
			this.enemyType = enemyType;
			this.movementType = movementType;
			this.numberOfEnemies = numberOfEnemies;
			this.time = time;
		}

		public StageDescription(boolean gameOver) {
			this.gameOver = gameOver;
		}

		public int getEnemyType() {
			return this.enemyType;
		}

		public int getMovementType() {
			return this.movementType;
		}

		public int getNumberOfEnemies() {
			return this.numberOfEnemies;
		}

		public boolean isGameOver() {
			return this.gameOver;
		}

		public int time() {
			return this.time;
		}

	}

	private void init() {
		levels = new StageDescription[][]{
				{new StageDescription(1, 1, 5, 5),
						new StageDescription(1, 1, 5, 5),
						new StageDescription(1, 1, 5, 5),
						new StageDescription(3, 3, 3, 0),
						new StageDescription(3, 4, 3, 30),
						new StageDescription(1, 1, 5, 5),
						new StageDescription(1, 1, 5, 5),
						new StageDescription(3, 3, 3, 0),
						new StageDescription(3, 4, 3, 30),
						new StageDescription(4, 5, 1, -1)
				},
				//level 2
				{new StageDescription(3, 1, 10, 30),
						new StageDescription(3, 2, 10, 20),
						new StageDescription(3, 2, 10, 20),
						new StageDescription(3, 3, 10, 10),
						new StageDescription(3, 4, 10, 10),
						new StageDescription(3, 1, 10, 30),
						new StageDescription(3, 2, 10, 20),
						new StageDescription(3, 2, 10, 20),
						new StageDescription(3, 3, 10, 10),
						new StageDescription(4, 1, 1, -1)
						}
				};

		//first is the number of levels, containing subarrays of stages.
		//each subarray contains a 2-length array which is in format of{ID, Amount}
	}

	public StageDescription getNextStage() {
		if (currentStage >= numOfStages) {
			currentStage = 0;
			currentLevel++;
		}
		if (currentLevel >= numOfLevels) {
			//GameStateManager.WON; //TODO

			return new StageDescription(true); // tells the game the level is won
		}
		currentStage++;
		return levels[currentLevel][currentStage - 1];
	}
}

