package com.darklegions.game.gameobjects;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;
import com.darklegions.game.DarkLegions;

public interface Cards {


    public final static float HEIGHT = 200;
    public final static float WIDTH = 100;


    public Sprite spriteCardBack = null;
    public String description = null;



    public Sprite getSpriteCardBack();
    public Table drawCard();
    public void setSpriteCardBack(Sprite spriteCardBack);
    public String getDescription();
    public void setDescription(String description);


}
