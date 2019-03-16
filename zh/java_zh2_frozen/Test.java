import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import game.arendelle.Chalet;
import game.arendelle.Kingdom;
import game.arendelle.Reachable;
import game.arendelle.SnowPalace;
import game.arendelle.SnowStorm;
import game.arendelle.TrollCave;
import game.items.Gem;
import game.players.Anna;
import game.players.Player;
import game.players.Troll;
import game.utils.Colour;
import game.utils.Position;
public class Test{

	private static int scores = 0;
	private static Gem diamond, carbon;
	private static Gem sapphire, lapisLazuli;
	private static Gem ruby, rubyPink;
	private static Gem emerald;
	private static Gem amethyst;
	private static Position p1, p2, p3, p4, p5;
	private static AdventureGame aG = new AdventureGame();

	public static void main(String[] args) {
		
		testColour();
		testGem();
		testPosition();
		testArendelle();
		testPlayer();
		testAnna();
		testTroll();
		testAdventureGame();
		testInappropriateBoardSizeException();
		System.out.println(scores);
		
	}
	
	private static void testColour() {
		assertTrue("The colours are not in the right order.", Colour.COLOURLESS.ordinal() == 0
				&& Colour.YELLOW.ordinal() == 1 && Colour.BROWN.ordinal() == 2 && Colour.GREY.ordinal() == 3 && Colour.BLUE.ordinal() == 4 && Colour.RED.ordinal() == 5 && Colour.PINK.ordinal() == 6 && Colour.GREEN.ordinal() == 7 && Colour.PURPLE.ordinal() == 8);			
		scores += 1;
		testColourToString();	
	}
	
	private static void testColourToString(){
	
		assertEquals(".toString() for colourless is not ok", "colourless", Colour.COLOURLESS.toString());
		assertEquals(".toString() for yellow is not ok", "yellow", Colour.YELLOW.toString());
		assertEquals(".toString() for brown is not ok", "brown", Colour.BROWN.toString());assertEquals(".toString() for grey is ok", "grey", Colour.GREY.toString());assertEquals(".toString() for blue is not ok", "blue", Colour.BLUE.toString());
		assertEquals(".toString() for red is not ok", "red", Colour.RED.toString());
		assertEquals(".toString() for pink is not ok", "pink", Colour.PINK.toString());
		assertEquals(".toString() for green is ok", "green", Colour.GREEN.toString());
		assertEquals(".toString() for purple is not ok", "purple", Colour.PURPLE.toString());
		scores += 1;	
		
	}
	
	private static void testGem() {
		
		diamond = new Gem("diamond", Colour.COLOURLESS, 50);
		carbon = new Gem("diamond", Colour.COLOURLESS, 50);
	    sapphire = new Gem("sapphire", Colour.BLUE, 20);
		lapisLazuli = new Gem("sapphire", Colour.BLUE, 15);
	    ruby = new Gem("ruby", Colour.RED, 10);
		rubyPink = new Gem("ruby", Colour.PINK, 20);
        emerald = new Gem("emerald", Colour.GREEN, 40);
	    amethyst = new Gem("amethyst", Colour.PURPLE, 30);
		
		assertTrue("Parameters for diamond are not valid", diamond != null);
		assertTrue("Parameters for carbon are not valid", carbon != null);
		assertTrue("Parameters for sapphire are not valid", sapphire != null);
		assertTrue("Parameters for lapisLazuli are not valid", lapisLazuli != null);
		assertTrue("Parameters for ruby are not valid", ruby != null);
		assertTrue("Parameters for rubyPink are not valid", rubyPink != null);
		assertTrue("Parameters for emerald are not valid", emerald != null);
		assertTrue("Parameters for amethyst are not valid", amethyst != null);
		
		testGemGetName();
		testGemGetColour();
		testGemGetValue();
		testGemToString();
		testGemHashCode();
		testGemEquals();
		testGemComparable();
		
	}
	
	private static void testGemGetName(){
		
		assertEquals("getName() is not ok", "diamond", diamond.getName());
		assertEquals("getName() is not ok", "diamond", carbon.getName());
		assertEquals("getName() is not ok", "sapphire", sapphire.getName());
		assertEquals("getName() is not ok", "sapphire", lapisLazuli.getName());
		assertEquals("getName() is not ok", "ruby", ruby.getName());
		assertEquals("getName() is not ok", "ruby", rubyPink.getName());
		assertEquals("getName() is not ok", "emerald", emerald.getName());
		assertEquals("getName() is not ok", "amethyst", amethyst.getName());	
		
	}
	
	private static void testGemGetColour(){
		
		assertEquals("getColour() is not ok", Colour.COLOURLESS, diamond.getColour());
		assertEquals("getColour() is not ok", Colour.COLOURLESS, carbon.getColour());
		assertEquals("getColour() is not ok", Colour.BLUE, sapphire.getColour());
		assertEquals("getColour() is not ok", Colour.BLUE, lapisLazuli.getColour());
		assertEquals("getColour() is not ok", Colour.RED, ruby.getColour());
		assertEquals("getColour() is not ok", Colour.PINK, rubyPink.getColour());
		assertEquals("getColour() is not ok", Colour.GREEN, emerald.getColour());
		assertEquals("getColour() is not ok", Colour.PURPLE, amethyst.getColour());	
		
	}
	
	private static void testGemGetValue(){
		
		assertTrue("getValue() is not ok", diamond.getValue()==50);
		assertTrue("getValue() is not ok", carbon.getValue()==50);
		assertTrue("getValue() is not ok", sapphire.getValue()==20);
		assertTrue("getValue() is not ok", lapisLazuli.getValue()==15);
		assertTrue("getValue() is not ok", ruby.getValue()==10);
		assertTrue("getValue() is not ok", emerald.getValue()==40);
		assertTrue("getValue() is not ok", amethyst.getValue()==30);
		
	}
	
	private static void testGemToString(){
	
		assertEquals(".toString() for diamond is not ok", "The colourless diamond is worth 50 ducats.", diamond.toString());
		assertEquals(".toString() for carbon is not ok", "The colourless diamond is worth 50 ducats.", carbon.toString());	
		assertEquals(".toString() for sapphire is not ok", "The blue sapphire is worth 20 ducats.", sapphire.toString());
		assertEquals(".toString() for lapisLazuli is not ok", "The blue sapphire is worth 15 ducats.", lapisLazuli.toString());			
		assertEquals(".toString() for ruby is not ok", "The red ruby is worth 10 ducats.", ruby.toString());
		assertEquals(".toString() for rubyPink is not ok", "The pink ruby is worth 20 ducats.", rubyPink.toString());
		assertEquals(".toString() for emerald is not ok", "The green emerald is worth 40 ducats.", emerald.toString());
		assertEquals(".toString() for amethyst is not ok", "The purple amethyst is worth 30 ducats.", amethyst.toString());		
		
		scores += 1;	
		
	}
	
	private static void testGemEquals(){
	
		assertTrue(".equals() for diamond is not ok", diamond.equals(carbon));
		assertTrue(".equals() for carbon is not ok", carbon.equals(diamond));
		assertTrue(".equals() for sapphire is not ok", !sapphire.equals(lapisLazuli)); 	
		assertTrue(".equals() for lapisLazuli is not ok", !lapisLazuli.equals(sapphire));
		assertTrue(".equals() for ruby is not ok", !ruby.equals(rubyPink)); 	
		assertTrue(".equals() for rubyPink is not ok", !rubyPink.equals(ruby));
		assertTrue(".equals() for emerald is not ok", !emerald.equals(amethyst));
		assertTrue(".equals() for amethyst is not ok", !amethyst.equals(emerald));
		
		scores += 2;	
	}
	
	private static void testGemHashCode(){
		boolean b = (diamond.hashCode() == carbon.hashCode());
		assertTrue(".hashCode() for diamond is not ok", b);
		scores += 2;	
	}
	
	private static void testGemComparable(){
		assertTrue("class Gem does not implement interface Comparable<Gem>",
				diamond instanceof Comparable<?>);
		assertTrue(".compareTo() is not ok", diamond.compareTo(carbon) == 0);
		assertTrue(".compareTo() is not ok", sapphire.compareTo(ruby) > 0);
		assertTrue(".compareTo() is not ok", amethyst.compareTo(emerald) < 0);
		assertTrue(".compareTo() is not ok", sapphire.compareTo(lapisLazuli) > 0);
		assertTrue(".compareTo() is not ok", ruby.compareTo(rubyPink) < 0);
		
	    scores += 2;	
	}
	
	private static void testPosition() {
		
		p1 = new Position(1, 1);
		p2 = new Position(1, 2);
		p3 = new Position(2, 1);
		p4 = new Position(2, 2);
		p5 = new Position(3, 3);
		testPositionConstants();
		testPositionGetters();
		testPositionSetters();
		testPositionIsInside();
		testPositionNeighbours();
		testPositionToString();
		testPositionEquals();
		testPositionHashCode();
		testPositionComparable();
	}
	
	private static void testPositionConstants() {
		assertTrue("MIN_X != 1", Position.MIN_X == 1);
		assertTrue("MIN_Y != 1", Position.MIN_Y == 1);
		assertTrue("MAX_X != 8", Position.MAX_X == 8);
		assertTrue("MAX_Y != 8", Position.MAX_Y == 8);
		assertTrue("INITIAL_POSITION != (1, 1)", Position.INITIAL_POSITION.equals(new Position(1, 1)));
		Position p = Position.WINNING_POSITION;
		boolean b = ((!(p.getX()==1 && p.getY()==1)) && (1 <= p.getX()) && (p.getX() <=8) && (1 <= p.getY()) && (p.getY() <=8)); 
		assertTrue("WINNING_POSITION is not ok", b);
		scores += 1;
	}
	
	private static void testPositionGetters(){
		testGetX();
		testGetY();
	}
	
	private static void testGetX() {
		assertTrue(".getX() for p5 is not ok", p5.getX()==3);	
	}
	
	private static void testGetY() {
		assertTrue(".getY() for p5 is not ok", p5.getY()==3);	
	}
	
	private static void testPositionSetters(){
		testSetX();
		testSetY();
	}
	
	private static void testSetX() {
		p5.setX(7);
		assertTrue(".setX() for p5 is not ok", p5.getX()==7);	
	}
	
	private static void testSetY() {
		p5.setY(6);
		assertTrue(".setY() for p5 is not ok", p5.getY()==6);	
	}
	
	private static void testPositionIsInside() {
		assertTrue(".isInside() is not ok", p4.isInside());
		assertTrue(".isInside() is not ok", !new Position(9,9).isInside());
		scores += 1;
	}

	private static void testPositionNeighbours() {
		assertTrue("The neighbours of position (2,2) are: (1,2), (2,1), (2,3) and (3,2)",
				p4.neighbours().containsAll(Arrays.asList(new Position(1,2),new Position(2,1),new Position(2,3),new Position(3,2))));
		assertTrue("The neighbours of position (1,1) are: (1,2) and (2,1)", Position.INITIAL_POSITION.neighbours().containsAll(Arrays.asList(new Position(1,2),new Position(2,1))));
		assertTrue("The neighbours of position (2,1) are: (1,1), (2,2) and (3,1)",new Position(2,1).neighbours().containsAll(Arrays.asList(new Position(1,1),new Position(2,2),new Position(3,1)))); 
		assertTrue("Positions (1,2) and (3,2) are not neighbours of position (2,1)", !new Position(2,1).neighbours().removeAll(Arrays.asList(new Position(1,2), new Position(3,2))));
		scores += 2;
	}
	
	private static void testPositionToString() {
		
		assertEquals(".toString() for INITIAL_POSITION is not ok", "(1,1)", Position.INITIAL_POSITION.toString());
		assertEquals(".toString() for position (1,2) is not ok", "(1,2)", p2.toString());	
		scores += 1;	
		
	}
	
	private static void testPositionEquals(){
		
		assertTrue(".equals() for INITIAL_POSITION is not ok", Position.INITIAL_POSITION.equals(p1));
		assertTrue(".equals() for p1 is not ok", p1.equals(Position.INITIAL_POSITION));
		assertTrue(".equals() for p2 is not ok", !p2.equals(p3)); 	
		assertTrue(".equals() for p3 is not ok", !p3.equals(p2)); 	
		scores += 1;	
	}
	
	private static void testPositionHashCode() {
		
		boolean b = (Position.INITIAL_POSITION.hashCode()== p1.hashCode());
		assertTrue(".hashCode() for INITIAL_POSITION is not ok", b);
		scores += 1;

	}
	
	private static void testPositionComparable(){
		assertTrue("class Position does not implement interface Comparable<Position>",
				p1 instanceof Comparable<?>);
		assertTrue(".compareTo() is not ok for (1,1) == (1,1)", p1.compareTo(p1) == 0);
		assertTrue(".compareTo() is not ok for (1,1) < (1,2)", p1.compareTo(p2) < 0);
		assertTrue(".compareTo() is not ok for (2,1) < (2,2)", p3.compareTo(p4) < 0);
		assertTrue(".compareTo() is not ok for (1,2) > (1,1)", p2.compareTo(p1) > 0);
		assertTrue(".compareTo() is not ok for (2,2) > (2,1)", p4.compareTo(p3) > 0);
	    scores += 1;	
	}
	
	private static void testArendelle() {
		testKingdom();
		testSnowStorm();
		testChalet();
		testSnowPalace();
		testTrollCave();	
	}
	
	private static void testKingdom() {
		DummyKingdom kd = new DummyKingdom();
		assertTrue("Class Kingdom does not implement Reachable.", Reachable.class.isAssignableFrom(Kingdom.class));
		scores += 1;
		assertTrue("The class is not abstract.", Modifier.isAbstract(Kingdom.class.getModifiers()));
		assertEquals(".toString() for Kingdom is not ok", "Welcome...", kd.toString());
		scores += 1;
		assertEquals(".isReachable() for Kingdom is not ok", false, kd.isReachable());
	}
	
	private static void testSnowStorm() {
		SnowStorm ss = new SnowStorm();	
		assertTrue("Class Kingdom is not a superclass of SnowStorm.", SnowStorm.class.getSuperclass().equals(Kingdom.class));
		boolean b = ss.isReachable();
		if (b){
			assertEquals(".isReachable() for SnowStorm is not ok", true, b);
		} else {
			assertEquals(".isReachable() for SnowStorm is not ok", false, b);
		}
		scores += 1;	
		assertEquals(".toString() for SnowStorm is not ok", "A winter storm will move across the region. You had better avoid it.", ss.toString());
		scores += 1;	
	}
	
	private static void testTrollCave() {
		TrollCave tc = new TrollCave();	
		assertTrue("Class Kingdom is not a superclass of TrollCave.", TrollCave.class.getSuperclass().equals(Kingdom.class));
		assertEquals(".isReachable() for TrollCave is not ok", true, tc.isReachable());
		assertEquals(".toString() for TrollCave is not ok", "Trolls are giant wealth suckers. Steer clear of them.", tc.toString());
		scores += 1;	
	}
	
	private static void testChalet() {
		Chalet ch = new Chalet(new ArrayList<Gem>(Arrays.asList(diamond,sapphire,ruby)));
		assertTrue("Class Kingdom is not a superclass of Chalet.", Chalet.class.getSuperclass().equals(Kingdom.class));
		assertEquals(".isReachable() for Chalet is not ok", true, ch.isReachable());
		assertEquals(".getGemList() for Chalet is not ok", new ArrayList<Gem>(Arrays.asList(diamond,sapphire,ruby)), ch.getGemList());
		ch.setGemList(new ArrayList<Gem>(Arrays.asList(diamond,carbon,sapphire,ruby,amethyst)));
		assertEquals(".setGemList() for Chalet is not ok", new ArrayList<Gem>(Arrays.asList(diamond,carbon,sapphire,ruby,amethyst)), ch.getGemList());
		ch.collectItems(2);
		assertEquals(".collectItems() for Chalet is not ok", new ArrayList<Gem>(Arrays.asList(sapphire,ruby,amethyst)), ch.getGemList());
		ch.collectItems(4);
		assertEquals(".collectItems() for Chalet is not ok", new ArrayList<Gem>(Arrays.asList(sapphire,ruby,amethyst)), ch.getGemList());
		scores += 1;
		assertEquals(".toString() for Chalet is not ok", "Welcome...If you are lucky, you will come across some gems here for Elsa.", ch.toString());
		scores += 1;	
			
	}
	
	private static void testSnowPalace() {
		SnowPalace sp = new SnowPalace();	
		assertTrue("Class Kingdom is not a superclass of SnowPalace.", SnowPalace.class.getSuperclass().equals(Kingdom.class));
		assertEquals(".isReachable() for SnowPalace is not ok", true, sp.isReachable());
		assertEquals(".toString() for SnowPalace is not ok", "Welcome...to the Palace. Elsa is waiting for you. You have won the game.", sp.toString());
		scores += 1;	
	}

	private static void testPlayer() {
		DummyPlayer dPlayer= new DummyPlayer();
		assertTrue("The class is not abstract.", Modifier.isAbstract(Player.class.getModifiers()));
		assertEquals(".getGemList() for Player is not ok", new ArrayList<Gem>(), dPlayer.getGemList());
		assertEquals(".getPosition() for Player is not ok", new Position(1,1), dPlayer.getPosition());
		ArrayList<Gem> dPlayerGemList = new ArrayList<Gem>();
		dPlayerGemList.add(diamond);
		dPlayer.setGemList(dPlayerGemList);
		assertEquals(".setGemList() for Player is not ok", new ArrayList<Gem>(Arrays.asList(diamond)), dPlayer.getGemList());
		dPlayer.setPosition(new Position(1,2));
		assertEquals(".setPosition() for Player is not ok", new Position(1,2), dPlayer.getPosition());
		assertEquals(".display() for Player is not ok", "My achievements...", dPlayer.display());
		scores += 2;	
		
	}
	
	private static void testTroll(){
		Troll tr = new Troll(new ArrayList<Gem>(Arrays.asList(diamond,sapphire,carbon,lapisLazuli,ruby,rubyPink, amethyst)), new Position(2,2),3);
		assertTrue("Parameters for Troll are not valid", tr != null);
		assertTrue("Class Player is not a superclass of Troll.",  Troll.class.getSuperclass().equals(Player.class));
		assertEquals(".getName() for Troll is not ok", "Troll 3", tr.getName());
		scores += 1;
		assertEquals(".display() for Troll is not ok", "Hi. My name is " + tr.getName() + ". Nice to meet you, Anna.", tr.display());
		scores += 1; 
	}
	
	private static void testAnna(){
		Anna princess = new Anna(new ArrayList<Gem>(Arrays.asList(diamond,sapphire,carbon,lapisLazuli,ruby,rubyPink, amethyst)), new Position(2,2));
		assertTrue("Parameters for Anna are not valid", princess != null);
		assertTrue("Class Player is not a superclass of Anna.",  Anna.class.getSuperclass().equals(Player.class));
		assertEquals(".getName() for Anna is not ok", "Princess Anna", princess.getName());
		Position pos = princess.getPosition(); 
		princess.move();
		Position newPos = princess.getPosition(); 
		assertTrue(".move() for Anna is not ok", pos.neighbours().contains(newPos));
		scores += 2;
		Troll tr = new Troll(new ArrayList<Gem>(Arrays.asList(diamond,sapphire,carbon,lapisLazuli,ruby,rubyPink, amethyst)), princess.getPosition(),3);
		ArrayList<Gem> diff = new ArrayList<Gem>();
		diff = princess.getGemList();
		princess.fight(tr);
		ArrayList<Gem> tmp = new ArrayList<Gem>();
		tmp = princess.getGemList();
		diff.removeAll(tmp);
		assertTrue(".fight() for Anna is not ok", tr.getGemList().containsAll(diff));
		scores += 2;
		princess.setGemList((new ArrayList<Gem>(Arrays.asList(diamond,sapphire,carbon,lapisLazuli,ruby,rubyPink, amethyst))));
		princess.fight();
		assertTrue(".fight() for Anna is not ok", princess.getGemList().containsAll(Arrays.asList(diamond,sapphire,carbon,lapisLazuli,ruby,rubyPink)));
		princess.setGemList((new ArrayList<Gem>(Arrays.asList(diamond))));
		princess.fight();
		assertEquals(".fight() for Anna is not ok", new ArrayList<Gem>(), princess.getGemList());
		scores += 2;
		if (princess.getPosition().equals(Position.WINNING_POSITION)){
			assertEquals(".display() for Princess Anna is not ok", "I have won the game.", princess.display()); 
		} else {
			assertEquals(".display() for Princess Anna is not ok", "I have lost the game.", princess.display());
		}
		scores += 1; 
		
	}
	
	private static void testAdventureGame(){
		testAdventureGameConstants();
		assertTrue("Parameters for AdventureGame are valid", aG != null);
		scores += 2;
		testBuildKingdom();
		testInitTrolls();
		aG.simulation();
		testSimulation();
	}
	
	private static void testAdventureGameConstants() {
		
		assertTrue("NUM_OF_TROLL_CAVES is not ok", (AdventureGame.NUM_OF_TROLL_CAVES>=15 && AdventureGame.NUM_OF_TROLL_CAVES<=20));
		assertTrue("NUM_OF_SNOW_STORMS is not ok", (AdventureGame.NUM_OF_SNOW_STORMS>=15 && AdventureGame.NUM_OF_SNOW_STORMS<=20));
		assertTrue("NUM_OF_CHALETS is not ok", (AdventureGame.NUM_OF_CHALETS>=23 && AdventureGame.NUM_OF_CHALETS<=33));
		assertTrue("MAX_NUM_OF_STEPS != 50", AdventureGame.MAX_NUM_OF_STEPS == 50);
		
	}
	
	private static void testBuildKingdom(){
		testInitGemPool();
		testInitChalets();
		int numOfCaves = 0;
		int numOfStorms = 0;
		int numOfChalets = 0;
		int numOfPalace = 0;	
		for(Map.Entry<Position, Kingdom> boardEntry : aG.getKingdom().entrySet()){
			if (boardEntry.getValue().getClass().equals(Chalet.class)) {
				numOfChalets++;
			}	
			else if (boardEntry.getValue().getClass().equals(SnowStorm.class)) {
				numOfStorms++;
			}
			else if (boardEntry.getValue().getClass().equals(TrollCave.class)) {
				numOfCaves++;
			}
			else if (boardEntry.getValue().getClass().equals(SnowPalace.class)) {
				numOfPalace++;
			}
		}	
		assertEquals(".buildPlaces() for AdventureGame is not ok", AdventureGame.NUM_OF_TROLL_CAVES, numOfCaves);
		assertEquals(".buildPlaces() for AdventureGame is not ok", AdventureGame.NUM_OF_SNOW_STORMS, numOfStorms);
		assertEquals(".buildPlaces() for AdventureGame is not ok", AdventureGame.NUM_OF_CHALETS, numOfChalets);
		assertEquals(".buildPlaces() for AdventureGame is not ok", 1, numOfPalace);
		
		scores += 3;
	}
	
	private static void testInitGemPool(){
		ArrayList<Gem> expected = new ArrayList<Gem>((Arrays.asList(new Gem("diamond", Colour.COLOURLESS, 50), 
			new Gem("diamond", Colour.YELLOW, 45), new Gem("diamond", Colour.BROWN, 40), new Gem("diamond", Colour.GREY, 35), 
			new Gem("sapphire", Colour.BLUE, 30), new Gem("ruby", Colour.RED, 10), new Gem("ruby", Colour.PINK, 20), 
			new Gem("emerald", Colour.GREEN, 40), new Gem("amethyst", Colour.PURPLE, 30))));		
		assertTrue(".testInitGemPool() for AdventureGame is not ok", aG.getPool().containsAll(expected));
	}
	
	private static void testInitChalets(){
		assertTrue("Number of chalets is not ok", aG.getChalets().size() == AdventureGame.NUM_OF_CHALETS);
		ArrayList<Gem> pool = new ArrayList<Gem>((Arrays.asList(new Gem("diamond", Colour.COLOURLESS, 50), 
			new Gem("diamond", Colour.YELLOW, 45), new Gem("diamond", Colour.BROWN, 40), new Gem("diamond", Colour.GREY, 35), 
			new Gem("sapphire", Colour.BLUE, 30), new Gem("ruby", Colour.RED, 10), new Gem("ruby", Colour.PINK, 20), 
			new Gem("emerald", Colour.GREEN, 40), new Gem("amethyst", Colour.PURPLE, 30))));
		for (int k=0; k < aG.getChalets().size(); k++){
			assertTrue(".initChalets() for AdventureGame is not ok",pool.containsAll(aG.getChalets().get(k).getGemList()));
		}
	}
	
	private static void testInitTrolls() {
		assertTrue("Number of trolls is not ok", aG.getTrolls().size() == AdventureGame.NUM_OF_TROLL_CAVES);
		ArrayList<Position> trMap = new ArrayList<Position>();
		ArrayList<Position> trPos = new ArrayList<Position>();
		for(Map.Entry<Position, Kingdom> boardEntry : aG.getKingdom().entrySet()){
			if (boardEntry.getValue().getClass().equals(TrollCave.class)) {
				trMap.add(boardEntry.getKey());
			}
		}	
		for (int k=0; k < aG.getTrolls().size(); k++){
			trPos.add(aG.getTrolls().get(k).getPosition());
			aG.getTrolls().get(k).getName().equals("Troll "+k+1);
		}
		assertTrue(".initTrolls() for AdventureGame is not ok", trPos.containsAll(trMap));
		
	}
	
	private static void testSimulation(){
		boolean b = (AdventureGame.princess.getPosition().equals(Position.WINNING_POSITION) || AdventureGame.numOfSteps >= AdventureGame.MAX_NUM_OF_STEPS);
		assertTrue(".simulation() for AdventureGame is ok", b);
		scores += 3;
	}
	
	private static void testInappropriateBoardSizeException() {
		assertEquals("Text for NegativeBoardSizeException is not ok",
				"Inappropriate board size dimensions.",
				new InappropriateBoardSizeException().getMessage());
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
	
