package game.players;

import java.util.ArrayList;

import game.items.Gem;
import game.utils.Position;

public abstract class Player {
	protected ArrayList<Gem> gemList;
	protected Position pos;

	public Player(ArrayList<Gem> gemList, Position pos) {
		this.gemList = gemList;
		this.pos = pos;
	}

	public ArrayList<Gem> getGemList() {
		return gemList;
	}

	public Position getPosition() {
		return pos;
	}

	public void setGemList(ArrayList<Gem> gemList) {
		this.gemList = gemList;
	}

	public void setPosition(Position pos) {
		this.pos = pos;
	}

	protected abstract String display();
}