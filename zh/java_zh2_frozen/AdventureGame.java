import java.util.Random;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import game.arendelle.*;
import game.items.Gem;
import game.utils.*;
import game.players.*;

public class AdventureGame {
	public static final int NUM_OF_TROLL_CAVES;
	public static final int NUM_OF_SNOW_STORMS;
	public static final int NUM_OF_CHALETS;
	public static final int MAX_NUM_OF_STEPS;

	private static ArrayList<Troll> trollList;
	private static ArrayList<Chalet> chalets;
	private static SnowPalace sp;
	private static ArrayList<Gem> pool;

	static {
		Random rnd = new Random();
		NUM_OF_TROLL_CAVES = 15 + rnd.nextInt(6);
		NUM_OF_SNOW_STORMS = 15 + rnd.nextInt(6);
		NUM_OF_CHALETS = (Position.MAX_X * Position.MAX_Y) - (NUM_OF_TROLL_CAVES + NUM_OF_SNOW_STORMS + 1);
		MAX_NUM_OF_STEPS = 50;

		trollList = new ArrayList<Troll>();
		chalets = new ArrayList<Chalet>();
		sp = new SnowPalace();
		pool = new ArrayList<Gem>();
	}

	private Map<Position, Kingdom> board = new TreeMap<Position, Kingdom>();

	public static Anna princess;
	public static int numOfSteps = 0;

	public AdventureGame() {
		if (Position.MAX_X * Position.MAX_Y != NUM_OF_TROLL_CAVES + NUM_OF_SNOW_STORMS + 1 + NUM_OF_CHALETS)
			throw new InappropriateBoardSizeException();

		for (int x = Position.MIN_X; x <= Position.MAX_X; ++x) {
			for (int y = Position.MIN_Y; y <= Position.MAX_Y; ++y) {
				Position curr = new Position(x, y);
				board.put(curr, null);
			}
		}
		buildKingdom();
	}

	public Map<Position, Kingdom> getKingdom() {
		return board;
	}

	public ArrayList<Gem> getPool() {
		return pool;
	}

	public ArrayList<Chalet> getChalets() {
		return chalets;
	}

	public ArrayList<Troll> getTrolls() {
		return trollList;
	}

	private ArrayList<Gem> initGemPool() {
		ArrayList<Gem> ret = new ArrayList<Gem>();

		ret.add(new Gem("diamond", Colour.COLOURLESS, 50));
		ret.add(new Gem("diamond", Colour.YELLOW, 45));
		ret.add(new Gem("diamond", Colour.BROWN, 40));
		ret.add(new Gem("diamond", Colour.GREY, 35));
		ret.add(new Gem("sapphire", Colour.BLUE, 30));
		ret.add(new Gem("ruby", Colour.RED, 10));
		ret.add(new Gem("ruby", Colour.PINK, 20));
		ret.add(new Gem("emerald", Colour.GREEN, 40));
		ret.add(new Gem("amethyst", Colour.PURPLE, 30));

		return ret;
	}

	private ArrayList<Chalet> initChalets() {
		ArrayList<Chalet> ret = new ArrayList<Chalet>(NUM_OF_CHALETS);

		for (int i=0;i<NUM_OF_CHALETS;i++) {
			int numGems = new Random().nextInt(8) + 1;
			ArrayList<Gem> gemList = new ArrayList<Gem>();
			ArrayList<Gem> gemPool = new ArrayList<Gem>(this.getPool());

			for (int n=0;n<numGems;n++) {
				gemList.add(gemPool.remove(new Random().nextInt(gemPool.size())));
			}
			Chalet curr = new Chalet(gemList);
			ret.add(curr);
		}
		return ret;
	}

	private void buildKingdom() {
		this.pool = initGemPool();
		this.chalets = initChalets();

		this.board.put(Position.INITIAL_POSITION, this.chalets.get(0));
		this.board.put(Position.WINNING_POSITION, sp);

		ArrayList<Position> posList = new ArrayList<Position>(Position.MAX_X * Position.MAX_Y);
		for (int x = Position.MIN_X; x <= Position.MAX_X; ++x) {
			for (int y = Position.MIN_Y; y <= Position.MAX_Y; ++y) {
				Position curr = new Position(x, y);

				if (curr.equals(Position.INITIAL_POSITION) || curr.equals(Position.WINNING_POSITION)) {
					continue;
				}

				posList.add(new Position(x, y));
			}
		}

		int numDoneSnowStorms = 0;
		int numDoneChalets = 1;
		int numDoneTrollCaves = 0;
		for (int i = posList.size() - 1; i >= 0; --i) {

			if (numDoneChalets < NUM_OF_CHALETS) {
				this.board.put(posList.get(i), this.chalets.get(numDoneChalets));
				posList.remove(i);
				++numDoneChalets;
			} else {
				if (numDoneSnowStorms < NUM_OF_SNOW_STORMS) {
					this.board.put(posList.get(i), new SnowStorm());
					posList.remove(i);
					++numDoneSnowStorms;
				} else {
					if (numDoneTrollCaves < NUM_OF_TROLL_CAVES) {
						this.board.put(posList.get(i), new TrollCave());
						posList.remove(i);
						++numDoneTrollCaves;
					} else {
						System.err.println("Can't generate any more... something happened. :D");
					}
				}
			}

			java.util.Collections.shuffle(posList);
		}

		initTrolls();
	}

	private void initTrolls() {
		int idx = 1;

		for (int x = Position.MIN_X; x <= Position.MAX_X; ++x) {
			for (int y = Position.MIN_Y; y <= Position.MAX_Y; ++y) {
				Position curr = new Position(x, y);
				if (this.board.get(curr) instanceof TrollCave) {
					Troll troll = new Troll(new ArrayList<Gem>(), curr, idx);
					trollList.add(troll);
					++idx;
				}
			}
		}
	}

	public void simulation() {
		this.princess = new Anna(new ArrayList<Gem>(), Position.INITIAL_POSITION);
		Position currentPos = this.princess.getPosition();

		while (!(currentPos.equals(Position.WINNING_POSITION)) && numOfSteps <= MAX_NUM_OF_STEPS) {
			currentPos = this.princess.getPosition();
			Kingdom currentTile = this.board.get(currentPos);

			if (currentTile.isReachable()) {
				if (currentTile instanceof Chalet) {
					Chalet cur = (Chalet)currentTile;
					int gemsToGet = cur.getGemList().size();
					ArrayList<Gem> gemsGot = cur.collectItems(gemsToGet);
					this.princess.getGemList().addAll(gemsGot);

				} else if (currentTile instanceof TrollCave) {
					Troll t = null;
					for (Troll tr : trollList) {
						if (tr.getPosition().equals(currentPos))
							t = tr;
					}

					this.princess.fight(t);
				} else if (currentTile instanceof SnowStorm && currentTile.isReachable()) {
					this.princess.fight();
				}
			}

			this.princess.move();
			currentPos = this.princess.getPosition();
			++numOfSteps;
		}

		if (numOfSteps > MAX_NUM_OF_STEPS) {
			// Kis csalás hogy ha túl sokat lépett Anna akkor semmiképp ne nyerje meg a játékot
			this.princess.setPosition(Position.INITIAL_POSITION);
		}
		System.out.println(this.princess.display()); // Így már itt biztosan a jól kiírja, hogy nem nyert.
	}
}