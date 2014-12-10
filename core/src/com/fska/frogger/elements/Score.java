package com.fska.frogger.elements;

import com.fska.frogger.Game;
import com.fska.frogger.sprites.NumberSprite;

public class Score extends NumberSprite {

	public Score(Game game, float x, float y, String nameRoot) {
		super(nameRoot, game, x, y);
	}
	
	@Override 
	public void draw () {
		value = _game.gameData.score;
		super.draw();
	}
}
