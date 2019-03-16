package auction;

import java.lang.*;
import java.util.*;
//import java.util.regex.Pattern;

public class Lot {
	private String artist;
	private String title;
	private int hammerPrice;
	
	private Lot(String artist, String title, int hammerPrice) {
		this.artist = artist;
		this.title = title;
		this.hammerPrice = hammerPrice;
	}
	
	public static Lot make(String artist, String title, int hammerPrice) {
		if (artist != null && 
			title != null &&
			title.length() >= 2 && 
			//(Pattern.matches("[A-Z]+ ", title) /*|| Pattern.matches(" ", title)*/) &&
			hammerPrice > 0) {
			
			boolean ok = true;
			int i = 0;
			while (i < title.length() && ok) {
				if (Character.isUpperCase(title.charAt(i)) || Character.isWhitespace(title.charAt(i))) {
					ok = true;
					i++;
				} else {
					ok = false;
					return null;
				}
			}
			return new Lot(artist, title, hammerPrice);
		} else {
			return null;
		}
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getHammerPrice() {
		return hammerPrice;
	}
	
	public void bid(int bidValue) {
		if (bidValue > 0 && bidValue > hammerPrice) {
			hammerPrice = bidValue;
		}
	}
	
	@Override public String toString() {
		return artist + ": " + title + " (" + hammerPrice + " GBP)";
	}
	
	public boolean moreExpensiveThan(Lot lot) {
		if (lot != null && this.hammerPrice > lot.hammerPrice) {
			return true;
		} else {
			return false;
		}
	}
	
	static Lot STATUE = new Lot("Felix W. de Weldon", "US MARINE MEMORIAL", 50000);
}