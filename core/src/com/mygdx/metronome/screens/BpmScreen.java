package com.mygdx.metronome.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.metronome.MainMenu;

import com.mygdx.metronome.ui.BpmTextField;
import com.mygdx.metronome.ui.CancelButton;
import com.mygdx.metronome.ui.DigitButton;
import com.mygdx.metronome.ui.OkButton;

public class BpmScreen extends AbstractScreen{
	
	private OkButton okButton;
	private CancelButton cancelButton;
	private DigitButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;

	private BpmTextField txfBpmChange;
	private MainScreen bpmChange;
	private MainScreen bpmLabelKeyboard;
	private Skin skin;
	
	private float bpmKeyboard;
	
	public BpmScreen(MainMenu menu) {
		super(menu);
		skin = new Skin(Gdx.files.internal("vhs-ui.json"));

		init();
	}
	
	private void init() {
		initOkButton();	
		initCancelButton();
		initTxfBpmChange();
		initDigitButtons();
	}

	private void initDigitButtons() {
		button1 = new DigitButton("1", skin);
		button1.setBounds(65, 520, 50, 50);
		stage.addActor(button1);
		button1.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				txfBpmChange.setText(txfBpmChange.getText()+"1");
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
		button2 = new DigitButton("2", skin);
		button2.setBounds(215, 520, 50, 50);
		stage.addActor(button2);
		button2.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				txfBpmChange.setText(txfBpmChange.getText()+"2");
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
		button3 = new DigitButton("3", skin);
		button3.setBounds(365, 520, 50, 50);
		stage.addActor(button3);
		button3.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				txfBpmChange.setText(txfBpmChange.getText()+"3");
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
		button4 = new DigitButton("4", skin);
		button4.setBounds(65, 370, 50, 50);
		stage.addActor(button4);
		button4.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				txfBpmChange.setText(txfBpmChange.getText()+"4");
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
		button5 = new DigitButton("5", skin);
		button5.setBounds(215, 370, 50, 50);
		stage.addActor(button5);
		button5.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				txfBpmChange.setText(txfBpmChange.getText()+"5");
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
		button6 = new DigitButton("6", skin);
		button6.setBounds(365, 370, 50, 50);
		stage.addActor(button6);
		button6.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				txfBpmChange.setText(txfBpmChange.getText()+"6");
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
		button7 = new DigitButton("7", skin);
		button7.setBounds(65, 220, 50, 50);
		stage.addActor(button7);
		button7.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				txfBpmChange.setText(txfBpmChange.getText()+"7");
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
		button8 = new DigitButton("8", skin);
		button8.setBounds(215, 220, 50, 50);
		stage.addActor(button8);
		button8.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				txfBpmChange.setText(txfBpmChange.getText()+"8");
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
		button9 = new DigitButton("9", skin);
		button9.setBounds(365, 220, 50, 50);
		stage.addActor(button9);
		button9.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				txfBpmChange.setText(txfBpmChange.getText()+"9");
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
		button0 = new DigitButton("0", skin);
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
		txfBpmChange = new BpmTextField("", skin);
		stage.addActor(txfBpmChange);
	}

	private void initCancelButton() {
		cancelButton = new CancelButton("Cancel", skin);
		stage.addActor(cancelButton);
		
		cancelButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				menu.setScreen(new MainScreen(menu, y));
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}

	private void initOkButton() {
		okButton = new OkButton("OK", skin);
		stage.addActor(okButton);
		
		okButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//				bpmChange = new MainScreen(menu);
				bpmKeyboard = Float.parseFloat(txfBpmChange.getText());
//				bpmLabelKeyboard = new MainScreen(menu, bpmKeyboard);
				checkTextField();
				
//				
//				bpmChange.setBpm(bpmKeyboard);
//				bpmLabelKeyboard.getBpmLabel().setText(""+bpmKeyboard);
				menu.setScreen(new MainScreen(menu, bpmKeyboard));
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}

	protected void checkTextField() {
		
		
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
	}

}
