package pattern;

import java.util.regex.Pattern;

public class PatternTest {

	public static void main(String[] args) {
		String s = "${IBM_SCMD}";
		//System.out.println(Pattern.compile(s)); //does not work
		System.out.println(Pattern.compile(Pattern.quote(s)));
	}

}
