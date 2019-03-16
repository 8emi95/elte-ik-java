package game.players;

import game.items.Gem;
import game.utils.Position;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Anna extends Player {
	private final String name = "Princess Anna";

	public Anna(ArrayList<Gem> gemList, Position pos) {
		super(gemList, pos);
	}

	public String getName() {
		return name;
	}

	public void fight(Troll troll) {
		int numGemLost = new Random().nextInt(this.getGemList().size()+1);
		ArrayList<Gem> gemsLost = new ArrayList<Gem>(this.getGemList().subList(0, numGemLost));
		this.getGemList().removeAll(gemsLost);
		troll.getGemList().addAll(gemsLost);
	}

	public void fight() {
		java.util.Collections.sort(this.getGemList());
		if (this.getGemList().size() > 0) {
			this.getGemList().remove(0);
		}
	}

	public void move() {
		List<Position> neighbours = this.getPosition().neighbours();
		this.setPosition(neighbours.get(new Random().nextInt(neighbours.size())));
	}

	@Override public String display() {
		if (this.getPosition().equals(Position.WINNING_POSITION)) {
			return "I have won the game.";
		}
		return "I have lost the game.";
	}
}