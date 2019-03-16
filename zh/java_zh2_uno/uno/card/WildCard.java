package uno.card;

import uno.Color;
import uno.Game;

public class WildCard implements Card {
	private Color chosenColor;

	public boolean canPlaceOn(Card other) {
		return true;
	}

	public int orderNum() {
		return 13;
	}

	public void effect(Game game) {
		return; // Purposefully empty.
	}

	public void chooseColor(Color color) {
		chosenColor = color;
	}

	public Color getColor() {
		return chosenColor;
	}

	@Override
	public String toString() {
		return "Wild (" + getColor() + ")";
	}

	public int compareTo(Card card) {
		if (card instanceof ColorCard) {
			return 1;
		} else {
			return Integer.compare(orderNum(), card.orderNum());
		}
	}
}