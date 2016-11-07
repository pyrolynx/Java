import static org.junit.Assert.*;

import org.junit.Test;

public class VectorTest {
	@Test
	public void EqualTest() {
		Vector v = new Vector(8, 4, 1);
		Vector w = new Vector(8, 4, 1);
		Vector u = new Vector(-8, -4, -1);
		assertTrue(v.areEqual(w));
		assertFalse(v.areEqual(u));
	}
	
	@Test
	public void LenTest() {
		Vector v = new Vector(8, 4, 1);
		assertEquals(v.len(), 9.0, 0.0001);
	}
	
	@Test
	public void CoordTest() {
		Vector v = new Vector(8, 4, 1);
		assertEquals(v.getX(), 8.0, 0.0001);
		assertEquals(v.getY(), 4.0, 0.0001);
		assertEquals(v.getZ(), 1.0, 0.0001);
	}
	
	@Test
	public void ScalarTest() {
		Vector v = new Vector(2, 3, 1);
		Vector w = new Vector(-3, 2, 0);
		Vector u = new Vector(-1, 2, 1);
		assertEquals(v.scalar(w), 0.0, 0.0001);
		assertEquals(v.scalar(v), v.len()*v.len(), 0.0001);
		assertEquals(w.scalar(u), 7.0, 0.0001);
	}
	
	@Test
	public void MultTest() {
		Vector v = new Vector(2, 3, 1);
		assertTrue(v.multiply(2).areEqual(new Vector(4, 6, 2)));
		assertTrue(v.multiply(-1).areEqual(new Vector(-2, -3, -1)));
		assertTrue(v.multiply(1).areEqual(new Vector(2, 3, 1)));
	}
	
	@Test
	public void AddTest() {
		Vector v = new Vector(2, 3, 1);
		Vector w = new Vector(-3, 2, 0);
		assertTrue(v.add(v).areEqual(v.multiply(2)));
		assertTrue(v.add(w).areEqual(new Vector(-1, 5, 1)));
		assertTrue(v.add(v.multiply(-1)).areEqual(v.multiply(0)));
	}
	
	@Test
	public void SubTest() {
		Vector v = new Vector(2, 3, 1);
		Vector w = new Vector(-3, 2, 0);
		assertTrue(v.sub(v).areEqual(v.multiply(0)));
		assertTrue(v.sub(w).areEqual(new Vector(5, 1, 1)));
	}
	
	@Test
	public void CollinearTest() {
		Vector v = new Vector(0, 0, 0);
		Vector w = new Vector(1, 1, 1);
		Vector u = new Vector(4, 4, 4);
		assertTrue(u.sub(w).areCollinear(v));
//		assertFalse(v.areEqual(u));
	}
}
