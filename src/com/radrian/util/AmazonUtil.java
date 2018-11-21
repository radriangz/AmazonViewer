package com.radrian.util;

import java.util.Scanner;

public class AmazonUtil {

	public static int validateUserInputMenu(int min, int max) {
		//Leer la respuesta del usuario
		Scanner scan = new Scanner(System.in);
		
		//Validar respuesta int
		while(!scan.hasNextInt()) {
			scan.next();
			System.out.println("No ingresaste una opción válida.\n" +
								"Intenta otra vez.");
		}
		
		int userInput = scan.nextInt();
		
		//Validar rango de respuesta
		while(userInput < min || userInput > max) {
			//Solicitar de nuevo la respuesta
			System.out.println("No ingresaste una opción válida.\n" +
					"Intenta otra vez.");
			
			while(!scan.hasNextInt()) {
				scan.next();
				System.out.println("No ingresaste una opción válida.\n" +
						"Intenta otra vez.");
			}
			userInput = scan.nextInt();
		}
		System.out.println("Tu Respuesta fue: " + userInput + "\n");
//		scan.close();
		return userInput;
	}

}