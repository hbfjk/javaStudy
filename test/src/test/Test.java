package test;

public class Test {
	
	public static void main(String[] args) {
		int r = 8 % 4;
		System.out.println(r);
	}

//	public static void main(String[] args) {
//		StringBuffer a = new StringBuffer("A");
//		StringBuffer b = new StringBuffer("B");
//		operate(a,b);
//		System.out.println("a:" + a);
//		System.out.println("b:" + b);
//	}
	
	public static void operate(StringBuffer x, StringBuffer y) {
		x.append("C");
		y.append("C");
		y.append(x);
		y=x	;
		System.out.println("x:" + x);
		System.out.println("y:" + y);
	}

}
