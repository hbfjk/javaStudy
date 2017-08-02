package annotation_classloader;

import Utils.Printer;

public class Annotation_ClassLoaderTest {
	
	private static ClassLoader cl = Annotation_ClassLoaderTest.class.getClassLoader();

	public static void main(String[] args) {
		try {
			ITestcase ts = (ITestcase) cl.loadClass("annotation_classloader.Testcase").newInstance();
			boolean isAnnotationExist = ts.getClass().isAnnotationPresent(TestcaseAnnotation.class);
			Printer.print(isAnnotationExist);
			isAnnotationExist = Testcase.class.isAnnotationPresent(TestcaseAnnotation.class);
			Printer.print(isAnnotationExist);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
