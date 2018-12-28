package com.romreviewer.flappylearn.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.romreviewer.flappylearn.flappybird;


public class EndState extends State{
    private Texture bg,playbutton,gameover;

    public EndState(GameStateManager gsm) {
        super(gsm);
        ogc.setToOrtho(false, flappybird.W/2,flappybird.H/2);
        bg=new Texture("bg.png");
        gameover=new Texture("gameover.png");
        playbutton=new Texture("playbtn.png");
    }

    @Override
    protected void handlerinput() {
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
        sb.draw(bg,0,0);
        sb.draw(gameover,ogc.position.x-gameover.getWidth()/2,ogc.position.y);
        sb.draw(playbutton,ogc.position.x-playbutton.getWidth()/2,ogc.position.y-gameover.getHeight()*2);
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        playbutton.dispose();
    }
}
