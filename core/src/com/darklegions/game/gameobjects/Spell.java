package com.darklegions.game.gameobjects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Spell implements Cards {
    private String cardName;
    private UniqueEffect effectCard;
    public Sprite cardArt;

    public Spell(String name) {
        this.cardName = name;
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

    }
}
