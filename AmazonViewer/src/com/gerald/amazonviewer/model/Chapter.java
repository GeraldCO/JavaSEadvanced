package com.gerald.amazonviewer.model;

import java.util.ArrayList;

public class Chapter extends Movie{
	
	private int id;
	private int seasonsNumber;
	
	public Chapter(String title, String genre, String creator, int duration, short year, int seasonsNumber) {
		super(title, genre, creator, duration, year);
		this.setSeasonsNumber(seasonsNumber);
	}
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
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
	
	public static ArrayList<Chapter> makeChapterList(){
		ArrayList<Chapter> chapters = new ArrayList();
		for(int i=1; i<=5; i++) {
			chapters.add(new Chapter("Capitulo"+i, "genero"+i, "creator"+1, 40,(short)1958, 5));
		}
		
		return chapters;
	}
	
	

}
