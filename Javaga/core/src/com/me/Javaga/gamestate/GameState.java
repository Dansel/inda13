package com.me.Javaga.gamestate;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Dansel on 2014-04-30.
 */
public abstract class GameState {

    public GameState() {
    }

    public abstract void init();

    public abstract void update();

    public abstract void draw(SpriteBatch batch);

    public abstract void handleInput();

    public abstract void dispose();
}
