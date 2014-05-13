package com.me.Javaga.spaceobject;

import com.badlogic.gdx.math.Vector2;
import com.me.Javaga.gamestate.levels.BulletDescription;

/**
 * Created by Lukas on 2014-05-13.
 */
public class MotionSeeker extends Bullet {

	private SpaceObject target;
	private Vector2 direction;
	private float currentDegree;

	public MotionSeeker(float xPos, float yPos, float degree, BulletDescription description, SpaceObject target) {
		super(xPos, yPos, degree, description);
		this.target = target;
		direction = new Vector2(dX, dY);
		currentDegree = degree;
	}

	@Override
	public void update() {
		xPos += direction.x;
		yPos += direction.y;
		//System.out.println("y: " + yPos);
		//System.out.println("x: " + xPos);

		sprite.setX(xPos);
		sprite.setY(yPos);
		xCenter = xPos + sprite.getWidth() / 2;
		yCenter = yPos + sprite.getHeight() / 2;
		hitbox.setCenter(xCenter, yCenter);

		if (isHealthy) {
			updateDirection();
			sprite.rotate(direction.angle() - currentDegree);
			currentDegree = direction.angle();
			if (System.currentTimeMillis() - startTime > description.getLifeTime()) {
				isHealthy = false;
			}
		} else {
			hurt();
		}
	}

	/**
	 * Update the direction for the enemy object
	 */
	private void updateDirection() {
		Vector2 newDirection = new Vector2(target.getX() - xCenter, target.getY() - yCenter);
		direction.add(newDirection.nor().scl(0.5f));
		//direction.nor().scl(description.getSpeed());
		direction.nor().scl(description.getSpeed());
	}
}
