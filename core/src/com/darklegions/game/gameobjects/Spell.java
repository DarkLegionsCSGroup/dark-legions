package com.darklegions.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

public class Spell implements Cards {
    private String cardName;
    private UniqueEffect effectCard;
    private Table table;
    public String description;
    private BitmapFont font = new BitmapFont(); //or use alex answer to use custom font
    private Skin skin;
    private Image background;
    Texture texture;
    BackgroundColor backgroundColor = new BackgroundColor("white_texture.png");


    public Spell(String name) {
        setDescription("I am a card");
        skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));
        table = new Table(skin);
        texture = new Texture(Gdx.files.internal("concept.png"));
        background = new Image(texture);
        backgroundColor.setColor(2, 179, 228, 255);

    }

    @Override
    public Sprite getSpriteCardBack() {
        return null;
    }

    @Override
    public Table drawCard() {

        table.setBackground(backgroundColor);
        /* Adds the "Cost" label and centers its text. */
        table.add("C").padLeft(10).width(30).height(30).getActor().setAlignment(Align.center);
        /* Important! Adds a column between "Cost" and "S". Used to
         * align "Image", "Title", "Description", and "Class". */
        table.add();
        /* Same as "Cost". */
        table.add("S").width(30).height(30).getActor().setAlignment(Align.center);
        table.row();

        /* Add "Image" to middle column with a height of 50% of the
         * background's height minus 75 (the top columns height). */
        table.add();
        table.add(background).size(100f);
        table.add();
        table.row();

        /* Add "Title".*/
        table.add();
        table.add(getCardName());
        table.add();
        table.row();

        /* Add "Description". */
        table.add();
        table.add(getDescription()).grow().getActor().setAlignment(Align.center);
        table.add();
        table.row();

        /* Add "Life", "Class", and "Attack". Same deal as "Cost" and
         * "S" */
        table.add("MC").width(30).height(30).getActor().setAlignment(Align.center);
        table.add("").growX().fillY().getActor().setAlignment(Align.center);
        table.add("END").width(30).height(30).getActor().setAlignment(Align.center);

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
        return description;
    }

    @Override
    public void setDescription(String description) {

    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public UniqueEffect getEffectCard() {
        return effectCard;
    }

    public void setEffectCard(UniqueEffect effectCard) {
        this.effectCard = effectCard;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public BitmapFont getFont() {
        return font;
    }

    public void setFont(BitmapFont font) {
        this.font = font;
    }

    public Skin getSkin() {
        return skin;
    }

    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    public Image getBackground() {
        return background;
    }

    public void setBackground(Image background) {
        this.background = background;
    }
}
