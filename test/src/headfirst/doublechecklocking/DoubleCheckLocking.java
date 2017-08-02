package headfirst.doublechecklocking;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DoubleCheckLocking {
	private Helper helper = null;
	
	private Helper getHelper() {
		if(helper == null) {
			synchronized(this) {
				if(helper == null) {
					helper = new Helper();
				}
			}
		}
		return helper;
	}

	public static void main(String[] args) {
		ThreadPoolExecutor tpool = new ThreadPoolExecutor(10, 100, 0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
		DoubleCheckLocking dcl = new DoubleCheckLocking();
		for(int i=0; i<10; i++) {
			tpool.submit(() -> {
				Helper helper = dcl.getHelper();
				System.out.println(Thread.currentThread().getName()+ ":" + helper.toString());
			});
		}
		tpool.shutdown();
		
	}

}
class Helper {
	private String a = null;
	private String b = null;
	private String c = null;
	private String d = null;
	
	protected Helper() {
		try {
			System.out.println(Thread.currentThread().getName()+ ":" + "initialize a");
			a = Thread.currentThread().getName() + "a";
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName()+ ":" + "initialize b");
			b = Thread.currentThread().getName() + "b";
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName()+ ":" + "initialize c");
			c = Thread.currentThread().getName() + "c";
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName()+ ":"+ "initialize d");
			d = Thread.currentThread().getName() + "d";
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("a:" + a + " ");
		sb.append("b:" + b + " ");
		sb.append("c:" + c + " ");
		sb.append("d:" + d);
		return sb.toString();
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}
}
