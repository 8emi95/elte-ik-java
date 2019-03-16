import utils.IntTree;

public class IntTreeTest {
    public static void main(String[] args) {
        IntTree v1 = new IntTree(new int[]{-1, 1});
        IntTree v2 = new IntTree(new int[]{-1, 1});

        System.out.println(v1 == v2); // false
        System.out.println(v1.equals(v2)); // true
        System.out.println(v1.toString().equals("Tree(0,Tree(1,null,null),Tree(-1,null,null)"));
    }

/*    @Test
    public void helloTest() {
        assertEquals(1, 2);
    }*/
}


/*
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import util.IntTree;

public class IntTreeTest {
  @Test
  public void helloTest() {
    IntTree v = new IntTree(new int[]{-1, 1});
    assertEquals(v.toString(), "Tree(0,Tree(1,null,null),Tree(-1,null,null))");
    assertEquals(1, 2);
  }

  @Test
  public void helloFailTest() {
    assertEquals(1, 2);
  }
}
*/