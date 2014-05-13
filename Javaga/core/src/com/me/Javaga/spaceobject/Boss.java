package com.me.Javaga.spaceobject;

import com.me.Javaga.managers.GameStateManager;

import java.util.ArrayList;

/**
 * Created by Lukas on 2014-05-13.
 */
public class Boss extends Enemy {

	public Boss(float xPos, float yPos, int type,
	            ArrayList<Bullet> enemyBullets, Player player) {
		super(xPos, yPos, type, enemyBullets, player);
	}

	@Override
	protected void updateGoal() {
		if (goalIndex + 1 < goals.size()) {
			goalIndex++;
			currentGoal = goals.get(goalIndex);
		} else {
			goalIndex = 0;
			currentGoal = goals.get(goalIndex);
		}
	}

	@Override
	public void fire() {
		if (System.currentTimeMillis() - time < shootLimit || outsideBourder) {
			return;
		}
		float dX = xCenter - player.getX(); // Aim for the player
		float dY = yCenter - player.getY(); // Aim for the player
		float startDegree = 270;
		if (yCenter - player.getY() < 0) { // Dont shoot if the player is behind you
			startDegree = 90;
		}
		double radian = Math.atan(dX / dY);
		float degree = (float) (startDegree - Math.toDegrees(radian));
		float miss = (random.nextBoolean()) ? random.nextFloat() * description.getAccuracy()
				: random.nextFloat() * -1 * description.getAccuracy(); // Makes their aim awful,
		//// probably should do it some other this
		enemyBullets.add(new Bullet(xCenter, yCenter - sHeight / 2, degree, description.getBulletType()));

		sound.play(GameStateManager.getEffectVolume()); // play lazer
		time = System.currentTimeMillis(); // reset time

	}
}
