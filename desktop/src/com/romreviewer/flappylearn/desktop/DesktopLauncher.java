package com.romreviewer.flappylearn.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.romreviewer.flappylearn.flappybird;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=flappybird.W;
		config.height=flappybird.H;
		config.title=flappybird.TITLE;
		new LwjglApplication(new flappybird(), config);
	}
}
