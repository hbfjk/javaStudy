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

public class Master implements Watcher {
	
	String serverId = Integer.toHexString(new Random().nextInt());
	boolean isLeader = false;
	
	ZooKeeper zk;
	String hostPort;
	
	Master(String hostPort) {
		this.hostPort = hostPort;
	}
	
	void startZK() throws IOException {
		zk = new ZooKeeper(hostPort, 15000, this);
	}
	
	void stopZK() throws Exception {
		zk.close();
	}
	
	void runForMaster() throws InterruptedException {
		while(true) {
			try {
				zk.create("/master", serverId.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
				isLeader = true;
				break;
			} catch (NodeExistsException e) {
				isLeader = false;
				break;
			} catch (ConnectionLossException e) {
			} catch (KeeperException e) {
			}
			if (checkMaster()) break;
		}
	}
	
	boolean isLeader() {
		return isLeader;
	}
	
	boolean checkMaster() {
		while(true) {
			try {
				Stat stat = new Stat();
				byte data[] = zk.getData("/master", false, stat);
				isLeader = new String(data).equals(serverId);
				return true;
			} catch (NoNodeException e) {
				//no master, so try create again
				return false;
			} catch (KeeperException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public void process(WatchedEvent e) {
		Printer.println(e.toString());
	}
	
	public static void main(String args[]) throws Exception {
		PropertyConfigurator.configure("/Users/fangjk/git/javaStudy/test/src/zookeeper/log4j.properties");
		Master m = new Master(args[0]);
		m.startZK();
		m.runForMaster();
		
		if(m.isLeader()) {
			Printer.println("I am the leader");
			Thread.sleep(60000);
		} else {
			Printer.println("Someone else is the leader");
		}
		m.stopZK();
	}

}
