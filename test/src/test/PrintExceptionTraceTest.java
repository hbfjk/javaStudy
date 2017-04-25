package test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class PrintExceptionTraceTest {

	public static void main(String[] args) {
		try {
			String a = "a";
			Integer.parseInt(a);
		} catch(Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			System.out.println(sw.toString());
			
//			String str = new String();
//			e.printStackTrace(new PrintWriter(str));
//			System.out.println(str);
		}
		
		

	}

}
