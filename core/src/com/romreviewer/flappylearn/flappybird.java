package com.romreviewer.flappylearn;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.romreviewer.flappylearn.States.GameStateManager;
import com.romreviewer.flappylearn.States.MenuState;

public class flappybird extends ApplicationAdapter {
	SpriteBatch batch;
	public static final int W=480;
	public static final int H=640;
	public static final String TITLE="Flappy Birds Demo";
	private GameStateManager gameStateManager;
	private Music music;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gameStateManager=new GameStateManager();
		music=Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        gameStateManager.push(new MenuState(gameStateManager));
	}

	@Override
	public void render () {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameStateManager.update(Gdx.graphics.getDeltaTime());
		gameStateManager.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		music.dispose();
	}
}
