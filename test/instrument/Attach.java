import java.io.IOException;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

public class Attach {

	public static void main(String[] args) {
		VirtualMachine vm = null;  
	    String agentjarpath = "/Users/fangjk/git/javaStudy/test/instrument/agent.jar"; //agentjar路径  
	    try {
			vm = VirtualMachine.attach("16357");//specify pid
			vm.loadAgent(agentjarpath, "This is Args to the Agent.");  
		    vm.detach();
		} catch (AttachNotSupportedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (AgentLoadException e) {
			e.printStackTrace();
		} catch (AgentInitializationException e) {
			e.printStackTrace();
		}
	    

	}

}
