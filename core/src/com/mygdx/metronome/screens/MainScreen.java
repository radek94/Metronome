package com.mygdx.metronome.screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.metronome.BpmName;
import com.mygdx.metronome.MainMenu;
import com.mygdx.metronome.ui.ClickCallBack;
import com.mygdx.metronome.ui.LessBpm;
import com.mygdx.metronome.ui.MoreBpm;
import com.mygdx.metronome.ui.PlayButton;
import com.mygdx.metronome.ui.StopButton;

public class MainScreen extends AbstractScreen{
		
	private float bpm;

	private Label bpmLabel, bpmNameLabel;
	private Slider slider;
	private StopButton stopButton;
	private PlayButton playButton;
	private Button changeBpmButton;
	private MoreBpm moreBpmButton;
	private LessBpm lessBpmButton;
	
	
	public MainScreen(MainMenu menu, float bpm){
		super(menu);
		this.bpm = bpm;
		init();
	}
	
	private void init() {
		initPlayButton();
		initStopButton();
		initMoreBpmButton();
		initLessBpmButton();
		initBpmLabel();
		initBpmNameLabel();
		initchangeBpmButton();
		initSlider();
	}
	
	private void initPlayButton() {
		playButton = new PlayButton(new ClickCallBack() {
			
			@Override
			public void onClick() {
				playButton.setTouchable(Touchable.disabled);
				playButton.setVisible(false);
				stopButton.setVisible(true);
					Timer.schedule(new Task() {
					
						@Override
						public void run() {
							bpmSound.play();
						}
					}, 0, (60/getBpm()));
			}
		});
		stage.addActor(playButton);
		playButton.setVisible(true);
	}
	
	private void initStopButton() {
		stopButton = new StopButton(new ClickCallBack() {
			
			@Override
			public void onClick() {
				playButton.setTouchable(Touchable.enabled);
				Timer.instance().clear();
				stopButton.setVisible(false);
				playButton.setVisible(true);
			}
		});
		stage.addActor(stopButton);
		stopButton.setVisible(false);
	}
	
	private void initMoreBpmButton() {
		moreBpmButton = new MoreBpm("+", skin, () -> bpm++);	
		stage.addActor(moreBpmButton);
	}
	
	private void initLessBpmButton() {
		lessBpmButton = new LessBpm("-", skin, () -> bpm--);
		stage.addActor(lessBpmButton);
	}
	
	private void initBpmLabel() {
		bpmLabel = new Label("", skin);
		bpmLabel.setBounds(205, 570, 70, 50);
		bpmLabel.setAlignment(1);
		stage.addActor(bpmLabel);	
	}
	
	private void initBpmNameLabel() {
		bpmNameLabel = new Label("", skin);
		bpmNameLabel.setBounds(170, 480, 140, 50);
		bpmNameLabel.setAlignment(1);
		stage.addActor(bpmNameLabel);		}
	
	private void initchangeBpmButton() {
		changeBpmButton = new Button(new ButtonStyle());
		changeBpmButton.setBounds(190, 570, 100, 80);
		stage.addActor(changeBpmButton);
		
		changeBpmButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				menu.setScreen(new BpmScreen(menu));
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
	
	private void initSlider() {
		slider = new Slider(MainMenu.MIN_BPM, MainMenu.MAX_BPM, 1, false, skin);
		slider.setBounds(90, 380, 300, 50);
		stage.addActor(slider);
		slider.setValue(getBpm());
		
		slider.addListener(new ChangeListener() {	
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				setBpm((int)slider.getValue());			
			}
		});
	}

	@Override
	public void render(float delta) {
		update();
		super.render(delta);
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}
	
	public void update(){
		getBpmLabel().setText("BPM: "+ (int)getBpm());
		getBpmNameLabel().setText((BpmName.getBpmName(getBpm())));
		checkMoreBpmButton();
		checkLessBpmButton();
		stage.act();
	}
	
	// checking if bpm is 240. If so, the button is disabled
	public void checkMoreBpmButton(){
		if(getBpm()>=MainMenu.MAX_BPM){
			moreBpmButton.setDisabled(true);
			moreBpmButton.setTouchable(Touchable.disabled);
		}
		else{
			moreBpmButton.setDisabled(false);
			moreBpmButton.setTouchable(Touchable.enabled);
		}
	}
	
	// checking if bpm is 20. If so, the button is disabled
	public void checkLessBpmButton(){
		if(getBpm()<=MainMenu.MIN_BPM){
			lessBpmButton.setDisabled(true);
			lessBpmButton.setTouchable(Touchable.disabled);
		}
		else{
			lessBpmButton.setDisabled(false);
			lessBpmButton.setTouchable(Touchable.enabled);
		}
	}
	
	// getters & setters
	public void setBpmLabel(Label bpmLabel){
		this.bpmLabel = bpmLabel;
	}
	
	public Label getBpmLabel(){
		return bpmLabel;
	}
	
	public void setBpmNameLabel(Label bpmNameLabel){
		this.bpmNameLabel = bpmNameLabel;
	}
	
	public Label getBpmNameLabel(){
		return bpmNameLabel;
	}
	
	public void setBpm(float bpm){
		this.bpm=bpm;
	}
	
	public float getBpm(){
		return bpm;
	}
}
