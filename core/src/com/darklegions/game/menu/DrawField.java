package com.darklegions.game.menu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.darklegions.game.gameobjects.Cards;
import com.darklegions.game.gameobjects.Creature;
import com.darklegions.game.DarkLegions;
import com.darklegions.game.manager.GameManager;

import org.w3c.dom.Text;

public class DrawField {

    public DarkLegions parent;


    public DrawField(DarkLegions parent) {
        this.parent = parent;
    }

    public Actor createField(GameManager currGame) {
        Gdx.app.log("Create", "drawField");


        Table gameField = new Table();
        //gameField.defaults().pad(10);
        gameField.defaults().width(200).height(180).expand().uniform();
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

    private void drawPlayer1(final Table gameField, final GameManager currGame) {
 /*
                Button Properties
         */
        Skin skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));
        float buttonWidth = Gdx.graphics.getWidth()/8 * 0.9f;
        float buttonHeight = buttonWidth * 1.0f;
        final float cardHeight = Cards.HEIGHT;
        final float cardWidth = Cards.WIDTH;
        /*
             Adding Player Stats and click listeners
         */

        Label label1 = new Label(currGame.player1.getPlayerName(), skin);
        final Label label2 = new Label("Health: " + currGame.player1.getHealthTotal(), skin);

        ClickListener clickListener = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(currGame.player1.getHealthTotal() < 1) {
                    Gdx.app.exit();
                }
                currGame.player1.setHealthTotal(currGame.player1.getHealthTotal() - 1);
                label2.setText("Health: " + currGame.player1.getHealthTotal());
            }
        };




        Window window = new Window("P1", skin);
        window.setMovable(false);
        window.setResizable(false);
        window.getTitleLabel().setAlignment(Align.center);
        window.add(label1).pad(0, 0, 0, 0).row();
        window.add(label2).pad(0, 0, 0, 0).row();
        TextButton phase = new TextButton("Sub Health", skin);
        phase.addListener(clickListener);
        window.add(phase).pad(0, 0, 0, 0).row();


        /*
              Player Hand
         */
        gameField.add(window).width(220).height(150).expand().uniform();
        for(int i = 0; i < currGame.player1.getPlayerHand().size(); i++) {
            gameField.add(currGame.player1.getPlayerHand().get(i).drawCard()).width(Cards.WIDTH).height(Cards.HEIGHT);
        }


        //gameField.add(handCardFive).width(buttonWidth).expandX();


        /*
            Creature and Deck Zone
         */
        gameField.row().width(200).height(150).expand().uniform();
        final Table creatureZone = new Table();
        final Button deckZone = new Button(new TextureRegionDrawable(currGame.player1.playerDeck.getCardBack()));
        deckZone.setSkin(skin);
        final TextButton deckZoneName = new TextButton(Integer.toString(currGame.player1.playerDeck.getDeckSize()), skin);
        deckZone.add(deckZoneName);
        TextButton creatureCard = new TextButton("Card", skin);
        TextButton creatureCard2 = new TextButton("Card", skin);
        TextButton creatureCard3 = new TextButton("Card", skin);
        TextButton creatureCard4 = new TextButton("Card", skin);
        TextButton graveZone = new TextButton("Graveyard", skin);


        ClickListener deckListener = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Cards topCard = currGame.player1.playerDeck.drawDeck();
                Table cardTable = topCard.drawCard();
                cardTable.setHeight(Cards.HEIGHT);
                cardTable.setWidth(Cards.WIDTH);
                gameField.addActorAfter(creatureZone, cardTable);
                cardTable.moveBy(900, 400);
                deckZoneName.setText(Integer.toString(currGame.player1.playerDeck.getDeckSize()));
            }
        };

        deckZone.addListener(deckListener);

        creatureZone.defaults().space(10).width(200).height(175).expand().uniform();

        gameField.add(creatureZone).colspan(6);
        creatureZone.add(graveZone);
        creatureZone.add(creatureCard);
        creatureZone.add(creatureCard2);
        creatureZone.add(creatureCard3);
        creatureZone.add(creatureCard4);
        creatureZone.add(deckZone).width(cardWidth).height(cardHeight);
        creatureZone.toBack();
        creatureZone.setDebug(true);

    }

    private void drawPlayer2(final Table gameField, final GameManager currGame) {


        Skin skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));
        float buttonWidth = Gdx.graphics.getWidth()/8 * 0.9f;
        float buttonHeight = buttonWidth * 1.0f;
        float cardWidth = Cards.WIDTH;
        float cardHeight = Cards.HEIGHT;
        TextButton playerTwo = new TextButton(currGame.player2.getPlayerName(), skin);

        final Table creatureZoneP2 = new Table();
        Button deckZoneP2 = new Button(new TextureRegionDrawable(currGame.player2.playerDeck.getCardBack()));
        deckZoneP2.setSkin(skin);
        final TextButton deckZoneName = new TextButton(Integer.toString(currGame.player2.playerDeck.getDeckSize()), skin);
        deckZoneP2.add(deckZoneName);
        TextButton creatureCardP2 = new TextButton("Card", skin);
        TextButton creatureCard2P2 = new TextButton("Card", skin);
        TextButton creatureCard3P2 = new TextButton("Card", skin);
        TextButton creatureCard4P2 = new TextButton("Card", skin);
        TextButton graveZoneP2 = new TextButton("Graveyard", skin);

        creatureZoneP2.defaults().space(10).width(200).height(180).expand().uniform();


        gameField.add(creatureZoneP2).colspan(6).fill();

        creatureZoneP2.add(deckZoneP2).width(cardWidth).height(cardHeight);
        creatureZoneP2.add(creatureCardP2);
        creatureZoneP2.add(creatureCard2P2);
        creatureZoneP2.add(creatureCard3P2);
        creatureZoneP2.add(creatureCard4P2);
        creatureZoneP2.add(graveZoneP2);
        creatureZoneP2.toBack();
        creatureZoneP2.setDebug(true);


        ClickListener deckListener = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Cards topCard = currGame.player2.playerDeck.drawDeck();
                Table cardTable = topCard.drawCard();
                cardTable.setWidth(Cards.WIDTH);
                cardTable.setHeight(Cards.HEIGHT);
                gameField.addActorAfter(creatureZoneP2, cardTable);
                cardTable.moveBy(400, 250);
                deckZoneName.setText(Integer.toString(currGame.player2.playerDeck.getDeckSize()));
            };
        };

        deckZoneP2.addListener(deckListener);

        gameField.row().width(250).height(150).expand().uniform();

        for(int i = 0; i < currGame.player2.getPlayerHand().size(); i++) {
            gameField.add(currGame.player2.getPlayerHand().get(i).drawCard()).width(cardWidth).height(cardHeight);
        }


        // ClickListener clickListener;
        Label label1 = new Label(currGame.player2.getPlayerName(), skin);
        final Label label2 = new Label("Health: " + currGame.player2.getHealthTotal(), skin);

        ClickListener healthListener = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(currGame.player2.getHealthTotal() < 1) {
                    Gdx.app.exit();
                }
                currGame.player2.setHealthTotal(currGame.player2.getHealthTotal() - 1);
                label2.setText("Health: " + currGame.player2.getHealthTotal());
            };
        };



        Window window = new Window("P2", skin);
        window.getTitleLabel().setAlignment(Align.center);
        window.setMovable(false);
        window.setResizable(false);
        window.add(label1).pad(0, 0, 0, 0).row();
        window.add(label2).pad(0, 0, 0, 0).row();
        TextButton phase = new TextButton("Sub Health", skin);
        phase.addListener(healthListener);
        window.add(phase).pad(0, 0, 0, 0).row();

        gameField.add(window).width(220).height(150).uniform();

    }
}