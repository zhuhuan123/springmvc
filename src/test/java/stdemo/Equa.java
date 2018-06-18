package stdemo;

import static org.junit.Assert.*;
import java.util.Objects;
import org.junit.Test;
import com.std.model.User;
import static org.junit.Assert.*;



public class Equa {

	@Test
	public void test() {
		String s1 ="abcd";
		String s2 ="abcd";
		assertEquals(s1, s2);
//		System.out.println(s1==s2); 
//		System.out.println("字符串相等 "+s1.equals(s2));
//		User u1 = null;
//		User u2 = null;
//		System.out.println(u1==u2);
////		System.out.println(u1.equals(u2));
//		System.out.println("两者相等  "+Objects.equals(u1, u2));
		
		assertEquals(1, MyUtil.g());
		
		String s3="";
		assertNotNull(s3);
		
		String s4=null;
		assertNotNull(s4);
	}

}
