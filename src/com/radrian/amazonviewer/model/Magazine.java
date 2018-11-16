/**
 * 
 */
package com.radrian.amazonviewer.model;

import java.sql.Date;

/**
 * @author RAdrian
 *
 */
public class Magazine extends Publication {
	private int id;

	public Magazine(String title, Date editorialDate, String editorial, String[] authors, int id) {
		super(title, editorialDate, editorial, authors);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "\nMAGAZINE" + 
				"\nTitle: " + getTitle() + 
				"\nEditorial: " + getEditorial() + 
				"\nEdición: " + getEditionDate();
	}

}
