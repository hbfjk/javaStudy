package java8.lambada;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortStringPriorJava8 {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				int result = o1.compareTo(o2);
				return result;
			}
			
		});
		System.out.println(names.toString());
	}

}
