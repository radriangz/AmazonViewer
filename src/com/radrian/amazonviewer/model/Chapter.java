/**
 * 
 */
package com.radrian.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author RAdrian
 *
 */
public class Chapter extends Movie {
	private int currentSeason;
	private int chapterNumber;

	public Chapter(String title, String genre, String creator, int duration, short year, 
					int currentSeason, int chapterNumber) {
		super(title, genre, creator, duration, year);
		this.currentSeason = currentSeason;
		this.chapterNumber = chapterNumber;
	}

	/*
	 * TODO continuing with the todo tag in series, the class field current season
	 * refers to the fact that the Season class will be created soon, and will refer to
	 * what season the current chapter belongs to.
	 */

	public static ArrayList<Chapter> makeChaptersList(int currentSeason) {
		ArrayList<Chapter> chapters = new ArrayList<Chapter>();

		for (byte i = 1; i <= 5; i++) {
			chapters.add(new Chapter("Chapter 0" + i, 
									"Género 0" + i, 
									"Creador 0" + i, 
									(120 + i), //duration
									(short) (2018 - i), 
									currentSeason, 
									(i))); //cchapterNnumber
		}
		return chapters;
	}

	private int getCurrentSeason() {
		return this.currentSeason;
	}

	public int getChapterNumber() {
		return this.chapterNumber;
	}

	@Override
	public String toString() {
		return "Title: " + getTitle() + 
				"\nGénero: " + getGenre() + 
				"\nCreador: " + getCreator() + 
				"\nDuración: " + getDuration() + 
				"\nAño: " + getYear() + 
				"\nTemporada: 0" + getCurrentSeason() + 
				"\nEpisodio: 0" + getChapterNumber();
	}

	@Override
	public Date startToWatch(Date dateI) {
		return dateI;
	}

	@Override
	public void stopWatching(Date dateI, Date dateF) {
		int result = dateF.getTime() > dateI.getTime() ? (int) (dateF.getTime() - dateI.getTime()) : 0;
		this.setTimeViewed(result);
	}

}