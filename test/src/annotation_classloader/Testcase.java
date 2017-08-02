package annotation_classloader;

import Utils.Printer;

@TestcaseAnnotation(testcaseName="helloTestcase")
public class Testcase implements ITestcase {

	@Override
	public void sayHello() {
		Printer.print("Hello, testcase!");
	}

}
