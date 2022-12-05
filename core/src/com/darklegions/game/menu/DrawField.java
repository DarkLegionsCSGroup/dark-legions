package com.darklegions.game.menu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.darklegions.game.DarkLegions;
import org.w3c.dom.Text;

public class DrawField {
    public DarkLegions parent;

    public DrawField(DarkLegions parent) {
        this.parent = parent;

    }
    public Actor createField() {
        Gdx.app.log("Create", "drawField");

        /*
                Table Creation
         */
        Table gameField = new Table();
        gameField.defaults().pad(10);
        gameField.left().top();
        gameField.setFillParent(true);
        gameField.setDebug(true);

        /*
                Button Properties
         */
        Skin skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));
        float buttonWidth = Gdx.graphics.getWidth()/8 * 0.9f;
        float buttonHeight = buttonWidth * 1.3f;
        TextButton playerOne = new TextButton("Player 1", skin);
        TextButton playerTwo = new TextButton("Player 2", skin);
        TextButton handCardOne =  new TextButton("card", skin);
        TextButton handCardTwo = new TextButton("card", skin);
        TextButton handCardThree = new TextButton("card", skin);
        TextButton handCardFour = new TextButton("card", skin);
        TextButton handCardFive = new TextButton("card", skin);
        TextButton deckZone = new TextButton("Deck Zone", skin);
        TextButton creatureZone = new TextButton("Card", skin);

        handCardOne.setWidth(5);
        handCardTwo.setWidth(5);
        handCardThree.setWidth(5);
        handCardFour.setWidth(5);
        handCardFive.setWidth(5);

        gameField.add(playerOne);
        gameField.add(handCardOne).width(buttonWidth).expandX();
        gameField.add(handCardTwo).width(buttonWidth).expandX();
        gameField.add(handCardThree).width(buttonWidth).expandX();
        gameField.add(handCardFour).width(buttonWidth).expandX();
        gameField.add(handCardFive).width(buttonWidth).expandX();

        gameField.row();
        gameField.add(deckZone);
        gameField.add(creatureZone).width(buttonWidth).padLeft(400);

        //drawPlayer1(playerOneTable);
        //drawPlayer2(playerTwoTable);


       // gameField.add(headerLabel).colspan(2).fillX();

        return gameField;

    }

    private Table drawPlayer1(Table playerOneTable) {
        Gdx.app.log("DrawField", "drawPlayer1");

        playerOneTable.setDebug(true);

        Skin skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));

        TextButton playerOne = new TextButton("Player 1", skin);


        TextButton fieldZone = new TextButton("Field Zone", skin);
        TextButton graveyardZone = new TextButton("Graveyard Zone", skin);
        TextButton handZone = new TextButton("Hand Zone", skin);
        TextButton creatureZone = new TextButton("Creature Zone", skin);
        TextButton spellZone = new TextButton("Spell Zone", skin);
        TextButton lifeZone = new TextButton("Life", skin);


        return playerOneTable;
    }

    private Table drawPlayer2(Table playerTwoTable) {
        Gdx.app.log("DrawField", "drawPlayer2");
        //playerTwoTable.setFillParent(true);
        playerTwoTable.setDebug(true);

        Skin skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));


        TextButton playerTwo = new TextButton("Player 2", skin);
        TextButton deckZone = new TextButton("Deck Zone", skin);
        TextButton fieldZone = new TextButton("Field Zone", skin);
        TextButton graveyardZone = new TextButton("Graveyard Zone", skin);
        TextButton handZone = new TextButton("Hand Zone", skin);
        TextButton creatureZone = new TextButton("Creature Zone", skin);
        TextButton spellZone = new TextButton("Spell Zone", skin);
        TextButton exitButton = new TextButton("Exit", skin);

        playerTwoTable.add(playerTwo);
        playerTwoTable.row();
        playerTwoTable.add(deckZone);
        playerTwoTable.row();
        playerTwoTable.add(fieldZone);
        playerTwoTable.row();
        playerTwoTable.add(graveyardZone);

        return playerTwoTable;
    }
}
