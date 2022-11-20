package com.darklegions.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.darklegions.game.DarkLegions;
import com.darklegions.game.menu.OptionScreen;

import jdk.jfr.internal.Options;

public class OptionScreen extends ScreenAdapter {
    private DarkLegions parent;

    public OptionScreen(DarkLegions darkLegions) {
        parent = darkLegions;
    }

    @Override
    public void show() {

    }

    @Override
    public void dispose() {

    }
}
