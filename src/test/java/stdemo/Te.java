package stdemo;

import static org.junit.Assert.*;

import org.junit.Test;

public class Te {

	@Test
	public void test() {
//		fail("Not yet implemented");
		byte [] b = "ס".getBytes();
		try {
			String s = new String(b,"utf-8");
			System.out.println(s);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
