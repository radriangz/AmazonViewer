/**
 * 
 */
package com.radrian.amazonviewer.model;

/**
 * @author RAdrian
 *
 */
public class Chapter extends Movie {
	private int id;
	private int seasonNumber;

	public Chapter(String title, String genre, String creator, int duration, short year, int seasonNumber) {
		super(title, genre, creator, duration, year);
		this.setSeasonNumber(seasonNumber);
	}
	
	@Override
	public int getId() {
		return this.id;
	}
	
	public int getSeasonNumber() {
		return seasonNumber;
	}

	public void setSeasonNumber(int seasonNumber) {
		this.seasonNumber = seasonNumber;
	}

}