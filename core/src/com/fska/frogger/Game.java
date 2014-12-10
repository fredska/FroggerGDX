package com.fska.frogger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fska.frogger.data.GameData;
import com.fska.frogger.screens.Screen;

public class Game implements ApplicationListener {

	public static GameState GAME_STATE;

	public Screen screen;

	public GameData gameData;
	public SpriteBatch spriteBatch;
	public OrthographicCamera camera;
	public int screenWidth = 0;
	public int screenHeight = 0;

	protected Map<String, Screen> _screens;

	@Override
	public void create() {
		_screens = new HashMap<String, Screen>();
	}

	public void setScreen(String screenClassName) {
		screenClassName = "com.fska.frogger.screens." + screenClassName;
		Screen newScreen = null;

		if (_screens.containsKey(screenClassName) == false) {
			try {
				Class screenClass = Class.forName(screenClassName);
				Constructor constructor = screenClass
						.getConstructor(Game.class);
				newScreen = (Screen) constructor.newInstance(this);
				_screens.put(screenClassName, newScreen);
			} catch (InvocationTargetException ex) {
				System.err.println(ex
						+ " Screen with Wrong args in Constructor.");
			} catch (NoSuchMethodException ex) {
			} catch (ClassNotFoundException ex) {
				System.err.println(ex + " Screen Class Not Found.");
			} catch (InstantiationException ex) {
				System.err.println(ex + " Screen Must be a concrete class.");
			} catch (IllegalAccessException ex) {
				System.err.println(ex + " Screen with Wrong number of args.");
			}
		} else { 
			newScreen = _screens.get(screenClassName);
		}
		
		if(newScreen == null) return;
		
		if(screen != null){
			screen.destroy();
		}
		
		screen = newScreen;
		screen.createScreen();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
