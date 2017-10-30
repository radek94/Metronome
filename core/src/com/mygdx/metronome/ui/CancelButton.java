package com.mygdx.metronome.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class CancelButton extends TextButton{
	
	public CancelButton(String text, Skin skin){
		super(text, skin);
		this.setWidth(100);
		this.setHeight(50);
		this.setX(30);
		this.setY(50);
	}

}
