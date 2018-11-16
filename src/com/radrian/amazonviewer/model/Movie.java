/**
 * 
 */
package com.radrian.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

import com.radrian.amazonviewer.interfaces.IVisualizable;

/**
 * @author RAdrian
 *
 */
public class Movie extends Film implements IVisualizable{
	private int id;
	private int timeViewed;

	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		setYear(year);
		super.setViewed(false);
	}

	public static ArrayList<Movie> makeMoviesList() {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		
		for(byte i = 1; i <5; i++) {
			movies.add(new Movie("Movie0" + i, "Género 0" + i, "Creador " + i, (120 + i), (short)(2018 - i)));
		}
		return movies;
	}
	
	public int getId(){
		return id;
	}
	
	public int getTimeViewed() {
		return timeViewed;
	}
	
	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}

	@Override
	public String toString() {
		return "\nMOVIE" +
				"\nTitle: " + getTitle() + 
				"\nCreador: " + getCreator() + 
				"\nAño: " + getYear() +
				"\nDuración: " + getDuration() + 
				"\nGénero: " + getGenre() + 
				"\nVisto: " + isViewed();
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
