package com.me.Javaga.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

/**
 * Keeps track of all the music playing in the game
 * Created by Lukas on 2014-05-06.
 */
public class MusicManager {

	public static final String PLAYSONG = "Test.mp3";
	public static final String WELCOMESONG = "Test2.mp3";
	private static Music musicPlayer;
	private static float musicVolume = 0.3f;

	/**
	 * Dispose the current song if something was playing and start the new song
	 *
	 * @param filename The filename of the song
	 */
	public static void startNewSong(String filename) {
		if (musicPlayer != null) {
			musicPlayer.dispose();
		}
		musicPlayer = Gdx.audio.newMusic(Gdx.files.internal(filename));
		musicPlayer.play();
		musicPlayer.setVolume(musicVolume);
		musicPlayer.setLooping(true);
	}

	/**
	 * Pause the current song, if nothing is playing, nothing will happen
	 */
	public static void pause() {
		musicPlayer.pause();
	}

	/**
	 * Start playing a song, if the song was already playing
	 */
	public static void play() {
		musicPlayer.play();
	}

	/**
	 * Set if the song which is playing should start looping
	 * @param looping true if the song should start looping, false if it should not
	 */
	public static void setLooping(boolean looping) {
		musicPlayer.setLooping(looping);
	}


}
