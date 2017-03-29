import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class Target {

	public static void main(String[] args) throws IOException {
		//current process id
		 final RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();  
		 final String info = runtime.getName();  
		 final int index = info.indexOf("@");  
		 if (index != -1) {
			 final int pid = Integer.parseInt(info.substring(0, index));
			 System.out.println(info);
			 System.out.println(pid);
		 }
		 
		//input a char
		System.out.print("Enter a Char:"); 
		char i = (char) System.in.read(); 
        System.out.println("your char is :"+i);
        
        //input a line
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        String str = null; 
        System.out.println("Enter your value:"); 
        str = br.readLine();
        System.out.println("your value is :"+str); 
	}

}
