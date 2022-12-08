package com.darklegions.game.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.darklegions.game.gameobjects.Deck;
import com.darklegions.game.menu.DrawField;

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

    public gameState getCurrGame() {
        return currGame;
    }

    public void setCurrGame(gameState currGame) {
        this.currGame = currGame;
    }


    public void manageState(DrawField adam) {
         switch(currGame) {
                case drawPlayer1:
                    player1.drawOne();
                    setCurrGame(gameState.mainPhasePlayer1);
                    Gdx.app.log("DRAW PHASE", "Game Drawn");
                    break;
                case mainPhasePlayer1:
                    Gdx.app.log("MAIN PHASE", "PLAYER 1");
                    setCurrGame(gameState.combatPlayer1);
                    break;
                case combatPlayer1:
                    Gdx.app.log("COMBAT PHASE", "Game Drawn");
                    setCurrGame(gameState.endPhasePlayer1);
                    break;
                case endPhasePlayer1:
                    Gdx.app.log("END PHASE", "End Phase Player 1");
                    setCurrGame(gameState.drawPlayer2);
                    break;
                case drawPlayer2:
                    Gdx.app.log("DRAW PHASE", "DRAW PHASE PLAYER 2");
                    player2.drawOne();
                    setCurrGame(gameState.mainPhasePlayer2);
                    break;
                case mainPhasePlayer2:
                    Gdx.app.log("MAIN PHASE 2", "Main PHASE 2");
                    setCurrGame(gameState.combatPlayer2);
                    break;
                case combatPlayer2:
                    Gdx.app.log("COMBAT PHASE 2", "COMBAT PHASE P2");
                    setCurrGame(gameState.endPhasePlayer2);
                    break;
                case endPhasePlayer2:
                    Gdx.app.log("END PHASE", "END PHASE 2");
                    setCurrGame(gameState.drawPlayer1);
                    break;
             default:
                 Gdx.app.log("GAME END", "GAME END");
         }
        }
    }