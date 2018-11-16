/**
 * 
 */
package com.radrian.amazonviewer.model;

import java.util.Date;

/**
 * @author RAdrian
 *
 */
public class Chapter extends Movie {
	private int id;
	private int seasonQuantity;
	private int chapterNumber;

	public Chapter(String title, String genre, String creator, int duration, short year, int seasonNumber) {
		super(title, genre, creator, duration, year);
		this.setSeasonQuantity(seasonNumber);
	}
	
	@Override
	public int getId() {
		return this.id;
	}
	
	public int getSeasonQuantity() {
		return seasonQuantity;
	}

	public void setSeasonQuantity(int seasonNumber) {
		this.seasonQuantity = seasonNumber;
	}
	
	public void setChapterNumber(int chapterNumber) {
		this.chapterNumber = chapterNumber;
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
				"\nTemporadas: " + getSeasonQuantity() +
				"\nEpisodio: " + (getChapterNumber());
	}
	
	@Override
	public Date startToSee(Date dateI) {
		return dateI;
	}

	@Override
	public void stopToSee(Date dateI, Date dateF) {
		int result = dateF.getTime() > dateI.getTime() ? (int)((dateF.getTime() - dateI.getTime()) * 1000) : 0;
		this.setTimeViewed(result);
	}
	
}