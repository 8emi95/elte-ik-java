import java.lang.reflect.Modifier;

import battleShip.board.Index;
import battleShip.board.Response;
import battleShip.GameException;
import battleShip.board.Ship;
import battleShip.board.Board;
import battleShip.Player;
import battleShip.ManualPlayer;
import battleShip.AutomaticPlayer;

public class Test{

	private static int scores = 0;

	private static Index i1, i2, i3, i4, i5, i6;
        private static Ship s1, s2, s3, s4;
	private static Board board;

	public static void main(String[] args) {
	
		testIndex();
		testResponse();
		testGameException();
		testShip();
		testBoard();
		testPlayers();
		testGame();
	
		System.out.println(scores);
	
	}
	
	private static void testIndex() {
	
		i1 = new Index(3,4);
		i2 = new Index(3,4);
		i3 = new Index(1,8);
		i4 = new Index(3,2);
		i5 = new Index(3,5);
		i6 = new Index(5,1);
		
		assertEquals("Row of i1 (3,4) is not ok", 3, i1.getRow());
		assertEquals("Column of i1 (3,4) is not ok", 4, i1.getColumn());
		assertEquals("Row of i3 (1,8) is not ok", 1, i3.getRow());
		assertEquals("Column of i3 (1,8) is not ok", 8, i3.getColumn());
		
		testIndexHashCode();
		testIndexEquals();
		testIndexCompareTo();
		testIndexToString();
		testIndexIsNeighbour();
	
	}
	
	private static void testIndexHashCode() {
	
		assertTrue("hashCode of i1 (3,4) must equal hashCode of i2 (3,4).", i1.hashCode() == i2.hashCode());
		
		scores += 1;
	
	}
	
	private static void testIndexEquals() {
	
		assertTrue(".equals() for i1 and null is not ok (must be false).", !i1.equals(null));
		assertTrue(".equals() for i1 and object from other class is not ok (must be false).", !i1.equals(new Integer(42)));
		assertTrue(".equals() for i1 and i1 is not ok (must be true).", i1.equals(i1));
		assertTrue(".equals() for i1 and i2 is not ok (must be true).", i1.equals(i2));
		assertTrue(".equals() for i2 and i1 is not ok (must be true).", i2.equals(i1));
		assertTrue(".equals() for i1 and i3 is not ok (must be false).", !i1.equals(i3));
		assertTrue(".equals() for i3 and i4 is not ok (must be false).", !i3.equals(i4));
		assertTrue(".equals() for i6 and i5 is not ok (must be false).", !i6.equals(i5));
		
		scores += 1;
	
	}
	
	private static void testIndexCompareTo() {
	
		assertTrue("class Index does not implement interface Comparable<Index>.", i1 instanceof Comparable<?>);
		assertTrue(".compareTo() for i1 (3,4) and i1 (3,4) is not ok.", i1.compareTo(i1) == 0);
		assertTrue(".compareTo() for i1 (3,4) and i2 (3,4) is not ok.", i1.compareTo(i2) == 0);
		assertTrue(".compareTo() for i1 (3,4) and i2 (3,4) is not ok.", i2.compareTo(i1) == 0);
		assertTrue(".compareTo() for i1 (3,4) and i3 (1,8) is not ok.", i1.compareTo(i3) > 0);
		assertTrue(".compareTo() for i1 (3,4) and i4 (3,2) is not ok.", i4.compareTo(i1) < 0);
		assertTrue(".compareTo() for i1 (3,4) and i5 (3,5) is not ok.", i1.compareTo(i5) < 0);
		assertTrue(".compareTo() for i1 (3,4) and i6 (5,1) is not ok.", i6.compareTo(i1) > 0);
		
		scores += 1;
	
	}
	
	private static void testIndexToString() {
	
		assertEquals(".toString() for i1 (3,4) is not ok", "(3,4)", i1.toString());
		assertEquals(".toString() for i3 (1,8) is not ok", "(1,8)", i3.toString());
		
		scores += 1;
	
	}
	
	private static void testIndexIsNeighbour() {
	
		Index index1 = new Index(3,4);
		Index index2 = new Index(3,5);
		Index index3 = new Index(3,3);
		Index index4 = new Index(2,4);
		Index index5 = new Index(4,4);
		Index index6 = new Index(2,3);
		Index index7 = new Index(3,6);
		Index index8 = new Index(8,9);
		
		assertTrue("Index (3,4) is not neighbour of (3,4).", !index1.isNeighbour(index1));
		assertTrue("Index (3,4) should be neighbour of (3,5).", index1.isNeighbour(index2));
		assertTrue("Index (3,4) should be neighbour of (3,3).", index1.isNeighbour(index3));
		assertTrue("Index (3,4) should be neighbour of (2,4).", index1.isNeighbour(index4));
		assertTrue("Index (3,4) should be neighbour of (4,4).", index1.isNeighbour(index5));
		assertTrue("Index (3,4) is not neighbour of (2,3).", !index1.isNeighbour(index6));
		assertTrue("Index (2,3) is not neighbour of (3,4).", !index6.isNeighbour(index1));
		assertTrue("Index (3,4) is not neighbour of (3,6).", !index1.isNeighbour(index7));
		assertTrue("Index (3,6) is not neighbour of (3,4).", !index7.isNeighbour(index1));
		assertTrue("Index (3,4) is not neighbour of (8,9).", !index1.isNeighbour(index8));
		assertTrue("Index (8,9) is not neighbour of (3,4).", !index8.isNeighbour(index1));
		
		scores += 1;
	
	}
	
	private static void testResponse() {
	
		assertTrue("The responses are not in the right order.", Response.HIT.ordinal() == 0
			&& Response.SUNK.ordinal() == 1 && Response.MISS.ordinal() == 2);
		
		scores += 1;
	
	}
	
	private static void testGameException() {
	
		assertEquals("GameException is not ok", "test exception", (new GameException("test exception")).getMessage());
		
		scores += 1;
	
	}
	
	private static void testShip() {
	
		Index[] indexList1 = new Index[]{new Index(1,1), new Index(1,3)};
		Index[] indexList2 = new Index[]{new Index(1,1), new Index(1,3), new Index(1,2)};
		
		assertTrue("Ship of (1,1) and (1,3) indices is not connected.", !Ship.isConnected(indexList1));
		assertTrue("Ship of (1,1), (1,3) and (1,2) indices is connected.", Ship.isConnected(indexList2));
		assertTrue("Ship of (1,1) indices is connected.", Ship.isConnected(new Index[]{new Index(1,1)}));
		
		scores += 2;
		
		try {
			s1 = new Ship(new Index[0]);
			assertTrue("Constructor of Ship is not ok, because ship is empty.", false);
		} catch (GameException e) {
			assertEquals("GameException for Ship's constructor is not ok", "Ship is invalid.", e.getMessage());
		}
		
		try {
			s1 = new Ship(indexList1);
			assertTrue("Constructor of Ship is not ok, because ship of (1,1) and (1,3) indices is not connected.", false);
		} catch (GameException e) {
			assertEquals("GameException for Ship's constructor is not ok", "Ship is invalid.", e.getMessage());
		}
		
		try {
			s1 = new Ship(indexList2);
			s2 = new Ship(new Index[]{new Index(9,10), new Index(10,10), new Index(11,10)});
			s3 = new Ship(new Index[]{new Index(2,2), new Index(1,2)});
			s4 = new Ship(new Index[]{new Index(5,6), new Index(5,7), new Index(6,7)});
		} catch(GameException e) {
			assertTrue("Ship's constructor is not ok.", false);
		}
		
		scores += 2;
		
		testShipHasHit();
		testShipFire();
		testShipHasSunk();
		testShipIsInside();
		testShipIsOverlapped();
	
	}
	
	private static void testShipHasHit() {
	
		try {
			boolean b = s1.hasHit(new Index(1,5));
			assertTrue("hasHit of s1 is not ok (index (1,5) is not part of ship).", false);
		} catch (GameException e) {
			assertEquals("GameException for hasHit is not ok", "Index is invalid.", e.getMessage());
		}
		
		try {
			assertTrue("hasHit for (1,1) of s1 is not ok.", !s1.hasHit(new Index(1,1)));
			assertTrue("hasHit for (1,2) of s1 is not ok.", !s1.hasHit(new Index(1,2)));
			assertTrue("hasHit for (1,3) of s1 is not ok.", !s1.hasHit(new Index(1,3)));
		} catch(GameException e) {
			assertTrue("Ship's hasHit is not ok.", false);
		}
		
		scores += 1;
	
	}
	
	private static void testShipFire() {
	
		assertEquals("Fire to index (5,4) of s1 is not ok", Response.MISS, s1.fire(new Index(5,4)));
		assertEquals("Fire to index (1,1) of s1 is not ok", Response.HIT, s1.fire(new Index(1,1)));
		assertEquals("Fire again to index (1,1) of s1 is not ok", Response.HIT, s1.fire(new Index(1,1)));
		
		try {
			assertTrue("hasHit or fire of s1 is not ok.", s1.hasHit(new Index(1,1)));
			assertTrue("hasHit or fire of s1 is not ok.", !s1.hasHit(new Index(1,2)));
		} catch(GameException e) {
			assertTrue("Ship's hasHit is not ok.", false);
		}
		
		assertEquals("Fire to index (1,2) of s1 is not ok", Response.HIT, s1.fire(new Index(1,2)));
		
		try {
			assertTrue("hasHit or fire of s1 is not ok.", s1.hasHit(new Index(1,2)));
		} catch(GameException e) {
			assertTrue("Ship's hasHit is not ok.", false);
		}
		
		assertEquals("Fire to index (1,3) of s1 is not ok", Response.SUNK, s1.fire(new Index(1,3)));
		assertEquals("Fire again to index (1,3) of s1 is not ok", Response.SUNK, s1.fire(new Index(1,3)));
		
		scores += 3;
	
	}
	
	private static void testShipHasSunk() {
	
		assertTrue("hasSunk for s1 is not ok (ship has sunk).", s1.hasSunk());
		assertTrue("hasSunk for s2 is not ok (ship has not sunk).", !s2.hasSunk());
		
		s3.fire(new Index(2,2));
		assertTrue("hasSunk for s3 is not ok (ship has not sunk).", !s3.hasSunk());
		s3.fire(new Index(1,2));
		assertTrue("hasSunk for s3 is not ok (ship has sunk).", s3.hasSunk());
		
		scores += 1;

	}
	
	private static void testShipIsInside() {
	
		assertTrue("isInside for s1 is not ok.", s1.isInside(1,1,5,5));
		assertTrue("isInside for s2 is not ok.", !s2.isInside(1,1,10,10));
		assertTrue("isInside for s3 is not ok.", !s3.isInside(2,2,5,5));
		assertTrue("isInside for s4 is not ok.", !s4.isInside(1,2,6,4));
		
		scores += 1;
	
	}
	
	private static void testShipIsOverlapped() {
	
		assertTrue("isOverlapped for s1 and s3 is not ok (must be true).", s1.isOverlapped(s3));
		assertTrue("isOverlapped for s1 and s2 is not ok (must be false).", !s1.isOverlapped(s2));
		assertTrue("isOverlapped for s1 and s4 is not ok (must be false).", !s1.isOverlapped(s4));
		
		scores += 2;
	
	}
	
	private static void testBoard() {
	
		board = new Board(10,10);
		
		scores += 1;
		
		testBoardIsPlaceable();
		testBoardAddShip();
		testBoardFire();
		testBoardAllSunk();
	
	}
	
	private static void testBoardIsPlaceable() {
	
		assertTrue("isPlaceable for s1 is not ok (must be true).", board.isPlaceable(s1));
		assertTrue("isPlaceable for s2 is not ok (must be false).", !board.isPlaceable(s2));
		assertTrue("isPlaceable for s3 is not ok (must be true).", board.isPlaceable(s3));
		assertTrue("isPlaceable for s4 is not ok (must be true).", board.isPlaceable(s4));
		
		scores += 2;
	
	}
	
	private static void testBoardAddShip() {
	
		try {
			board.addShip(new Ship(new Index[]{new Index(1,1), new Index(1,3), new Index(1,2)}));
		} catch(GameException e) {
			assertTrue("Board's addShip for s1 is not ok.", false);
		}
		
		try {
			board.addShip(s2);
			assertTrue("addShip for s2 is not ok.", false);
		} catch (GameException e) {
			assertEquals("GameException for addShip is not ok", "Not all ships could be placed on the board.", e.getMessage());
		}
		
		try {
			board.addShip(s3);
			assertTrue("addShip for s3 is not ok.", false);
		} catch (GameException e) {
			assertEquals("GameException for addShip is not ok", "Not all ships could be placed on the board.", e.getMessage());
		}
		
		try {
			board.addShip(new Ship(new Index[]{new Index(5,6), new Index(5,7), new Index(6,7)}));
		} catch(GameException e) {
			assertTrue("Board's addShip for s4 is not ok.", false);
		}
		
		scores += 1;
	
	}
	
	private static void testBoardFire() {
	
		assertEquals("Fire to index (2,2) is not ok", Response.MISS, board.fire(new Index(2,2)));
		assertEquals("Fire to index (1,1) is not ok", Response.HIT, board.fire(new Index(1,1)));
		assertEquals("Fire to index (1,2) is not ok", Response.HIT, board.fire(new Index(1,2)));
		assertEquals("Fire to index (1,3) is not ok", Response.SUNK, board.fire(new Index(1,3)));
		
		scores += 3;
	
	}
	
	private static void testBoardAllSunk() {
	
		assertTrue("hasSunk for board is not ok (only s1 has sunk).", !board.allSunk());
		
		assertEquals("Fire to index (5,6) is not ok", Response.HIT, board.fire(new Index(5,6)));
		assertEquals("Fire to index (5,7) is not ok", Response.HIT, board.fire(new Index(5,7)));
		assertEquals("Fire to index (6,7) is not ok", Response.SUNK, board.fire(new Index(6,7)));
		
		assertTrue("hasSunk for board is not ok (all ships have sunk).", board.allSunk());
		
		scores += 1;
	
	}
	
	static class DummyPlayer extends ManualPlayer {
		public DummyPlayer() {
			super(Test.board, "dummy");
		}
		public Index makeIndex() {
			return new Index(1, 1);
		}
	}
	
	private static void testPlayers() {
	
		assertTrue("The Player class is not abstract.", Modifier.isAbstract(Player.class.getModifiers()));
		
		DummyPlayer p = new DummyPlayer();
		assertTrue("Player's fire is not ok.", p.fire());
		
		scores += 2;
		
		ManualPlayer mp = new ManualPlayer(board, "Test");
		
		scores += 1;
		
		AutomaticPlayer ap = new AutomaticPlayer(board);
		assertTrue("AutomaticPlayer is not ok.", ap.fire());
		
		scores += 1;
	
	}
	
	private static void testGame() {
	
		testGameReadBoard();
		testGameConstructor();
		testGamePlay();
	
	}
	
	private static void testGameReadBoard() {
	
		Board board1 = Game.readBoard("board1.txt");
		
		assertEquals("Fire to index (1,4) is not ok", Response.MISS, board1.fire(new Index(1,4)));
		assertEquals("Fire to index (1,1) is not ok", Response.HIT, board1.fire(new Index(1,1)));
		assertEquals("Fire to index (1,2) is not ok", Response.HIT, board1.fire(new Index(1,2)));
		assertEquals("Fire to index (1,3) is not ok", Response.SUNK, board1.fire(new Index(1,3)));
		
		scores += 3;
	
	}
	
	static class DummyGame extends Game {
		public DummyGame() {
			super("Teszt1", "Teszt2");
		}
		public void test() {
			Board board1 = player1.getBoard();
			assertEquals("Fire to index (1,4) is not ok", Response.MISS, board1.fire(new Index(1,4)));
			assertEquals("Fire to index (1,1) is not ok", Response.HIT, board1.fire(new Index(1,1)));
			assertEquals("Fire to index (1,2) is not ok", Response.HIT, board1.fire(new Index(1,2)));
			assertEquals("Fire to index (1,3) is not ok", Response.SUNK, board1.fire(new Index(1,3)));
			Board board2 = player2.getBoard();
			assertEquals("Fire to index (1,1) is not ok", Response.MISS, board2.fire(new Index(1,1)));
			assertEquals("Fire to index (2,2) is not ok", Response.HIT, board2.fire(new Index(2,2)));
			assertEquals("Fire to index (2,3) is not ok", Response.HIT, board2.fire(new Index(2,3)));
			assertEquals("Fire to index (3,2) is not ok", Response.SUNK, board2.fire(new Index(3,2)));
		}
		public void test2() {
			try {
				Board b1 = new Board(2,2);
				b1.addShip(new Ship(new Index[]{new Index(1,1)}));
				player1 = new AutomaticPlayer(b1);
				Board b2 = new Board(2,2);
				b2.addShip(new Ship(new Index[]{new Index(2,2)}));
				player2 = new AutomaticPlayer(b2);
				play();
			} catch(GameException e) {
				assertTrue("play is not ok.", false);
			}
		}
	}
	
	private static void testGameConstructor() {

		DummyGame dg = new DummyGame();
		dg.test();
		
		scores += 1;
	
	}
	
	private static void testGamePlay() {
	
		DummyGame dg = new DummyGame();
		dg.test2();
		
		scores += 1;
	
	}
	
	/*
	 * Ezek a segedfuggvenyek a teszteléshez hasznalatosak. Ezeket nem szabad
	 * kikommentezni. Mindegyik valamilyen tulajdonságot ellenoriz es kivételt valt ki, ha
	 * nem teljesul az adott tulajdonsag.
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
			throw new RuntimeException(msg + ", expected: " + expected
					+ ", actual: " + actual);
		}
	}
	
}

