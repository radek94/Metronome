package com.mygdx.metronome;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenu extends ApplicationAdapter {
	
	public final static String NAME = "Metronome";
	
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;
	
	private SpriteBatch batch;
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		
	}
}
