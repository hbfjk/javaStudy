package thread.demonthread;

import Utils.Printer;

public class MyThread extends Thread {
	private int i=0;
	public void run() {
		try {
			while(true) {
				i++;
				Printer.println("i=" + (i));
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.setDaemon(true);
		thread.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Printer.println("Leaving main function.");
	}

}
