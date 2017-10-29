package com.mygdx.metronome;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.metronome.ui.LessBpm;
import com.mygdx.metronome.ui.MoreBpm;
import com.mygdx.metronome.ui.PlayButton;
import com.mygdx.metronome.ui.StopButton;

public class MainMenu extends Game implements Screen{
	
	public static final int MIN_BPM = 20;
	public static final int MAX_BPM = 240;
	
	private boolean isPaused;
	private boolean isButtonClicked;
	private boolean isMoreBpm;
	
	private float bpm=120;
	private Sound bpmSound;
	
	private Label bpmLabel;
	private Skin skin;
	private StopButton stopButton;
	private PlayButton playButton;
	private MoreBpm moreBpmButton;
	private LessBpm lessBpmButton;
	
	public final static String NAME = "Metronome";
	
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;
	
	private SpriteBatch spriteBatch;
	private Stage stage;
	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		bpmSound = Gdx.audio.newSound(Gdx.files.internal("bpm.wav"));
		stage = new Stage(new StretchViewport(MainMenu.WIDTH, MainMenu.HEIGHT));
		Gdx.input.setInputProcessor(stage);
		init();	
	}

	private void init() {
		initPlayButton();
		initStopButton();
		initMoreBpmButton();
		initLessBpmButton();
		initBpmLabel();
	}

	private void initBpmLabel() {
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = new BitmapFont();
		bpmLabel = new Label("", labelStyle);
		bpmLabel.setX(20);
		bpmLabel.setY(400);
		stage.addActor(bpmLabel);	
	}

	private void initLessBpmButton() {
		lessBpmButton = new LessBpm();
		stage.addActor(lessBpmButton);
		
		lessBpmButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				setMoreBpm(false);
				changeBpm();
				return super.touchDown(event, x, y, pointer, button);
			}
		});		
	}

	private void initMoreBpmButton() {
		moreBpmButton = new MoreBpm();
		stage.addActor(moreBpmButton);
		
		moreBpmButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				setMoreBpm(true);
				changeBpm();
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}

	protected void changeBpm() {
		if(isMoreBpm()){
			bpm++;
		}
		else{
			bpm--;
		}
		
	}

	private void initStopButton() {
		stopButton = new StopButton();
		stage.addActor(stopButton);
		
		stopButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
					Timer.instance().clear();
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
	
	public void stopSound(){
		
	}

	private void initPlayButton() {
		playButton = new PlayButton();
		stage.addActor(playButton);
		
		playButton.addListener(new ClickListener(){
			
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				isButtonClicked = true;
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
		
//		playButton.addListener(new ClickListener(){
//			@Override
//			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//				Timer.instance().clear();
//				super.touchUp(event, x, y, pointer, button);
//			}
//		});
	}
	
	public void addBpm(){
		bpm++;
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}
	
	public void update(){
		bpmLabel.setText(""+ getBpm());
		stage.act();
	}
	
	
	@Override
	public void dispose () {
		spriteBatch.dispose();
		bpmSound.dispose();
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	public boolean isPaused() {
		return isPaused;
	}

	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
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
}
