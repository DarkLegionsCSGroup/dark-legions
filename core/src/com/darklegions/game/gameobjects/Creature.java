package com.darklegions.game.gameobjects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.Align;

import sun.font.TextLabel;

public class Creature extends Actor implements Cards {

    public final static float HEIGHT = 200;
    public final static float WIDTH = 100;

    private String cardName;
    private int power;
    private int defend;
    private Table table;
    private UniqueEffect effectCard;
    public Sprite cardArt;
    public String description;
    private BitmapFont font = new BitmapFont(); //or use alex answer to use custom font
    private Skin skin;
    private Image background;
    BackgroundColor backgroundColor = new BackgroundColor("white_texture.png");

    Texture texture;


    static private boolean projectionMatrixSet;



    public Creature() {
        this.cardName = "Default";
        this.power = 3;
        this.defend = 3;
        setDescription("I am a card");
        skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));
        table = new Table(skin);
        texture = new Texture(Gdx.files.internal("concept.png"));
        background = new Image(texture);
        backgroundColor.setColor(2, 179, 228, 255); // r, g, b, a
    }

    public Creature (String cardName) {
        this.cardName = cardName;
        this.power = 3;
        this.defend = 3;
        setDescription("I am a card");
        skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));
        table = new Table(skin);
        texture = new Texture(Gdx.files.internal("concept.png"));
        background = new Image(texture);
        backgroundColor.setColor(200, 0, 0, 255); // r, g, b, a
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDefend() {
        return defend;
    }

    public void setDefend(int defend) {
        this.defend = defend;
    }

    public UniqueEffect getEffectCard() {
        return effectCard;
    }

    public void setEffectCard(UniqueEffect effectCard) {
        this.effectCard = effectCard;
    }

    public Sprite getCardArt() {
        return cardArt;
    }

    public void setCardArt(Sprite cardArt) {
        this.cardArt = cardArt;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {


        batch.end();

        batch.begin();

        font.setColor(Color.WHITE);
        font.getData().setScale(5, 5);
        font.draw(batch, getCardName(), 200, 300);

    }

    @Override
    public Sprite getSpriteCardBack() {
        return null;
    }

    @Override
    public Table drawCard() {
        Label nameLabel = new Label(getCardName(), skin);
        nameLabel.setScale(0.5f,0.5f);
        table.setBackground(backgroundColor);
        table.setTouchable(Touchable.enabled);
        table.addListener(new DragListener() {
            public void drag(InputEvent event, float x, float y, int pointer) {
                table.moveBy(x - table.getWidth() / 2, y - table.getHeight() / 2);
            }
        });
        /* Adds the "Cost" label and centers its text. */
        table.add("C").width(5).height(5).uniform().getActor().setAlignment(Align.center);
        /* Important! Adds a column between "Cost" and "S". Used to
         * align "Image", "Title", "Description", and "Class". */
        table.add();
        /* Same as "Cost". */
        table.add("S").width(5).height(5).uniform().getActor().setAlignment(Align.center);
        table.row();

        /* Add "Image" to middle column with a height of 50% of the
         * background's height minus 75 (the top columns height). */
        table.add();
        table.add(background).size(75f, 75f).getActor().setAlign(Align.center);
        table.add();
        table.row();

        /* Add "Title".*/
        table.add();
        table.add(nameLabel).width(Cards.WIDTH).getActor().setAlignment(Align.center);
        table.add();
        table.row();

        /* Add "Description". */
        table.add();
        table.add(getDescription()).grow().getActor().setAlignment(Align.center);
        table.add();
        table.row();

        /* Add "Life", "Class", and "Attack". Same deal as "Cost" and
         * "S" */
        table.add(Integer.toString(getPower())).width(5).height(5).uniform().getActor().setAlignment(Align.center);
        table.add("").growX().fillY().getActor().setAlignment(Align.center);
        table.add(Integer.toString(getDefend())).width(5).height(5).uniform().getActor().setAlignment(Align.center);

        /* Used to show the table above the background image. You
         * should probably use Table#setBackground(drawable)
         * instead of using a stack! */
        return table;
    }

    @Override
    public void setSpriteCardBack(Sprite spriteCardBack) {

    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getType() {
        return "Creature";
    }
}
