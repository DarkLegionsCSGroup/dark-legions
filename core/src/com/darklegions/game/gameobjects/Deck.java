package com.darklegions.game.gameobjects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.darklegions.game.gameobjects.Cards;
import com.sun.tools.javac.file.PathFileObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {
    /*
    Two Ideas:
    If we were to shuffle a deck of different objects, we would need an identifier to know which object is which eg Planet card is of "planet" type(string)
    The other idea is that we have multiple lists that only contain certain objects then shuffle and add n amount of those specific card types then shuffle the deck at the end.
     */

    private ArrayList<Cards> deck;
    private Creature[] creaturePool = new Creature[]{
            new Creature("Captain Bogart"),
            new Creature("Space Dog"),
            new Creature("Mist Zombie"),
            new Creature("Zena the Instigator"),
            new Creature("Reaper"),
            new Creature("Zombie Overlord"),
            new Creature("Zombie Ferry"),
            new Creature("The All-Seeing Parasite"),
            new Creature("Ice Golem"),
            new Creature("Brax, Brother of Ice"),
            new Creature("Garn, Brother of Fire"),
            new Creature("Fire Giant"),
            new Creature("Mineral Worker"),
            new Creature("Magic Cultist"),
            new Creature("Political Guide")
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
        int structureLimit = 10;
        int spellLimit = 10;
        int creatureLimit = 20;
        for(int i = 0; i < creatureLimit; i++) {
            shuffleArray(creaturePool);
            deck.add(creaturePool[0]);
        }
        for(int i = 0; i < spellLimit; i++) {
            shuffleArray(spellPool);
            deck.add(spellPool[0]);
        }
        for(int i = 0; i < structureLimit; i++) {
            shuffleArray(structurePool);
            deck.add(structurePool[0]);
        }

    }
}
