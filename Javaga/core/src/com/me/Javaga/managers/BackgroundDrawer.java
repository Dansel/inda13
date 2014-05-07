package com.me.Javaga.managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.spaceobject.Star;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Lukas on 2014-05-06.
 */
public class BackgroundDrawer {
	private static ArrayList<Star> stars;
	private static long time; // Keep track of the star animation time

	static {
		stars = new ArrayList<Star>();
		time = 0;
	}

	public static void update() {
		if (System.currentTimeMillis() - time > 200) {
			time = System.currentTimeMillis();
			stars.add(new Star());
		}

		Iterator<Star> iterator = stars.iterator();
		while (iterator.hasNext()) {
			Star star = iterator.next();
			if (!star.checkHealthy()) {
				iterator.remove();
			}
		}

		iterator = stars.iterator();
		while (iterator.hasNext()) {
			Star star = iterator.next();
			star.update();
		}
	}

	public static void draw(SpriteBatch batch) {
		//draw stars
		Iterator<Star> iterator = stars.iterator();
		while (iterator.hasNext()) {
			Star star = iterator.next();
			star.draw(batch);
		}
	}
}
