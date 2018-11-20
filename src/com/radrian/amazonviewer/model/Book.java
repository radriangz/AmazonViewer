/**
 * 
 */
package com.radrian.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

import com.radrian.amazonviewer.interfaces.IVisualizable;

/**
 *<h1>Book</h1>
 * Book class contains books to be read. 
 *<p>
 * This class makes an ArrayList of books which can be read by the user.
 *<p>
 * Extends from {@link Publication}
 * Implements {@link IVisualizable}
 * @see Publication
 *<p>
 * @author RAdrian
 * @version 1.1
 * @since 2018
 * 
 */
public class Book extends Publication implements IVisualizable{
	private int id;
	private String isbn;
	private boolean hasBeenRead;
	private int timeReading;
	
	public Book(String title, Date editionDate, String editorial, String[] authors, int id, String isbn, boolean hasBeenRead) {
		super(title, editionDate, editorial, authors);
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
	
	public void playMedia(int linesToPrint) {
		for(int i = 0; i< linesToPrint; i++) {
			System.out.println(".");		
		}
	}
	
	public void view() {
		setHasBeenRead(true);
		Date dateI = startToWatch(new Date());

		playMedia(100000);
		
		stopWatching(dateI, new Date());
		System.out.println("\nLeiste: \n" + toString() + 
							"\nPor: " + getTimeReading() + " milisegundos");

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

	public boolean getHasBeenRead() {
		return this.hasBeenRead;
	}
	
	public String hasBeenRead() {
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

	/**
	 * {@inheritDoc}
	 * */
	@Override
	public String toString() {
		return "\nBOOK" + 
				"\nTitle: " + getTitle() + 
				"\nAutores: " + "" + 
				"\nEditorial: " + getEditorial() + 
				"\nEdición: " + getEditionDate() + 
				"\nISBN: " + getIsbn() +
				"\nTiempo de lectura: " + getTimeReading();
	}

	/**
	 * {@inheritDoc}
	 * */
	@Override
	public Date startToWatch(Date dateI) {
		return dateI;
	}

	/**
	 * {@inheritDoc}
	 * */
	@Override
	public void stopWatching(Date dateI, Date dateF) {
		int result = dateF.getTime() > dateI.getTime() ? (int) (dateF.getTime() - dateI.getTime()) : 0;
		this.setTimeReading(result);
	}
	
}
