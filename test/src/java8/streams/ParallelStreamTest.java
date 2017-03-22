package java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ParallelStreamTest {

	public static void main(String[] args) {
		int max = 1000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
		    UUID uuid = UUID.randomUUID();
		    values.add(uuid.toString());
		}
		
		//sequential sort
		long t0 = System.nanoTime();
		long count = values.stream().sorted().count();
		System.out.println(count);
		long t1 = System.nanoTime();
		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("sequential sort took: %d ms", millis));
		
		//parallel sort
		long t0_p = System.nanoTime();
		long count_p = values.parallelStream().sorted().count();
		System.out.println(count_p);
		long t1_p = System.nanoTime();
		long millis_p = TimeUnit.NANOSECONDS.toMillis(t1_p - t0_p);
		System.out.println(String.format("parallel sort took: %d ms", millis_p));

	}

}
