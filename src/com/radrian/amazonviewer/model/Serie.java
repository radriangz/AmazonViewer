/**
 * 
 */
package com.radrian.amazonviewer.model;

/**
 * @author RAdrian
 *
 */
public class Serie extends Film {
	int id;
	private int seasonQuantity;
	private Chapter[] chapters;

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

	public Chapter[] getChapters() {
		return chapters;
	}

	public void setChapters(Chapter[] chapters) {
		this.chapters = chapters;
	}

	@Override
	public String toString() {
		return "Title: " + getTitle() + 
				"\nG�nero: " + getGenre() + 
				"\nCreador: " + getCreator() + 
				"\nDuraci�n: " + getDuration() + 
				"\nA�o: " + getYear() + 
				"\nTemporadas: " + getSeasonQuantity() +
				"\nEpisodios: " + chapters.length;
	}

	
}
