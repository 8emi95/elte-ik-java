package game.utils;

public enum Colour {
	COLOURLESS, YELLOW, BROWN, GREY, BLUE, RED, PINK, GREEN, PURPLE;

	@Override public String toString() {
		return this.name().toLowerCase();
/*
		switch(this) {
			case COLOURLESS: return "colourless";
			case YELLOW: return "yellow";
			case BROWN: return "brown";
			case GREY: return "grey";
			case BLUE: return "blue";
			case RED: return "red";
			case PINK: return "pink";
			case GREEN: return "green";
			default: return "purple";
*/
	}
}