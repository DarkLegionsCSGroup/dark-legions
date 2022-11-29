package com.darklegions.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
    private Stage stage;
    private DarkLegions parent;
    public SpriteBatch batch = new SpriteBatch();
    public ShapeRenderer shapeRenderer = new ShapeRenderer();
    //public static Sprite backgroundSprite;
    //TODO: GET A NEW BACKGROUND IMAGE TO FIT AND SCALE PROPERLY
    Texture background = new Texture(Gdx.files.internal("concept.png"));
    Sprite backgroundSprite = new Sprite(background);




    public MenuScreen(final DarkLegions parent) {
        this.parent = parent;
        stage = new Stage(new ScreenViewport());
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

        Table table = new Table();
        table.setFillParent(true); //table is set to fill the stage
        table.setDebug(true); // This is optional, but enables debug lines for tables.
        stage.addActor(table); //Creates the table to be added to the stage

        Skin skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));

        /* BUTTONS FOR THE MAIN MENU */

        //TODO: Disable the gameTitle button or change it to text
        //TextField gameTitleNew = new TextField("Dark Legions", skin); //Was testing TextField instead of TextButton
        TextButton gameTitle = new TextButton("Dark Legions", skin);
        gameTitle.setDisabled(true);
        TextButton newGame = new TextButton("New Game", skin);
        TextButton gallery = new TextButton("Gallery", skin);
        TextButton options = new TextButton("Options", skin);
        TextButton exit = new TextButton("Exit", skin);

        /* FORMATTING BUTTONS INTO A TABLE */
        //TODO: Maybe shift the buttons over to the left side of the screen?
        table.left();
        table.padLeft(20);
        table.add(gameTitle).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(newGame).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(gallery).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(options).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(exit).fillX().uniformX();
        table.setDebug(true);


        /* BUTTON LISTENERS START */
        newGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.log("MenuScreen", "New Game Button Clicked");
                parent.changeScreen(DarkLegions.APPLICATION);
            }
        });

        options.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.log("MenuScreen", "Options Button Clicked");
                parent.changeScreen(DarkLegions.OPTIONS);
            }
        });

        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.log("MenuScreen", "Exit Button Clicked");
                Gdx.app.exit();
            }
        });

        /* BUTTON LISTENERS END */
        stage.draw();

    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        //Draws the background image to the screen
        stage.getBatch().begin();
        //TODO: FIX THE BACKGROUND IMAGE TO FIT THE SCREEN SIZE AND NOT BE STRETCHED
        stage.getBatch().draw(backgroundSprite, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //backgroundSprite.draw(stage.getBatch()); //Draws the background image to screen
        stage.getBatch().end();
        Gdx.input.setInputProcessor(stage);
        stage.draw();
        //testCard.drawCard(batch, shapeRenderer);
        //shapeRenderer.end();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        Gdx.app.debug("MenuScreen", "Disposing MenuScreen");
        stage.dispose();
    }
}
