package com.darklegions.game.menu;

import com.badlogic.gdx.ScreenAdapter;
import com.darklegions.game.DarkLegions;

//TODO:

public class LoadingScreen extends ScreenAdapter {
    final DarkLegions parent;

    public LoadingScreen(DarkLegions darkLegions) {
        parent = darkLegions;
    }

    @Override
    public void render(float delta) {
        parent.changeScreen(DarkLegions.MENU);
    }

    @Override
    public void dispose() {

    }
}
