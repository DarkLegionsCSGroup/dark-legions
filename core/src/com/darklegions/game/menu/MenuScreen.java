package com.darklegions.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.darklegions.game.DarkLegions;
import com.darklegions.game.utils.Constants;

public class MenuScreen extends AbstractGameScreen {
    public static final String TAG = MenuScreen.class.getName();
    private Stage stage;
    private DarkLegions parent;
    public SpriteBatch batch = new SpriteBatch();
    public ShapeRenderer shapeRenderer = new ShapeRenderer();
    //public static Sprite backgroundSprite;
    //TODO: GET A NEW BACKGROUND IMAGE TO FIT AND SCALE PROPERLY

    private final Skin skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));


    //Options
    private Window winOptions; //Window for options
    private TextButton btnWinOptSave; //Save
    private TextButton btnWinClose; //Close the options window
    private CheckBox chkSound;
    private Slider sldSound;
    private CheckBox chkMusic;
    private Slider sldMusic;
    private CheckBox chkShowFpsCounter;

    Texture background = new Texture(Gdx.files.internal("concept.png"));
    Sprite backgroundSprite = new Sprite(background);

    private void rebuildStage () {
        // build all layers
        Table layerBackground = buildBackgroundLayer();
//        Table layerLogos = buildLogosLayer();
        Table layerControls = buildControlsLayer();
        Table layerLeftMenu = buildLeftMenuLayer();
        Table layerOptionsWindow = buildOptionsWindowLayer();

        // assemble stage for menu screen
        stage.clear();
        Stack stack = new Stack();
        stage.addActor(stack);
        stack.setSize(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT);
        stack.add(layerBackground);
//        stack.add(layerLogos);
        stack.add(layerLeftMenu);
        stack.add(layerControls);
        stage.addActor(layerOptionsWindow);
    }

    private Table buildBackgroundLayer () {
        Table layer = new Table();
        // + Background
        backgroundSprite = new Sprite(new Texture(Gdx.files.internal("concept.png")));
        backgroundSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        layer.add(new Image(backgroundSprite));
        return layer;
    }
//    private Table buildObjectsLayer () {
//        return new Table();
//    }
//    private Table buildLogosLayer () {
////        Table layer = new Table();
////        layer.left().top();
////        // + Game Logo
////        Image imgLogo = new Image(skin, "logo");
////        layer.add(imgLogo);
////        layer.row().expandY();
////        // + Info Logos
////        Image imgInfo = new Image(skin, "info");
////        layer.add(imgInfo).bottom();
////        if(debugEnabled) layer.debug();
////        return layer;
//    }

    private Table buildLeftMenuLayer() {
        Table layer = new Table();
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
        layer.left();
        layer.padLeft(20);
        layer.add(gameTitle).fillX().uniformX();
        layer.row().pad(10, 0, 10, 0);
        layer.add(newGame).fillX().uniformX();
        layer.row().pad(10, 0, 10, 0);
        layer.add(gallery).fillX().uniformX();
        layer.row().pad(10, 0, 10, 0);
        layer.add(options).fillX().uniformX();
        layer.row().pad(10, 0, 10, 0);
        layer.add(exit).fillX().uniformX();
        layer.setDebug(false);

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
        return layer;
    }

    private Table buildControlsLayer () {
        return new Table();
    }

    private void loadSettings() {
        Options prefs = Options.instance;
        prefs.load();
        chkSound.setChecked(prefs.sound);
        sldSound.setValue(prefs.soundVolume);
        chkMusic.setChecked(prefs.music);
        sldMusic.setValue(prefs.musicVolume);
        chkShowFpsCounter.setChecked(prefs.showFpsCounter);
    }

    private void saveSettings() {
        Options prefs = Options.instance;
        prefs.sound = chkSound.isChecked();
        prefs.soundVolume = sldSound.getValue();
        prefs.music = chkMusic.isChecked();
        prefs.musicVolume = sldMusic.getValue();
        prefs.showFpsCounter = chkShowFpsCounter.isChecked();
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
        return tbl;
    }

    private Table buildOptWinDebug () {
        Table tbl = new Table();
        // + Title: "Debug"
        tbl.pad(10, 10, 0, 10);
        tbl.add(new Label("Debug", skin, "font", Color.RED)).colspan(3);
        tbl.row();
        tbl.columnDefaults(0).padRight(10);
        tbl.columnDefaults(1).padRight(10);
        // + Checkbox, "Show FPS Counter" label
        chkShowFpsCounter = new CheckBox("", skin);
        tbl.add(new Label("Show FPS Counter", skin));
        tbl.add(chkShowFpsCounter);
        tbl.row();
        return tbl;
    }

    private Table buildOptWinButtons () {
        Table tbl = new Table();
        // + Separator
        Label lbl = null;
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
        // + Save Button with event handler
        btnWinOptSave = new TextButton("Save", skin);
        tbl.add(btnWinOptSave).padRight(30);
        btnWinOptSave.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                onSaveClicked();

            }
        });
        return tbl;
    }
        // + Cancel Button with event handler
        //create the window with the title
        private Window buildOptionsWindowLayer() {
            winOptions = new Window("Options", skin);
            // + Audio Settings: Sound/Music CheckBox and Volume Slider
            winOptions.add(buildOptWinAudioSettings()).row();
            // + Debug: Show FPS Counter
            winOptions.add(buildOptWinDebug()).row();
            // + Separator and Buttons (Save, Cancel)
            winOptions.add(buildOptWinButtons()).pad(10, 0, 10, 0);

            // Make options window slightly transparent
            winOptions.setColor(1, 1, 1, 0.8f);
            // Hide options window by default
            winOptions.setVisible(false);
            if (debugEnabled) winOptions.debug();
            // Let TableLayout recalculate widget sizes and positions
            winOptions.pack();
            // Move options window to bottom right corner
            //Get current viewport size
            float width = Gdx.graphics.getWidth();
            winOptions.setPosition(  width - winOptions.getWidth() - 50, 50);
            return winOptions;
        }
        // + Cancel Button with event handler
//        btnWinOptCancel = new TextButton("Cancel", skinLibgdx);
//        tbl.add(btnWinOptCancel);
//        btnWinOptCancel.addListener(new ChangeListener() {
//            @Override
//            public void changed (ChangeEvent event, Actor actor) {
//                onCancelClicked();
//            }
//        });
    public MenuScreen(DarkLegions darkLegions) {
        super(darkLegions);
        stage = new Stage(new ScreenViewport());
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

        //Get the OptionWindow Class to work
        final OptionWindow optionWindow = new OptionWindow(parent);

        Table table = new Table();
        table.setFillParent(true); //table is set to fill the stage
        table.setDebug(true); // This is optional, but enables debug lines for tables.

        stage.addActor(table); //Creates the table to be added to the stage

        //stage.addActor(OptionWindow);

        /* BUTTON LISTENERS END */
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
        //Table.drawDebug(stage);


//        super.render(delta);
//        // Clear the screen
//        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        //stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
//        //Draws the background image to the screen
//        stage.getBatch().begin();
//        //TODO: FIX THE BACKGROUND IMAGE TO FIT THE SCREEN SIZE AND NOT BE STRETCHED
//        stage.getBatch().draw(backgroundSprite, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        //backgroundSprite.draw(stage.getBatch()); //Draws the background image to screen
//        stage.getBatch().end();
//        Gdx.input.setInputProcessor(stage);
//        stage.draw();
//        testCard.drawCard(batch, shapeRenderer);
//        shapeRenderer.end();
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
