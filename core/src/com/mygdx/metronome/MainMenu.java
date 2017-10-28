package com.mygdx.metronome;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class MainMenu extends Game implements Screen{
	
	private MainMenu menu;
	private boolean isPaused;
	
	private int bpm = 60;
	private Sound bpmSound;
	
	private Button playButton, stopButton;
	
	public final static String NAME = "Metronome";
	
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;
	
	private SpriteBatch spriteBatch;
	private Stage stage;
	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		bpmSound = Gdx.audio.newSound(Gdx.files.internal("bpm.wav"));
		stage = new Stage(new StretchViewport(MainMenu.WIDTH, MainMenu.HEIGHT));
		Gdx.input.setInputProcessor(stage);
		initPlayButton();
	}

	private void initPlayButton() {
		playButton = new Button(new ButtonStyle());
		playButton.setWidth(100);
		playButton.setHeight(100);
		playButton.setX(190);
		playButton.setY(300);
		playButton.setDebug(true);
		stage.addActor(playButton);
		
		playButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
					Timer.schedule(new Task() {
						
						@Override
						public void run() {
							bpmSound.play();
						}
					}, 0, 1);
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}
	
	public void update(){
		stage.act();
	}
	
	@Override
	public void dispose () {
		spriteBatch.dispose();
		bpmSound.dispose();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	public boolean isPaused() {
		return isPaused;
	}

	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}
}
