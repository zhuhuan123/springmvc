package stdemo;

import org.junit.Test;
class P{
	 int i=0;
	public void f() {
		System.out.println("f---A");
	}
}
class S extends P{
	 int i=1;
	public void f() {
		System.out.println("f---B");
	}
}
public class Ts {
	@Test
	public void t() {
		P p = new S();
		System.out.println(p.i);
		p.f();
//		String s = "abcd";
//		int f=1,s=1;
//		for(int i=2;i<6;i++) {
//			int te = f+s;
//			f =s;
//			s = te;
//		}
//		System.out.println(s);
		
//		String s="";
		
	}
	
	@Test
	public void tes() {
		
	}
}
