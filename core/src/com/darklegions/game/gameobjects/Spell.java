package com.darklegions.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
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
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.Align;

public class Spell extends Actor implements Cards {
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

    public Spell(String name, String Description) {
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
        skin.getFont("font").getData().setScale(0.3f);
        Label nameLabel = new Label(getCardName(), skin);
        //nameLabel.setScale(0.1f,0.1f);
        table.setBackground(backgroundColor);
        table.setTouchable(Touchable.enabled);
        table.setWidth(Cards.WIDTH);
        table.setHeight(Cards.HEIGHT);
        table.addListener(new DragListener() {
            public void drag(InputEvent event, float x, float y, int pointer) {
                table.moveBy(x - table.getWidth() / 2, y - table.getHeight() / 2);
                table.toFront();
            }
        });
        /* Adds the "Cost" label and centers its text. */
        table.add("C").width(1).height(1).top().left().getActor().setAlignment(Align.topLeft);
        /* Important! Adds a column between "Cost" and "S". Used to
         * align "Image", "Title", "Description", and "Class". */
        //table.add();
        /* Same as "Cost". */
        table.add("S").width(1).height(1).top().right().getActor().setAlignment(Align.topRight);
        table.row();

        /* Add "Image" to middle column with a height of 50% of the
         * background's height minus 75 (the top columns height). */
        //table.add();
        //table.add(background).size(75f, 75f).center().getActor().setAlign(Align.center);
        table.add(background).colspan(2).padTop(10).size(85f, 80f).getActor().setAlign(Align.center);
        //table.add();
        table.row();

        /* Add "Title".*/
        //table.add();
        table.add(nameLabel).colspan(2).top().getActor().setAlignment(Align.center);
        //table.add();
        table.row();

        /* Add "Description". */
        //table.add();
        table.add(getDescription()).colspan(2).grow().getActor().setAlignment(Align.center);
        //table.add();
        table.row();

        /* Add "Life", "Class", and "Attack". Same deal as "Cost" and
         * "S" */
        table.add("MC").width(1).height(1).bottom().left().getActor().setAlignment(Align.bottomLeft);
        //table.add("").growX().fillY().getActor().setAlignment(Align.center);
        table.add("End").width(1).height(1).bottom().right().getActor().setAlignment(Align.bottomRight);

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

    @Override
    public String getType() {
        return "Spell";
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
