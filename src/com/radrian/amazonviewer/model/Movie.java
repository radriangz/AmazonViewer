/**
 * 
 */
package com.radrian.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

import com.radrian.amazonviewer.dao.MovieDAO;
import com.radrian.amazonviewer.interfaces.IVisualizable;

/**
 * <h1>Movie</h1> Movie class contains movies which can be watched.
 * <p>
 * This class can display a movie.
 * <p>
 * Extends from {@link Film} Implements {@link IVisualizable}
 * 
 * @see Film
 *      <p>
 * @author RAdrian
 * @version 1.1
 * @since 2018
 */
public class Movie extends Film implements IVisualizable, MovieDAO {
	private int id;
	private int timeViewed;
	
	public Movie() {
		
	}

	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		setYear(year);
		super.setViewed(false);
	}

	public static ArrayList<Movie> makeMoviesList() {
		Movie movie = new Movie();
		return movie.read();
	}

	public void playMedia(int linesToPrint) {
		for (int i = 0; i < linesToPrint; i++) {
			System.out.println(".");
		}
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
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
		return "\nMOVIE" + "\nTitle: " + getTitle() + "\nCreador: " + getCreator() + "\nAño: " + getYear()
				+ "\nDuración: " + getDuration() + "\nGénero: " + getGenre() + "\nVisto: " + isViewed();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date startToWatch(Date dateI) {
		return dateI;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stopWatching(Date dateI, Date dateF) {
		int result = dateF.getTime() > dateI.getTime() ? (int) (dateF.getTime() - dateI.getTime()) : 0;
		this.setTimeViewed(result);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void view() {
		setViewed(true);

		Date dateI = startToWatch(new Date());

		playMedia(100000);

		stopWatching(dateI, new Date());
		System.out.println("\nViste: " + toString() + "\nPor: " + getTimeViewed() + " milisegundos");
	}

}
