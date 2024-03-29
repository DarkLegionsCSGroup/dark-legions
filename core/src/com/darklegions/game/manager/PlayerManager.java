package com.darklegions.game.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.darklegions.game.gameobjects.Cards;
import com.darklegions.game.gameobjects.Deck;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    private final static int MAX_HAND_SIZE = 5;
    private String playerName;

    private int playerID;
    private long totalWins;
    private long totalLosses;
    private ArrayList<String> Achievements = new ArrayList<>();
    private boolean isTurn;
    private int capacityResources;
    private Integer healthTotal;
    private Integer mineralTotal;
    private Integer magicTotal;
    private Integer motivationTotal;

    private List<Cards> playerHand;
    private Texture playerImage;
    public Deck playerDeck;


    public void init() {
        setTotalLosses(0);
        setTotalWins(0);
        setTurn(false);
        setCapacityResources(10);
        setHealthTotal(10);
        setMineralTotal(10);
        setMagicTotal(10);
        setMotivationTotal(10);
        drawPlayerHand();
    }

    public PlayerManager(Deck insertDeck, String pName, int pID) {
        /*
            Mandatory Constructor
         */
        setPlayerID(pID);
        setPlayerName(pName);
        playerDeck = insertDeck;
        playerHand = new ArrayList<>();
        this.playerImage = new Texture(Gdx.files.internal("concept.png"));
        init();
    }

    public PlayerManager() {

    }

    public void drawPlayerHand() {
        for(int i = 0; i < 5; i++) {
            playerHand.add(playerDeck.drawDeck());
        }
    }

    public void drawOne() {
        if(playerHand.size() < MAX_HAND_SIZE) {
            playerHand.add(playerDeck.drawDeck());
        }
    }
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public long getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(long totalWins) {
        this.totalWins = totalWins;
    }

    public long getTotalLosses() {
        return totalLosses;
    }

    public void setTotalLosses(long totalLosses) {
        this.totalLosses = totalLosses;
    }

    public ArrayList<String> getAchievements() {
        return Achievements;
    }

    public void setAchievements(ArrayList<String> achievements) {
        Achievements = achievements;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    public int getCapacityResources() {
        return capacityResources;
    }

    public void setCapacityResources(int capacityResources) {
        this.capacityResources = capacityResources;
    }

    public Integer getHealthTotal() {
        return healthTotal;
    }

    public void setHealthTotal(Integer healthTotal) {
        this.healthTotal = healthTotal;
    }

    public Integer getMineralTotal() {
        return mineralTotal;
    }

    public void setMineralTotal(Integer mineralTotal) {
        this.mineralTotal = mineralTotal;
    }

    public Integer getMagicTotal() {
        return magicTotal;
    }

    public void setMagicTotal(Integer magicTotal) {
        this.magicTotal = magicTotal;
    }

    public Integer getMotivationTotal() {
        return motivationTotal;
    }

    public void setMotivationTotal(Integer motivationTotal) {
        this.motivationTotal = motivationTotal;
    }

    public List<Cards> getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(List<Cards> playerHand) {
        this.playerHand = playerHand;
    }


}
