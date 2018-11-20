/**
 * 
 */
package com.radrian.amazonviewer.model;

import java.util.ArrayList;

/**
 * Extends from {@link Movie}
 * @see Movie
 * <p>
 * @author RAdrian
 * @version 1.1
 * @since 2018
 *<p>
 * TODO create a Season class between the Series and Chapter classes, also maybe
 * change the name of Chapter to Episode, since that'll make more sense Series
 * have Seasons and Seasons have Episodes.
 * will be creating chapters and series with only one season, hardcoded.
 */
public class Series extends Film {
	private int id;
	private int seasonQuantity;
	private ArrayList<Chapter> chapters;

	public Series(String title, String creator, String genre, int duration, int seasonQuantity,
			ArrayList<Chapter> chapters) {
		super(title, genre, creator, duration);
		this.seasonQuantity = seasonQuantity;
		this.chapters = chapters;
	}

	public static ArrayList<Series> makeSeriesList() {
		ArrayList<Series> seriesArrayList = new ArrayList<Series>();

		for (byte i = 1; i <= 5; i++) {
			Series singleSerie = new Series("Serie 0" + i, "Creador 0" + i, "Género 0" + i, (120 + i), i, new ArrayList<Chapter>());
			singleSerie.setChapters(Chapter.makeChaptersList(singleSerie, 1));
			seriesArrayList.add(singleSerie);
		}
		return seriesArrayList;
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
	
	public void setChapters(ArrayList<Chapter> chapters){
		this.chapters = chapters;
	}
	
	/**
	 * {@inheritDoc}
	 * */
	@Override
	public String toString() {
		return "\nSERIE" +
				"Title: " + getTitle() + 
				"\nGénero: " + getGenre() + 
				"\nCreador: " + getCreator() + 
				"\nDuración: " + getDuration() + 
				"\nAño: " + getYear() + 
				"\nTemporadas: " + getSeasonQuantity() + 
				"\nEpisodios: " + (chapters.size() + 1);
	}

	/**
	 * {@inheritDoc}
	 * */
	@Override
	public void view() {
		setViewed(true);
	}

}
