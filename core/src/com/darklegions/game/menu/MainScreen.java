package com.darklegions.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.darklegions.game.DarkLegions;

public class MainScreen extends ScreenAdapter {
    final DarkLegions parent;
    private Stage stage;

    public MainScreen(final DarkLegions parent) {
        this.parent = parent;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

        Gdx.input.setInputProcessor(stage);
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);

        Skin skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));

        TextButton deckZone = new TextButton("Deck Zone", skin);
        TextButton fieldZone = new TextButton("Field Zone", skin);
        TextButton graveyardZone = new TextButton("Graveyard Zone", skin);
        TextButton handZone = new TextButton("Hand Zone", skin);
        TextButton creatureZone = new TextButton("Creature Zone", skin);
        TextButton spellZone = new TextButton("Spell Zone", skin);
        TextButton exitButton = new TextButton("Exit", skin);

        table.add(deckZone).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(fieldZone).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(graveyardZone).fillX().uniformX();
        stage.draw();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

        /* ESC Key Takes you back to Menu */
        //TODO: Changing Screens doesn't allow you to interact with the Menu Screen
        if(Gdx.input.isKeyJustPressed(111)) {
            Gdx.app.log("MainScreen", "Pressed");
            parent.changeScreen(DarkLegions.MENU);
        }
        //TODO: Draw empty playing field

    }
    @Override
    public void resize(int width, int height) {
        stage = new Stage(new StretchViewport(1920, 1080));
        Gdx.input.setInputProcessor(stage);
        Gdx.graphics.setWindowedMode(1920, 1080);
        //TODO: Resize viewport to fit screen
        stage.getViewport().update(width, height, true);


    }

//    @Override
//    public void hide() {
//        //Gdx.input.setInputProcessor(null);
//    }

    @Override
    public void dispose() {
        Gdx.app.debug("MainScreen", "disposed");
        stage.dispose();
        parent.dispose();
    }
}
