package com.fska.frogger.sprites;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fska.frogger.Game;
import com.fska.frogger.data.ImageCache;

public class NumberSprite extends GameSprite {
	public int value;
	private List<TextureRegion> _textures;
	private List<Sprite> _numbers;
	
	public NumberSprite(String nameRoot, Game game, float x, float y){
		super(game,x,y);
		skin = null;
		value = 0;
		_textures = new ArrayList<TextureRegion>();
		_numbers = new ArrayList<Sprite>();
		
		int i;
		for(i=0;i<10;i++){
			_textures.add(ImageCache.getFrame(nameRoot, i));
		}
		
		Sprite sprite;
		for(i=0;i<10;i++){
			//craete Sprite w/ TextureRegion
			sprite = new Sprite(_textures.get(i));
			sprite.setPosition(x+i*(sprite.getRegionWidth() + 2), y);
			_numbers.add(sprite);
		}
		
		_game.screen.elements.add(this);
	}
	
	public void draw(){
		//Odd way of going about checking if value is over it's digit limit
		String string = value + "";
		int len = string.length();
		if(len > 10) return;
		
		Sprite sprite;
		for(int i =0 ; i < len; i++){
			sprite = _numbers.get(i);
			sprite.setRegion(_textures.get(Character.getNumericValue(string.charAt(i))));
			sprite.draw(_game.spriteBatch);
		}
	}
}
