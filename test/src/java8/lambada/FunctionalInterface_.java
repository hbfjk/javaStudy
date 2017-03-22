package java8.lambada;

@FunctionalInterface
public interface FunctionalInterface_<F, T> {
	T convert(F from);
	
	boolean equals(Object obj);
	
	public static void staticM() {
	}
	
	public static void main(String...strings) {
		//reference constructor
		MyIntegerFactory<?> factory = MyInteger::new;
		MyInteger mi = factory.createMyInterger();
		mi.testFuntionalInterface();
	}
}

class MyInteger {
	
	static String outterStaticStr = "4";
	String outterStr = "6";
	
	public static Integer valueOf(String from) {
		return Integer.valueOf(from) + 1;
	}
	
	Integer valueOf_nonStatic(String from) {
		return Integer.valueOf(from) + 2;
	}
	
	void testFuntionalInterface() {
		//reference static method
		FunctionalInterface_<String, Integer> converter = MyInteger::valueOf;
		Integer converted = converter.convert("456");
		System.out.println(converted);
		
		//reference non-static method
		converter = this::valueOf_nonStatic;
		converted = converter.convert("456");
		System.out.println(converted);
		
		//below local variable in an enclosing scope must be final or effectively final, that mean the value of a_ can not be changed.
		String a_ = "789";
		converter = (from) -> Integer.valueOf(from) + Integer.valueOf(a_+outterStr+outterStaticStr);
		converted = converter.convert("456");
		System.out.println(converted);
	}
}

interface MyIntegerFactory<MI extends MyInteger> {
	MI createMyInterger();
}
