package auction;

import auction.Genre;
import java.lang.Object;
import java.util.*;

public class Book{
	
	private String writer;
	private String title;
	private int hammerPrice;
	private int id;
	private Genre genre;
	
	private Book(String writer, String title, int hammerPrice, Genre genre){
		this.writer = writer;
		this.title = title;
		this.hammerPrice = hammerPrice;
		this.genre = genre;
		this.id = 0;
	}
	
	public Book make(String writer, String title, int hammerPrice, String genre){
		
		//genre = Genre.valueOf(genre);
		
		if(writer.equals("") || title.equals("") || writer == null || title == null || hammerPrice < 0 ) {
			return null;
		} else {
			return new Book(writer, title, hammerPrice, Genre.valueOf(genre));
		}
	}

	public String getAuthor(){
		return this.writer;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public int getHammerPrice(){
		return this.hammerPrice;
	}
	
	public Genre getGenre(){
		return this.genre;
	}
	
	public void bid(int parameter){
		if(parameter > this.hammerPrice){
			parameter = this.hammerPrice;
		}
	}
	
	public String toString(){
		return this.writer + ": " + this.title + " (" + this.hammerPrice + "HUF" + ")" ;
	}
	
	public boolean moreExpensiveThan(Book b){
		if(b != null && b.getHammerPrice() < this.hammerPrice){
			return true;
		} else {
			return false;
		}
		
		
	
	}
	
	
}