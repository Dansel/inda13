package com.me.Javaga.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Created by Dansel on 2014-04-30.
 */
public class InputManager {

    public int getKeypress(){
        Gdx.input.isKeyPressed(Input.Keys.ANY_KEY);
    }
}
