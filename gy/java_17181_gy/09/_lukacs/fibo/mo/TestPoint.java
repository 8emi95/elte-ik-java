
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPoint {

	Point origo;
	
	@Before
	public void before() {
		origo = new Point(0,0);
	}
	
	@Test
	public void testTranslate() {
		Point translated = origo.translate(3, 2);
		assertEquals(new Point(3,2), translated);
	}

}
