package com.mygdx.metronome.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.metronome.MainMenu;
import com.mygdx.metronome.ui.BpmButton;
import com.mygdx.metronome.ui.LessBpm;
import com.mygdx.metronome.ui.MoreBpm;
import com.mygdx.metronome.ui.PlayButton;
import com.mygdx.metronome.ui.StopButton;

public class MainScreen extends AbstractScreen{
	
	public static final int MIN_BPM = 20;
	public static final int MAX_BPM = 240;
	
	private boolean isButtonClicked;
	private boolean isMoreBpm;
	
	private float bpm=120;
	private Sound bpmSound;
	
	private Label bpmLabel;
	private Skin skin;
	private StopButton stopButton;
	private PlayButton playButton;
	private BpmButton changeBpmButton;
	private MoreBpm moreBpmButton;
	private LessBpm lessBpmButton;
	
	
	public MainScreen(MainMenu menu){
		super(menu);
		skin = new Skin(Gdx.files.internal("vhs-ui.json"));
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
	}
	
	private void initchangeBpmButton() {
		changeBpmButton = new BpmButton();
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
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = new BitmapFont();
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
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				isButtonClicked=false;
				super.touchUp(event, x, y, pointer, button);
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
		
		stopButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				playButton.setTouchable(Touchable.enabled);
				Timer.instance().clear();
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
	
	private void initPlayButton() {
		playButton = new PlayButton();
		stage.addActor(playButton);
		
		playButton.addListener(new ClickListener(){
			
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				setButtonClicked(true);
				playButton.setTouchable(Touchable.disabled);
					Timer.schedule(new Task() {
					
						@Override
						public void run() {
							bpmSound.play();
						}
					}, 0, (60/bpm));
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
		bpmLabel.setText(""+ (int)getBpm());
		stage.act();
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
