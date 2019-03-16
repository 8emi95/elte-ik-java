package uno.card;

import uno.Game;

public class TakeFourCard extends WildCard {
	public int orderNum() {
		return 14;
	}

	@Override public void effect(Game game) {
		game.nextPlayer();
		for (int i = 0; i < 4; ++i) {
			game.getActualPlayer().draw(game.nextCard());
		}
	}

	@Override public String toString() {
		return "+4 (" + getColor() + ")";
	}
}