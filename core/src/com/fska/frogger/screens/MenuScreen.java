package com.fska.frogger.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteCache;
import com.fska.frogger.Game;
import com.fska.frogger.sprites.GameSprite;

public class MenuScreen extends Screen {

	private SpriteCache _spriteCache;
	private int _spriteCacheIndex;
	
	public MenuScreen(Game game){
		super(game);
	}

	@Override
	public void createScreen() {
		if(elements.isEmpty()){
			GameSprite logo = new GameSprite("logo", _game, _game.screenWidth * 0.5f, _game.screenHeight * 0.7f );
			GameSprite label1 = new GameSprite ("label_how_to", _game, _game.screenWidth * 0.5f,  _game.screenHeight * 0.53f);
			GameSprite label2 = new GameSprite ("label_instructions", _game, _game.screenWidth * 0.5f,  _game.screenHeight * 0.2f);
			GameSprite label3 = new GameSprite ("label_tap", _game, _game.screenWidth * 0.5f,  _game.screenHeight * 0.02f);
			GameSprite control = new GameSprite ("control", _game, _game.screenWidth * 0.5f,  _game.screenHeight * 0.4f);
			
			_spriteCache = new SpriteCache();
			_spriteCache.beginCache();
			_spriteCache.add(logo.skin, logo.x, logo.y);
			_spriteCache.add(label1.skin, label1.x, label1.y);
			_spriteCache.add(label2.skin, label2.x, label2.y);
			_spriteCache.add(label3.skin, label3.x, label3.y);
			_spriteCache.add(control.skin, control.x, control.y);
			_spriteCacheIndex = _spriteCache.endCache();
		}
	}

	@Override
	public void update(float dt) {
		if(Gdx.input.justTouched()){
			Gdx.app.log("A Hit!", "A most palpable hit?");
			_game.setScreen("GameScreen");
		} else {
			GL20 gl = Gdx.gl;
			gl.glClearColor(0.4f, .4f, .4f, 1);
			gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
			_game.camera.update();
			
			gl.glEnable(GL20.GL_BLEND);
			gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
			
			_spriteCache.setProjectionMatrix(_game.camera.combined);
			_spriteCache.begin();
			_spriteCache.draw(_spriteCacheIndex);
			_spriteCache.end();
		}
	}

}
