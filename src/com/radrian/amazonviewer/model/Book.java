/**
 * 
 */
package com.radrian.amazonviewer.model;

import java.sql.Date;

/**
 * @author RAdrian
 *
 */
public class Book {
	private int id;
	private String title;
	private Date editionDate;
	private String editorial;
	private String[] authors;
	private String isbn;
	private boolean hasbeenRead;
	private int timeReading;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getEditionDate() {
		return editionDate;
	}

	public void setEditionDate(Date editionDate) {
		this.editionDate = editionDate;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean isHasbeenRead() {
		return hasbeenRead;
	}

	public void setHasbeenRead(boolean hasbeenRead) {
		this.hasbeenRead = hasbeenRead;
	}

	public int getTimeReading() {
		return timeReading;
	}

	public void setTimeReading(int timeReading) {
		this.timeReading = timeReading;
	}

}
