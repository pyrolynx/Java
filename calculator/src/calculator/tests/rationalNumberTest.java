package calculator.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import calculator.DivisionByZeroException;
import calculator.datatypes.rational.RationalValue;

public class rationalNumberTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void addTest() {
		RationalValue first = new RationalValue(1, 3);
		RationalValue second = new RationalValue(4, 3);
		assertTrue(new RationalValue(5, 3).equals(first.add(second)));
		second = new RationalValue(5, 3);
		assertTrue(new RationalValue(2, 1).equals(first.add(second)));
		second = new RationalValue(-1, 3);
		assertTrue(new RationalValue(0, 1).equals(first.add(second)));
		second = new RationalValue(2, -3);
		assertTrue(new RationalValue(-1, 3).equals(first.add(second)));
	}
	
	@Test
	public void subTest() {
		RationalValue first = new RationalValue(4, 3);
		RationalValue second = new RationalValue(1, 3);
		assertTrue(new RationalValue(1, 1).equals(first.sub(second)));
		second = new RationalValue(5, 3);
		assertTrue(new RationalValue(-1, 3).equals(first.sub(second)));
		second = new RationalValue(4, 3);
		assertTrue(new RationalValue(0, 1).equals(first.sub(second)));
		second = new RationalValue(0, -1);
		assertTrue(new RationalValue(4, 3).equals(first.sub(second)));
	}
	
	@Test
	public void mulTest() {
		RationalValue first = new RationalValue(-4, 3);
		RationalValue second = new RationalValue(1, 6);
		assertTrue(new RationalValue(-2, 9).equals(first.mul(second)));
		second = new RationalValue(3, -8);
		assertTrue(new RationalValue(1, 2).equals(first.mul(second)));
		second = new RationalValue(0, 1);
		assertTrue(new RationalValue(0, 1).equals(first.mul(second)));
		second = new RationalValue(3, -4);
		assertTrue(new RationalValue(1, 1).equals(first.mul(second)));
	}
	
	@Test
	public void divTest() throws DivisionByZeroException {
		RationalValue first = new RationalValue(-4, 3);
		RationalValue second = new RationalValue(1, 3);
		assertTrue(new RationalValue(-4, 1).equals(first.div(second)));
		second = new RationalValue(3, -8);
		assertTrue(new RationalValue(32, 9).equals(first.div(second)));
		second = new RationalValue(1, 1);
		assertTrue(new RationalValue(-4, 3).equals(first.div(second)));
		second = new RationalValue(-4, 3);
		assertTrue(new RationalValue(1, 1).equals(second.div(first)));
		second  = new RationalValue(0, 1);
		try
		{
			second = new RationalValue(0, 1);
			RationalValue value = (RationalValue)first.div(second);
			assertTrue(false);
		}
		catch (DivisionByZeroException e)
		{
			assertTrue(true);
		}
	}
	
}
