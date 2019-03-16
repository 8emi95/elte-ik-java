package weightlifting;

public class WeightLifter {
	private String name;
	private int weight;
	static WeightLifter strongestWeightLifter = null;
	
	private WeightLifter(String name, int weight) {
		this.name = name;
		this.weight = weight;
		if (strongestWeightLifter == null) strongestWeightLifter = this;
		if (strongestWeightLifter.getWeight() < this.weight) strongestWeightLifter = this; 
	}
	
	public static WeightLifter make(String name, int weight) {
		if (name.length() >= 2 && name.matches("[ a-zA-Z]*") && weight <= 300 && weight > 0) {
			return new WeightLifter(name, weight);
		}
		return null;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public boolean strongerThan(WeightLifter wl) {
		return this.weight > wl.getWeight();
	}
	
	public String show() {
			if (weight >= 100) return name + " - " + weight + " kg";
			if (weight >= 10) return name + " -  " + weight + " kg";
			return name + " -   " + weight + " kg";
		}
	
	public static WeightLifter getStrongestWeightLifter() {
		return strongestWeightLifter;
	}
}
