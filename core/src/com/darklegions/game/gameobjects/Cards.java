package com.darklegions.game.gameobjects;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;
import com.darklegions.game.DarkLegions;

public interface Cards {


    float HEIGHT = 200;
    float WIDTH = 100;


     Sprite spriteCardBack = null;
     String description = null;


     Sprite getSpriteCardBack();
     Table drawCard();
     void setSpriteCardBack(Sprite spriteCardBack);
     String getDescription();
     void setDescription(String description);
     String getType();


}
