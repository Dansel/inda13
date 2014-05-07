package com.me.Javaga.gamestate.levels;

/**
 * Created by Dansel on 2014-05-05.
 */
public class Level {
	private int[][][] levels;
	private int numOfLevels;
	private int numOfStages;
	private int currentLevel;
	private int currentStage;

	public Level() {
		numOfLevels = 2;
		numOfStages = 5;
		currentLevel = 0;
		currentStage = 0;
		init();
	}

	private void init() {
		levels = new int[][][]{
				{{1, 10}, {2, 10}, {3, 10}, {4, 10}, {5, 1}},    //level 1
				{{1, 10}, {2, 10}, {3, 10}, {4, 10}, {5, 1}}     //level 2
		};
		//first is the number of levels, containing subarrays of stages.
		//each subarray contains a 2-length array which is in format of{ID, Amount}
	}

	public int[] getNextStage() {
		if (currentStage >= numOfStages) {
			currentStage = 0;
			currentLevel++;
		}
		if (currentLevel >= numOfLevels) {
			//GameStateManager.WON; //TODO

			return new int[]{0};
		}
		currentStage++;
		return levels[currentLevel][currentStage - 1];
	}
}

