package this_test;

public class ParentClass {
	
	private String string = "parentString";
	
	protected ParentClass() {
		System.out.println("Parent constructor");
	}
	
	protected ParentClass(String another) {
		System.out.println("Parent another constructor");
	}
	private void print() {
		System.out.println("this is parent!");
	}

}
