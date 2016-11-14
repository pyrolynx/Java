package Graph.test;

import Graph.entities.Edge;
import Graph.entities.Item;
import static org.junit.Assert.*;

import org.junit.Test;

public class EntitiesTest {

	@Test
	public void equalsItemTest() {
		Item<String> item = new Item<String>(null, "Ivan");
		assertTrue(item.equals(item));
		Item<String> sameItem = new Item<String>(null, "Ivan");
		assertTrue(item.equals(sameItem));
	}
	
	@Test
	public void equalsEdgeTest() {
		Item<String> foo = new Item<String>(null, "Ivan");
		Item<String> bar = new Item<String>(null, "Petr");
		Item<String> buz = new Item<String>(null, "Max");
		Edge<String> item = new Edge<String>(null, foo, bar);
		assertTrue(item.equals(item));
		Edge<String> sameItem = new Edge<String>(null, foo, bar);
		assertTrue(item.equals(sameItem));
		Edge<String> differentItem = new Edge<String>(null, foo, buz);
		assertFalse(item.equals(differentItem));
	}
	
	@Test
	public void includesEdgeTest() {
		Item<String> foo = new Item<String>(null, "Ivan");
		Item<String> bar = new Item<String>(null, "Petr");
		Item<String> buz = new Item<String>(null, "Max");
		assertTrue(new Edge<String>(null, foo, bar).includes(bar));
		assertTrue(new Edge<String>(null, foo, bar).includes(foo));
		assertFalse(new Edge<String>(null, foo, bar).includes(buz));
	}
	
	@Test
	public void getOppositeEdgeTest() {
		Item<String> foo = new Item<String>(null, "Ivan");
		Item<String> bar = new Item<String>(null, "Petr");
		Item<String> buz = new Item<String>(null, "Max");
		assertEquals(new Edge<String>(null, foo, bar).getOpposite(bar), foo);
		assertEquals(new Edge<String>(null, foo, bar).getOpposite(foo), bar);
		assertEquals(new Edge<String>(null, foo, bar).getOpposite(buz), null);
	}
	
	

}
