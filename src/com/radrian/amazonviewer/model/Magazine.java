/**
 * 
 */
package com.radrian.amazonviewer.model;

import java.util.Date;

/**
 *<h1>Magazine</h1>
 * Magazine class contains a catalog of magazines. 
 *<p>
 * This class shows magazines contained in a catalog, these magazines can't be 
 * read, only displayed to the used.
 * 
 * Extends from {@link Publication}
 * 
 * @author RAdrian
 * @version 1.1
 * @since 2018
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
