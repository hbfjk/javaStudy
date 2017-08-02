package test;

import Utils.Printer;

public class MyThread extends Thread {
	private volatile int count = 5;
	
	public void run() {
		while(count > 0) {
			count--;
			Printer.println("Current thread:" + Thread.currentThread().getName() + " count:" + count);
		}
	}
	
	public static void main(String... args) {
		MyThread mythread = new MyThread();
		
		Thread a = new Thread(mythread, "A");
		Thread b = new Thread(mythread, "B");
		Thread c = new Thread(mythread, "C");
		Thread d = new Thread(mythread, "D");
		Thread e = new Thread(mythread, "E");
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
	}

}
