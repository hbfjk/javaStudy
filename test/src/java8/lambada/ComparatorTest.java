package java8.lambada;

import java.util.Comparator;

public class ComparatorTest {

	public static void main(String[] args) {
		Comparator<Person> comparator = (p1, p2) -> {
			return p1.firstName.compareTo(p2.firstName);
		};
		 
		Person p1 = new Person("John", "Doe");
		Person p2 = new Person("Alice", "Wonderland");
		 
		System.out.println(comparator.compare(p1, p2));             // > 0
		System.out.println(comparator.reversed().compare(p1, p2));  // < 0

	}

}
