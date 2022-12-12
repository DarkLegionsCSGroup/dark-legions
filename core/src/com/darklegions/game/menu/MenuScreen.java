package com.darklegions.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.darklegions.game.DarkLegions;
import com.darklegions.game.utils.Constants;

public class MenuScreen extends AbstractGameScreen {
    public static final String TAG = MenuScreen.class.getName();
    private OrthographicCamera camera;
    private Stage stage;
    private DarkLegions parent =  (DarkLegions) Gdx.app.getApplicationListener();

    private Skin skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));


    //Options
    private Window winOptions; //Window for options
    private CheckBox chkSound;
    private Slider sldSound;
    private CheckBox chkMusic;
    private Slider sldMusic;
    private CheckBox chkShowFpsCounter;
    private CheckBox chkShowFullScreen;
    private TextButton textButton;

    Texture background = new Texture(Gdx.files.internal("concept.png"));
    Sprite backgroundSprite = new Sprite(background);

    private void rebuildStage () {
        // build all layers
        Table layerBackground = buildBackgroundLayer();
        Table layerControls = buildControlsLayer();
        Table layerLeftMenu = buildLeftMenuLayer();
        Table layerOptionsWindow = buildOptionsWindowLayer();

        // assemble stage for menu screen
        stage.clear();
        Stack stack = new Stack();
        stage.addActor(stack);
        stack.setSize(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT);
        stack.add(layerBackground);
        stack.add(layerLeftMenu);
        stack.add(layerControls);
        stage.setDebugAll(false); // remove later
        stage.addActor(layerOptionsWindow);
    }

    /**
     * Builds the background layer.
     * @return
     */
    private Table buildBackgroundLayer () {
        Table layer = new Table();
        backgroundSprite = new Sprite(new Texture(Gdx.files.internal("concept.png")));
        backgroundSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        layer.add(new Image(backgroundSprite));
        return layer;
    }

    /**
     * Builds the controls layer.
     * @return
     */
    private Table buildLeftMenuLayer() {
        Table layer = new Table();
        layer.pad(0, 0, 0, 0);
        /* BUTTONS FOR THE MAIN MENU */
        //TODO: Disable the gameTitle button or change it to text
        Label gameTitle = new Label("Dark Legions", skin, "title");
        TextButton newGame = new TextButton("New Game", skin);
        TextButton gallery = new TextButton("Gallery", skin);
        TextButton options = new TextButton("Options", skin);
        TextButton exit = new TextButton("Exit", skin);

        skin.getFont("title").getData().setScale(0.5f);


        /* FORMATTING BUTTONS INTO A TABLE */
        //TODO: Maybe shift the buttons over to the left side of the screen?
        layer.left();
        layer.padLeft(5);
        layer.add(gameTitle).colspan(2).align(Align.left).padBottom(20);
        layer.row().pad(2, 0, 2, 0);
        layer.add(newGame).align(Align.left).padBottom(20);
        layer.row().pad(2, 0, 2, 0);
        layer.add(gallery).align(Align.left).padBottom(20);
        layer.row().pad(2, 0, 2, 0);
        layer.add(options).align(Align.left).padBottom(20);
        layer.row().pad(2, 0, 2, 0);
        layer.add(exit).align(Align.left).padBottom(20);
        layer.setTransform(true);
        layer.setScale(0.75f);
        //layer.align(Align.top);
        //layer.setScale(0.5f);
        //layer.setWidth(100);
        //Align the table to the left side of the screen and set the position to the bottom


        /**
         * LISTENERS FOR BUTTONS
         */
        /* BUTTON LISTENERS START */
        newGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.log("MenuScreen", "New Game Button Clicked");
                //parent.changeScreen(DarkLegions.APPLICATION);
                parent.changeScreen(DarkLegions.APPLICATION);
            }
        });

        options.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.log("MenuScreen", "Options Button Clicked");

                //TODO: Get the OptionWindow to work
                loadSettings();
                winOptions.setVisible(true);
                //                optionWindow.show(stage);
//                stage.addActor(optionWindow); //Creates the options window to be added to the stage
            }
        });
        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.log("MenuScreen", "Exit Button Clicked");
                Gdx.app.exit();
            }
        });
        layer.setDebug(true);

        return layer;
    }

    /**
     * Builds the controls layer.
     * @return
     */
    private Table buildControlsLayer () {
        return new Table();
    }

    /**
     * Builds the options window layer.
     * @return
     */
    private void loadSettings() {
        Options prefs = Options.instance;
        prefs.load();
        chkSound.setChecked(prefs.sound);
        sldSound.setValue(prefs.soundVolume);
        chkMusic.setChecked(prefs.music);
        sldMusic.setValue(prefs.musicVolume);
        chkShowFpsCounter.setChecked(prefs.showFpsCounter);
        chkShowFullScreen.setChecked(prefs.isFullScreen);

    }

    /**
     * Builds the options window layer.
     * @return
     */
    private void saveSettings() {
        Options prefs = Options.instance;
        prefs.sound = chkSound.isChecked();
        prefs.soundVolume = sldSound.getValue();
        prefs.music = chkMusic.isChecked();
        prefs.musicVolume = sldMusic.getValue();
        prefs.showFpsCounter = chkShowFpsCounter.isChecked();
        prefs.isFullScreen = chkShowFullScreen.isChecked();
        prefs.save();
    }

    // debug
    private final float DEBUG_REBUILD_INTERVAL = 5.0f;
    private final boolean debugEnabled = false;

    private float debugRebuildStage;

    private void onSaveClicked() {
        saveSettings();
        //hideOptionsWindow();
    }

    //Get fullscreen boolean value

    private void isFullScreenChecked() {
        if(chkShowFullScreen.isChecked()) {
            Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        } else {
            Gdx.graphics.setWindowedMode(800, 480);
        }
    }

    private Table buildOptWinAudioSettings() {
        Table tbl = new Table();
        // + Title: "Audio"
        tbl.pad(10, 10, 0, 10);
        tbl.add(new Label("Audio",skin, "font", Color.ORANGE)).colspan(3);
        tbl.row();
        tbl.columnDefaults(0).padRight(10);
        tbl.columnDefaults(1).padRight(10);
        // + Checkbox, "Sound" label, sound volume slider
        chkSound = new CheckBox("", skin);
        tbl.add(chkSound);
        tbl.add(new Label("Sound", skin));
        sldSound = new Slider(0.0f, 1.0f, 0.1f, false, skin);
        tbl.add(sldSound);
        tbl.row();
        // + Checkbox, "Music" label, music volume slider
        chkMusic = new CheckBox("", skin);
        tbl.add(chkMusic);
        tbl.add(new Label("Music", skin));
        sldMusic = new Slider(0.0f, 1.0f, 0.1f, false, skin);
        tbl.add(sldMusic);
        tbl.row();
        tbl.setDebug(false);
        return tbl;
    }

    private Table buildOptWinDebug () {
        Table tbl = new Table();
        tbl.pad(10, 10, 0, 10);
        tbl.add(new Label("Debug", skin, "font", Color.RED)).colspan(3);
        tbl.row();
        tbl.columnDefaults(0).padRight(10);
        tbl.columnDefaults(1).padRight(10);
        chkShowFpsCounter = new CheckBox("", skin);
        tbl.add(new Label("Show FPS Counter", skin));
        chkShowFullScreen = new CheckBox("", skin);
        tbl.add(chkShowFpsCounter);
        tbl.row();
        tbl.add(new Label("Set FullScreen", skin));
        tbl.add(chkShowFullScreen);
        tbl.setDebug(false);
        return tbl;
    }

    //
    private Table buildOptWinButtons () {
        Table tbl = new Table();
        Label lbl;
        lbl = new Label("", skin);
        lbl.setColor(0.75f, 0.75f, 0.75f, 1);
        lbl.setStyle(new Label.LabelStyle(lbl.getStyle()));
        lbl.getStyle().background = skin.newDrawable("white");
        tbl.add(lbl).colspan(2).height(1).width(220).pad(0, 0, 0, 1);
        tbl.row();
        lbl = new Label("", skin);
        lbl.setColor(0.5f, 0.5f, 0.5f, 1);
        lbl.setStyle(new Label.LabelStyle(lbl.getStyle()));
        lbl.getStyle().background = skin.newDrawable("white");
        tbl.add(lbl).colspan(2).height(1).width(220).pad(0, 1, 5, 0);
        tbl.row();

        //Save button
        TextButton btnWinOptSave = new TextButton("Save", skin);
        tbl.add(btnWinOptSave).padRight(30);
        //Close the options window
        TextButton btnWinClose = new TextButton("Close", skin);
        tbl.add(btnWinClose).padLeft(30);

        // Listener for the save button
        btnWinOptSave.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                onSaveClicked();
            }
        });

        // Listener for the close button
        btnWinClose.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                hideOptionsWindow();
            }
        });

        //Lister to check if fullscreen is checked
        chkShowFullScreen.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.debug("MenuScreen", "chkShowFullScreen checked" + chkShowFullScreen.isChecked());
                isFullScreenChecked();

            }
        });
        tbl.setDebug(false);

        return tbl;
    }

    //Sets the options window to be hidden
    private void hideOptionsWindow() {
        winOptions.setVisible(false);
    }

    private Window buildOptionsWindowLayer() {
        winOptions = new Window("Options", skin);
        winOptions.getTitleLabel().setAlignment(Align.center); //Center the winOptions text in the title
        winOptions.add(buildOptWinAudioSettings()).row(); //Audio Settings: Sound/Music CheckBox and Volume Slider

        winOptions.add(buildOptWinDebug()).row();
        winOptions.add(buildOptWinButtons()).pad(10, 0, 10, 0);

        // Make options window slightly transparent
        winOptions.setColor(1, 1, 1, 0.8f);
        winOptions.setVisible(false);
        if (debugEnabled) winOptions.debug();
        winOptions.pack();
        float width = Gdx.graphics.getWidth();
        winOptions.setPosition(  width - winOptions.getWidth() - 50, 50);
        winOptions.setMovable(false);
        winOptions.setDebug(false);
        winOptions.setTransform(true);
        winOptions.setScale(0.5f);
        return winOptions;
    }

    public MenuScreen(DarkLegions darkLegions) {
        super(darkLegions);

//        camera = new OrthographicCamera();
//        camera.position.set(0, 0, 0);
//        camera.setToOrtho(false, 800, 480);
//        camera.update();

        stage = new Stage(new ScreenViewport());
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
//        stage.draw();

        Table table = new Table();
        table.setFillParent(false); //table is set to fill the stage
        table.setDebug(false); // This is optional, but enables debug lines for tables.
        stage.addActor(table); //Creates the table to be added to the stage

        stage.draw();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.getBatch().begin();
        stage.getBatch().draw(backgroundSprite, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage.getBatch().end();
        Gdx.input.setInputProcessor(stage);

        if(debugEnabled) {
            debugRebuildStage -= delta;
            if(debugRebuildStage <= 0) {
                debugRebuildStage = 10;
                rebuildStage();
            }
        }
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    public void hide() {
        stage.dispose();
    }

    @Override
    public void pause() {

    }

    @Override
    public void show() {
        stage = new Stage(new StretchViewport(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT));
        Gdx.input.setInputProcessor(stage);
        rebuildStage();
    }


    @Override
    public void dispose() {
        Gdx.app.debug("MenuScreen", "Disposing MenuScreen");
        stage.dispose();
    }
}
