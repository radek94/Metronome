package com.mygdx.metronome.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;

public class StopButton extends Button{
	
	public StopButton(){
		super(new ButtonStyle());
		init();
	}
	
	private void init() {
		this.setWidth(100);
		this.setHeight(100);
		this.setX(290);
		this.setY(300);
		this.setDebug(true);
		
	}

}
