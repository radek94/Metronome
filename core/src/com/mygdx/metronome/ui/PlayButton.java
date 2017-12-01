package com.mygdx.metronome.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class PlayButton extends Button{
			
	public PlayButton(final ClickCallBack callBack){
		super(preparePlayButtonStylePlay());
		init(callBack);
	}

	private void init(final ClickCallBack callBack) {
		this.setWidth(80);
		this.setHeight(50);
		this.setX(190);
		this.setY(240);
		
		this.addListener(new ClickListener(){
			
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				callBack.onClick();
				return super.touchDown(event, x, y, pointer, button);
			}
		});
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
