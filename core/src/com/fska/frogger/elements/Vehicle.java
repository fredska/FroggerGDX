package com.fska.frogger.elements;

import com.fska.frogger.Game;
import com.fska.frogger.sprites.TierSprite;


public class Vehicle extends TierSprite {
	
	public Vehicle (String skinName, int skinIndex, Game game, float x, float y) {
		
		super(game, x, y);
		
		this._game = game;
		active = true;
		visible = true;
		
		setSkin (skinName, skinIndex);
		
		game.screen.elements.add(this);
	}

}
