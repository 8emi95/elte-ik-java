package game.arendelle;

public class SnowStorm extends Kingdom {
	@Override public String toString() {
		return "A winter storm will move across the region. You had better avoid it.";
	}

	public boolean isReachable() {
		return Math.random() > 10;
	}
}