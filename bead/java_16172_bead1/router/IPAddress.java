package router;

import java.util.Arrays;

public class IPAddress {
	private int[] components;

	public IPAddress(int[] copy) {
		// components = Arrays.copyOf(copy, copy.length);

		components = new int[4];
		if (copy.length >= 4) {
			for (int i = 0; i < 4; ++i) {
				components[i] = copy[i];
			}
		} else if (copy.length < 4) {
			for (int i = 0; i < copy.length; ++i) {
				components[i] = copy[i];
			}
		}
		this.components = components.clone();
	}

	public static IPAddress fromString(String address) {
		String[] splitted = address.split("\\.");
		int[] ip = new int[4];
		if (splitted.length == 4) {
			for (int i = 0; i < ip.length; ++i) {
				ip[i] = Integer.parseInt(splitted[i]);
			}
			return new IPAddress(ip);
		} else {
			return null;
		}
	}

	public boolean isTheSame(IPAddress other) {
/*		if (this.equals(other)) { // konsi szivárogtat
			return true;
		} else {
			return false;
		}*/

		return Arrays.equals(this.components, other.components);
	}

	public boolean insideRng(IPAddress ip1, IPAddress ip2) {
		boolean left = false;
		boolean right = false;

		int i = 0;
		while (i < 4 && 
			   !left && 
			   ip1.components[i] <= components[i]) {
			if (ip1.components[i] < components[i]) {
				left = true;
			} else {
				i++;
			}
		}

		int j = 0;
		while (j < 4 && 
			   !right && 
			   ip2.components[j]>=components[j]) {
			if (ip2.components[j]>components[j]) {
				right=true;
			} else j++;
		}
		if ((i == 4 && j == 4) || 
			(i == 4 && right) || 
			(j == 4 && left) || 
			(left && right)) {
			return true;
		}
		return false;
	}

	public String toString() {
		return components[0] + "." + components[1] + "." + components[2] + "." + components[3];
	}
}