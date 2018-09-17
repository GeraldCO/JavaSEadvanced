package com.gerald.amazonviewer.model;

import java.util.ArrayList;

public class Serie extends Film {
	
	private int id;
	private int seasonsQuantity;
	private ArrayList<Chapter> chapters;
	
	public Serie(String title, String genre, String creator, int duration, int seasonsQuantity) {
		super(title, genre, creator, duration);
		this.seasonsQuantity = seasonsQuantity;
		this.chapters = chapters;
	}

	public int getId() {
		return id;
	}

	public int getSeasonsQuantity() {
		return seasonsQuantity;
	}

	public void setSeasonsQuantity(int seasonsQuantity) {
		this.seasonsQuantity = seasonsQuantity;
	}
	
	public ArrayList<Chapter> getChapters() {
		return chapters;
	}

	public void setChapter(ArrayList<Chapter> chapters) {
		this.chapters = chapters;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\n ::SERIE ::"+
				"\n Titulo: "+getTitle()+
				"\n Genero: "+ getGenre()+
				"\n A�o: "+getYear()+
				"\n Creador: "+getCreator()+
				"\n Duration: "+getDuration();
	}
	
	public static ArrayList<Serie> makeSeriesList() {
		  ArrayList<Serie> series = new ArrayList<>();
		  
		  for (int i = 1; i <= 5; i++) {
		    Serie serie = new Serie("Serie " + i, "Genre " + i, "Creator " + i, 1200 + i, 5 + i);
		    serie.setChapter(Chapter.makeChaptersList(serie));
		    series.add(serie);
		  }
		  
		  return series;
		}

	@Override
	public void view() {
		// TODO Auto-generated method stub
		setViewed(true);
		
	}
	
}
