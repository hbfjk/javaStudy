package java8.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		 
		for (int i = 0; i < 10; i++) {
		    map.putIfAbsent(i, "val" + i);
		}
		 
		map.forEach((id, val) -> System.out.println(id +":" + val));
		
		
		map.computeIfPresent(3, (num, val) -> val + num);
		map.get(3);             // val33
		 
		map.computeIfPresent(9, (num, val) -> null);
		map.containsKey(9);     // false
		 
		String v = map.get(23);
		map.computeIfAbsent(23, num -> "val" + num);
		map.containsKey(23);    // true
		 
		map.computeIfAbsent(3, num -> "bam");
		map.get(3);             // val33
		
		map.forEach((id, val) -> System.out.println(id +":" + val));

	}

}
