package com.darklegions.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.darklegions.game.DarkLegions;

//TODO: Create a loading screen

public class LoadingScreen extends AbstractGameScreen {
    final DarkLegions parent;

    public LoadingScreen(DarkLegions darkLegions) {
        super(darkLegions);
        parent = darkLegions;
    }

    @Override
    public void render(float delta) {
        Gdx.app.log("LoadingScreen", "render");
        parent.changeScreen(DarkLegions.MENU);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }


    public void hide() {
        dispose();
    }

    @Override
    public void pause() {

    }


    @Override
    public void dispose() {
        parent.dispose();

    }
}
