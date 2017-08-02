package resourcebundle;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DefaultResourceBundleTest {

	public static void main(String[] args) {
		try {
			Locale locale = Locale.getDefault();
			ResourceBundle resourceBundle = ResourceBundle.getBundle("resourcebundle.ConfigPIINonMessages.nlsprops", locale);
			System.out.println(resourceBundle);
		} catch(MissingResourceException mre) {
			mre.printStackTrace();
		}
	}

}
