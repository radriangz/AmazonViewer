/**
 * 
 */
package com.radrian.amazonviewer.model;

import java.util.ArrayList;

/**
 * <h1>Chapter</h1>
 * <p>
 * Chapter is a class that creates a list of chapters.
 * <p>
 * Creates a list of chapters for the Series object and then displays it to the user.
 * <p>
 * Extends from {@link Movie}
 * @see Movie
 * <p>
 * @author RAdrian
 * @version 1.1
 * @since 2018
 *
 */
public class Chapter extends Movie {
	private int currentSeason;
	private int chapterNumber;
	private Series serie;

	/*
	 * TODO continuing with the todo tag in series, the class field current season
	 * refers to the fact that the Season class will be created soon, and will refer to
	 * what season the current chapter belongs to.
	 */
	public Chapter(String title, String genre, String creator, int duration, short year, 
					int currentSeason, int chapterNumber, Series serie) {
		super(title, genre, creator, duration, year);
		this.currentSeason = currentSeason;
		this.chapterNumber = chapterNumber;
		this.serie = serie;
	}

	public static ArrayList<Chapter> makeChaptersList(Series series, int currentSeason) {
		ArrayList<Chapter> chapters = new ArrayList<Chapter>();

		for (byte i = 1; i <= 5; i++) {
			chapters.add(new Chapter("Chapter 0" + i, 
									"Género 0" + i, 
									"Creador 0" + i, 
									(120 + i), //duration
									(short) (2018 - i), 
									currentSeason, 
									(i),
									series)); //cchapterNnumber
		}
		return chapters;
	}
	
	public Series getSerie() {
		return serie;
	}

	private int getCurrentSeason() {
		return this.currentSeason;
	}

	public int getChapterNumber() {
		return this.chapterNumber;
	}

	/**
	 * {@inheritDoc}
	 * */
	@Override
	public String toString() {
		return "\nCHAPTER" +
				"\nSerie: " + getSerie().getTitle() +
				"\nTitle: " + getTitle() + 
				"\nGénero: " + getGenre() + 
				"\nCreador: " + getCreator() + 
				"\nDuración: " + getDuration() + 
				"\nAño: " + getYear() + 
				"\nTemporada: 0" + getCurrentSeason() + 
				"\nEpisodio: 0" + getChapterNumber();
	}

	/**
	 * {@inheritDoc}
	 * */
	@Override
	public void view() {
		super.view();
		ArrayList<Chapter> chapters = getSerie().getChapters();
		int chapterViewedCounter = 0;
		for (Chapter chapter : chapters) {
			if (chapter.getIsViewed()) {
				chapterViewedCounter++;
			}
		}
		if (chapterViewedCounter == chapters.size()) {
			getSerie().view();
		}
	}
	
}