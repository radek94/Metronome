package com.mygdx.metronome.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.metronome.MainMenu;
import com.mygdx.metronome.ui.DigitButton;

public class BpmScreen extends AbstractScreen{
	
	private TextButton okButton, cancelButton, backspaceButton;

	private DigitButton digitButton0, digitButton1, digitButton2, digitButton3, digitButton4, digitButton5, digitButton6, digitButton7, digitButton8, digitButton9;
	
	private TextField txfBpmChange;
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
		initBackspaceButton();
		initDigitButtons();
	}

	private void initDigitButtons() {
		digitButton1 = new DigitButton("1", skin, txfBpmChange);
		digitButton1.setX(65);
		digitButton1.setY(520);
		stage.addActor(digitButton1);
		
		digitButton2 = new DigitButton("2", skin, txfBpmChange);
		digitButton2.setX(215);
		digitButton2.setY(520);
		stage.addActor(digitButton2);
		
		digitButton3 = new DigitButton("3", skin, txfBpmChange);
		digitButton3.setX(365);
		digitButton3.setY(520);
		stage.addActor(digitButton3);
		
		digitButton4 = new DigitButton("4", skin, txfBpmChange);
		digitButton4.setX(65);
		digitButton4.setY(370);
		stage.addActor(digitButton4);
		
		digitButton5 = new DigitButton("5", skin, txfBpmChange);
		digitButton5.setX(215);
		digitButton5.setY(370);
		stage.addActor(digitButton5);
		
		digitButton6 = new DigitButton("6", skin, txfBpmChange);
		digitButton6.setX(365);
		digitButton6.setY(370);
		stage.addActor(digitButton6);
		
		digitButton7 = new DigitButton("7", skin, txfBpmChange);
		digitButton7.setX(65);
		digitButton7.setY(220);
		stage.addActor(digitButton7);
		
		digitButton8 = new DigitButton("8", skin, txfBpmChange);
		digitButton8.setX(215);
		digitButton8.setY(220);
		stage.addActor(digitButton8);
		
		digitButton9 = new DigitButton("9", skin, txfBpmChange);
		digitButton9.setX(365);
		digitButton9.setY(220);
		stage.addActor(digitButton9);
		
		digitButton0 = new DigitButton("0", skin, txfBpmChange);
		digitButton0.setX(215);
		digitButton0.setY(70);
		stage.addActor(digitButton0);
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
			if(bpmDigits>MainScreen.MAX_BPM || bpmDigits<MainScreen.MIN_BPM){
				okButton.setDisabled(true);
				okButton.setTouchable(Touchable.disabled);
			}
			else{
				okButton.setDisabled(false);
				okButton.setTouchable(Touchable.enabled);
			}
		}
		else{
			okButton.setDisabled(true);
			okButton.setTouchable(Touchable.disabled);	
		}
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
