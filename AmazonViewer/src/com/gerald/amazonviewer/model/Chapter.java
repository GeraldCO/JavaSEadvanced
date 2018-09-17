package com.gerald.amazonviewer.model;

import java.util.ArrayList;

/**
 * Hereda de {@link Movie}
 * @see Film
 * */

public class Chapter extends Movie{
	
	private int id;
	private int seasonsNumber;
	private Serie serie;
	int seasonNumber;
	
	public Chapter(String title, String genre, String creator, int duration, short year, int seasonNumber, Serie serie) {
		  super(title, genre, creator, duration, year);
		  this.seasonNumber = seasonNumber;
		  this.serie = serie;
		}
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	public Serie getSerie() {
		return serie;
	}
	
	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public int getSeasonsNumber() {
		return seasonsNumber;
	}

	public void setSeasonsNumber(int seasonsNumber) {
		this.seasonsNumber = seasonsNumber;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\n :: Chapter ::"+
				"\n Title: "+ getTitle()+
				"\n Genre: "+ getGenre()+
				"\n Creator: "+ getCreator() +
				"\n Duration: "+ getDuration() +
				"\n Year: "+ getYear() + 
				"\n SeasonNumber: "+ getSeasonsNumber()
		;
		
	}
	
	public static ArrayList<Chapter> makeChaptersList(Serie serie) {
		  ArrayList<Chapter> chapters = new ArrayList<>();
		  
		  for (int i = 1; i <= 5; i++) {
		    chapters.add(new Chapter("Chapter " + i, "Genre " + i, "Creator " + i, 45 + i, (short) (2017 + i), i, serie));
		  }
		  
		  return chapters;
		}
	
	@Override
	public void view() {
		// TODO Auto-generated method stub
		super.view();
		ArrayList<Chapter> chapters =  getSerie().getChapters();
		int chapterViewedCounter = 0;
		for (Chapter chapter : chapters) {
			if (chapter.getIsViewed()) {
				chapterViewedCounter++;
			}
		}
		
		if (chapterViewedCounter == chapters.size()) {
			getSerie().view();
		}
	}
	
	

}
