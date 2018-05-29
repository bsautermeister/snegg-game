package de.bsautermeister.snegg;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

import de.bsautermeister.snegg.common.GameApp;
import de.bsautermeister.snegg.common.GameServiceApp;
import de.bsautermeister.snegg.screen.loading.LoadingScreen;
import de.bsautermeister.snegg.services.PlayGameServices;

public class SneggGame extends GameServiceApp {

	public SneggGame(PlayGameServices gameServices) {
		super(gameServices);
	}

	@Override
	public void create() {
		super.create();
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		setScreen(new LoadingScreen(this));
	}
}
