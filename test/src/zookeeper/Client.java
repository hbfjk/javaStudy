package zookeeper;

import java.io.IOException;
import java.util.Random;

import org.apache.log4j.PropertyConfigurator;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.KeeperException.ConnectionLossException;
import org.apache.zookeeper.KeeperException.NoNodeException;
import org.apache.zookeeper.KeeperException.NodeExistsException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import Utils.Printer;

public class Client implements Watcher {
	
	ZooKeeper zk;
	String hostPort;
	
	Client(String hostPort) {
		this.hostPort = hostPort;
	}
	
	void startZK() throws IOException {
		zk = new ZooKeeper(hostPort, 15000, this);
	}
	
	String queueCommand(String command) throws Exception {
		while(true) {
			try {
				String name = zk.create("/tasks/task-", command.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
				return name;
			} catch (NodeExistsException e) {
				throw new Exception(command + " already appears to be running");
			} catch (ConnectionLossException e) {
			}
		}
	}

	@Override
	public void process(WatchedEvent e) {
		Printer.println(e.toString());
	}
	
	public static void main(String args[]) throws Exception {
		PropertyConfigurator.configure("/Users/fangjk/git/javaStudy/test/src/zookeeper/log4j.properties");
		Client c = new Client(args[0]);
		c.startZK();
		
		String name = c.queueCommand(args[1]);
		Printer.println("Created " + name);
	}

}
