package inputstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderTest {
	
	public static void main(String... args) {
		try {
			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Input server name:");
			String serverName = buf.readLine();
			System.out.println("Your input:" + serverName);
			System.out.println("Confiugration Items:");
			System.out.println("1.	User Registry(Basic,LDAP)");
			System.out.println("2.	SSO");
			System.out.println("3.	SSL");
			System.out.println("4.	Pfsdb");
			System.out.println("5.	Elastic search");
			System.out.println("6.	Federate system(BPD,BPEL)");
			System.out.println("0.	Exit");
			System.out.print("Choose configuration item to edit:");
			String option = buf.readLine();
			System.out.println("Your input:" + option);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
