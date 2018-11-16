package com.radrian.amazonviewer.model;

import java.util.Date;

public class Publication {
	private String title;
	private Date editorialDate;
	private String editorial;
	private String[] authors;

	public Publication(String title, Date editorialDate, String editorial, String[] authors) {
		this.title = title;
		this.editorialDate = editorialDate;
		this.editorial = editorial;
		this.authors = authors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getEditionDate() {
		return editorialDate;
	}

	public void setEditionDate(Date editionDate) {
		this.editorialDate = editionDate;
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
	
}
