package Graph.test;

import static org.junit.Assert.*;
import Graph.task.User;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	private User user;
	
	@Before
	public void setUp() throws Exception {
		user = new User("Ivanov");
	}

	@Test
	public void equalsTest() {
		assertTrue(user.equals(user));
		assertTrue(user.equals(new User("Ivanov")));
		assertFalse(user.equals(new User("Petrov")));
	}
	
	@Test
	public void toStringTest() {
		assertEquals(user.toString(), "Ivanov");
		assertNotEquals(user.toString(), "ivanov");
	}

}
