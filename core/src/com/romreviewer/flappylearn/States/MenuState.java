package com.romreviewer.flappylearn.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.romreviewer.flappylearn.flappybird;

public class MenuState extends State {
    private Texture background;
    private Texture playbutton;
    public MenuState(GameStateManager gsm) {
        super(gsm);
        ogc.setToOrtho(false, flappybird.W/2,flappybird.H/2);
        background=new Texture("bg.png");
        playbutton=new Texture("playbtn.png");
    }

    @Override
    public void handlerinput() {
        if(Gdx.input.justTouched())
        {
            gsm.setStates(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handlerinput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(ogc.combined);
        sb.begin();
        sb.draw(background,0,0);
        sb.draw(playbutton,ogc.position.x-playbutton.getWidth()/2,ogc.position.y);
        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        playbutton.dispose();
        System.out.println("Menu State Disposed");
    }
}
