package weightlifting;

import java.util.*;
import java.io.*;

public class Championship {
	LinkedList<WeightLifter> lifters = new LinkedList<>();
	
	public Championship(String filename) {
		try {
			Scanner sc = new Scanner(new File(filename));
			
			while (sc.hasNextLine()) {
				String[] parts = sc.nextLine().split(":");
				try {
				if (parts.length == 2) {
					WeightLifter wl = WeightLifter.make(parts[0], Integer.parseInt(parts[1]));
					if (wl != null) lifters.add(wl);
				}
				} catch (NumberFormatException ex) { }
			}
		} catch (FileNotFoundException ex) {}
	}
	
	public int numberOfWeightLifters() {
		return lifters.size();
	}
	
	public String show() {		
		String result = "";
		
		if (lifters.isEmpty()) return result;
		
		for (WeightLifter wl : lifters) {
			result = result + wl.show() + "\n";
		}
		
		return result.substring(0, result.length() - 1);
	}
	
	public LinkedList<WeightLifter> strongerThan(WeightLifter wl) {
		LinkedList<WeightLifter> result = new LinkedList<>();
		
		for (WeightLifter lifter : lifters) {
			if (lifter.strongerThan(wl)) result.add(lifter);
		}
		
		return result;
	}
	
	public double average() {
		double result = 0;
		
		if (lifters.isEmpty()) return -1;
		for (WeightLifter lifter : lifters) {
			result += lifter.getWeight();
		}
		
		return result / lifters.size();
	}
	
	public WeightLifter round() {
		if (lifters.isEmpty()) return null;
		
		WeightLifter weakest = lifters.get(0);
		
		for (WeightLifter lifter : lifters) {
			if (weakest.strongerThan(lifter)) weakest = lifter;
		}
		
		lifters.remove(weakest);
		return weakest;
	}
	
	public LinkedList<WeightLifter> championship() {
		LinkedList<WeightLifter> result = new LinkedList<>();
		
		while (!lifters.isEmpty()) {
			result.add(round());
		}
		
		return result;
	}
}
