package com.fska.frogger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fska.frogger.data.GameData;
import com.fska.frogger.data.ImageCache;
import com.fska.frogger.data.Sounds;

public class FroggerGame extends Game {
	
	@Override
	public void create(){
		super.create();
		

		screenWidth = 320;
		screenHeight = 480;
		
		camera = new OrthographicCamera(screenWidth, screenHeight);
		camera.position.set(screenWidth * 0.5f, screenHeight * 0.5f, 0);
		
		Sounds.load();
		ImageCache.load();
		
		gameData = new GameData(this);
		spriteBatch = new SpriteBatch();
		
		setScreen("MenuScreen");
		
	}
	
	@Override
	public void dispose() {
		if (screen != null) screen.dispose();
	}

	@Override
	public void pause() {
		if (screen != null) screen.pause();
	}

	@Override
	public void render() {
		if (screen != null) {
			screen.update(Gdx.graphics.getDeltaTime());
		} else {
			
			GL20 gl = Gdx.gl;
			gl.glClearColor(0, 0, 0, 1);
			gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		}
	}

	@Override
	public void resize(int arg0, int arg1) {
		
	}

	@Override
	public void resume() {
		if (screen != null) screen.resume();
	}
}
