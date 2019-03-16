package utils;

import java.util.Arrays;
import java.util.Vector;

public class IntTree {
	
	private int data;
	private IntTree left;
	private IntTree right;

	public IntTree(int[] elements) {
		if ((elements != null) && (elements.length > 0)) {
			this.data = elements[0];
			for (int x : Arrays.copyOfRange(elements, 1, elements.length)) {
				insert(x);
			}
		}
	}

	public IntTree(int data) {
		this.data  = data;
		this.left  = null;
		this.right = null;
	}

	public void insert(int data) {
		if (data < this.data) {
			if (left != null) {
				left.insert(data);
			} else {
				left = new IntTree(data);
			}		
		} else {
			if (right != null) {
				right.insert(data);
			} else {
				right = new IntTree(data);
			}	
		}
	}

	public boolean contains(int data) {
		return (this.data == data) || ((left != null) && left.contains(data)) || ((right != null) && right.contains(data));
	}

	public Integer[] toArray() {
		Integer[] leftElements  = (left != null) ? left.toArray() : null;
		Integer[] rightElements = (right != null) ? right.toArray() : null;

		Vector<Integer> result = new Vector<Integer>();

		if (leftElements != null) {
			for (int x : leftElements) {
  				result.add(x);
			}
		}

		result.add(data);

		if (rightElements != null) {
			for (int x : rightElements) {
				result.add(x);
			}
		}
		return result.toArray(new Integer[0]);
	}

	public String toString() {
		return Arrays.toString(toArray());
	}

	public boolean equalsTo(IntTree other) {
		return (this.data == other.data) &&
			((left != null) ? left.equalsTo(other.left) : other.left == null) &&
			((right != null) ? right.equalsTo(other.right) : other.right == null);
	}
	
}