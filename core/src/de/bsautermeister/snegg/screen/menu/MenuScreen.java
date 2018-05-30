package de.bsautermeister.snegg.screen.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import de.bsautermeister.snegg.assets.AssetDescriptors;
import de.bsautermeister.snegg.assets.RegionNames;
import de.bsautermeister.snegg.assets.Styles;
import de.bsautermeister.snegg.common.GameServiceApp;
import de.bsautermeister.snegg.config.GameConfig;
import de.bsautermeister.snegg.screen.ScreenBase;
import de.bsautermeister.snegg.screen.game.GameScreen;
import de.bsautermeister.snegg.services.PlayGameServices;
import de.bsautermeister.snegg.util.GdxUtils;

public class MenuScreen extends ScreenBase {
    private Viewport viewport;
    private Stage stage;
    private Skin skin;
    private TextureAtlas atlas;

    private final PlayGameServices gameServices;

    public MenuScreen(GameServiceApp game) {
        super(game);
        this.gameServices = game.getGameServices();
    }

    @Override
    public void show() {
        viewport = new FitViewport(GameConfig.HUD_WIDTH, GameConfig.HUD_HEIGHT);
        stage = new Stage(viewport, getBatch());
        skin = getAsset(AssetDescriptors.Skins.UI);
        atlas = getAsset(AssetDescriptors.Atlas.GAMEPLAY);

        Gdx.input.setInputProcessor(stage);
        Actor ui = createUI();
        stage.addActor(ui);

        if (!gameServices.isSignedIn()) {
            gameServices.signIn();
        }
    }

    private Actor createUI() {
        Table table = new Table(skin);
        table.defaults().pad(10);

        TextureRegion backgroundRegion = atlas.findRegion(RegionNames.BACKGROUND);
        table.setBackground(new TextureRegionDrawable(backgroundRegion));

        Image title = new Image(skin, RegionNames.TITLE);

        Button playButton = new Button(skin, Styles.Button.PLAY);
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                play();
            }
        });

        Button leaderboardsButton = new Button(skin, Styles.Button.LEADERBOARDS);
        leaderboardsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gameServices.showScore();
            }
        });

        Button achievementsButton = new Button(skin, Styles.Button.ACHIEVEMENTS);
        achievementsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gameServices.showAchievements();
            }
        });

        Button reviewsButton = new Button(skin, Styles.Button.REVIEWS);
        reviewsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // FIXME crashes the app?
                //gameServices.rateGame();
            }
        });

        Button quitButton = new Button(skin, Styles.Button.QUIT);
        quitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                quit();
            }
        });

        table.add(title).row();
        table.add(playButton).row();
        table.add(leaderboardsButton).row();
        table.add(achievementsButton).row();
        table.add(reviewsButton).row();
        table.add(quitButton);

        table.center();
        table.setFillParent(true);
        table.pack();

        return table;
    }

    private void play() {
        setScreen(new GameScreen(getGame()));
    }

    private void quit() {
        gameServices.signOut();
        Gdx.app.exit();
    }

    @Override
    public void render(float delta) {
        GdxUtils.clearScreen();

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
