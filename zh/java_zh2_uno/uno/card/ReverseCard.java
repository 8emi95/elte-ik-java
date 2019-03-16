package uno.card;

import uno.Color;
import uno.Game;

public class ReverseCard extends ColorCard {
	public ReverseCard(Color color) {
		super(color);
	}

	public boolean canPlaceOn(Card other) {
		return getColor().equals(other.getColor()) || getClass().equals(other.getClass());
	}

	public int orderNum() {
		return 11;
	}

	public void effect(Game game) {
		game.reverseOrder();
	}

	@Override public String toString() {
		return getColor().toString() + " reverse";
	}
}