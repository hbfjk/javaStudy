package concurrent;

import java.util.concurrent.Callable;
import java.util.Random;

public class PrivateAccount implements Callable<Integer> {
	Integer totalMoney;
    public  Integer call()  throws  Exception  {
            //Simulates a time conusimg task, sleep for 10s, 与Callable 不同，它有返回值
           Thread.sleep( 10000 );
           totalMoney  = new Integer(new Random().nextInt(10000));
           System.out.println("You have "+ totalMoney +"  in your private Account. " );
           return  totalMoney;
       }

}
