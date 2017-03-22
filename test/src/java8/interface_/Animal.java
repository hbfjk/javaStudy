/**
 * interface can have default method body.
 */
package java8.interface_;

public interface Animal {
	default String getName() {
		return "animal";
	};

}
