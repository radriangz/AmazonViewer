package com.radrian.amazonviewer.model;

/**
 * <h1>Film</h1>
 * <p>
 * Film is an abstract parent class.
 * </p>
 * Parents the family class Films, can't be instantiated because it's abstract, 
 * contains the abstract method {@code view();} 

 * @author RAdrian
 * @version 1.1
 * @since 2018
 *
 */
public abstract class Film {
	private String title;
	private String genre;
	private String creator;
	private int duration;
	private short year;
	private boolean isViewed;

	public Film() {
		
	}
	
	public Film(String title, String genre, String creator, int duration) {
		super();
		this.title = title;
		this.genre = genre;
		this.creator = creator;
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public String isViewed() {
		return (this.isViewed? "Si": "No");
	}
	
	public boolean getIsViewed() {
		return isViewed;
	}

	public void setViewed(boolean viewed) {
		this.isViewed = viewed;
	}
	
	/**
	 * {@code view();} This is the abstract method to be inherited to the family.
	 * */
	public abstract void view();
	
}
