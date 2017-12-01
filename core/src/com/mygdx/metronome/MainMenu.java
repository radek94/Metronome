package com.mygdx.metronome;

import com.badlogic.gdx.Game;
import com.mygdx.metronome.screens.MainScreen;

public class MainMenu extends Game{
	
	private boolean paused;
	
	public final static String NAME = "Metronome";
	
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;
	
	public static final int MIN_BPM = 20;
	public static final int MAX_BPM = 240;
		
	@Override
	public void create () {
		this.setScreen(new MainScreen(this, 120));
	}

	public boolean isPaused() {
		return paused;
	}


	public void setPaused(boolean paused) {
		this.paused = paused;
	}	
}
