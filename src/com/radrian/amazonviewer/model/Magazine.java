/**
 * 
 */
package com.radrian.amazonviewer.model;

import java.util.Date;

/**
 * @author RAdrian
 *
 */
public class Magazine extends Publication {
	private int id;

	public Magazine(String title, Date editionDate, String editorial) {
		super(title, editionDate, editorial);
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
