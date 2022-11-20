package com.darklegions.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.darklegions.game.menu.EndScreen;
import com.darklegions.game.menu.LoadingScreen;
import com.darklegions.game.menu.MainScreen;
import com.darklegions.game.menu.MenuScreen;
import com.darklegions.game.menu.OptionScreen;

public class DarkLegions extends Game {
	SpriteBatch batch;
	Texture img;

	private LoadingScreen loadingScreen;
	private OptionScreen optionScreen;
	private MenuScreen menuScreen;
	private MainScreen mainScreen;
	private EndScreen endScreen;

	public final static int MENU = 0;
	public final static int OPTIONS = 1;
	public final static int APPLICATION = 2;
	public final static int ENDGAME = 3;


	public void changeScreen(int screen) {
		switch(screen) {
			case MENU:
				if(menuScreen == null) menuScreen = new MenuScreen(this);
				this.setScreen(menuScreen);
				break;
			case OPTIONS:
				if(optionScreen == null) optionScreen = new OptionScreen(this);
				this.setScreen(optionScreen);
				break;
			case APPLICATION:
				if(mainScreen == null) mainScreen = new MainScreen(this);
				this.setScreen(mainScreen);
				break;
			case ENDGAME:
				if(endScreen == null) endScreen = new EndScreen(this);
				this.setScreen(endScreen);
				break;
		}
	}

	@Override
	public void create () {
		LoadingScreen loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);
	}
/*
	@Override
	public void render () {

	}

	@Override
	public void dispose () {

	}
 */
}
