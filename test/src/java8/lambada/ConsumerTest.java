package java8.lambada;

import java.util.function.Consumer;

import javax.script.ScriptEngineManager;

public class ConsumerTest {

	public static void main(String[] args) {
		Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
		greeter.accept(new Person("Luke", "Skywalker"));
		ScriptEngineManager engineManager = new ScriptEngineManager();
	}

}
