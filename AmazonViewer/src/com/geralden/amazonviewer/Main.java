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

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		//Movie movie= new Movie("Coco", "Animation", (short)2017);
		
		int i = 7;
		char c = 'w'; 
		System.out.println((i >= 6) && (c == 'w'));
		
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
					break;
				case 6:
					makeReport(new Date());
				default: 
					System.out.println();
					System.out.println("Selecciona una opcion");
					System.out.println();
					break;
			}
			
			
		} while (exit != 0);
		
		
	}
	
	static ArrayList<Movie> movies = Movie.makeMoviesList();	
	public static void showMovies() {
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
				movieSelected.setViewed(true);
				Date dateI = new Date();
				movieSelected.startToSee(dateI);
				
				for (int i=0; i<10000 ; i++){
					System.out.println(".......");
				}
				
				movieSelected.stopToSee(dateI , new Date());
				System.out.println();
				System.out.println("Viste: "+ movieSelected);
				System.out.println("Por: "+movieSelected.getTimeViewed()+ "milisegundos");
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
				showMenu();
			}
			
			if(response > 0) {
				Book bookSelected = books.get(response-1);
				bookSelected.setReaded(true);
				Date dateI = new Date();
				bookSelected.startToSee(dateI);
				
				for (int i=0; i<10000; i++) {
					System.out.println("............");
				}
				
				bookSelected.stopToSee(dateI, new Date());
				System.out.println();
				System.out.println("Leiste: "+ bookSelected.getTitle());
				System.out.println("Por: "+bookSelected.getTimeReaded()+" milisegundos");
			}
			

		} while (exit != 0);
	}
	
	public static void showSeries() {
		int exit = 1 ;
		ArrayList<Serie> series = Serie.makeSeriesList();
		do {
			System.out.println();
			System.out.println(":: SERIES ::");
			System.out.println();
			
			for (int i=0; i<series.size();i++) {
				System.out.println((i+1)+ ". Serie: "+series.get(i).getTitle()+" isViwed= "+series.get(i).isViewed());
			}
			System.out.println();
			System.out.println("0. Regresar al menu");
			System.out.println();
			
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			if (response == 0) {
				exit=0;
				showMenu();
			}
			
			if(response > 0){
				Serie serieSelected = series.get(response-1);
				serieSelected.setViewed(true);
				
				showChapters(serieSelected.getChapters());
			}
			
		} while (exit != 0);
	}
	
	public static void showChapters(ArrayList<Chapter> chaptersOfSeriesSelected) {
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: CHAPTERS ::");
			System.out.println();
			
			ArrayList<Chapter> chapters = Chapter.makeChapterList();
			
			for(int i=0; i<5; i++) {
				System.out.println((i+1)+" Chapter: "+ chapters.get(i).getTitle()+" Viewed: "+chapters.get(i).isViewed());
			}
			
			System.out.println("0. Para volver a capitulos");
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			if(response ==0) {
				exit=0;
				showSeries();
			}
			
			if(response > 0) {
				Chapter chapterSelected = chapters.get(response + 1);
				chapterSelected.setViewed(true);
				Date dateI= new Date();
				chapterSelected.startToSee(new Date());
				
				for (int i=0; i<1000; i++) {
					System.out.println("............");
				}
				
				chapterSelected.stopToSee(dateI, new Date());
				
				System.out.println();
				System.out.println("Viste el capitulo: "+chapterSelected.getTitle());
				System.out.println("Durante: "+ chapterSelected.getTimeViewed()+" milisegundos");
			}		
		} while (exit != 0);
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

	
