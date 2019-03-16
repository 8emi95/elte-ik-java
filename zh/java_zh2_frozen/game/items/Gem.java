package game.items;

import game.utils.Colour;

public class Gem implements Comparable<Gem> {
	private String name;
	private Colour colour;
	private int value;

	public Gem(String name, Colour colour, int value) {
		this.name = name;
		this.colour = colour;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Colour getColour() {
		return colour;
	}

	public int getValue() {
		return value;
	}

	@Override public String toString() {
		return "The " + this.getColour() + " " + this.getName() + " is worth " + this.getValue() + " ducats."; 

/*
		StringBuilder sb = new StringBuilder();
		sb.append("The ");
		sb.append(colour.toString());
		sb.append(" ");
		sb.append(name);
		sb.append(" is worth ");
		sb.append(value);
		sb.append(" ducats.");
		return sb.toString();
*/
	}

	@Override public boolean equals(Object gem) { // Object o
		if (this.getName().equals(((Gem)gem).getName()) && 
			this.getColour().equals(((Gem)gem).getColour()) && 
			this.getValue() == ((Gem)gem).getValue()) {
				return true;
			}
		return false;

/*
		if (o == this) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (o.getClass() != this.getClass()) {
			return false;
		}
		else {
			Gem that = (Gem) o;
			return (that.getName().equals(this.getName()) &&
					that.getColour().equals(this.getColour()) &&
					that.getValue() == this.getValue());
		}
*/
	}

	@Override public int hashCode() {
		return this.getName().hashCode() + this.getColour().hashCode() + this.getValue() * 1000;
	}

	public int compareTo(Gem gem) {
		if (this.getName().equals(gem.getName())) {
			if (this.getColour().equals(gem.getColour())) {
				return Integer.compare(this.getValue(), gem.getValue());
			} else {
				return this.getColour().compareTo(gem.getColour());
			}
		} else {
			return this.getName().compareTo(gem.getName());
		}

/*
		int nameDif = name.compareTo(g.name);
		int colourDif = colour.compareTo(g.colour);
		if (nameDif != 0) {
			return nameDif;
		}
		if (colourDif != 0) {
			return colourDif;
		}
		if (this.value < g.value) {
			return -1;
		}
		else {
			if (this.value == g.value) {
				return 0;
			}
			else {
				return 1;
			}
		}
*/
	}
}