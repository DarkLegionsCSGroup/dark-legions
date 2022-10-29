package com.darklegions.game.manager;

import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

public class PlayerManager {
    private String playerName;
    private int playerID;
    private long totalWins;
    private long totalLosses;
    private ArrayList<String> Achievements;
    private boolean isTurn;
    private int capacityResources;
    private Integer healthTotal;
    private Integer mineralTotal;
    private Integer magicTotal;
    private Integer motivationTotal;
    private Sprite playerImage;
}
