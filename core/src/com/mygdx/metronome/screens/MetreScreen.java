package com.mygdx.metronome.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.metronome.MainMenu;


public class MetreScreen extends AbstractScreen{
	
	private TextButton okButton, cancelButton;
	
	private Label upMetre, downMetre;
	
	private Skin skin;
	
	public MetreScreen(MainMenu menu) {
		super(menu);
		skin = new Skin(Gdx.files.internal("vhs-ui.json"));
		init();
	}

	private void init() {
		initOkButton();
		initCancelButton();
		initUpMetre();
		initDownMetre();
	}
	
	private void initDownMetre() {
		downMetre = new Label("4", skin);
		downMetre.setBounds(240, 300, 50, 50);
		stage.addActor(downMetre);
	}

	private void initUpMetre() {
		upMetre = new Label("4", skin);
		upMetre.setBounds(240, 350, 50, 50);
		stage.addActor(upMetre);
	}

	private void initCancelButton() {
		cancelButton = new TextButton("Cancel", skin);
		cancelButton.setBounds(30, 50, 100, 50);
		stage.addActor(cancelButton);
		
		cancelButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				menu.setScreen(new MainScreen(menu, 60));
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}

	private void initOkButton() {
		okButton = new TextButton("OK", skin);
		okButton.setBounds(350, 50, 100, 50);
		stage.addActor(okButton);
	}

	@Override
	public void render(float delta) {
		update();
		super.render(delta);
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

	private void update() {
		stage.act();
	}
	
}
