package com.darklegions.game.manager;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.darklegions.game.gameobjects.Deck;

public class GameManager {

    public boolean isOver;
    public PlayerManager player1;
    public PlayerManager player2;
    public Deck p1Deck = new Deck();
    public Deck p2Deck = new Deck();
    private gameState currGame;

    public enum gameState {
        drawPlayer1,
        mainPhasePlayer1,
        combatPlayer1,
        endPhasePlayer1,
        drawPlayer2,
        mainPhasePlayer2,
        combatPlayer2,
        endPhasePlayer2,
    }

    //TODO: Retrieve Player 1 and Player 2's decks

    public GameManager() {
        startGame();
    }

    public void startGame() {
            isOver = false;
            player1 = new PlayerManager(p1Deck, "Prof Iacona", 1);
            player2 = new PlayerManager(p2Deck, "Adam", 2);
            currGame = gameState.drawPlayer1;
    }

    public void playGame(Table adam) {

        while (player1.getHealthTotal() > 0 && player2.getHealthTotal() > 0) {
            switch(currGame) {
                case drawPlayer1:
                    break;
                case drawPlayer2:
                    break;
            }
        }
    }


}
