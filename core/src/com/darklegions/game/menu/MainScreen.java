package com.darklegions.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.darklegions.game.DarkLegions;

public class MainScreen extends ScreenAdapter {
    final DarkLegions parent;
    private Stage stage;


    public MainScreen(DarkLegions parent) {
        this.parent = parent;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        //TODO: Draw empty playing field



    }
    @Override
    public void resize(int width, int height) {
        stage = new Stage(new StretchViewport(800, 480));
        Gdx.input.setInputProcessor(stage);
        Gdx.graphics.setWindowedMode(1920, 1080);
        //TODO: Resize viewport to fit screen
        stage.getViewport().update(width, height, true);


    }

    @Override
    public void dispose() {

    }
}
