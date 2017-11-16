package com.mygdx.metronome.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.metronome.MainMenu;
import com.mygdx.metronome.ui.LessBpm;
import com.mygdx.metronome.ui.MoreBpm;
import com.mygdx.metronome.ui.PlayButton;
import com.mygdx.metronome.ui.StopButton;

public class MainScreen extends AbstractScreen{
	
	public static final int MIN_BPM = 20;
	public static final int MAX_BPM = 240;
	
	private boolean isButtonClicked;
	private boolean isMoreBpm;
	private boolean isRunning;
	
	private float bpm=120;
	private Sound bpmSound;
	
	private Label bpmLabel;
	private Skin skin;
	private Slider slider;
	private StopButton stopButton;
	private PlayButton playButton;
	private Button changeBpmButton, metreButton;
	private MoreBpm moreBpmButton;
	private LessBpm lessBpmButton;
	
	
	public MainScreen(MainMenu menu, float bpm){
		super(menu);
		this.bpm = bpm;
		skin = new Skin(Gdx.files.internal("Holo-dark-mdpi.json"));
		bpmSound = Gdx.audio.newSound(Gdx.files.internal("bpm.wav"));
		init();
	}
	
	private void init() {
		initPlayButton();
		initStopButton();
		initMoreBpmButton();
		initLessBpmButton();
		initBpmLabel();
		initchangeBpmButton();
		initSlider();
	}
	
	private void initSlider() {
		slider = new Slider(MainScreen.MIN_BPM, MainScreen.MAX_BPM, 1, false, skin);
		slider.setBounds(100, 500, 200, 50);
		stage.addActor(slider);
		slider.setValue(getBpm());
		
		slider.addListener(new ChangeListener() {
			
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				setBpm((int)slider.getValue());
				
			}
		});
	}
	
	private void initchangeBpmButton() {
		changeBpmButton = new Button(new ButtonStyle());
		changeBpmButton.setBounds(190, 600, 100, 50);
		stage.addActor(changeBpmButton);
		
		changeBpmButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				menu.setScreen(new BpmScreen(menu));
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}

	private void initBpmLabel() {
		bpmLabel = new Label("", skin);
		bpmLabel.setX(190);
		bpmLabel.setY(600);
		bpmLabel.setWidth(100);
		bpmLabel.setHeight(50);
		stage.addActor(bpmLabel);	
	}
	
	private void initLessBpmButton() {
		lessBpmButton = new LessBpm("-", skin);
		stage.addActor(lessBpmButton);
		
		lessBpmButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				isButtonClicked=true;				
				bpm--;				
				return super.touchDown(event, x, y, pointer, button);
			}
		});		
	}
	
	private void initMoreBpmButton() {
		moreBpmButton = new MoreBpm("+", skin);
		stage.addActor(moreBpmButton);
		
		moreBpmButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				
				bpm++;
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
	
	private void initStopButton() {
		stopButton = new StopButton();
		stage.addActor(stopButton);
		stopButton.setVisible(false);
		
		stopButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				playButton.setTouchable(Touchable.enabled);
				isRunning = false;
				Timer.instance().clear();
				stopButton.setVisible(false);
				playButton.setVisible(true);
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
	
	private void initPlayButton() {
		playButton = new PlayButton();
		stage.addActor(playButton);
		playButton.setVisible(true);
		
		playButton.addListener(new ClickListener(){
			
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				setButtonClicked(true);
				playButton.setTouchable(Touchable.disabled);
				isRunning = true;
				playButton.setVisible(false);
				stopButton.setVisible(true);
					Timer.schedule(new Task() {
					
						@Override
						public void run() {
							bpmSound.play();
						}
					}, 0, (60/getBpm()));
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
	
	public void addBpm(){
		bpm++;
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
		getBpmLabel().setText(""+ (int)getBpm());
		checkMoreBpmButton();
		checkLessBpmButton();
		stage.act();
	}
	
	public void checkMoreBpmButton(){
		if(getBpm()>=MAX_BPM || getBpm()<=MIN_BPM) moreBpmButton.setTouchable(Touchable.disabled);
		else moreBpmButton.setTouchable(Touchable.enabled);
	}
	
	public void checkLessBpmButton(){
		if(getBpm()<=MIN_BPM) lessBpmButton.setTouchable(Touchable.disabled);
		else lessBpmButton.setTouchable(Touchable.enabled);
	}
	
	public void setBpmLabel(Label bpmLabel){
		this.bpmLabel = bpmLabel;
	}
	
	public Label getBpmLabel(){
		return bpmLabel;
	}
	
	public void setBpm(float bpm){
		this.bpm=bpm;
	}
	
	public float getBpm(){
		return bpm;
	}

	public boolean isMoreBpm() {
		return isMoreBpm;
	}

	public void setMoreBpm(boolean isMoreBpm) {
		this.isMoreBpm = isMoreBpm;
	}

	public boolean isButtonClicked() {
		return isButtonClicked;
	}

	public void setButtonClicked(boolean isButtonClicked) {
		this.isButtonClicked = isButtonClicked;
	}
		
}
