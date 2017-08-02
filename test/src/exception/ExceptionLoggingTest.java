package exception;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

import Utils.Printer;

public class ExceptionLoggingTest {
	
	private final static String clazz = ExceptionLoggingTest.class.getName();
	private final static Logger logger = Logger.getLogger(clazz);

	public static void main(String[] args) {
		try {
			throwException();
		} catch (Exception e) {
			Printer.println(e.getMessage());
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			logger.log(Level.SEVERE, sw.toString());
		}
	}
	
	public static void throwException() throws MyException {
		try {
			Stack<String> stack = new Stack<String>();
			stack.pop();
		} catch (Exception e) {
			logger.logp(Level.SEVERE, clazz, "main", "stack empty:", e);
			throw new MyException("stack empty:",e);
		}
	}

}
