import static org.junit.Assert.*;

import org.junit.Test;

public class SegmentTest {	
	@Test
	public void CoordTest() {
		Segment s = new Segment(new Vector(1,1,1), new Vector(3,4,5));
		assertTrue(s.getStart().areEqual(new Vector(1, 1, 1)));
		assertTrue(s.getEnd().areEqual(new Vector(3, 4, 5)));		
	}
	
	@Test
	public void LenTest() {
		Segment s = new Segment(new Vector(1,1,1), new Vector(9,5,2));
		Segment d = new Segment(new Vector(1,1,1), new Vector(1,1,1));
		assertEquals(s.len(), 9.0, 0.0001);
		assertEquals(d.len(), 0.0, 0.0001);
	}
	
	@Test
	public void DistanseTest() {
		Segment s = new Segment(new Vector(1,1,1), new Vector(4,4, 4));
		assertEquals(s.distanseTo(new Vector(0, 0, 0)), Math.sqrt(2), 0.0001);
	}
}
