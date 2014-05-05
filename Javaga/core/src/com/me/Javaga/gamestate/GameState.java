package com.me.Javaga.gamestate;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.managers.GameStateManager;

/**
 * Created by Dansel on 2014-04-30.
 */
public abstract class GameState {

    protected GameStateManager gameStateManager;

    public GameState(GameStateManager gameStateManeger) {
        this.gameStateManager = gameStateManager;
    }

    public abstract void init();

    public abstract void update();

    public abstract void draw(SpriteBatch batch);

    public abstract void handleInput();

    public abstract void dispose();
}
