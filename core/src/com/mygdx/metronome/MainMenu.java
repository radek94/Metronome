package com.mygdx.metronome;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.metronome.screens.MainScreen;
import com.mygdx.metronome.ui.LessBpm;
import com.mygdx.metronome.ui.MoreBpm;
import com.mygdx.metronome.ui.PlayButton;
import com.mygdx.metronome.ui.StopButton;

public class MainMenu extends Game{
	
	private boolean paused;
	
	public final static String NAME = "Metronome";
	
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;
		
	@Override
	public void create () {
		this.setScreen(new MainScreen(this, 60));
	}

	public boolean isPaused() {
		return paused;
	}


	public void setPaused(boolean paused) {
		this.paused = paused;
	}	
}
