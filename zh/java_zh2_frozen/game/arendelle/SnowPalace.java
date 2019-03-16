package game.arendelle;

public class SnowPalace extends Kingdom {
	@Override public String toString() {
		return "Welcome...to the Palace. Elsa is waiting for you. You have won the game.";
	}

	public boolean isReachable() {
		return true;
	}
}