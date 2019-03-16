package uno.card;

import uno.Color;
import uno.Game;

public class TakeTwoCard extends ColorCard {
	public TakeTwoCard(Color color) {
		super(color);
	}

	public boolean canPlaceOn(Card other) {
		return getColor().equals(other.getColor()) || getClass().equals(other.getClass());
	}

	public int orderNum() {
		return 12;
	}

	public void effect(Game game) {
		game.nextPlayer();
		for (int i = 0; i < 2; ++i) {
			game.getActualPlayer().draw(game.nextCard());
		}
	}

	@Override public String toString() {
		return getColor().toString() + " +2";
	}
}