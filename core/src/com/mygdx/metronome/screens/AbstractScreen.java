package com.mygdx.metronome.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.metronome.MainMenu;

public abstract class AbstractScreen implements Screen{
	
	protected MainMenu menu;
	
	protected Stage stage;
	
	protected SpriteBatch spriteBatch;
	protected Skin skin;
	protected Sound bpmSound;
	
	public AbstractScreen(MainMenu menu){
		this.menu = menu;
		spriteBatch = new SpriteBatch();
		skin = new Skin(Gdx.files.internal("Holo-dark-mdpi.json"));
		bpmSound = Gdx.audio.newSound(Gdx.files.internal("bpm.wav"));
		stage = new Stage(new StretchViewport(MainMenu.WIDTH, MainMenu.HEIGHT));
		Gdx.input.setInputProcessor(stage);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);	
	}
	
	@Override
	public void resume() {
		menu.setPaused(false);
	}
	
	@Override
	public void pause() {
		menu.setPaused(true);	
	}
	
	@Override
	public void dispose() {
		menu.dispose();	
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
}
