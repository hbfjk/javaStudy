package test;

public class Test {
	
	public static void main(String[] args) {
		"key099".hashCode();
		int r = 8 % 4;
		String key="key099";
		int h;
		System.out.println(key.hashCode());
		System.out.println("key099".hashCode()>>>16);
		int hash = (h = key.hashCode()) ^ (h >>> 16);
		System.out.println(15 & hash);
		System.out.println((h = key.hashCode()));
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
