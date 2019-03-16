package uno.card;

import uno.Color;

public abstract class ColorCard implements Card {
	private Color color;

	public ColorCard(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public int compareTo(Card to) {
		if (to instanceof WildCard) {
			return -1;
		}

		int colorComp = getColor().compareTo(to.getColor());
		if (colorComp == 0) {
			return Integer.compare(orderNum(), to.orderNum());
		} else {
			return colorComp;
		}
	}
}