package com.darklegions.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Disposable;

//TODO: Not loading/working properly. Probably not the correct folder path to the Resource folder

public class Assets implements Disposable, AssetErrorListener {
    public static final String TAG = Assets.class.getName();
    public static final Assets instance = new Assets();
    private AssetManager assetManager;
    private Assets() { }

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        assetManager.setErrorListener(this);

        assetManager.load(Constants.TEXTURE_ATLAS_OBJECTS, TextureAtlas.class);
        assetManager.finishLoading();
        Gdx.app.debug(TAG, "# of assets loaded: " + assetManager.getAssetNames().size);
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    public void error(String filename, Class type, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset '" + filename + "'", (Exception)throwable);
    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset '" + asset.fileName + "'", (Exception)throwable);
    }

    /**
     * Returns the texture atlas for the game Level
     *
     */
    //For designing the game
    //TODO: Create Assets for the game/Level
    public class AssetLevelDesign {
        public final AtlasRegion background;

        public AssetLevelDesign(TextureAtlas atlas) {
            background = atlas.findRegion("background");
        }
    }


    /**
     * AssetCard used to store the card images
     *
     */
    public class AssetCard {
        //TODO: Create Assets for the cards
        public final AtlasRegion cardFront;
        public final AtlasRegion cardBack;
        public AssetCard(TextureAtlas atlas) {
            cardFront = atlas.findRegion("cardFront");
            cardBack = atlas.findRegion("cardBack");
        }
    }
}


