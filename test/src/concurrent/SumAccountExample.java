package concurrent;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class SumAccountExample {

	public static void main(String[] args) {
		
		// Create a new thread to do so
		int coreCpuNum = Runtime.getRuntime().availableProcessors();
		ExecutorService executor = Executors.newFixedThreadPool(coreCpuNum);
		
		try {
			// init callable object and future task
			Callable<Integer> pAccount = new PrivateAccount();
			FutureTask<Integer> futureTask = new FutureTask<Integer>(pAccount);

			executor.submit(futureTask);
			
			// Do something else in the main thread
			System.out.println("Doing something else here.");

			// Get the total money from other accounts
			int totalMoney = new Random().nextInt(100000);
			System.out.println("You have " + totalMoney + " in your other Accounts.");
			System.out.println("Waiting for data from Private Account");
			// If the Future task is not finished, we will wait for it
			while (!futureTask.isDone()) {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Integer privataAccountMoney = null;
			// Since the future task is done, get the object back
			try {
				privataAccountMoney = (Integer) futureTask.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			System.out.println("The total moeny you have is " + (totalMoney + privataAccountMoney.intValue()));
		} finally {
			while(!executor.isTerminated()) {
				executor.shutdown();
			}
		}
		
		
	}

}
