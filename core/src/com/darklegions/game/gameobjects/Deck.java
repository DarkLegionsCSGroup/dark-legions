package com.darklegions.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.darklegions.game.gameobjects.Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {
    /*
    Two Ideas:
    If we were to shuffle a deck of different objects, we would need an identifier to know which object is which eg Planet card is of "planet" type(string)
    The other idea is that we have multiple lists that only contain certain objects then shuffle and add n amount of those specific card types then shuffle the deck at the end.
     */
    private static final int MAX_STRUCTURE = 10;
    private static final int MAX_CREATURE = 20;
    private static final int MAX_SPELL = 10;
    private static final int DECK_SIZE = 40;


    Texture cardBack = new Texture(Gdx.files.internal("CardBack.png"));
    private int deckSize;

    private ArrayList<Cards> deck;
    private Creature[] creaturePool = new Creature[]{
            new Creature("Captain Bogart", "Cards/Captain_Bogart.png", "The Captain of Inner Circles"),
            new Creature("Space Dog", "Cards/Space Dog.png", "He's a dog. In Space."),
            new Creature("Mist Zombie", "Cards/Mist Zombie.png", "Scarier cause you can't see him"),
            new Creature("Zena the Instigator", "Cards/Zena Instigator.png", "Don't try me"),
            new Creature("Reaper", "Cards/Reaper.png", "Death's Assistant"),
            new Creature("Zombie Overlord", "Cards/Zombie Overlord.png", "King of the Zombies"),
            new Creature("Zombie Ferry", "Cards/Zombie Ferry.png", "Better than the S.I Ferry!"),
            new Creature("The All-Seeing Parasite", "Cards/Parasite.png", "Parasites are scary"),
            new Creature("Ice Golem", "Cards/Ice Golem.png", "Iceeeeeeee"),
            new Creature("Brax, Brother of Ice", "Cards/Brax Brother of Ice.png", "I'm made of fire"),
            new Creature("Garn, Brother of Fire" , "Cards/Garn Brother of Fire.png", "I'm made of ice"),
            new Creature("Fire Giant", "Cards/Fire Giant.png", "Fireeeeee"),
            new Creature("Mineral Worker", "Cards/Mineral Worker.png", "Minerals"),
            new Creature("Magic Cultist", "Cards/Magic Cultist.png", "DIE FOOLS"),
            new Creature("Political Guide", "Cards/Political Guide.png", "I'm here for you." ),
            //new Creature("TESTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT")
    };

    private Structure[] structurePool = new Structure[]{
            new Structure("Magic Festival"),
            new Structure("Night Colosseum"),
            new Structure("Cemetery Mineral Mine"),
            new Structure("Ice Field")
    };

    private Spell[] spellPool = new Spell[]{
            new Spell("Eye for an Eye"),
            new Spell("Sub Zero")
    };

    //Shuffle method using Fisher-Yates shuffle algorithm
    static <T>void shuffleArray(T[] arr) {
        Random rand = new Random();
        for(int i = arr.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            T a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
    }
    //Each deck should contain 10 structures, 10 spells, 20 creatures?
    public Deck() {
        this.deck = new ArrayList<>();
        shuffleArray(creaturePool);
        shuffleArray(spellPool);
        shuffleArray(structurePool);
        for(int i = 0; i < creaturePool.length; i++) {
            //shuffleArray(creaturePool);
            deck.add(creaturePool[i]);
        }
        for(int i = 0; i < spellPool.length; i++) {
            //shuffleArray(spellPool);
            deck.add(spellPool[i]);
        }
        for(int i = 0; i < structurePool.length; i++) {
            //shuffleArray(structurePool);
            deck.add(structurePool[i]);
        }

        setDeckSize(creaturePool.length + spellPool.length + structurePool.length);
        //setDeckSize(DECK_SIZE);
    }
    public ArrayList<Cards> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Cards> deck) {
        this.deck = deck;
    }

    public Cards drawDeck() {
        setDeckSize(getDeckSize() - 1);
        return (Cards) deck.remove(0);
    }

    public int getDeckSize() {
        return deckSize;
    }

    public Texture getCardBack() {
        return cardBack;
    }

    public void setCardBack(Texture cardBack) {
        this.cardBack = cardBack;
    }

    public void setDeckSize(int deckSize) {
        this.deckSize = deckSize;
    }
}
