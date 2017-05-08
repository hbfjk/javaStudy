package Utils;

public class Printer {
	
	public static void print(int[] array) {
		for(int t : array) {
			System.out.print(" " + t);
		}
		System.out.println();
	}

	public static void print(String s) {
		System.out.println(s);
	}
	
	public static void println(String s) {
		System.out.println(s);
	}

}
