/**
 * 
 */
package com.radrian.amazonviewer.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.radrian.amazonviewer.model.Book;
import com.radrian.amazonviewer.model.Chapter;
import com.radrian.amazonviewer.model.Movie;
import com.radrian.amazonviewer.model.Series;
import com.radrian.makereport.model.Report;
import com.radrian.util.AmazonUtil;

/**
 * <h1>Amazon Viewer<h1>
 * <p>
 * AmazonViewer is a program which allows to visualize, Movies, Series and it's
 * chapters, Books and Magazines. AmazonViewer also allows to generate general
 * reports and current date reports.
 * <p>
 * Some rules are applied, all elements can be visualized (read or watched) except
 * Magazines, this are only to be seen as a catalog, not read them.
 * <p>
 * @author RAdrian
 * @version 1.0
 * @since 2018
 *
 */
public class Main {
	private static Scanner scan = new Scanner(System.in);
	private static ArrayList<Movie> movies;
	private static ArrayList<Series> series;
	private static ArrayList<Book> books;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		showMenu();
	}

	public static void showMenu() {
		int exit = -1;
		System.out.println("BIENVENIDO A AMAZON VIEWER\n");
		System.out.println("Selecciona el número de la opción deseada");
		System.err.println("1. Movies");
		System.err.println("2. Series");
		System.err.println("3. Books");
		System.err.println("4. Magazines");
		System.err.println("5. Report");
		System.err.println("6. Report Today");
		System.err.println("0. Exit");

		do {
			int userInput = AmazonUtil.validateUserInputMenu(0, 6);

			switch (userInput) {
			case 0:
					exit = 0;
					break;
			case 1:
					showMovies();
					break;
			case 2:
					showSeries();
					break;
			case 3:
					showBooks();
					break;
			case 4:
					showMagazines();
					break;
			case 5:
					makeReport();
					exit = 1;
					break;
			case 6:
					makeReport(new Date());
					exit = 1;
					break;
			default:
					System.out.println("\nSelecciona una opción válida.\n");
					exit = 1;
					break;
			}

		} while (exit != 0);

	}

	public static void showMovies() {
		int exit = -1;
		movies = Movie.makeMoviesList();
		
		do {
			System.out.println("\n:: MOVIES ::");
			
			for (int i = 0; i < movies.size(); i++) {
				System.out.println((i + 1) + ". " + 
									movies.get(i).getTitle() + 
									". Visto: " + movies.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al Menú.\n");
			System.out.println("Selecciona el número de la película que quieres ver.");
			int userInput = AmazonUtil.validateUserInputMenu(0, movies.size());
			
			if (userInput == 0) {
				exit = 0;
				showMenu();
				break;
			}
			if(userInput > 0) {
				Movie movieSelected = movies.get(userInput-1);
				movieSelected.view();
			}

		} while (exit != 0);

	}

	public static void showSeries() {
		int exit = -1;
		
		if(series == null) {
			series = Series.makeSeriesList();
		}

		do {
			System.out.println("\n:: SERIES ::");
			
			for (int i = 0; i < series.size(); i++) {
				System.out.println((i + 1) + ". " + series.get(i).getTitle() + 
									". Visto: " + series.get(i).isViewed());
			}
			System.out.println("0. Regresar al Menú.\n");
			System.out.println("Selecciona el número de la opción deseada.");
			int userInput = scan.nextInt();
			
			if (userInput == 0) {
				showMenu();
			}
			
			if(userInput > 0) {
				showChapters(series.get(userInput-1).getChapters());
			}

		} while (exit != 0);
	}

	public static void showChapters(ArrayList<Chapter> chaptersOfSeriesSelected) {
		int exit = -1;

		do {
			System.out.println("\n:: CHAPTERS ::\n");
			
			for (int i = 0; i < chaptersOfSeriesSelected.size(); i++) {
				System.out.println((i + 1) + ". " + chaptersOfSeriesSelected.get(i).getTitle() + 
									". Visto: " + chaptersOfSeriesSelected.get(i).isViewed());
			}
			System.out.println("0. Regresar al menú anterior.\n");
			System.out.println("Selecciona el número de la opción deseada.");
			int userInput = scan.nextInt();
			
			if (userInput == 0) {
				showSeries();
			}
			if(userInput > 0) {
				Chapter chapterSelected = chaptersOfSeriesSelected.get(userInput-1);
				chapterSelected.view();
			}
			
		} while (exit != 0);
	}

	public static void showBooks() {
		int exit = -1;
		books = Book.makeBooksList();
		
		do {
			System.out.println("\n:: BOOKS ::");
			
			for (int i = 0; i < books.size(); i++) {
				System.out.println((i + 1) + ". " + books.get(i).getTitle() + 
									". Leído: " + books.get(i).hasBeenRead());
			}
			System.out.println("0. Regresar al Menú.\n");
			System.out.println("Selecciona el número de la opción deseada.");
			int userInput = scan.nextInt();
			
			if (userInput == 0) {
				showMenu();
			} 
			if(userInput > 0) {
				Book bookSelected = books.get(userInput-1);
				bookSelected.view();
			}

		}while (exit != 0);
	}

	public static void showMagazines() {
		int exit = 0;

		do {
			System.out.println();
			System.out.println(":: MAGAZINES ::");
		} while (exit != 0);
	}

	public static void makeReport() {
		Report report = new Report();
		report.setNameFile("reporte_AmazonViewer");
		report.setExtension("txt");
		report.setTitle(": : Vistos : :\n");
		
		StringBuilder contentReport = new StringBuilder().append(report.getTitle()).append(buildReportContent());
		
		report.setContent(contentReport.toString());
		report.makeReport();
//		playMedia(5);
		System.out.println("\nEl reporte ha sido generado con éxito\n");
		showMenu();
	}

	public static void makeReport(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = dateFormat.format(date);
		Report report = new Report();
		report.setNameFile("reporte_" + dateString);
		report.setExtension("txt");
		report.setTitle(": : Vistos : :\n");
		
		StringBuilder contentReport = new StringBuilder().append(report.getTitle()).append(buildReportContent());
		
		report.setContent(contentReport.toString());
		report.makeReport();
//		playMedia(5);
		System.out.println("\nEl reporte del día ha sido generado con éxito\n");
		showMenu();
	}
	
	private static String buildReportContent() {
		StringBuilder contentReport = new StringBuilder();
		
		try {
			for (Movie movie : movies) {
				if(movie.getIsViewed()) {
					contentReport.append(movie.toString()).append("\n");
				}
			}
		} catch (NullPointerException e) {
			contentReport.append("\nNo se ha visto ninguna película\n");
		}
		
		try {
			for (Series series : series) {
				if(series.getIsViewed()) {
					contentReport.append(series.toString()).append("\n");
					for(Chapter chapter: series.getChapters()) {
						if(chapter.getIsViewed()) {
							contentReport.append(chapter.toString()).append("\n");
						}
					}
				} 
			}
		} catch (NullPointerException e) {
			contentReport.append("\nNo se ha visto ninguna serie\n");
		}
		
		try {
			for (Book book : books) {
				if(book.getHasBeenRead()) {
					contentReport.append(book.toString()).append("\n");
				}
			}
		} catch (NullPointerException e) {
			contentReport.append("\nNo se ha leído ningún libro\n");
		}
		
		return contentReport.toString();
	}
	
	
	
}
