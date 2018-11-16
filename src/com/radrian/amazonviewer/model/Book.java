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
public class Book extends Publication implements IVisualizable{
	private int id;
	private String isbn;
	private boolean hasBeenRead;
	private int timeReading;
	
	public Book(String title, Date editorialDate, String editorial, String[] authors, int id, String isbn, boolean hasBeenRead) {
		super(title, editorialDate, editorial, authors);
		this.id = id;
		this.isbn = isbn;
		this.hasBeenRead = hasBeenRead;
	}

	public static ArrayList<Book> makeBooksList() {
		ArrayList<Book> books = new ArrayList<Book>();
		
		for(byte i = 1; i <=5; i++) {
			books.add(new Book("Book 0" + i, new Date(), "Editorial 0" + i, new String[]{"Author 0" + i, "Author 0"  + i}, (i * 1001), "ISBN 0000" + i, false));
		}
		return books;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String isHasBeenRead() {
		return hasBeenRead? "Yes": "No";
	}

	public void setHasBeenRead(boolean hasbeenRead) {
		this.hasBeenRead = hasbeenRead;
	}

	public int getTimeReading() {
		return timeReading;
	}

	public void setTimeReading(int timeReading) {
		this.timeReading = timeReading;
	}

	@Override
	public String toString() {
		return "Title: " + getTitle() + 
				"\nAutores: " + "" + 
				"\nEditorial: " + getEditorial() + 
				"\nEdición: " + getEditionDate() + 
				"\nISBN: " + getIsbn() +
				"\nTiempo de lectura: " + getTimeReading();
	}

	@Override
	public Date startToWatch(Date dateI) {
		return dateI;
	}

	@Override
	public void stopWatching(Date dateI, Date dateF) {
		int result = dateF.getTime() > dateI.getTime() ? (int) (dateF.getTime() - dateI.getTime()) : 0;
		this.setTimeReading(result);
	}
}
