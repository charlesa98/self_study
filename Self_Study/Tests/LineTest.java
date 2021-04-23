
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ss.basics.part4.Line;

public class LineTest {
	
	@Test
	public void getSlope()
	{
		Line l = new Line(1.0, 1.0, 2.0, 2.0);				//x0, x1, y0, y1
		assertEquals(l.getSlope(), 1.0, .001);				//(2-1)/(2-1) = 1
		assertNotEquals(l.getSlope(), 9999.0, .001);
	}
	
	@Test
	public void getDistance() 
	{
		Line l = new Line(1.0, 1.0, 2.0, 2.0);
		assertEquals(l.getDistance(), 1.414, .001);			//sqr((2-1)*(2-1)+(2-1)*(2-1) = 1.414
		assertNotEquals(l.getDistance(), 9999.0, .001);
	}
	@Test
	public void parallelTo()
	{
		Line l1 = new Line(1.0, 1.0, 2.0, 2.0);				//slope is 1
		Line l2 = new Line(3.0, 3.0, 4.0, 4.0);				//slope is 1
		Line l3 = new Line(1.0, 3.0, 2.0, 5.0);				//slope is 3/2
		assertTrue(l1.parallelTo(l2));						//lines 1 and 2 should be parallel
		assertFalse(l1.parallelTo(l3));						//while line 1 and 3 should not because of the difference in slopes
	}
}