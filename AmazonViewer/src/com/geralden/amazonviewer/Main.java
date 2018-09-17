package com.geralden.amazonviewer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.gerald.amazonviewer.model.Book;
import com.gerald.amazonviewer.model.Chapter;
import com.gerald.amazonviewer.model.Movie;
import com.gerald.amazonviewer.model.Serie;
import com.gerald.makereport.Report;
import com.gerald.util.AmazonUtil;


/**
 * <h1> Amazon Viewer</h1>
 * AmazonViewer es un programa que permite visualizar Movies, Series
 * con sus respectivos Chapters, Books y Magazine. Te permite generar reportes generales y con fecha del dia.
 * 
 * <p>
 * Existen algunas reglas como todos los elementos pueden ser visualizados o leídos a excepción de las Magazines, estas sólo pueden ser vistas a modo de exposición sin ser leídas.
 * 
 * @author gerald
 * @version 1.1
 * @since 2018
 * 
 * </p>
 * 
 * 
 * 
 * */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		System.out.println("gerald");
		showMenu();
		
		
	}
	
	public static void showMenu() {
		int exit = 0;
		do {
			System.out.println("BIENVENIDOS A AMAZON VIEWER");
			System.out.println("");
			System.out.println("Seleccione el numero de la opcion deseada");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("3. Books");
			System.out.println("4. Magazines");
			System.out.println("5. Report");
			System.out.println("6. Report Today");
			System.out.println("0. Exit");			
			
			Scanner sc = new Scanner(System.in);
			int response= Integer.valueOf(sc.nextLine());
			System.out.println(response);
			switch(response) {
				case 0:
					//salir
					exit = 0;
					break;
				case 1: 
					showMovies();
					break;
				case 2 :
					showSeries();
					break;
				case 3: 
					showBooks();
					break;
				case 4: 
					showMagazine();
					break;
				case 5: 
					makeReport();
					exit=1;
					break;
				case 6:
					makeReport(new Date());
					exit = 1;
				default: 
					System.out.println();
					System.out.println("Selecciona una opcion");
					System.out.println();
					exit=1;
					break;
			}
			
			
		} while (exit != 0);
		
		
	}
	
	static ArrayList<Movie> movies = new ArrayList();	
	public static void showMovies() {
		movies = Movie.makeMoviesList();
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: MOVIES ::");
			System.out.println();
			
			for(int i=0; i< movies.size(); i++) {
				System.out.println(i+1 + ". "+ movies.get(i).getTitle()+ ", Visto: "+ movies.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			if(response == 0) {
				exit=0;
				showMenu();
			}
			
			if(response > 0) {
				Movie movieSelected = movies.get(response-1);
				movieSelected.view();
			}
			

			
		} while (exit != 0);
	}
	
	public static void showBooks() {
		int exit = 1;
		ArrayList<Book> books = Book.makeBooksList();		
		do {
			System.out.println();
			System.out.println(":: BOOKS ::");
			System.out.println();
			for(int i=0; i <
					books.size(); i++) {
				System.out.println(i+1 +". Book: "+ books.get(i).getTitle()+", visto: "+ books.get(i).isReaded());
			}
			System.out.println("0. Regresar al menu");
			System.out.println();
			
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			
			
			if(response == 0) {
				exit = 0;
				showMenu();
			}
			
			if(response > 0) {
				Book bookSelected = books.get(response-1);
				bookSelected.view();
			}
			

		} while (exit != 0);
	}
	
	static ArrayList<Serie> series = Serie.makeSeriesList();
	public static void showSeries() {
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: SERIES ::");
			System.out.println();
			
			for (int i = 0; i < series.size(); i++) { //1. Serie 1
				System.out.println(i+1 + ". " + series.get(i).getTitle() + " Visto: " + series.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			//Leer Respuesta usuario
			int response = AmazonUtil.validateUserResponseMenu(0, series.size());
			
			if(response == 0) {
				exit = 0;
				showMenu();
			}
			
			if(response > 0) {
				showChapters(series.get(response-1).getChapters());
			}
			
			
		}while(exit !=0);
	}
	
	public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected) {
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: CHAPTERS ::");
			System.out.println();
			
			
			for (int i = 0; i < chaptersOfSerieSelected.size(); i++) { //1. Chapter 1
				System.out.println(i+1 + ". " + chaptersOfSerieSelected.get(i).getTitle() + " Visto: " + chaptersOfSerieSelected.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			//Leer Respuesta usuario
			int response = AmazonUtil.validateUserResponseMenu(0, chaptersOfSerieSelected.size());
			
			if(response == 0) {
				exit = 0;
			}
			
			
			if(response > 0) {
				Chapter chapterSelected = chaptersOfSerieSelected.get(response-1);
				chapterSelected.view();
			}
		}while(exit !=0);
	}
	
	
	
	public static void showMagazine() {
		int exit = 1;
		do {
			System.out.println();
			System.out.println(":: MAGAZINE ::");
			System.out.println();
		} while (exit != 0);
	}
	
	public static void makeReport() {
		System.out.println("generando reporte");
		Report report = new Report();
		report.setNameFile("reporte");
		report.setExtension("txt");
		report.setTitle(":: VISTOS ::");
		String contentReport = "";
		
		for (Movie movie : movies) {
			if(movie.getIsViewed()) {
				contentReport += movie.toString()+"\n";
			}			
		}
		report.setContent(contentReport);
		report.makeReport();		
	}
	
	public static void makeReport(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = df.format(date);
		
		Report report = new Report();
		
		report.setNameFile("reporte"+ dateString);
		report.setExtension("txt");
		report.setTitle(":: VISTOS ::");
		String contentReport = "";
		
		for (Movie movie : movies) {
			if(movie.getIsViewed()) {
				contentReport += movie.toString()+"\n";
			}			
		}
		report.setContent(contentReport);
		report.makeReport();		
	}
}

	
