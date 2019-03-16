package uno;

import java.util.TreeSet;

import uno.card.Card;

public class Player {
	private String name;
	private TreeSet<Card> hand = new TreeSet<Card>();

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void draw(Card card) {
		if (card != null) {
			hand.add(card);
		}
	}

	public boolean hasWon() {
		return hand.isEmpty();
	}

	public String terminalMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + " [");

		int handSize = hand.size();
		int i = 1;
		for (Card c : hand) {
			sb.append("#" + i + ": ");
			sb.append(c.toString());

			if (i <= handSize - 1) {
				sb.append(", ");
			}

			++i;
		}
		sb.append("]");

		return sb.toString();
	}

	public Card chooseCard(String input) {
		if (input.isEmpty()) {
			return null;
		} else {
			int chosenNumber = 0;
			try {
				chosenNumber = Integer.parseInt(input);
			} catch (NumberFormatException nfe) {
				assert false;
				return null;
			}

			int numbering = 1;
			for (Card c : hand) {
				if (numbering < chosenNumber) {
					++numbering;
				} else {
					Card chosen = c;
					hand.remove(c);
					return chosen;
				}
			}
		}

		assert false;
		return null;
	}
}