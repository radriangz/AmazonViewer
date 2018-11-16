/**
 * 
 */
package com.radrian.amazonviewer.model;

import java.util.ArrayList;

/**
 * @author RAdrian
 *
 */
public class Serie extends Film {
	int id;
	private int seasonQuantity;
	private ArrayList<Chapter> chapters;

	public Serie(String title, String genre, String creator, int duration,
				int seasonQuantity) {
		super(title, genre, creator, duration);
		this.seasonQuantity = seasonQuantity;
	}

	public int getId() {
		return id;
	}

	public int getSeasonQuantity() {
		return seasonQuantity;
	}

	public void setSeasonQuantity(int seasonQuantity) {
		this.seasonQuantity = seasonQuantity;
	}

	public ArrayList<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(ArrayList<Chapter> chapters) {
		this.chapters = chapters;
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
