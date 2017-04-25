package test;

import java.util.HashMap;

public class NumberOverflowTest {

	public static void main(String[] args) {

		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for(int i=0; i<100; i++) {
			map.put(i, "value"+i);
			map.put(i, "value"+i);
		}
		
		int a = -6352731;
		System.out.println(a % 10);
		
		int b = 1;
		for(int i=1; i< 35; i++) {
			b *= 2;
			System.out.println(i + ":" + b);
		}
		
		int c = 1;
		for(int j=1; j< 30; j++) {
			c *= 3;
			System.out.println(j + ":" + c);
		}

	}

}
