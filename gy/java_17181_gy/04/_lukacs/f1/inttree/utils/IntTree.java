package utils;

import java.util.Arrays;
// import java.lang.StringBuilder;
// import java.lang.*;

public class IntTree {
  public static void main(String[] args){
    int[] keys = {5,6,7,1,2,3,8,9,10,4};
    IntTree mytree = new IntTree(keys);

    int[] preorder = mytree.preorder();
    System.out.println(mytree);
    System.out.println(preorder);
    System.out.println(Arrays.toString(preorder));
    System.out.println(arrayToString(preorder));

  }

  private int key;  /* = 0 */
  private IntTree left; /* = null */
  private IntTree right; /* = null */

  public IntTree(int key){this.key = key;}
  
  public IntTree(int[] keys){
    for(int k : keys){
      this.insert(k);
    }
  }

  public void insert(int newKey){
    // eml.: stackoverflow
    
    // csellengő else helyett inkább zárójelezzünk
    if(this.key < newKey) {
      if(left == null){  // referencia-szerinti összehasonlítás null-referenciával 

        // rekurzió alapesete
        left = new IntTree(newKey);
      } else { 
        // rekurzió általános eset
        left.insert(newKey);  
      }
    } else {
      if(right == null){
        right = new IntTree(newKey);
      } else
        right.insert(newKey);
    }
  }

  public String toString(){
    return "Tree{" + key + ","
                   + (left == null ? "null" : left.toString()) + ","
                   + (right == null ? "null" : right.toString()) + "}";
  }

  public boolean equals(IntTree other){
  // eml.: == primitív típusoknál értékszerinti összehasonlítás, referencia-típusoknál referencia-szerinti összehasonlítás

    if(other == null) return false;  // korai visszatérés
       
    boolean b1 = key == other.key;  
    boolean b2 = (left == null && other.left == null) 
                 ;
    boolean b3 = (right == null && other.right == null) 
                 || right.equals(other.right);

    return b1 && b2 && b3;
  }

  public static String arrayToString(int[] arr){
    // eml.: String immutábilis, ciklusban konkatenálás n^2 idejű
    // helyette: https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html

    // trükk: összehasonlítás drága, helyette értékadás
    StringBuilder s = new StringBuilder();
    String delim = "";
    for(int k : arr){
      s.append(delim + k);
      delim = ";";
    }

    return "[" + s.toString() + "]";
  }

  public int[] preorder(){
    int[] lpo = left == null ? new int[0] : left.preorder();
    int[] rpo = right == null ? new int[0] : right.preorder();

    int[] result = new int[1 + lpo.length + rpo.length];

    int i = 0;
    result[i] = this.key;
    for(int k : lpo){
      i += 1;
      result[i] = k;
    }
    
    for(int k : rpo){
      i += 1;
      result[i] = k;
    }

    return result;
  }

  
}
