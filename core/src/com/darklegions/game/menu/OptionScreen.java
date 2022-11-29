package com.darklegions.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.darklegions.game.DarkLegions;

public class OptionScreen extends ScreenAdapter {
    private Stage stage;
    private DarkLegions parent;
    public SpriteBatch batch = new SpriteBatch();
    public ShapeRenderer shapeRenderer = new ShapeRenderer();
    private Label titleLabel;
    private Label volumeMusicLabel;
    private Label volumeSoundLabel;
    private Label musicOnOffLabel;
    private Label soundOnOffLabel;

    public OptionScreen(final DarkLegions parent) {
        this.parent = parent;
        stage = new Stage(new ScreenViewport());
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));

        Table table = new Table();
        table.setFillParent(true); //table is set to fill the stage
        table.setDebug(true); // This is optional, but enables debug lines for tables.
        stage.addActor(table); //Creates the table to be added to the stage

        Skin skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));

        titleLabel = new Label("Options", skin);
        volumeMusicLabel = new Label("Music Volume", skin);
        volumeSoundLabel = new Label("Sound Volume", skin);
        musicOnOffLabel = new Label("Music On/Off", skin);
        soundOnOffLabel = new Label("Sound On/Off", skin);

        //volume
        final Slider volumeMusicSlider = new Slider(0f, 1f, 0.1f, false, skin);
        volumeMusicSlider.setValue(parent.getPreferences().getMusicVolume());
        volumeMusicSlider.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                parent.getPreferences().setMusicVolume(volumeMusicSlider.getValue());
                return false;
            }
        });

        //sound
        final Slider soundSlider = new Slider(0f, 1f, 0.1f, false, skin);
        soundSlider.setValue(parent.getPreferences().getSoundVolume());
        soundSlider.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                parent.getPreferences().setSoundVolume(soundSlider.getValue());
                return false;
            }
        });

        //music checkbox
        final CheckBox musicCheckBox = new CheckBox("Music", skin);
        musicCheckBox.setChecked(parent.getPreferences().isMusicEnabled());
        musicCheckBox.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                boolean enabled = musicCheckBox.isChecked();
                parent.getPreferences().setMusicEnabled(enabled);
                return false;
            }
        });

        //sound checkbox
        final CheckBox soundCheckBox = new CheckBox("Sound", skin);
        soundCheckBox.setChecked(parent.getPreferences().isSoundEffectsEnabled());
        soundCheckBox.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                boolean enabled = soundCheckBox.isChecked();
                parent.getPreferences().setSoundEffectsEnabled(enabled);
                return false;
            }
        });

        //return to main menu button
        final TextButton backButton = new TextButton("Back", skin);
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.log("MenuScreen", "Back Button Clicked");
                parent.changeScreen(DarkLegions.MENU);
            }
        });

        table.add(titleLabel);
        table.row();
        table.add(volumeMusicLabel);
        table.add(volumeMusicSlider);
        table.row();
        table.add(musicOnOffLabel);
        table.add(musicCheckBox);
        table.row();
        table.add(volumeSoundLabel);
        table.add(soundSlider);
        table.row();
        table.add(soundOnOffLabel);
        table.add(soundCheckBox);
        table.row();
        table.add(backButton);
        table.setDebug(true);
        table.setFillParent(true);

        stage.draw();
    }

    @Override
    public void show() {
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

//    @Override
//    public void resize(int width, int height) {
//        stage.getViewport().update(width, height, true);
//    }

    @Override
    public void dispose() {
        Gdx.app.debug("OptionsScreen", "Disposing OptionsScreen");
        stage.dispose();
    }
}
