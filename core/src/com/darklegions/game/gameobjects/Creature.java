package com.darklegions.game.gameobjects;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

import sun.font.TextLabel;

public class Creature extends Actor implements Cards {

    public final static float HEIGHT = 200;
    public final static float WIDTH = 100;

    String cardName;
    private int power;
    private int defend;
    private UniqueEffect effectCard;
    public Sprite cardArt;
    public String description;
    private BitmapFont font = new BitmapFont(); //or use alex answer to use custom font
    private ShapeRenderer shapeRenderer;
    static private boolean projectionMatrixSet;



    public Creature() {
        this.cardName = "Default";
        this.power = 3;
        this.defend = 3;
        setDescription("I am a card");
        shapeRenderer = new ShapeRenderer();
    }

    public Creature (String cardName) {
        this.cardName = cardName;
        this.power = 3;
        this.defend = 3;
        setDescription("I am a card");
        shapeRenderer = new ShapeRenderer();
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

    public void DrawCard(ShapeRenderer shapeRenderer, SpriteBatch batch) {
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(15, 15, WIDTH, HEIGHT);
        shapeRenderer.setColor(Color.WHITE);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {


        batch.end();

        if(!projectionMatrixSet){
            shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        }
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(0, 0, WIDTH, HEIGHT);
        shapeRenderer.end();

        batch.begin();

        font.setColor(Color.WHITE);
        font.draw(batch, getCardName(), 200, 300);

    }

    @Override
    public Sprite getSpriteCardBack() {
        return null;
    }

    @Override
    public void drawCard(SpriteBatch batch, ShapeRenderer shape) {

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
}
