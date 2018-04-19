package exception;

public class RuntimeExceptionTest {

	public static void main(String[] args) {
		try{
			if(isThrowFirstException()) {
				throw new RuntimeException("first runtime exception");
			}
		} catch(Exception e) {
			throw new RuntimeException("second runtime exception");
		}
	}

	private static boolean isThrowFirstException() {
		return true;
	}

}
