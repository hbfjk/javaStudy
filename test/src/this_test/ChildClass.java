package this_test;

public class ChildClass extends ParentClass {
	
	private String string = "childString";
	
	private ChildClass() {
		this("another");
		System.out.println("Child construtor");
	}
	
	public ChildClass(String string2) {
		System.out.println("Child another construtor");
	}

	private void print() {
		System.out.println("this is child!");
	}
	
	private void printChildOrParent() {
		System.out.println(this.string);
		this.print();
	}

	public static void main(String[] args) {
		ChildClass child = new ChildClass();
		child.print();
		child.printChildOrParent();
	}

}
