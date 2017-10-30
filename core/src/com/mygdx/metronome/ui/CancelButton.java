package com.mygdx.metronome.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;

public class CancelButton extends Button{
	
	public CancelButton(){
		super(new ButtonStyle());
		this.setWidth(100);
		this.setHeight(50);
		this.setX(30);
		this.setY(50);
		this.setDebug(true);
	}

}
