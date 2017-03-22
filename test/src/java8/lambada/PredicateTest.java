package java8.lambada;

import java.util.Objects;
import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {
		String a = null;
		
		Predicate<String> nonNull = Objects::nonNull;
		
		System.out.println(nonNull.negate().test(a));
		
		Predicate<String> numberOnly = (from) -> {
			try {
				Integer.valueOf(from);
			} catch (NumberFormatException e) {
				return false;
			}
			return true;
		};
		
		Predicate<String> nonNullAndNumerOnly = nonNull.and(numberOnly);
		a="fdas";
		System.out.println(nonNullAndNumerOnly.test(a));
		a="1234";
		System.out.println(nonNullAndNumerOnly.test(a));
	}

}
