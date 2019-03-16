import utils.IntTree;

import java.util.Arrays;
// https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html

public class IntTreeTest {
  public static void main(String[] args){
    int[] keys = {5,6,7,1,2,3,8,9,10,4};
    IntTree mytree = new IntTree(keys);

    int[] preorder = mytree.preorder();
    System.out.println(mytree);
    System.out.println(preorder);
    System.out.println(Arrays.toString(preorder));
    System.out.println(IntTree.arrayToString(preorder));

  }
}
