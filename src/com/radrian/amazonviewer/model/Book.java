/**
 * 
 */
package com.radrian.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

import com.radrian.amazonviewer.interfaces.IVisualizable;
import com.radrian.util.AmazonUtil;

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
	private ArrayList<Page> pages;

	public Book(String title, Date editionDate, String editorial, 
				String[] authors, int id, String isbn, boolean hasBeenRead,
				ArrayList<Page> pages) {
		super(title, editionDate, editorial, authors);
		this.id = id;
		this.isbn = isbn;
		this.hasBeenRead = hasBeenRead;
		this.pages = pages;
	}

	public static ArrayList<Book> makeBooksList() {
		ArrayList<Book> books = new ArrayList<Book>();
		String[] authors = new String[3];
		for (int i = 0; i < authors.length; i++) {
			authors[i] = "Author 0" + (i+1);
		}
		
		ArrayList<Page> pages = new ArrayList<>();
		byte pagina = 0;
		for (byte i = 0; i<3; i++ ) {
			pagina = (byte) (i+1);
			pages.add(new Book.Page(pagina, "Este es el contenido de la página."));
		}
		
		for(byte i = 1; i <=5; i++) {
			books.add(new Book("Book 0" + i, new Date(), "Editorial 0" + i, 
					authors, (i * 1001), 
					"ISBN 0000" + i, false, pages));
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

		int countIndex = 0;
		
		do {
			System.out.println("..........");
			System.out.println("Page " + getPages().get(countIndex).number);
			System.out.println(getPages().get(countIndex).getContent());
			System.out.println("..........");
			
			if (countIndex!= 0) {
				System.out.println("1. Regresar Página.");
			}
			
			System.out.println("2. Siguiente Página.\n" +
								"0. Cerrar Libro.\n");
			int userInput = AmazonUtil.validateUserInputMenu(0, 2);
			
			if(userInput == 2) {
				countIndex++;
			} else if(userInput == 1) {
				countIndex--;
			} else if(countIndex == 0) {
				break;
			}
			
			} while(countIndex< getPages().size());
		
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
	
	public ArrayList<Page> getPages() {
		return pages;
	}

	public void setPages(ArrayList<Page> pages) {
		this.pages = pages;
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
	
	public static class Page {
		private int id;
		private int number;
		private String content;
		
		public Page(int number, String content) {
			super();
			this.setNumber(number);
			this.setContent(content);
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		
	}
	
}
