package com.darklegions.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.darklegions.game.menu.EndScreen;
import com.darklegions.game.menu.LoadingScreen;
import com.darklegions.game.menu.MainScreen;
import com.darklegions.game.menu.MenuScreen;
import com.darklegions.game.menu.OptionScreen;
import com.darklegions.game.menu.Options;
import com.darklegions.game.utils.Assets;

public class DarkLegions extends Game {
	public SpriteBatch batch;
	Texture img;
	public ShapeRenderer shapeRenderer;
	BitmapFont font;

	private LoadingScreen loadingScreen;
	private OptionScreen optionScreen;
	private MenuScreen menuScreen;
	private MainScreen mainScreen;
	private EndScreen endScreen;
	private Options prefs;

	//Use a TAG for logging purposes
	private static final String TAG = DarkLegions.class.getName();

	public final static int MENU = 0;
	public final static int OPTIONS = 1;
	public final static int APPLICATION = 2;
	public final static int ENDGAME = 3;

	public DarkLegions() {
	}

	public Options getPreferences() {
		return this.prefs;
	}

	public void changeScreen(int screen) {
		switch(screen) {
			case MENU:
				if(menuScreen == null) menuScreen = new MenuScreen(this);
				this.setScreen(menuScreen);
				break;
//			case OPTIONS:
//				if(optionScreen == null) optionScreen = new OptionScreen(this);
//				this.setScreen(optionScreen);
//				break;
			case APPLICATION:
				if(mainScreen == null) mainScreen = new MainScreen(this);
				this.setScreen(mainScreen);
				//Gdx.app.debug("DarkLegions", "Application");
				//
				break;
			case ENDGAME:
				if(endScreen == null) endScreen = new EndScreen(this);
				this.setScreen(endScreen);
				//Gdx.app.debug("DarkLegions", "EndGame");
				break;
		}
	}

	@Override
	public void create () {
		//Logging
		Gdx.app.setLogLevel(Gdx.app.LOG_DEBUG);
		//Load Assets
		Assets.instance.init(new AssetManager());
		//TODO: Create loading screen
		//Start the Loading Screen
		LoadingScreen loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);
		//prefs = new Options();
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		font = new BitmapFont();
	}


	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
		shapeRenderer.dispose();
		Assets.instance.dispose();
	}
}
