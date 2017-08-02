package exception;

public class ExceptionTimeConsumingTest {
	
	private int counts;  

	public ExceptionTimeConsumingTest(int counts) {  
	    this.counts = counts;  
	}  

	public void newObject() {  
	    long l = System.nanoTime();  
	    for (int i = 0; i < counts; i++) {  
	        new Object();  
	    }  
	    System.out.println("建立基础对象：" + (System.nanoTime() - l));  
	}  

	public void newOverridObj() {  
	    long l = System.nanoTime();  
	    for (int i = 0; i < counts; i++) {  
	        new Child();  
	    }  
	    System.out.println("建立继承对象：" + (System.nanoTime() - l));  
	} 

	public void newException() {  
	    long l = System.nanoTime();  
	    for (int i = 0; i < counts; i++) {  
	        new Exception();
	    }  
	    System.out.println("新建异常对象：" + (System.nanoTime() - l));  
	}  

	public void catchException() {  
	    long l = System.nanoTime(); 
	    for (int i = 0; i < counts; i++) { 
	        try {  
	            throw new Exception();
	        } catch (Exception e) { 
	            try {
					throw new MyException("my exception", e);
				} catch (MyException e1) {
					e1.printStackTrace();
				}
	        }  
	    }
	    System.out.println("抛出并捕获异常：" + (System.nanoTime() - l));  
	}

	public static void main(String[] args) {
		ExceptionTimeConsumingTest test = new ExceptionTimeConsumingTest(10000);  
	    test.newObject();  
	    test.newOverridObj();
	    test.newException();  
	    test.catchException(); 
	}
}
class Child {
	
}