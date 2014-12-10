package com.fska.frogger;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
//		ImageCache.load();
		
//		gameData = new GameData(this);
		spriteBatch = new SpriteBatch();
		
		setScreen("MenuScreen");
		
	}
}
