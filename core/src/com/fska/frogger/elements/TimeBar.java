package com.fska.frogger.elements;

import java.util.Timer;
import java.util.TimerTask;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fska.frogger.Game;
import com.fska.frogger.GameState;
import com.fska.frogger.data.ImageCache;
import com.fska.frogger.sprites.GameSprite;

public class TimeBar extends GameSprite {
	public int seconds;
	
	private Timer _timer;
	private int _timeWidth;
	private float _timeDecrement;
	private TextureRegion _bar;
	
	public TimeBar(Game game, float x, float y){
		super(game, x, y);
		
		seconds = 0;
		
		skin = null;
		_bar = ImageCache.getTexture("time_bar");
		width = _bar.getRegionWidth();
		height = _bar.getRegionHeight();
		
		_timeWidth = width;
		_timeDecrement = _timeWidth * 0.001f;
		
		_timer = new Timer();
		
		_game.screen.elements.add(this);
		_timer.schedule(new TickTockTask(), 0l, 1000);
	}
	
	class TickTockTask extends TimerTask{
		public void run(){
			if(_game.gameData.gameMode == GameState.PLAY && visible){
				seconds++;
				if(_timeWidth - _timeDecrement <= 0){
					visible = false;
					_timer.cancel();
//					GameScreen screen = (GameScreen)_game.screen;
//					screen.gameOver();
				} else {
					_timeWidth -= _timeDecrement;
				}
			}
		}
	}
}
