package com.romreviewer.flappylearn.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {
    OrthographicCamera ogc;
    Vector3 mouse;
    GameStateManager gsm;

    public State(GameStateManager gsm) {
        this.gsm = gsm;
        mouse = new Vector3();
        ogc = new OrthographicCamera();
    }
    protected abstract void handlerinput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}
