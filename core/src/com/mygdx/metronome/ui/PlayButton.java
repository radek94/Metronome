package com.mygdx.metronome.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class PlayButton extends Button{
		
	public PlayButton(){
		super(preparePlayButtonStylePlay());
		init();
	}

	private void init() {
		this.setWidth(70);
		this.setHeight(50);
		this.setX(160);
		this.setY(300);
	}

	private static ButtonStyle preparePlayButtonStylePlay(){
		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("vhs-ui.atlas"));
		Skin skin = new Skin(atlas);
		ButtonStyle buttonStyle = new ButtonStyle();
		buttonStyle.up = skin.getDrawable("label-play");
		buttonStyle.down = skin.getDrawable("label-play");
		skin.add("", buttonStyle);
		return buttonStyle;
	}
}
