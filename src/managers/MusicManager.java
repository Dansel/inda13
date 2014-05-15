package com.me.Javaga.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

/**
 * Created by Lukas on 2014-05-06.
 */
public class MusicManager {

	public static final String PLAYSONG = "Test.mp3";
	public static final String WELCOMESONG = "Test2.mp3";
	private static Music musicPlayer;
	private static float musicVolume = 0.3f;

	public static void startNewSong(String filename) {
		if (musicPlayer != null) {
			musicPlayer.dispose();
		}
		musicPlayer = Gdx.audio.newMusic(Gdx.files.internal(filename));
		musicPlayer.play();
		musicPlayer.setVolume(musicVolume);
		musicPlayer.setLooping(true);
	}

	public static void pause() {
		musicPlayer.pause();
	}

	public static void play() {
		musicPlayer.play();
	}

	public static void setLooping(boolean looping) {
		musicPlayer.setLooping(looping);
	}


}
