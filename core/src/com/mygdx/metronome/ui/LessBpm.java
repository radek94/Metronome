package com.mygdx.metronome.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class LessBpm extends TextButton{
	
	public LessBpm(String text, Skin skin){
		super(text, skin);
		init();
	}
	
	private void init() {
		this.setWidth(70);
		this.setHeight(50);
		this.setX(70);
		this.setY(300);	
	}
}
