package com.me.Javaga.spaceobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

/**
 * Created by Lukas on 2014-05-05.
 */
public class Star extends SpaceObject {

    private final static String FILENAME = "star.png";
    private float dY;
    private Random random;

    public Star() {
        super(0, 0);
        init();
    }

    @Override
    public void init() {
		random = new Random();
        xPos = random.nextFloat()*Gdx.graphics.getWidth();
        yPos = Gdx.graphics.getHeight();

        //Create the sprite with some texture
        sprite = new Sprite(new Texture(Gdx.files.internal(FILENAME)));
        sprite.setX(xPos);
        sprite.setY(yPos);
        //Set scalefactor
        setScale(0.2f);

        //Find the sprites dimensions.
        sWidth = sprite.getWidth()*SCALEFACTOR;
        sHeight = sprite.getHeight()*SCALEFACTOR;

        //shift position down and to the left so we draw the sprite centered.
        xPos -= sprite.getWidth()/2;
        yPos -= sprite.getHeight()/2;

        xCenter = xPos + sprite.getWidth()/2;
        yCenter = yPos + sprite.getHeight()/2;

        hitbox = new Rectangle();
        hitbox.setHeight(sHeight).setWidth(sWidth).setCenter(xCenter,yCenter);

        dY = - random.nextFloat() * 30 + 10;
    }

    @Override
    public void update() {
        yPos += dY;
        yCenter = yPos + sprite.getHeight()/2;
        sprite.setY(yPos);
        wrap();
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    @Override
    public void wrap() {
        if ((yCenter - sHeight / 2 < 0 )) {
            isHealthy = false;
        }

    }

    @Override
    public boolean checkHealthy() {
        return isHealthy;
    }
}
