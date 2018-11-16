/**
 * 
 */
package com.radrian.amazonviewer.model;

import java.util.ArrayList;

/**
 * @author RAdrian
 *
 */
public class Series extends Film {
	int id;
	private int seasonQuantity;
	private ArrayList<Chapter> chapters;

	public Series(String title, String creator, String genre, int duration, int seasonQuantity,
			ArrayList<Chapter> chapters) {
		super(title, genre, creator, duration);
		this.seasonQuantity = seasonQuantity;
		this.chapters = chapters;
	}

	/*
	 * TODO create a Season class between the Serie and Chapter classes, also maybe
	 * change the name of Chapter to Episode, since that'll make more sense Series
	 * have Seasons and Seasons have Episodes.
	 * 
	 * will be creating chapters and series with only one season, hardcoded.
	 */

	public static ArrayList<Series> makeSeriesList() {
		ArrayList<Series> series = new ArrayList<Series>();

		for (byte i = 1; i <= 5; i++) {
			series.add(new Series("Serie 0" + i, "Creador 0" + i, "Género 0" + i, (120 + i), i,
					Chapter.makeChaptersList(1)));
		}
		return series;
	}

	public int getId() {
		return id;
	}

	private int getSeasonQuantity() {
		return seasonQuantity;
	}

	public ArrayList<Chapter> getChapters() {
		return chapters;
	}

	@Override
	public String toString() {
		return "Title: " + getTitle() + 
				"\nGénero: " + getGenre() + 
				"\nCreador: " + getCreator() + 
				"\nDuración: " + getDuration() + 
				"\nAño: " + getYear() + 
				"\nTemporadas: " + getSeasonQuantity() + 
				"\nEpisodios: " + (chapters.size() + 1);
	}

}
