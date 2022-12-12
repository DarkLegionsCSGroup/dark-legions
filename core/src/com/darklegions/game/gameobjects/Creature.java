package com.darklegions.game.gameobjects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;


public class Creature extends Actor implements Cards {

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
        this.setDescription("I am a card");
        skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));
        //skin.getFont("font").getData().setScale(0.1f);
        table = new Table(skin);
        texture = new Texture(Gdx.files.internal("BasicTemplate.png"));
        background = new Image(texture);
//        backgroundColor.setWidth(Cards.WIDTH);
//        backgroundColor.setHeight(Cards.HEIGHT);
        backgroundColor.setColor(2, 179, 228, 255); // r, g, b, a
    }

    public Creature (String cardName) {
        this.cardName = cardName;
        this.power = 3;
        this.defend = 3;
        this.setDescription("I am a card");
        skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));
        //skin.getFont("font").getData().setScale(0.1f);
        table = new Table(skin);
        texture = new Texture(Gdx.files.internal("concept.png"));
        background = new Image(texture);
        backgroundColor.setColor(200, 0, 0, 255); // r, g, b, a
    }


    public Creature (String cardName, String Texture, String Description) {
        this.cardName = cardName;
        this.power = 3;
        this.defend = 3;
        this.setDescription(Description);
        skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));
        //skin.getFont("font").getData().setScale(0.1f);
        table = new Table(skin);
        texture = new Texture(Gdx.files.internal(Texture));
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
        skin.getFont("font").getData().setScale(0.3f);
        table.setWidth(Cards.WIDTH);
        table.setHeight(Cards.HEIGHT);
        Label nameLabel = new Label(getCardName(), skin);
        //nameLabel.setScale(0.1f,0.1f);
        nameLabel.setWidth(Cards.WIDTH - 10);
        table.setBackground(backgroundColor);
        table.setTouchable(Touchable.enabled);
        table.defaults().setActorBounds(10,10,Cards.WIDTH,Cards.HEIGHT);
        table.addListener(new DragListener() {
            public void drag(InputEvent event, float x, float y, int pointer) {
                table.moveBy(x - table.getWidth() / 2, y - table.getHeight() / 2);
                table.toFront();
            }
        });
        table.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(getTapCount() == 2) {
                    table.setWidth(Cards.WIDTH * 2);
                    table.setHeight(Cards.HEIGHT * 2);
                    skin.getFont("font").getData().setScale(1f);
                }
                if(getTapCount() == 1) {
                    table.setWidth(Cards.WIDTH);
                    table.setHeight(Cards.HEIGHT);
                    skin.getFont("font").getData().setScale(0.3f);
                }
            }
        });
        /* Adds the "Cost" label and centers its text. */
        table.add("C").top().left().getActor().setAlignment(Align.topLeft);
        /* Important! Adds a column between "Cost" and "S". Used to
         * align "Image", "Title", "Description", and "Class". */
        //table.add();
        /* Same as "Cost". */
        table.add("S").top().right().getActor().setAlignment(Align.topRight);
        table.row();

        /* Add "Image" to middle column with a height of 50% of the
         * background's height minus 75 (the top columns height). */
        //table.add();
        //table.add(background).size(75f, 75f).center().getActor().setAlign(Align.center);
        table.add(background).colspan(2).padTop(2).size(Cards.WIDTH - 10, Cards.HEIGHT / 2).getActor().setAlign(Align.center);
        //table.add();
        table.row();

        /* Add "Title".*/
        //table.add();
        table.add(nameLabel).width(Cards.WIDTH - 10).colspan(2).top().getActor().setAlignment(Align.center);
        //table.add();
        table.row();

        /* Add "Description". */
        //table.add();
        table.add(this.description).width(Cards.WIDTH - 10).colspan(2).grow().top().getActor().setAlignment(Align.center);
        //table.add();
        table.row();

        /* Add "Life", "Class", and "Attack". Same deal as "Cost" and
         * "S" */
        table.add(Integer.toString(getPower())).bottom().left().getActor().setAlignment(Align.bottomLeft);
        //table.add("").growX().fillY().getActor().setAlignment(Align.center);
        table.add(Integer.toString(getDefend())).bottom().right().getActor().setAlignment(Align.bottomRight);

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
