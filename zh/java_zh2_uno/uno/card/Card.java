package uno.card;

import uno.Color;
import uno.Game;

public interface Card extends Comparable<Card> {
	boolean canPlaceOn(Card other);
	void effect(Game game);
	int orderNum();
	Color getColor();
}