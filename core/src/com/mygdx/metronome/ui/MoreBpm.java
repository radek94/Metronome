package com.mygdx.metronome.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MoreBpm extends TextButton{
	
	public MoreBpm(String text, Skin skin){
		super(text, skin);
		init();
	}
	
	private void init() {
		this.setWidth(70);
		this.setHeight(50);
		this.setX(340);
		this.setY(300);	
	}
}
