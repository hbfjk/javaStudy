package java8.lambada;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		Optional<String> optional = Optional.of("bpm");
		 
		optional.isPresent();           // true
		optional.get();                 // "bam"
		optional.orElse("fallback");    // "bam"
		 
		optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
	}

}
