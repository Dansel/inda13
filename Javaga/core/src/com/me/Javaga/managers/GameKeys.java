package com.me.Javaga.managers;

import com.badlogic.gdx.Gdx;

/**
 * Contains the state of keys which are pressed (or not pressed)
 * and the position of the mouse and its state
 * Created by Dansel on 2014-04-30.
 */
public class GameKeys {

	public static final int UP = 0;
	public static final int LEFT = 1;
	public static final int DOWN = 2;
	public static final int RIGHT = 3;
	public static final int ENTER = 4;
	public static final int ESCAPE = 5;
	public static final int SPACE = 6;
	public static final int SHIFT = 7;
	private static final int NUM_KEYS = 8;
	public static int xMouse;
	public static int yMouse;
	public static boolean mousePressed;
	private static boolean[] keys;
	private static boolean[] pkeys;
	private static boolean prevMousePressed;

	static {
		keys = new boolean[NUM_KEYS];
		pkeys = new boolean[NUM_KEYS];
	}

	/**
	 * Update list containing pressed keys.
	 */
	public static void update() {
		prevMousePressed = mousePressed;
		for (int i = 0; i < NUM_KEYS; i++) {
			pkeys[i] = keys[i];
		}
	}

	/**
	 * Used to create list.
	 *
	 * @param k int, key ID
	 * @param b boolean, pressed or not.
	 */
	public static void setKey(int k, boolean b) {
		keys[k] = b;
	}

	/**
	 * Checks if a key is "down"
	 *
	 * @param k int, key ID
	 * @return boolean, if key is pressed or not.
	 */
	public static boolean isDown(int k) {
		return keys[k];
	}

	/**
	 * Checks if a key is "down" and previously was "up", aka it only returns true on statechange.
	 *
	 * @param k int, key ID
	 * @return boolean, true on statechange.
	 */
	public static boolean isPressed(int k) {
		return keys[k] && !pkeys[k];
	}

	/**
	 * Return the x position of the mouse
	 *
	 * @return the x-value of the mouse
	 */
	public static int xMouse() {
		return xMouse;
	}

	/**
	 * Return the y position of the mouse
	 *
	 * @return the y-value of the mouse
	 */
	public static int yMouse() {
		return Gdx.graphics.getHeight() - yMouse; // Sense we have origo in the bottom left corner
		// we have to convert the y-position like this
	}

	/**
	 * Return true if the mouse left "button" is held down
	 *
	 * @return true if the mouse is held down
	 */
	public static boolean isMouseDown() {
		return mousePressed;
	}

	/**
	 * Return true if the the mouse left"button" was pressed"
	 *
	 * @return true if the mouse was pressed
	 */
	public static boolean isMousePressed() {
		return mousePressed && !prevMousePressed;
	}

}
