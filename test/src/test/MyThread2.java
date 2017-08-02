package test;

public class MyThread2 extends Thread {
	
	private long i = 0;
	public void run() {
		while(true) {
			i++;
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		
		try {
			MyThread2 thread = new MyThread2();
			thread.start();
			Thread.sleep(10000);
			thread.suspend();
			Thread.sleep(10000);
			thread.resume();
			Thread.sleep(10000);
			thread.suspend();
			System.out.println("main end!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
