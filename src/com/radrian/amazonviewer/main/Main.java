/**
 * 
 */
package com.radrian.amazonviewer.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.radrian.amazonviewer.model.Movie;

/**
 * @author RAdrian
 *
 */
public class Main {
	public static Scanner scan = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		showMenu();

	}

	public static void showMenu() {
		int exit = 0;
		System.out.println("BIENVENIDO A AMAZON VIEWER");
		System.err.println("");
		System.out.println("Selecciona el número de la opción deseada");
		System.err.println("1. Movies");
		System.err.println("2. Series");
		System.err.println("3. Books");
		System.err.println("4. Magazines");
		System.err.println("5. Report");
		System.err.println("6. Report Today");
		System.err.println("0. Exit");

		do {
			int userInput = scan.nextInt();
			switch (userInput) {
			case 0:
				exit = 0;
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
				break;
			case 6:
				makeReport(new Date());
				break;
			default:
				System.out.println("\nSelecciona una opción válida.\n");
				break;
			}

		} while (exit != 0);

	}

	public static void showMovies() {
		int exit = 0;
		ArrayList<Movie> movies = Movie.makeMoviesList();

		do {
			System.out.println("\n:: MOVIES ::\n");
			for (int i = 0; i < movies.size(); i++) {
				System.out.println(
						"Movie 0" + i + 1 + ". " + movies.get(i).getTitle() + "Visto: " + movies.get(i).isViewed());
			}
			System.out.println("0. Regresar al Menú.\n");
		} while (exit != 0);

	}

	public static void showSeries() {
		int exit = 0;

		do {
			System.out.println();
			System.out.println(":: SERIES ::");
		} while (exit != 0);
	}

	public static void showChapters() {
		int exit = 0;

		do {
			System.out.println();
			System.out.println(":: CHAPTERS ::");
		} while (exit != 0);
	}

	public static void showBooks() {
		int exit = 0;

		do {
			System.out.println();
			System.out.println(":: BOOKS ::");
		} while (exit != 0);
	}

	public static void showMagazines() {
		int exit = 0;

		do {
			System.out.println();
			System.out.println(":: MAGAZINES ::");
		} while (exit != 0);
	}

	public static void makeReport() {

	}

	public static void makeReport(Date date) {

	}

}
