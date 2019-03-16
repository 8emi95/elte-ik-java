package game.arendelle;

import java.util.ArrayList;

import game.items.Gem;

public class Chalet extends Kingdom {
	private ArrayList<Gem> gemList;

	public Chalet(ArrayList<Gem> gemList) {
		this.gemList = gemList;
	}

	public ArrayList<Gem> getGemList() {
		return gemList;
	}

	public void setGemList(ArrayList<Gem> gemList) {
		this.gemList = gemList;
	}

	public ArrayList<Gem> collectItems(int count) {
		ArrayList<Gem> ret = new ArrayList<Gem>();
		if (count <= this.gemList.size()) {
			for (int i = 0; i < count; i++) {
				Gem gem = this.gemList.remove(0);
				ret.add(gem);
			}
		}
		return ret;
	}

	@Override public String toString() {
		return "Welcome...If you are lucky, you will come across some gems here for Elsa.";
	}

	public boolean isReachable() {
		return true;
	}
}