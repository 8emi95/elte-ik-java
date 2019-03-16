package game.players;

import game.items.Gem;
import game.utils.Position;
import java.util.ArrayList;

public class Troll extends Player {
	private final String name;

	public Troll(ArrayList<Gem> gemList, Position pos, int num) {
		super(gemList, pos);
		this.name = "Troll " + num;
	}

	public String getName() {
		return name;
	}

	@Override public String display() {
		return "Hi. My name is " + this.getName() + ". Nice to meet you, Anna.";
	}
}