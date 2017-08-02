package testVolatile;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
	
	public static AtomicInteger count = new AtomicInteger(0);
	
	private static void addCount() {
		for(int i=0; i<100; i++) {
			count.incrementAndGet();
		}
		System.out.println("count=" + count);
	}
	
	public void run() {
		addCount();
	}
	
	public static void main(String[] args) {
		MyThread[] mythreadArray = new MyThread[100];
		for(int i=0;i<100;i++) {
			mythreadArray[i] = new MyThread();
		}
		for(int i=0;i<100;i++) {
			mythreadArray[i].start();
		}
	}
}
