package com.darklegions.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.darklegions.game.DarkLegions;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Dark Legions - Card Game");
		config.setWindowedMode(1400, 800);
		config.useVsync(true);
		new Lwjgl3Application(new DarkLegions(), config);
	}
}
