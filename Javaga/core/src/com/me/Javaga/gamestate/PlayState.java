package com.me.Javaga.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.spaceobject.Bullet;
import com.me.Javaga.spaceobject.Player;

import java.util.ArrayList;

/**
 * Created by Dansel on 2014-04-30.
 */
public class PlayState extends GameState {
	private Player player;
	private ArrayList<Bullet> bullets;

	public PlayState() {
		super();
		init();
	}

    @Override
    public void init() {
	    bullets = new ArrayList<Bullet>();
	    player = new Player(Gdx.graphics.getWidth() / 2, 30, bullets);
    }

	@Override
	public void update() {
		player.update();
		for(Bullet bullet: bullets) {
			bullet.update();
		}
	}

    @Override
    public void draw(SpriteBatch batch) {
	    player.draw(batch);
	    for(Bullet bullet: bullets) {
		    bullet.draw(batch);
	    }
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void dispose() {

    }
}
