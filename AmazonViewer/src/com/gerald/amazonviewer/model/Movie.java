package com.gerald.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

import com.gerald.amazonviewer.dao.MovieDAO;

/**
 * Hereda de {@link Film}
 * Implementa de {@link IVisualizable}
 * 
 * */

public class Movie extends Film implements IVisualizable, MovieDAO{
	
	private  int id;
	private  int timeViewed;
	
	public Movie() {}
	
	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		setYear(year);
	}

	public void showData() {
	//	System.out.println("Title: "+title);
	//System.out.println("Genre: "+genre);
	//	System.out.println("Year: "+year);
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	
	public int getTimeViewed() {
		return timeViewed;
	}

	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Title:"+ getTitle() + 
				"\n Genero:" +getGenre()+
				"\n Year:"+ getYear()+
				"\n Creator: "+ getCreator()+
				"\n Duracion: "+ getDuration();
	}
	
	/**
	 * {@inheritDoc}
	 * */

	
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}
	
	/**
	 * {@inheritDoc}
	 * */


	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		
		if (dateF.getTime() > dateI.getTime()) {
			setTimeViewed((int)(dateF.getTime() - dateI.getTime()));
		}else {
			setTimeViewed(0);
		}	
	}
	
	
	public static ArrayList<Movie> makeMoviesList(){
		Movie movie = new Movie();
		
		return movie.read();
	}
	
	/**
	 * {@inheritDoc}
	 * */

	@Override
	public void view() {
		// TODO Auto-generated method stub
		setViewed(true);
		Movie movie = new Movie();
		movie.setMovieViewed(this);
		
		Date dateI = new Date();
		//startToSee(dateI);
		
		for (int i=0; i<10000 ; i++){
			System.out.println(".......");
		}
		
		stopToSee(dateI , new Date());
		System.out.println();
		System.out.println("Viste: "+ toString());
		System.out.println("Por: "+ getTimeViewed()+ "milisegundos");
	}
	
	
	
		
		
	}
	
	

