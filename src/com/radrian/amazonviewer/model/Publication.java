package com.radrian.amazonviewer.model;

import java.util.Date;

/** 
 *<h1>Publication</h1>
 * This is a parent class. 
 *<p>
 * It is Publication family's parent, contains parameters for books and magazines.
 * 
 *@author RAdrian 
 *@version 1.1
 *@since 2018
 * 
 **/
public class Publication {
	private String title;
	private Date editionDate;
	private String editorial;
	private String[] authors;

	public Publication(String title, Date editionlDate, String editorial, String[] authors) {
		this.title = title;
		this.editionDate = editionlDate;
		this.editorial = editorial;
		this.authors = authors;
	}

	public Publication(String title, Date editionDate, String editorial) {
		this.title = title;
		this.editionDate = editionDate;
		this.editorial = editorial;
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
	
}
