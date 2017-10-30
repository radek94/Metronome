package com.mygdx.metronome.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class OkButton extends TextButton{
	
	public OkButton(String text, Skin skin){
		super(text, skin);
		this.setWidth(100);
		this.setHeight(50);
		this.setX(350);
		this.setY(50);
	}
	
}
