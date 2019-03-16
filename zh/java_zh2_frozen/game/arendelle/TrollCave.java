package game.arendelle;

public class TrollCave extends Kingdom {
	@Override public String toString() {
		return "Trolls are giant wealth suckers. Steer clear of them.";
	}

	public boolean isReachable() {
		return true;
	}
}