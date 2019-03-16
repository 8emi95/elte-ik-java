package auction;

import java.util.*;
import java.lang.*;

public class Auction {
	private Lot[] lots;
	
	public Auction(Lot[] lots) {
		this.lots = lots.clone();
	}
	
	public int numberOfLots() {
		return lots.length;
	}
	
	@Override public String toString() {
		String auction = "";
		for (int i = 0; i < lots.length; ++i) {
			auction += lots[i].toString() + "\n";
		}
		return auction;
	}
	
	public List<Lot> browseLots(String artist) {
		List<Lot> list = new ArrayList<>(0);
		if (artist != null) {
			for (int i = 0; i < lots.length; ++i) {
				if (lots[i].getArtist().equals(artist)) {
					list.add(lots[i]);
				}
			}
		}
		return list;
	}
	
	public long priceOfCollection(String artist) {
		long price = 0;
		if (artist != null) {
			for (int i = 0; i < lots.length; ++i) {
				if (lots[i].getArtist().equals(artist)) {
					price += lots[i].getHammerPrice();
				}
			}
		}
		return price;
	}
	
	public Lot mostExpensive() {
		int maxIndex = 0;
		int maxHammerPrice = 0;
		if (lots.length != 0) {
			for (int i = 0; i < lots.length; ++i) {
				if (lots[i].getHammerPrice() > maxHammerPrice) {
					maxIndex = i;
					maxHammerPrice = lots[i].getHammerPrice();
				}
			}
		} else {
			return null;
		}
		return lots[maxIndex];
	}
}