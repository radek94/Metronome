package com.mygdx.metronome.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MoreBpm extends TextButton{
	
	public MoreBpm(String text, Skin skin, final ClickCallBack callBack){
		super(text, skin);
		init(callBack);
	}
	
	private void init(final ClickCallBack callBack) {
		this.setWidth(120);
		this.setHeight(90);
		this.setX(320);
		this.setY(220);
		
		this.addListener(new ClickListener(){
			
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				callBack.onClick();
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
}
