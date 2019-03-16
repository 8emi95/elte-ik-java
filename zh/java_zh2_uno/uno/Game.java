package uno;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import uno.card.*;

public class Game {
	public static LinkedList<Card> getAllCards() {
		LinkedList<Card> list = new LinkedList<Card>();

		for (Color c : Color.values()) {
			for (int i = 1; i <= 9; ++i) {
				list.add(new NumberCard(c, i));
				list.add(new NumberCard(c, i));
			}

			list.add(new NumberCard(c, 0));
			for (int i = 0; i < 2; ++i) {
				list.add(new SkipCard(c));
				list.add(new ReverseCard(c));
				list.add(new TakeTwoCard(c));
			}
		}

		for (int i = 0; i < 3; ++i) {
			list.add(new WildCard());
			list.add(new TakeFourCard());
		}

		return list;
	}

	private ArrayList<Player> players;
	private int actualPlayer = 0;
	private LinkedList<Card> pile = new LinkedList<Card>();
	private LinkedList<Card> played = new LinkedList<Card>();
	private boolean forwardOrder = true;

	public Player getActualPlayer() {
		return players.get(actualPlayer);
	}

	public void nextPlayer() {
		actualPlayer = ((forwardOrder ? actualPlayer + 1 : actualPlayer - 1) + players.size()) % players.size();
	}

	public void reverseOrder() {
		forwardOrder = !forwardOrder;
	}

	public void putOnTop(Card card) {
		played.push(card);
	}

	public Game(String[] playerNames) {
		players = new ArrayList<Player>(playerNames.length);

		for (String name : playerNames) {
			Player ply = new Player(name);
			players.add(ply);
		}
	}

	public void startGame() {
		pile = getAllCards();
		java.util.Collections.shuffle(pile);

		for (Player ply : players) {
			for (int i = 0; i < 6; ++i) {
				ply.draw(nextCard());
			}
		}

		Card next = nextCard();
		putOnTop(next);
		while (!(next instanceof NumberCard)) {
			next = nextCard();
			putOnTop(next);
		}
	}

	public Card nextCard() {
		try {
			Card next = pile.pop();
			return next; // A pakliban volt lap, visszaadjuk.
		} catch (NoSuchElementException nsee) {
			// A pakli üres.
			Card lastPlayedCard = played.pollFirst();

			pile = new LinkedList<Card>(played);
			java.util.Collections.shuffle(pile);
			played.clear();

			played.push(lastPlayedCard); // Az utolsó kijátszott lap a kupacon marad.

			return pile.pop(); // A kevert pakli legfelső lapja
		}
	}

	public String play() {
		while (!getActualPlayer().hasWon()) {
			System.out.println("A legutolsó kijátszott lap: " + played.peek().toString());
			System.out.println(getActualPlayer().terminalMessage());

			System.out.print("Melyik lapot választod? ");
			String choice = readLine();
			Card chosenCard = getActualPlayer().chooseCard(choice);
			if (chosenCard == null || !chosenCard.canPlaceOn(played.peek())) {
				getActualPlayer().draw(nextCard());

				if (chosenCard != null) { // Visszakapja azt is, amit lerakott... már ha tudott bármit is lerakni!
					getActualPlayer().draw(chosenCard);
				}
			} else {
				if (chosenCard instanceof WildCard) {
					StringBuilder sb = new StringBuilder();
					System.out.print("Joker lapot választottál. Milyen színű legyen? (");
					int i = 0;
					for (Color c : Color.values()) {
						sb.append(c.toString());
						if (i < Color.values().length - 1)
							sb.append(", ");
					}
					System.out.print(sb.toString() + ") ");

					String colorChoice = readLine();
					Color chosenColor = null;
					for (Color c : Color.values()) {
						if (colorChoice.equals(c.toString())) {
							chosenColor = c;
						}
					}
					if (chosenColor == null) {
						System.err.println("Ilyen szín nincs!");
					}

					((WildCard)chosenCard).chooseColor(chosenColor); // A cast tuti jó, instanceof igaz az IF alapján.
				}

				chosenCard.effect(this);
				putOnTop(chosenCard);
				nextPlayer();
			}
		}

		return getActualPlayer().getName();
	}

	protected String readLine() {
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();

		return choice;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Hány játékos lesz? ");
		int plyCount = sc.nextInt();
		sc.nextLine();
		System.out.println();

		String[] plyNames = new String[plyCount];

		for (int i = 0; i < plyCount; ++i) {
			System.out.print( (i+1) + ". játékos neve: ");
			plyNames[i] = sc.nextLine();
		}

		Game game = new Game(plyNames);
		game.startGame();
		game.play();

		System.out.println("Vége. :-(");
	}
}