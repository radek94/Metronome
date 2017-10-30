package com.mygdx.metronome.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.metronome.MainMenu;
import com.mygdx.metronome.ui.BpmTextField;
import com.mygdx.metronome.ui.CancelButton;
import com.mygdx.metronome.ui.OkButton;

public class BpmScreen extends AbstractScreen{
	
	private OkButton okButton;
	private CancelButton cancelButton;

	private BpmTextField txfBpmChange;
	
	private Skin skin;
	
	public BpmScreen(MainMenu menu) {
		super(menu);
		skin = new Skin(Gdx.files.internal("vhs-ui.json"));
		init();
	}
	
	private void init() {
		initOkButton();	
		initCancelButton();
		initTxfBpmChange();
	}

	private void initTxfBpmChange() {
		txfBpmChange = new BpmTextField("", skin);
		stage.addActor(txfBpmChange);
	}

	private void initCancelButton() {
		cancelButton = new CancelButton();
		stage.addActor(cancelButton);
		
		cancelButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				menu.setScreen(new MainScreen(menu));
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}

	private void initOkButton() {
		okButton = new OkButton();
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
