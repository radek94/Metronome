package com.mygdx.metronome.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.metronome.MainMenu;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = MainMenu.WIDTH;
		config.height = MainMenu.HEIGHT;
		config.title = MainMenu.NAME;
		config.resizable = false;
		new LwjglApplication(new MainMenu(), config);
	}
}
