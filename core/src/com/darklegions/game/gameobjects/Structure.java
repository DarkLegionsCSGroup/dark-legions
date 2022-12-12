package com.darklegions.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.Align;

public class Structure extends Actor implements Cards {

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    private String cardName;
    public String description;
    private UniqueEffect effectCard;
    public static Sprite cardArt;
    private Table table;
    private BitmapFont font = new BitmapFont(); //or use alex answer to use custom font
    private Skin skin;
    private Image background;
    Texture texture;
    BackgroundColor backgroundColor;


    public Structure(String name) {
        this.cardName = name;
        backgroundColor = new BackgroundColor("white_texture.png");
    }

    public Structure(String name, String Description) {
        this.description = Description;
        this.cardName = name;
        backgroundColor = new BackgroundColor("white_texture.png");
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

    @Override
    public String getType() {
        return "Structure";
    }


    public Table DrawCard() {

        table.setBackground(backgroundColor);
        table.addListener(new DragListener() {
            public void drag(InputEvent event, float x, float y, int pointer) {
                table.moveBy(x - table.getWidth() / 2, y - table.getHeight() / 2);
            }
        });
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

}
