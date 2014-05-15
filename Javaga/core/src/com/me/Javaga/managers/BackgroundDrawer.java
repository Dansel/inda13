package com.me.Javaga.managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.spaceobject.Star;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class draws the background onto the canvas,
 * it is mostly static to keep the background from changing
 * from gamestate to gamestate
 * Created by Lukas on 2014-05-06.
 */
public class BackgroundDrawer {
	private static ArrayList<Star> stars;
	private static long time; // Keep track of the star animation time

	static {
		stars = new ArrayList<Star>();
		time = 0;
	}

	/**
	 * Update the background components
	 */
	public static void update() {
		if (System.currentTimeMillis() - time > 200) {
			time = System.currentTimeMillis();
			stars.add(new Star());
		}

		Iterator<Star> iterator = stars.iterator();
		while (iterator.hasNext()) {
			Star star = iterator.next();
			if (star.isDisposable()) {
				star.dispose();
				iterator.remove();
			}
		}

		iterator = stars.iterator();
		while (iterator.hasNext()) {
			Star star = iterator.next();
			star.update();
		}
	}

	/**
	 * Draw all the background components onto the canvas, should be called before all other draw methods
	 *
	 * @param batch A Sprite bacth
	 */
	public static void draw(SpriteBatch batch) {
		//draw stars
		for (Star star : stars) {
			star.draw(batch);
		}
	}
}
