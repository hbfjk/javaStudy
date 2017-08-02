package thread.notifyMultiple;

import Utils.Printer;

public class NotifyMultipleTimeTest {

	public static void main(String[] args) {
		String lock = new String();
		WaitThread wait_0 = new WaitThread(lock);
		wait_0.setName("wait_0_THEAD");
		wait_0.start();
		
		WaitThread wait_1 = new WaitThread(lock);
		wait_1.setName("wait_1_THEAD");
		wait_1.start();
		
		WaitThread wait_2 = new WaitThread(lock);
		wait_2.setName("wait_2_THEAD");
		wait_2.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		NotifyThread notify = new NotifyThread(lock);
		notify.setName("notify_THREAD");
		notify.start();
		
		
	}

}

class WaitThread extends Thread {
	String lock;
	WaitThread(String lock) {
		this.lock = lock;
	}
	public void run() {
		synchronized(lock) {
			Printer.println(Thread.currentThread().getName() + " begin: " + System.currentTimeMillis());
			try {
				Printer.println(Thread.currentThread().getName() + " is going to wait " + System.currentTimeMillis());
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Printer.println(Thread.currentThread().getName() + " end: " + System.currentTimeMillis());
		}
		
		
	}
}

class NotifyThread extends Thread {
	String lock;
	NotifyThread(String lock) {
		this.lock = lock;
	}
	public void run() {
		synchronized(lock) {
			Printer.println(Thread.currentThread().getName() + " begin: " + System.currentTimeMillis());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.notifyAll();
			Printer.println(Thread.currentThread().getName() + " end: " + System.currentTimeMillis());
		}
	}
}
