package com.mygdx.metronome.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class BpmTextField extends TextField{

	public BpmTextField(String text, Skin skin) {
		super(text, skin);
		this.setWidth(300);
		this.setHeight(50);
		this.setX(90);
		this.setY(620);
	}
	
	

}
