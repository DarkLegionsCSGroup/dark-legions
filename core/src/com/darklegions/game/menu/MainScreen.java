package com.darklegions.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
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
import com.darklegions.game.manager.GameManager;

public class MainScreen extends ScreenAdapter implements InputProcessor {
    DarkLegions parent;
    Stage stage;
    OrthographicCamera camera;
    GameManager newGame;
    DrawField drawField;
    private InputMultiplexer inputMultiplexer;


    public MainScreen(final DarkLegions parent) {
        this.parent = parent;
        inputMultiplexer = new InputMultiplexer( this);
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        newGame = new GameManager();
        drawField = new DrawField(parent);
        stage.addActor(drawField.createField(newGame));
    }


    @Override
    public void render(float delta) {
        //Gdx.input.setInputProcessor(stage);
        super.render(delta);
        //newGame.manageState(drawField);
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

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
