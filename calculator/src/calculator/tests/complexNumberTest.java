package calculator.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import calculator.DivisionByZeroException;
import calculator.datatypes.complex.ComplexValue;

public class complexNumberTest {
	
	@Test
	public void equalsTest(){
		assertTrue(new ComplexValue(4, 2).equals(new ComplexValue(4, 2)));
		assertTrue(new ComplexValue(0, 0).equals(new ComplexValue(0, 0)));
		assertFalse(new ComplexValue(-4, 2).equals(new ComplexValue(2, -4)));
	}
	
	@Test
	public void addTest() {
		ComplexValue first = new ComplexValue(1, 3);
		ComplexValue second = new ComplexValue(4, 3);
		assertTrue(new ComplexValue(5, 6).equals(first.add(second)));
		second = new ComplexValue(-1, -3);
		assertTrue(new ComplexValue(0, 0).equals(first.add(second)));
		second = new ComplexValue(0, 0);
		assertTrue(new ComplexValue(1, 3).equals(first.add(second)));
	}
	
	@Test
	public void subTest() {
		ComplexValue first = new ComplexValue(4, 3);
		ComplexValue second = new ComplexValue(1, 3);
		assertTrue(new ComplexValue(3, 0).equals(first.sub(second)));
		second = new ComplexValue(4, 3);
		assertTrue(new ComplexValue(0, 0).equals(first.sub(second)));
		second = new ComplexValue(0, 0);
		assertTrue(new ComplexValue(4, 3).equals(first.sub(second)));
	}
	
	@Test
	public void mulTest() {
		ComplexValue first = new ComplexValue(-4, 3);
		ComplexValue second = new ComplexValue(1, 6);
		assertTrue(new ComplexValue(-22, -21).equals(first.mul(second)));
		second = new ComplexValue(0, 1);
		assertTrue(new ComplexValue(-3, -4).equals(first.mul(second)));
		second = new ComplexValue(0, 0);
		assertTrue(new ComplexValue(0, 0).equals(first.mul(second)));
		first = new ComplexValue(0, 1);
		second = new ComplexValue(0, 1);
		assertTrue(new ComplexValue(-1, 0).equals(first.mul(second)));
	}
	
	@Test
	public void divTest() throws DivisionByZeroException {
		ComplexValue first = new ComplexValue(-4, 3);
		ComplexValue second = new ComplexValue(1, 3);
		assertTrue(new ComplexValue(0.5, 1.5).equals(first.div(second)));
		second = new ComplexValue(2, 1);
		assertTrue(new ComplexValue(-1, 2).equals(first.div(second)));
		second = new ComplexValue(1, 0);
		assertTrue(new ComplexValue(-4, 3).equals(first.div(second)));
		second = new ComplexValue(0, 1);
		assertTrue(new ComplexValue(3, 4).equals(first.div(second)));
		try
		{
			second = new ComplexValue(0, 0);
			ComplexValue value = (ComplexValue)first.div(second);
			assertTrue(false);
		}
		catch (DivisionByZeroException e)
		{
			assertTrue(true);
		}
	}
	
}
