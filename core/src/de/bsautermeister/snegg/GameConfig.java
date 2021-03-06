package de.bsautermeister.snegg;

import com.badlogic.gdx.utils.Logger;

public final class GameConfig {
    public static final int LOG_LEVEL = Logger.DEBUG;
    public static final boolean DEBUG_MODE = false;

    public static final float WIDTH = 720;
    public static final float HEIGHT = 1280;

    public static final float HUD_WIDTH = 720; // still world units!
    public static final float HUD_HEIGHT = 1280; // still world units!

    public static final float HUD_CENTER_X = HUD_WIDTH / 2f;
    public static final float HUD_CENTER_Y = HUD_HEIGHT / 2f;

    public static final float WORLD_WIDTH = 9.0f;
    public static final float WORLD_HEIGHT = 16.0f;

    public static final float WORLD_CENTER_X = WORLD_WIDTH / 2f;
    public static final float WORLD_CENTER_Y = WORLD_HEIGHT / 2f;

    public static final float SNAKE_SIZE = 1f;
    public static final float MOVE_TIME = 0.40f;
    public static final float MIN_MOVE_TIME = 0.1f;
    public static final float SNAKE_SPEED = 1f;
    public static final float SNAKE_HAPPY_TIME = 0.66f;

    public static final float INITIAL_TRANS_DURATION = MOVE_TIME / 2;
    public static final float INITIAL_TRANS_DELAY = INITIAL_TRANS_DURATION / 5;

    public static final float DIFFICULTY_LOWERING_MOVE_TIME_FACTOR = 0.00025f;

    public static final float COLLECTIBLE_SIZE = 1f;
    public static final int EGG_SCORE = 25;
    public static final int WORM_START_SCORE = 100;
    public static final int WORM_END_SCORE = 10;
    public static final int WORM_SPAWN_INTERVAL = 5;
    public static final float WORM_MIN_SPAWN_DELAY = 2f;
    public static final float WORM_MAX_SPAWN_DELAY = 10f;
    public static final float WORM_LIFETIME = 10f;
    public static final float WORM_SCARED_DISTANCE_SQUARED = 2f * 2f;

    private static final float MARGIN_TOP = 0f;
    private static final float MARGIN_OTHER = 0f;

    public static final float MIN_X = MARGIN_OTHER;
    public static final float MAX_X = WORLD_WIDTH - MARGIN_OTHER;
    public static final float MIN_Y = MARGIN_OTHER;
    public static final float MAX_Y = WORLD_HEIGHT - MARGIN_TOP;
    public static final float GAMEFIELD_WIDTH = MAX_X - MIN_X;
    public static final float GAMEFIELD_HEIGHT = MAX_Y - MIN_Y;

    public static final float TEXT_ANIMATION_DURATION = 3f;
    public static final float CHAR_ANIMATION_TIME = 0.5f;
    public static final float TEXT_ANIMATION_TIME = 1.0f;

    public static final float MUSIC_VOLUME = 0.33f;
    public static final float MUSIC_IN_GAME_VOLUME = 0.1f;
    public static final int MAX_SNAKE_LENGTH = (int)(WORLD_WIDTH - 2 * MARGIN_OTHER) * (int)(WORLD_HEIGHT - MARGIN_TOP - MARGIN_OTHER) - 5;

    private GameConfig() { }
}
