package stdemo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesJunit {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void t() {
		String object = "string";
		assertNotNull(object);
		
		assertEquals(12, 12);
	}

}
