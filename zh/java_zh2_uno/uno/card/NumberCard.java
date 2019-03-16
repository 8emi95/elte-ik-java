package uno.card;

import uno.Color;
import uno.Game;

public class NumberCard extends ColorCard {
	private int number;

	public NumberCard(Color color, int number) {
		super(color);

		if (number < 0 || number > 9)
			throw new IllegalArgumentException("number: must be a number between 0 and 9.");

		this.number = number;
	}

	public boolean canPlaceOn(Card other) {
		return getColor().equals(other.getColor()) || orderNum() == other.orderNum();
	}

	public int orderNum() {
		return number;
	}

	public void effect(Game game) {
		return; // Purposefully empty.
	}

	@Override
	public String toString() {
		return getColor().toString() + " " + orderNum();
	}
}