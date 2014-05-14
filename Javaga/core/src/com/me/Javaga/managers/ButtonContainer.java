package com.me.Javaga.managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class contains the buttons which a menu uses
 * Created by Lukas on 2014-05-06.
 */
public class ButtonContainer {
	private ArrayList<Button> buttons;
	private Button currentButton;
	private int currentButtonIndex;

	public ButtonContainer() {
		buttons = new ArrayList<Button>();
	}

	/**
	 * Add a button to the container, the order which the buttons are added will
	 * affect how the will highligt when you iterate over them with the arrow buttons.
	 * The buttons which is highest on the screen should be added first etc
	 *
	 * @param button The button which should be added to the container
	 */
	public void addButton(Button button) {
		buttons.add(button);
	}

	/**
	 * Handle the user input
	 */
	public void handleInput() {
		Iterator<Button> iterator = buttons.iterator();
		while (iterator.hasNext()) {
			Button button = iterator.next();
			if (button.isHovering()) {
				if (currentButton != null) {
					currentButton.setSelected(false);
				}
				currentButton = button;
				currentButtonIndex = buttons.indexOf(currentButton);
				button.setSelected(true);
				if (GameKeys.isMousePressed()) {
					button.preformAction();
				}
			}
		}

		if (GameKeys.isPressed(GameKeys.UP)) {
			if (currentButton != null) {
				if (currentButtonIndex > 0) {
					currentButtonIndex--;
				}
				currentButton.setSelected(false);
				currentButton = buttons.get(currentButtonIndex);
				currentButton.setSelected(true);
			} else {
				currentButtonIndex = 0;
				currentButton = buttons.get(currentButtonIndex);
				currentButton.setSelected(true);
			}
		}

		if (GameKeys.isPressed(GameKeys.DOWN)) {
			if (currentButton != null) {
				if (currentButtonIndex != buttons.size() - 1) {
					currentButtonIndex++;
				}
				currentButton.setSelected(false);
				currentButton = buttons.get(currentButtonIndex);
				currentButton.setSelected(true);
			} else {
				currentButtonIndex = buttons.size() - 1;
				currentButton = buttons.get(currentButtonIndex);
				currentButton.setSelected(true);
			}
		}

		if (GameKeys.isPressed(GameKeys.ENTER)) {
			if (currentButton != null) {
				currentButton.preformAction();
			}
		}
	}

	public void draw(SpriteBatch batch) {
		for (Button button : buttons) {
			button.draw(batch);
		}
	}

	/**
	 *
	 */
	public void dispose() {
		Iterator<Button> buttonIterator = buttons.iterator();
		while (buttonIterator.hasNext()) {
			Button button = buttonIterator.next();
			button.dispose();
			buttonIterator.remove();
		}

	}

}
