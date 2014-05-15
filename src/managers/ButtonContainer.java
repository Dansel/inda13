package com.me.Javaga.managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Lukas on 2014-05-06.
 */
public class ButtonContainer {
	private ArrayList<Button> buttons;
	private Button currentButton;
	private int currentButtonIndex;

	public ButtonContainer() {
		buttons = new ArrayList<Button>();
	}

	public void addButton(Button button) {
		buttons.add(button);
	}

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

	public void dispose() {
		Iterator<Button> buttonIterator = buttons.iterator();
		while (buttonIterator.hasNext()) {
			Button button = buttonIterator.next();
			button.dispose();
			buttonIterator.remove();
		}

	}

}
