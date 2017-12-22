package testVolatile;

public class VolatileTest {
	
	volatile static int start = 3;
	volatile static int end = 6;

	public static void main(String[] args) {
		
		Thread threadA = new Thread(new Runnable() {
			@Override
			public void run() {
				while(start < end) {
					System.out.println("threadA is running. start="+start+"end="+end);
				}
				System.out.println("threadA is exiting.");
			}
			
		});
		
		
		Thread threadB = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					start += 3;
					end += 3;
					System.out.println("threadB is running. start="+start+"end="+end);
				}
			}
		});
		
		threadB.start();
		threadA.start();
		
	}

}
