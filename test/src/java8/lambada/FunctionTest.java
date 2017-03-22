package java8.lambada;

import java.util.function.Function;

public class FunctionTest {

	public static void main(String[] args) {
		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);
		
		String a = backToString.apply("123");
		System.out.println(a);

	}

}
