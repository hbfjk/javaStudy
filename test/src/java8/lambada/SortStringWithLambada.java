package java8.lambada;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortStringWithLambada {
	
	public static void main(String... strings ) {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names, (a, b) -> { return b.compareTo(a); });
		System.out.println(names.toString());
	}
	
}
