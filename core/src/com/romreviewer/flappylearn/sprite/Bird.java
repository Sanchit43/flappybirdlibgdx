package com.romreviewer.flappylearn.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Bird {
    private static final int GRAV=-15;
    private static final int MOVEMENT=100;
    private Vector3 pos;
    private Vector3 velocity;
    private Texture bird;
    private Rectangle bounds;
    private Animation birdAnimation;
    private Texture texture;
    private Sound sound;

    public Bird(int x, int y) {
        pos=new Vector3(x,y,0);
        velocity=new Vector3(0,0,0);
        bird=new Texture("bird.png");
        texture=new Texture("birdanimation.png");
        birdAnimation=new Animation(new TextureRegion(texture),3,0.5f);
        bounds=new Rectangle(x,y,texture.getWidth()/3,texture.getHeight());
        sound=Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
    }
    public void update(float dt)
    {
        birdAnimation.update(dt);
        if(pos.y>0)
            velocity.add(0,GRAV,0);
        velocity.scl(dt);
        pos.add(MOVEMENT*dt,velocity.y,0);
        if(pos.y<0)
        {
            pos.y=0;
        }
        velocity.scl(1/dt);
        bounds.setPosition(pos.x,pos.y);
    }

    public Vector3 getPos() {
        return pos;
    }

    public TextureRegion getBird() {
        return birdAnimation.getFrame();
    }
    public void jump()
    {
        velocity.y=250;
        sound.play(0.5f);
    }
    public Rectangle getBounds()
    {
        return bounds;
    }
    public void dispose()
    {
        sound.dispose();
        bird.dispose();
    }

}
