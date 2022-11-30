package com.darklegions.game.menu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.math.MathUtils;

/**
 * Created by DarkLegions on 2014-04-20.
 * This class is used to store the user's preferences
 * such as the volume of the music and sound effects
 * and the difficulty of the game
 * as well as Screen Resolution
 */

//TODO: Add a Fullscreen checkbox
public class Options {

    public static final Options instance = new Options();

    public boolean sound;
    public boolean music;
    public float soundVolume;
    public float musicVolume;
    public boolean showFpsCounter;

    private final Preferences prefs;

    private Options() {
        prefs = Gdx.app.getPreferences(OPTIONS_NAME);
    }

    public void load() {
        sound = prefs.getBoolean("sound", true);
        music = prefs.getBoolean("music", true);
        soundVolume = MathUtils.clamp(prefs.getFloat("soundVolume", 0.5f), 0.0f, 1.0f);
        musicVolume = MathUtils.clamp(prefs.getFloat("musicVolume", 0.5f), 0.0f, 1.0f);
        showFpsCounter = prefs.getBoolean("showFpsCounter", false);
    }

    public void save() {
        prefs.putBoolean("sound", sound);
        prefs.putBoolean("music", music);
        prefs.putFloat("soundVolume", soundVolume);
        prefs.putFloat("musicVolume", musicVolume);
        prefs.putBoolean("showFpsCounter", showFpsCounter);
        prefs.flush();
    }

    //OLD CODE BELOW
    private static final String PREF_MUSIC_VOLUME = "volume";
    private static final String PREF_MUSIC_ENABLED = "music.enabled";
    private static final String PREF_SOUND_ENABLED = "sound.enabled";
    private static final String PREF_SOUND_VOL = "sound";
    private static final String OPTIONS_NAME = "DarkLegions";

    private Preferences getPrefs() {
        return Gdx.app.getPreferences(OPTIONS_NAME);
    }

    public boolean isSoundEffectsEnabled() {
        return getPrefs().getBoolean(PREF_SOUND_ENABLED, true);
    }

    public void setSoundEffectsEnabled(boolean soundEffectsEnabled) {
        getPrefs().putBoolean(PREF_SOUND_ENABLED, soundEffectsEnabled);
        getPrefs().flush();
    }

    public boolean isMusicEnabled() {
        return getPrefs().getBoolean(PREF_MUSIC_ENABLED, true);
    }

    public void setMusicEnabled(boolean musicEnabled) {
        getPrefs().putBoolean(PREF_MUSIC_ENABLED, musicEnabled);
        getPrefs().flush();
    }

    public float getMusicVolume() {
        return getPrefs().getFloat(PREF_MUSIC_VOLUME, 0.5f);
    }

    public void setMusicVolume(float volume) {
        getPrefs().putFloat(PREF_MUSIC_VOLUME, volume);
        getPrefs().flush();
    }

    public float getSoundVolume() {
        return getPrefs().getFloat(PREF_SOUND_VOL, 0.5f);
    }

    public void setSoundVolume(float volume) {
        getPrefs().putFloat(PREF_SOUND_VOL, volume);
        getPrefs().flush();
    }
}
