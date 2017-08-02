package test;

import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {

	public static void main(String[] args) {
		ConcurrentHashMap map = new ConcurrentHashMap();
		for(int i=0; i<1000; i++) {
			map.put(i, i);
		}

	}

}
