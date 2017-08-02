package java8.interface_;

/**
 * 1.8开始，接口中可以定义默认方法和静态方法
 * @author fangjk
 *
 */
public class MyTest {

	public static void main(String[] args) {
		
		Test1.run2();//接口中定义的静态方法直接调用
		Test2.run2();
		
		Test test = new Test();
		test.show();
		test.run1();

	}

}

class Test implements Test1,Test2{
	@Override
	public void show(){
		Test2.super.run1();
	}

	@Override
	public void run1() {		
		Test1.super.run1();
	}
	
}


interface Test1{
	void show();
	default void run1(){
		System.out.println("test1 run1.... ");
	}
	static void run2(){
		System.out.println("test1 run2.....");
	}
}

interface Test2{
	void show();
	default void run1(){
		System.out.println("test2 run1.... ");
	}
	static void run2(){
		System.out.println("test2 run2.....");
	}
}
