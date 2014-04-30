package com.me.Javaga.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.spaceobject.Player;

/**
 * Created by Dansel on 2014-04-30.
 */
public class PlayState extends GameState {
	private Player player;

	public PlayState() {
		super();
		init();
	}

    @Override
    public void init() {
	    player = new Player(Gdx.graphics.getWidth() / 2, 30);
    }

	@Override
	public void update() {
		player.update();
	}

    @Override
    public void draw(SpriteBatch batch) {
	    player.draw(batch);    }

    @Override
    public void handleInput() {

    }

    @Override
    public void dispose() {

    }
}
