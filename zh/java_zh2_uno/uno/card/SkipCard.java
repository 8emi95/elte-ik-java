package uno.card;

import uno.Color;
import uno.Game;

public class SkipCard extends ColorCard {
	public SkipCard(Color color) {
		super(color);
	}

	public boolean canPlaceOn(Card other) {
		return getColor().equals(other.getColor()) || getClass().equals(other.getClass());
	}

	public int orderNum() {
		return 10;
	}

	public void effect(Game game) {
		game.nextPlayer();
	}

	@Override public String toString() {
		return getColor().toString() + " skip";
	}
}