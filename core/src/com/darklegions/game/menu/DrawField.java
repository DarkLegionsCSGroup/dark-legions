package com.darklegions.game.menu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
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


        Table gameField = new Table();
        gameField.defaults().pad(10);
        gameField.left().top();
        gameField.setFillParent(true);
        gameField.setDebug(true);
        gameField.padTop(30);


        drawPlayer1(gameField);

        gameField.row();
        gameField.add().size(0, 50);
        gameField.row();

        drawPlayer2(gameField);

        return gameField;

    }

    private void drawPlayer1(Table gameField) {
 /*
                Button Properties
         */
        Skin skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));
        float buttonWidth = Gdx.graphics.getWidth()/8 * 0.9f;
        float buttonHeight = buttonWidth * 1.3f;
        TextButton playerOne = new TextButton("Player 1", skin);
        TextButton handCardOne =  new TextButton("card", skin);
        TextButton handCardTwo = new TextButton("card", skin);
        TextButton handCardThree = new TextButton("card", skin);
        TextButton handCardFour = new TextButton("card", skin);
        TextButton handCardFive = new TextButton("card", skin);

        /*
              Player Hand
         */
        gameField.add(playerOne);
        gameField.add(handCardOne).width(buttonWidth).expandX();
        gameField.add(handCardTwo).width(buttonWidth).expandX();
        gameField.add(handCardThree).width(buttonWidth).expandX();
        gameField.add(handCardFour).width(buttonWidth).expandX();
        gameField.add(handCardFive).width(buttonWidth).expandX();


        /*
            Creature and Deck Zone
         */
        gameField.row();
        Table creatureZone = new Table();
        TextButton deckZone = new TextButton("Deck Zone", skin);
        TextButton creatureCard = new TextButton("Card", skin);
        TextButton creatureCard2 = new TextButton("Card", skin);
        TextButton graveZone = new TextButton("Graveyard", skin);

        creatureZone.defaults().space(10);


        gameField.add(creatureZone).colspan(6);
        creatureZone.add(deckZone);
        creatureZone.add(creatureCard);
        creatureZone.add(creatureCard2);
        creatureZone.add(graveZone);

    }

    private void drawPlayer2(Table gameField) {

        Skin skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));
        float buttonWidth = Gdx.graphics.getWidth()/8 * 0.9f;
        float buttonHeight = buttonWidth * 1.3f;
        TextButton playerTwo = new TextButton("Player 2", skin);

        Table creatureZoneP2 = new Table();
        TextButton deckZoneP2 = new TextButton("Deck Zone", skin);
        TextButton creatureCardP2 = new TextButton("Card", skin);
        TextButton creatureCard2P2 = new TextButton("Card", skin);
        TextButton graveZoneP2 = new TextButton("Graveyard", skin);

        creatureZoneP2.defaults().space(10);


        gameField.add(creatureZoneP2).colspan(6);
        creatureZoneP2.add(deckZoneP2);
        creatureZoneP2.add(creatureCardP2);
        creatureZoneP2.add(creatureCard2P2);
        creatureZoneP2.add(graveZoneP2);

        gameField.row();

        TextButton handCardOneP2 =  new TextButton("card", skin);
        TextButton handCardTwoP2 = new TextButton("card", skin);
        TextButton handCardThreeP2 = new TextButton("card", skin);
        TextButton handCardFourP2 = new TextButton("card", skin);
        TextButton handCardFiveP2 = new TextButton("card", skin);

        gameField.add(playerTwo);
        gameField.add(handCardOneP2).width(buttonWidth).expandX();
        gameField.add(handCardTwoP2).width(buttonWidth).expandX();
        gameField.add(handCardThreeP2).width(buttonWidth).expandX();
        gameField.add(handCardFourP2).width(buttonWidth).expandX();
        gameField.add(handCardFiveP2).width(buttonWidth).expandX();

    }
}
