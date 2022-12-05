package com.darklegions.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.darklegions.game.DarkLegions;

public class MainScreen extends ScreenAdapter {
    DarkLegions parent;
    Stage stage;
    OrthographicCamera camera;

    public MainScreen(final DarkLegions parent) {
        this.parent = parent;
        stage = new Stage(new ScreenViewport());
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));

        DrawField drawField = new DrawField(parent);
        stage.addActor(drawField.createField());
    }

    @Override
    public void render(float delta) {
        //Gdx.input.setInputProcessor(stage);
        super.render(delta);
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        camera = new OrthographicCamera();
        camera.setToOrtho(false,800,400);
        stage.draw();
        /* ESC Key Takes you back to Menu */
        //TODO: Changing Screens doesn't allow you to interact with the Menu Screen
        if(Gdx.input.isKeyJustPressed(111)) {
            Gdx.app.log("MainScreen", "Pressed");
            parent.changeScreen(DarkLegions.MENU);
        }
        //TODO: Draw empty playing field

    }
//    @Override
//    public void resize(int width, int height) {
//        //stage = new Stage(new StretchViewport(width, height));
//        Gdx.input.setInputProcessor(stage);
//        Gdx.graphics.setWindowedMode(1600  , 1000);
//        //TODO: Resize viewport to fit screen
//        //stage.getViewport().update(width, height, true);
//    }

    @Override
    public void dispose() {
       // Gdx.app.debug("MainScreen", "disposed");
        stage.dispose();
        parent.dispose();
    }
}
