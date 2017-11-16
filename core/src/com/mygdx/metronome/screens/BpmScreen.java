package com.mygdx.metronome.screens;

import org.omg.CORBA.portable.ValueOutputStream;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.metronome.MainMenu;

public class BpmScreen extends AbstractScreen{
	
	private TextButton okButton, cancelButton, backspaceButton, button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;;

	private TextField txfBpmChange;
	private MainScreen bpmChange;
	private MainScreen bpmLabelKeyboard;
	private Skin skin;
	
	private float bpmKeyboard;
	
	public BpmScreen(MainMenu menu) {
		super(menu);
		skin = new Skin(Gdx.files.internal("Holo-dark-mdpi.json"));
		init();
	}
	
	private void init() {
		initOkButton();	
		initCancelButton();
		initTxfBpmChange();
		initDigitButtons();
		initBackspaceButton();
	}

	private void initBackspaceButton() {
		backspaceButton = new TextButton("C", skin);
		backspaceButton.setBounds(65, 570, 50, 50);
		stage.addActor(backspaceButton);
		
		backspaceButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				String cancel = txfBpmChange.getText();
				if(cancel.length()>1){
					cancel = cancel.substring(0, cancel.length()-1);
					txfBpmChange.setText(cancel);
				}
				else if(cancel.length()==1){
					txfBpmChange.setText("");
				}
				return super.touchDown(event, x, y, pointer, button);
			}		
		});
		
	}

	private void initDigitButtons() {
		button1 = new TextButton("1", skin);
		button1.setBounds(65, 520, 50, 50);
		stage.addActor(button1);
		button1.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				txfBpmChange.setText(txfBpmChange.getText()+"1");
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
		button2 = new TextButton("2", skin);
		button2.setBounds(215, 520, 50, 50);
		stage.addActor(button2);
		button2.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				txfBpmChange.setText(txfBpmChange.getText()+"2");
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
		button3 = new TextButton("3", skin);
		button3.setBounds(365, 520, 50, 50);
		stage.addActor(button3);
		button3.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				txfBpmChange.setText(txfBpmChange.getText()+"3");
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
		button4 = new TextButton("4", skin);
		button4.setBounds(65, 370, 50, 50);
		stage.addActor(button4);
		button4.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				txfBpmChange.setText(txfBpmChange.getText()+"4");
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
		button5 = new TextButton("5", skin);
		button5.setBounds(215, 370, 50, 50);
		stage.addActor(button5);
		button5.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				txfBpmChange.setText(txfBpmChange.getText()+"5");
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
		button6 = new TextButton("6", skin);
		button6.setBounds(365, 370, 50, 50);
		stage.addActor(button6);
		button6.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				txfBpmChange.setText(txfBpmChange.getText()+"6");
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
		button7 = new TextButton("7", skin);
		button7.setBounds(65, 220, 50, 50);
		stage.addActor(button7);
		button7.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				txfBpmChange.setText(txfBpmChange.getText()+"7");
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
		button8 = new TextButton("8", skin);
		button8.setBounds(215, 220, 50, 50);
		stage.addActor(button8);
		button8.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				txfBpmChange.setText(txfBpmChange.getText()+"8");
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
		button9 = new TextButton("9", skin);
		button9.setBounds(365, 220, 50, 50);
		stage.addActor(button9);
		button9.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				txfBpmChange.setText(txfBpmChange.getText()+"9");
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
		button0 = new TextButton("0", skin);
		button0.setBounds(215, 70, 50, 50);
		stage.addActor(button0);
		button0.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				txfBpmChange.setText(txfBpmChange.getText()+"0");
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}

	private void initTxfBpmChange() {
		txfBpmChange = new TextField("", skin);
		txfBpmChange.setBounds(90, 620, 300, 50);
		txfBpmChange.setMaxLength(4);
		stage.addActor(txfBpmChange);
	}

	private void initCancelButton() {
		cancelButton = new TextButton("Cancel", skin);
		cancelButton.setBounds(30, 50, 100, 50);
		stage.addActor(cancelButton);
		
		cancelButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				menu.setScreen(new MainScreen(menu, 60));
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}

	private void initOkButton() {
		okButton = new TextButton("OK", skin);
		okButton.setBounds(350, 50, 100, 50);
		stage.addActor(okButton);
		
		okButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {			
				bpmKeyboard = Float.parseFloat(txfBpmChange.getText());
				menu.setScreen(new MainScreen(menu, bpmKeyboard));
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}

		
	private void checkTextField(){
		if(!txfBpmChange.getText().equals("")){
			float bpmDigits = Float.parseFloat(txfBpmChange.getText());
			if(bpmDigits>MainScreen.MAX_BPM || bpmDigits<MainScreen.MIN_BPM) okButton.setTouchable(Touchable.disabled);
			else okButton.setTouchable(Touchable.enabled);
		}
		else okButton.setTouchable(Touchable.disabled);	
	}
	

	@Override
	public void render(float delta) {
		update();
		super.render(delta);
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}
	
	private void update() {
		stage.act();
		checkTextField();
	}

}
