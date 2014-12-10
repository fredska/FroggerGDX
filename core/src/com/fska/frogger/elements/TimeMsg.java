package com.fska.frogger.elements;

import com.fska.frogger.Game;
import com.fska.frogger.data.ImageCache;
import com.fska.frogger.sprites.GameSprite;
import com.fska.frogger.sprites.NumberSprite;

public class TimeMsg extends GameSprite {

	public NumberSprite timeLabel;
	
	public TimeMsg(Game game, float x, float y) {

		super(game, x, y);
		setSkin(ImageCache.getTexture("time_box"));
		
		_game.screen.elements.add(this);
		
		timeLabel = new NumberSprite ("number_time_", _game, x + width * 0.1f, y - height*0.3f);
		timeLabel.visible = false;
	}
	
	@Override 
	public void show () {
		visible = true;
		timeLabel.visible = true;
	}
	
	@Override 
	public void hide () {
		visible = false;
		timeLabel.visible = false;
	}
}
