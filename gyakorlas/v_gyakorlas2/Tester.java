import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*import uno.Color;*/
/*import uno.Game;*/
/*import uno.Player;*/
/*import uno.card.Card;*/
/*import uno.card.NumberCard;*/
/*import uno.card.ReverseCard;*/
/*import uno.card.SkipCard;*/
/*import uno.card.TakeFourCard;*/
/*import uno.card.TakeTwoCard;*/
/*import uno.card.WildCard;*/

public class Tester {

	private static int points = 0;

	/*static NumberCard nc1;*/
	/*static NumberCard nc2;*/
	/*static NumberCard nc3;*/
	/*static TakeTwoCard ttc1;*/
	/*static TakeTwoCard ttc2;*/
	/*static SkipCard sc1;*/
	/*static SkipCard sc2;*/
	/*static ReverseCard rc1;*/
	/*static ReverseCard rc2;*/
	/*static WildCard wc;*/
	/*static TakeFourCard tfc;*/

	/*static Player player;*/

	/*static Game game;*/

	public static void main(String[] args) {/*
		testColor(1);
		testNumberCard(5);
		testWildcard(3);
		testPlayer();
		testGame();
		testSkipCards(2);
		testReverseCards(2);
		testTakeTwoCards(2);
		testTakeFourCards(3);
		testGetAllCards(4);

		System.out.println("\n\nElert pontszam: " + points);
	*/}

	private static void testColor(int p) {/*
		assertTrue("A szinek nem a megfelelo sorrendben szerepelnek.", Color.GREEN.ordinal() == 0
				&& Color.BLUE.ordinal() == 1 && Color.YELLOW.ordinal() == 2 && Color.RED.ordinal() == 3);
		points += p;
	*/}

	private static void testNumberCard(int p) {/*
		nc1 = new NumberCard(Color.BLUE, 3);
		nc2 = new NumberCard(Color.BLUE, 8);
		nc3 = new NumberCard(Color.RED, 3);
		assertTrue("Nem lehet BLUE 3-at BLUE 8-ra rakni", nc1.canPlaceOn(nc2));
		assertTrue("Nem lehet BLUE 3-at RED 3-ra rakni", nc1.canPlaceOn(nc3));
		assertTrue("BLUE 3 nem kisebb BLUE 8-nal", nc1.compareTo(nc2) < 0);
		assertTrue("BLUE 3 nem kisebb RED 3-nal", nc1.compareTo(nc3) < 0);
		assertTrue("BLUE 8 nem kisebb RED 3-nal", nc2.compareTo(nc3) < 0);
		assertEquals("BLUE 3 toString()-je nem jo", "BLUE 3", nc1.toString());

		boolean exceptionOnWrong = false;
		try {
			new NumberCard(Color.RED, 10);
		} catch (IllegalArgumentException e) {
			exceptionOnWrong = true;
		}
		assertTrue("RED 10 letrehozasa nem valtott ki kivetelt", exceptionOnWrong);

		points += p;
	*/}

	private static void testWildcard(int p) {/*
		wc = new WildCard();
		assertTrue("Nem lehet jokert BLUE 8-ra rakni", wc.canPlaceOn(nc2));
		assertTrue("Nem lehet jokert RED 3-ra rakni", wc.canPlaceOn(nc3));
		assertTrue("Nem lehet jokert RED +2-re rakni", wc.canPlaceOn(ttc2));
		wc.chooseColor(Color.RED);
		assertTrue("Nem lehet RED 3-at Wild (RED)-re rakni", nc3.canPlaceOn(wc));
		assertTrue("BLUE skip nem nagyobb BLUE 8-nal", wc.compareTo(nc2) > 0);
		assertTrue("BLUE skip nem nagyobb RED 3-nal", wc.compareTo(nc2) > 0);
		assertTrue("BLUE skip nem nagyobb RED +2-nal", wc.compareTo(nc2) > 0);
		assertEquals("wildcard toString()-je nem jo", "Wild (RED)", wc.toString());
		points += p;
	*/}

	private static void testPlayer() {/*
		player = new Player("Adam");
		testPlayerName(1);
		testPlayerDrawWon(2);
		testPlayerTerminalMessage(2);
		testPlayerChooseCard(2);
	*/}

	private static void testPlayerName(int p) {/*
		assertEquals("Player neve nem jo", "Adam", player.getName());
		points += p;
	*/}

	private static void testPlayerDrawWon(int p) {/*
		assertTrue("Nem igaz a hasWon kartya nelkuli jatekosra", player.hasWon());
		player.draw(null);
		assertTrue("draw nem hagyja figyelmen kivul a null-t", player.hasWon());
		player.draw(nc1);
		assertTrue("Igaz a hasWon kartyaval rendelkezo jatekosra", !player.hasWon());
		points += p;
	*/}

	private static void testPlayerTerminalMessage(int p) {/*
		player.draw(nc3);
		player.draw(nc2);
		String terminalMessage = player.terminalMessage();
		assertTrue("A jatekos terminal message-je nem tartalmazza a jatekosnevet",
				terminalMessage.contains(player.getName()));
		assertTrue("A jatekos terminal message-je nem tartalmazza BLUE 3-at, pedig a kezeben van",
				terminalMessage.contains(nc1.toString()));
		assertTrue("A jatekos terminal message-je nem tartalmazza BLUE 8-at, pedig a kezeben van",
				terminalMessage.contains(nc2.toString()));
		assertTrue("A jatekos terminal message-je nem tartalmazza RED 3-at, pedig a kezeben van",
				terminalMessage.contains(nc3.toString()));
		points += p;
	*/}

	private static void testPlayerChooseCard(int p) {/*
		Card c = player.chooseCard("");
		assertTrue("Az ures stringre a chooseCard legyen null", c == null);
		assertTrue("Az 1-es kartya a BLUE 3", player.chooseCard("1") == nc1);
		assertTrue("Az 3-as kartya a RED 3", player.chooseCard("2") == nc3);
		assertTrue("Az 2-es kartya a BLUE 8", player.chooseCard("1") == nc2);
		points += p;
	*/}

	private static void testGame() {/*
		game = new Game(new String[] { "A", "B", "C" });
		gameSimpleFunctions(4);
		gameNextCard(5);
		gamePlay(5);
	*/}

	private static void gameSimpleFunctions(int p) {/*
		assertEquals("Az elso jatekos legyen a kezdo", "A", game.getActualPlayer().getName());
		game.nextPlayer();
		assertEquals("Az kovetkezo jatekos legyen B", "B", game.getActualPlayer().getName());
		game.nextPlayer();
		assertEquals("Utana legyen C", "C", game.getActualPlayer().getName());
		game.nextPlayer();
		assertEquals("Utana megint A", "A", game.getActualPlayer().getName());
		game.reverseOrder();
		game.nextPlayer();
		assertEquals("Megforditva a kort megint C jon", "C", game.getActualPlayer().getName());
		game.nextPlayer();
		assertEquals("Aztan megint B", "B", game.getActualPlayer().getName());
		points += p;
	*/}

	private static void gameNextCard(int p) {/*
		List<Card> cards = new LinkedList<>();
		cards.add(game.nextCard());
		cards.add(game.nextCard());
		boolean ordered = true;
		for (int i = 0; i < 20; ++i) {
			Card card = game.nextCard();
			cards.add(card);
			if (cards.get(i).compareTo(cards.get(i + 1)) != cards.get(i + 1).compareTo(cards.get(i + 2))) {
				ordered = false;
			}
			game.putOnTop(card);
		}
		assertTrue("A pakli valoszinu nincs jol megkeverve, 20 lap sorban jott", !ordered);

		// ha nem tud 200-szor húzni a pakliból, akkor az újrakeverés nem
		// működik
		for (int i = 0; i < 200; ++i) {
			game.putOnTop(game.nextCard());
		}
		points += p;
	*/}

	private static void testSkipCards(int p) {/*
		sc1 = new SkipCard(Color.BLUE);
		sc2 = new SkipCard(Color.RED);
		assertTrue("Nem lehet BLUE skipet RED skipre rakni", sc1.canPlaceOn(sc2));
		assertTrue("Nem lehet BLUE skipet BLUE 3-ra rakni", nc1.canPlaceOn(nc1));
		assertTrue("BLUE skip nem nagyobb BLUE 8-nal", sc1.compareTo(nc2) > 0);
		assertTrue("BLUE skip nem kisebb RED 3-nal", sc1.compareTo(nc3) < 0);
		assertEquals("BLUE skip toString()-je nem jo", "BLUE skip", sc1.toString());
		points += p;
	*/}

	private static void gamePlay(int p) {/*
		game = new TestGame(new String[] { "A", "B", "C" }, new String[] { "1", "1", "1" });
		game.putOnTop(nc1);
		for (int i = 0; i < 3; i++) {
			game.getActualPlayer().draw(new NumberCard(Color.BLUE, i));
			game.nextPlayer();
		}

		assertEquals("Az 'A' játékosnak kell nyernie, ha mindenkinek csak 1 lapja van, ami letehető", "A", game.play());
		points += p;
	*/}

	private static void testReverseCards(int p) {/*
		rc1 = new ReverseCard(Color.BLUE);
		rc2 = new ReverseCard(Color.RED);
		assertTrue("Nem lehet BLUE reverse-et RED reverse-re rakni", rc1.canPlaceOn(rc2));
		assertTrue("Nem lehet BLUE reverse-et BLUE 3-ra rakni", rc1.canPlaceOn(nc1));
		assertTrue("BLUE reverse nem nagyobb BLUE 8-nal", rc1.compareTo(nc2) > 0);
		assertTrue("BLUE reverse nem kisebb RED 3-nal", rc1.compareTo(nc3) < 0);
		assertEquals("BLUE reverse toString()-je nem jo", "BLUE reverse", rc1.toString());
		points += p;
	*/}

	private static void testTakeTwoCards(int p) {/*
		ttc1 = new TakeTwoCard(Color.BLUE);
		ttc2 = new TakeTwoCard(Color.RED);
		assertTrue("Nem lehet BLUE +2-t RED +2-re rakni", ttc1.canPlaceOn(ttc2));
		assertTrue("Nem lehet BLUE +2-t BLUE 3-ra rakni", ttc1.canPlaceOn(nc1));
		assertTrue("BLUE +2 nem nagyobb BLUE 8-nal", ttc1.compareTo(nc2) > 0);
		assertTrue("BLUE +2 nem kisebb RED 3-nal", ttc1.compareTo(nc3) < 0);
		assertEquals("BLUE +2 toString()-je nem jo", "BLUE +2", ttc1.toString());
		points += p;
	*/}

	private static void testTakeFourCards(int p) {/*
		tfc = new TakeFourCard();
		assertTrue("Nem lehet +4-t RED +2-re rakni", tfc.canPlaceOn(ttc2));
		assertTrue("Nem lehet +4-t BLUE 3-ra rakni", tfc.canPlaceOn(nc1));
		assertTrue("+4 nem nagyobb BLUE 8-nal", tfc.compareTo(nc2) > 0);
		assertTrue("+4 nem nagyobb RED 3-nal", tfc.compareTo(nc3) > 0);
		assertTrue("+4 nem nagyobb jokernal", tfc.compareTo(wc) > 0);
		tfc.chooseColor(Color.GREEN);
		assertEquals("+4 toString()-je nem jo", "+4 (GREEN)", tfc.toString());
		points += p;
	*/}

	private static void testGetAllCards(int p) {/*
		LinkedList<Card> allCards = Game.getAllCards();
		for (Card card : Arrays.asList(nc1, nc2, nc3)) {
			assertTrue("A " + card + " kartya nincs a pakliban",
					allCards.stream().anyMatch(c -> c.compareTo(card) == 0));
		}
		points += 2;
		for (Card card : Arrays.asList(ttc1, ttc2, sc1, sc2, rc1, rc2, wc, tfc)) {
			assertTrue("A " + card + " kartya nincs a pakliban",
					allCards.stream().anyMatch(c -> c.compareTo(card) == 0));
		}
		points += p - 2;
	*/}

	/*
	 * Ezek a segédfüggvények a teszteléshez használatosak. Ezeket ne kommentezd
	 * ki. Mindegyik valamilyen tulajdonságot ellenőriz és kivételt vált ki, ha
	 * nem teljesül az adott tulajdonság.
	 */

	private static void assertTrue(String msg, boolean p) {
		if (!p) {
			throw new RuntimeException(msg);
		}
	}

	private static void assertEquals(String msg, Object expected, Object actual) {
		if (expected == null && actual == null) {
			return;
		}
		if (expected == null || !expected.equals(actual)) {
			throw new RuntimeException(msg + ", expected: " + expected + ", actual: " + actual);
		}
	}

}

