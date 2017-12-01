package com.mygdx.metronome.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class DigitButton extends TextButton{
	
	public DigitButton(final String text, Skin skin, final TextField txf){
		super(text, skin);
		this.setWidth(50);
		this.setHeight(50);
		
		this.addListener(new ClickListener(){
			
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				txf.setText(txf.getText()+text);
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
}
