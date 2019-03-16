import util.IntVector;

class Calculator {
    public static void main(String[] args) {
	String[] nums = args[0].split(","); // nums -> "1" "2" "3"
	int[] nums2 = new int[nums.length];
	for (int i = 0; i < nums.length; i++)
	    nums2[i] = Integer.parseInt(nums[i]);
	                                               // nums2 -> 1 2 3
	int n = Integer.parseInt(args[1]);
	IntVector v = new IntVector(nums2);
	v.add(n);
	System.out.println(v);
    }
}
