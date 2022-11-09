package com.darklegions.game.menu;

import com.badlogic.gdx.Screen;
import com.darklegions.game.DarkLegions;

public class LoadingScreen implements Screen {
    private DarkLegions parent;

    public LoadingScreen(DarkLegions darkLegions) {
        parent = darkLegions;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        parent.changeScreen(DarkLegions.MENU);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
