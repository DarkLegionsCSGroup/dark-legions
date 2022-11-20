package com.darklegions.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.darklegions.game.DarkLegions;
import com.darklegions.game.gameobjects.Cards;
import com.darklegions.game.gameobjects.Creature;

import javax.swing.event.ChangeEvent;

public class MenuScreen extends ScreenAdapter {
    private final Stage stage;
    private final DarkLegions parent;
    public SpriteBatch batch = new SpriteBatch();
    public ShapeRenderer shapeRenderer = new ShapeRenderer();

    public MenuScreen(DarkLegions darkLegions) {
        parent = darkLegions;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void show() {
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);

        Skin skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));

        //TODO: Disable the gameTitle button or change it to text
        //TODO: Change gameTitle to be TextFields instead of TextButtons
        //TextField gameTitleNew = new TextField("Dark Legions", skin);
        TextButton gameTitle = new TextButton("Dark Legions", skin);
        gameTitle.setDisabled(true);
        Gdx.app.log("MenuScreen", "gameTitle: " + gameTitle.getText());
        TextButton newGame = new TextButton("New Game", skin);
        Gdx.app.log("MenuScreen", "newGame: " + newGame.getText());
        TextButton options = new TextButton("Options", skin);
        Gdx.app.log("MenuScreen", "options: " + options.getText());
        TextButton exit = new TextButton("Exit", skin);
        Gdx.app.log("MenuScreen", "exit: " + exit.getText());


        table.add(gameTitle).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(newGame).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(options).fillX().uniformX();
        table.row();
        table.add(exit).fillX().uniformX();

        newGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.log("MenuScreen", "New Game Button Clicked");
                //parent.changeScreen(DarkLegions.APPLICATION);
            }
        });

        options.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.log("MenuScreen", "Options Button Clicked");
                //parent.changeScreen(DarkLegions.OPTIONS);
            }
        });

        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.log("MenuScreen", "Exit Button Clicked");
                Gdx.app.exit();
            }
        });

        stage.draw();

    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        //testCard.drawCard(batch, shapeRenderer);
        //shapeRenderer.end();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
        stage.dispose();
    }
}
