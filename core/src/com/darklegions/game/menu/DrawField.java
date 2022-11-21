package com.darklegions.game.menu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.darklegions.game.DarkLegions;
import org.w3c.dom.Text;

public class DrawField {
    DarkLegions parent;

    public DrawField(DarkLegions parent) {
        this.parent = parent;

    }
    public Actor createField() {
        Gdx.app.log("Create", "drawField");
        Table gameField = new Table();
        gameField.setFillParent(true);
        gameField.setDebug(true);

        //gameField.add(drawPlayer2()).top();
        //gameField.row().pad(0, 0, 10f, 0);
        gameField.add(drawPlayer1()).bottom().maxWidth(1000f);

        return gameField;

    }

    private Table drawPlayer1() {
        Gdx.app.log("DrawField", "drawPlayer1");

        Table playerOneTable = new Table();
        //playerOneTable.setFillParent(true);
        playerOneTable.setDebug(true);
        playerOneTable.setWidth(1000f);
        playerOneTable.setHeight(400f);
        playerOneTable.align(1);
        playerOneTable.padTop(100);

        Table centerField = new Table();
        centerField.setDebug(true);

        Skin skin = new Skin(Gdx.files.internal("skin/star-soldier/skin/star-soldier-ui.json"));

        TextButton playerOne = new TextButton("Player 1", skin);
        TextButton deckZone = new TextButton("Deck Zone", skin);
        TextButton fieldZone = new TextButton("Field Zone", skin);
        TextButton graveyardZone = new TextButton("Graveyard Zone", skin);
        TextButton handZone = new TextButton("Hand Zone", skin);
        TextButton creatureZone = new TextButton("Creature Zone", skin);
        TextButton spellZone = new TextButton("Spell Zone", skin);
        TextButton lifeZone = new TextButton("Life", skin);

        playerOneTable.add(playerOne).bottom();
        playerOneTable.row();
        playerOneTable.add(deckZone);
        playerOneTable.row();
        playerOneTable.add(fieldZone);
        playerOneTable.row();
        playerOneTable.add(graveyardZone).left();
        playerOneTable.row();
        playerOneTable.add(handZone);
        playerOneTable.row();
        playerOneTable.add(creatureZone);
        playerOneTable.row();
        playerOneTable.add(spellZone);
        playerOneTable.row();
        playerOneTable.add(lifeZone).bottom().maxWidth(10);

        return playerOneTable;
    }

    private Table drawPlayer2() {
        Gdx.app.log("DrawField", "drawPlayer2");
        Table playerTwoTable = new Table();
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

        playerTwoTable.add(playerTwo).top();
        playerTwoTable.row();
        playerTwoTable.add(deckZone).fillX().uniformX();
        playerTwoTable.row();
        playerTwoTable.add(fieldZone).fillX().uniformX();
        playerTwoTable.row();
        playerTwoTable.add(graveyardZone).fillX().uniformX();

        return playerTwoTable;
    }
}
