package com.mygdx.metronome.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class BpmButton extends Button{
	
	public BpmButton(){
		super((new ButtonStyle()));
		this.setWidth(100);
		this.setHeight(50);
		this.setX(190);
		this.setY(600);
		this.setDebug(true);
	}
	
}
