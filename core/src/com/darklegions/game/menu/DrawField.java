package com.darklegions.game.menu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.darklegions.game.gameobjects.Cards;
import com.darklegions.game.gameobjects.Creature;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.darklegions.game.DarkLegions;
import com.darklegions.game.manager.GameManager;

public class DrawField {
    public DarkLegions parent;
    public Creature card1;
    public Creature card2;
    public Creature card3;

    public DrawField(DarkLegions parent) {
        this.parent = parent;
        card1 = new Creature();
        card2 = new Creature("Eating God");
        card3 = new Creature("Dork");
    }

    public Actor createField(GameManager currGame) {
        Gdx.app.log("Create", "drawField");


        Table gameField = new Table();
        //gameField.defaults().pad(10);
        gameField.defaults().width(50).height(100).uniform();
        gameField.left().top();
        gameField.setFillParent(true);
        gameField.setDebug(true);
        gameField.padTop(30).padBottom(30);


        drawPlayer1(gameField, currGame);

        gameField.row();
        //gameField.add().size(0, 50);
        //gameField.row();

        drawPlayer2(gameField, currGame);

        return gameField;

    }

    private void drawPlayer1(Table gameField, GameManager currGame) {
 /*
                Button Properties
         */
        Skin skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));
        float buttonWidth = Gdx.graphics.getWidth()/8 * 0.9f;
        float buttonHeight = buttonWidth * 1.0f;
        float cardHeight = Cards.HEIGHT;
        float cardWidth = Cards.WIDTH;
        TextButton playerOne = new TextButton(currGame.player1.getPlayerName(), skin);
        TextButton handCardFive = new TextButton("card", skin);

        /*
              Player Hand
         */
        gameField.add(playerOne).width(200).height(100).uniform();
        for(int i = 0; i < currGame.player1.getPlayerHand().size(); i++) {
            gameField.add(currGame.player1.getPlayerHand().get(i).drawCard()).expand().width(cardWidth).height(cardHeight).uniform();
        }


        //gameField.add(handCardFive).width(buttonWidth).expandX();


        /*
            Creature and Deck Zone
         */
        gameField.row().height(150);
        Table creatureZone = new Table();
        TextButton deckZone = new TextButton("Deck Zone", skin);
        TextButton creatureCard = new TextButton("Card", skin);
        TextButton creatureCard2 = new TextButton("Card", skin);
        TextButton creatureCard3 = new TextButton("Card", skin);
        TextButton creatureCard4 = new TextButton("Card", skin);
        TextButton graveZone = new TextButton("Graveyard", skin);

        creatureZone.defaults().space(10).width(100).height(175).uniform();


        gameField.add(creatureZone).colspan(6);
        creatureZone.add(deckZone);
        creatureZone.add(creatureCard);
        creatureZone.add(creatureCard2);
        creatureZone.add(creatureCard3);
        creatureZone.add(creatureCard4);
        creatureZone.add(graveZone);
        creatureZone.setDebug(true);

    }

    private void drawPlayer2(Table gameField, GameManager currGame) {


        Skin skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));
        float buttonWidth = Gdx.graphics.getWidth()/8 * 0.9f;
        float buttonHeight = buttonWidth * 1.0f;
        float cardWidth = Cards.WIDTH;
        float cardHeight = Cards.HEIGHT;
        TextButton playerTwo = new TextButton(currGame.player2.getPlayerName(), skin);

        Table creatureZoneP2 = new Table();
        TextButton deckZoneP2 = new TextButton("Deck Zone", skin);
        TextButton creatureCardP2 = new TextButton("Card", skin);
        TextButton creatureCard2P2 = new TextButton("Card", skin);
        TextButton creatureCard3P2 = new TextButton("Card", skin);
        TextButton creatureCard4P2 = new TextButton("Card", skin);
        TextButton graveZoneP2 = new TextButton("Graveyard", skin);

        creatureZoneP2.defaults().space(10).width(100).height(175).uniform();


        gameField.add(creatureZoneP2).colspan(6);
        creatureZoneP2.add(deckZoneP2);
        creatureZoneP2.add(creatureCardP2);
        creatureZoneP2.add(creatureCard2P2);
        creatureZoneP2.add(creatureCard3P2);
        creatureZoneP2.add(creatureCard4P2);
        creatureZoneP2.add(graveZoneP2);
        creatureZoneP2.setDebug(true);

        gameField.row().height(150);

        for(int i = 0; i < currGame.player2.getPlayerHand().size(); i++) {
            gameField.add(currGame.player2.getPlayerHand().get(i).drawCard()).expand().width(cardWidth).height(cardHeight).uniform();
        }

        gameField.add(playerTwo).width(200).height(100).uniform();

    }
}