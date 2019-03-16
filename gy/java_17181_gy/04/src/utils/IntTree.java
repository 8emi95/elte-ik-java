package utils;

public class IntTree {
    private IntTree left;
    private IntTree right;
    private int key;

    public boolean equals(IntTree o) {
        return o.key == key;
    }

    public IntTree(int keys) {
        this.key = key;
    }

    public IntTree(int[] keys) {
        for (int k : keys) {
            insert(k);
        }
    }

    private void insert(int key) {
        if (this.key < key) {
            if (left == null) {
                left = new IntTree(key);
            } else {
                left.insert(key);
            }
        } else {
            if (right == null) {
                right = new IntTree(key);
            } else {
                right.insert(key);
            }
        }
    }

    public String toString() {
        return "Tree(" + key + "," 
                       + left == null ? "null" : left.toString() + "," 
                       + right == null ? "null" : right.toString() + ")";
    }

    public static String displayArray(int[] arr) {
        return arr.toString();
    }
}