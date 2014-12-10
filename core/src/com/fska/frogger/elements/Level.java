package com.fska.frogger.elements;

import com.fska.frogger.Game;
import com.fska.frogger.sprites.NumberSprite;

public class Level extends NumberSprite {

	public Level(Game game, float x, float y, String nameRoot) {
		super(nameRoot,game, x, y);
	}
	
	@Override 
	public void draw () {
		value = _game.gameData.level;
		super.draw();
	}

}
