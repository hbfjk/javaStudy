package java8.lambada;

import java.util.function.Supplier;

public class SupplierTest {

	public static void main(String[] args) {
		Supplier<Person> personSupplier = Person::new;
		personSupplier.get();   // new Person
	}

}

class Person {
	
	public String firstName;

	public Person() {
		
	}

	public Person(String string, String string2) {
		this.firstName = string;
	}
	
}
