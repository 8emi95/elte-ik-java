import static org.junit.Assert.*;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;

public class FibonacchiTest {
	@Test
	public void testIterative() {
    assertEquals(0, Fibonacchi.iterative(0));
    assertEquals(1, Fibonacchi.iterative(1));
		assertEquals(1, Fibonacchi.iterative(2));
		assertEquals(2, Fibonacchi.iterative(3));
		assertEquals(3, Fibonacchi.iterative(4));
				
    assertEquals(1836311903, Fibonacchi.iterative(46));
    assertEquals(2971215073L, Fibonacchi.iterative(47));
    assertEquals(-1, Fibonacchi.iterative(100)); // 

    // assertEquals(354224848179261915075, Fibonacchi.iterative(100));
    // assertEquals(new BigInteger("354224848179261915075"), Fibonacchi.iterative(100));
	}
	

	@Test(timeout = 100) // fib 100 will not finish in 100 ms
	public void testRecursive() {

    assertEquals(0, Fibonacchi.recursive(0));
    assertEquals(1, Fibonacchi.recursive(1));
		assertEquals(1, Fibonacchi.recursive(2));
		assertEquals(2, Fibonacchi.recursive(3));
		assertEquals(3, Fibonacchi.recursive(4));
				
    assertEquals(1836311903, Fibonacchi.recursive(46));
    assertEquals(2971215073L, Fibonacchi.recursive(47));
    assertEquals(-1, Fibonacchi.recursive(100));

    // assertEquals(354224848179261915075, Fibonacchi.recursive(100));
    // assertEquals(new BigInteger("354224848179261915075"), Fibonacchi.recursive(100));
	}

	
}
