package com.darklegions.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.darklegions.game.DarkLegions;

@Deprecated
//TODO: Remove this class eventually
// This class is deprecated because it is being implemented inside the MenuScreen class
public class OptionWindow extends Window {

    private Stage stage;
    private DarkLegions parent;
    public SpriteBatch batch = new SpriteBatch();
    public ShapeRenderer shapeRenderer = new ShapeRenderer();

    //TODO: Create a window that will display the options for the game

    public OptionWindow(final DarkLegions parent) {
        super("Options", new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json")));
        this.parent = parent;
        Skin skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));

        final TextButton backButton = new TextButton("Back", skin);
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.log("MenuScreen", "Back Button Clicked");
                parent.changeScreen(DarkLegions.MENU);
            }
        });

        Window options = new Window("Options", new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json")));

        Label volumeMusicLabel = new Label("Music Volume", skin);
        Label volumeSoundLabel = new Label("Sound Volume", skin);
        Label musicOnOffLabel = new Label("Music On/Off", skin);
        Label soundOnOffLabel = new Label("Sound On/Off", skin);

        options.setMovable(false);
        options.setResizable(false);
        options.setKeepWithinStage(true);
        options.setDebug(true);
        options.setVisible(true);
//        options.add(titleLabel);
//        options.row();
        options.add(volumeMusicLabel);
        options.row();
        options.add(volumeSoundLabel);
        options.row();
        options.add(musicOnOffLabel);
        options.row();
        options.add(soundOnOffLabel);
        options.row();
        options.add(backButton);
        options.pack();
        //options.setPosition(0, 0);

        float newWidth = options.getWidth();
        float newHeight = options.getHeight();

        options.setBounds((Gdx.graphics.getWidth() - newWidth) / 2, (Gdx.graphics.getHeight() - newHeight) / 2, newWidth, newHeight);
        //stage.addActor(options);
    }


    public void show(Stage stage) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //stage.clear();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
//        stage.getBatch().begin();
//        stage.getBatch().draw(backgroundSprite, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        stage.getBatch().end();
        stage.draw();
        Gdx.input.setInputProcessor(stage); //This line of code should be placed somewhere in the show/render methods instead of in object creation.
    }
}
