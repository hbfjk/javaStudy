package zookeeper;

import java.io.IOException;
import java.util.Random;

import org.apache.log4j.PropertyConfigurator;
import org.apache.zookeeper.AsyncCallback.DataCallback;
import org.apache.zookeeper.AsyncCallback.StringCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException.Code;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import Utils.Printer;

public class Master_asyn implements Watcher {
	
	static String serverId = Integer.toHexString(new Random().nextInt());
	static boolean isLeader = false;
	
	static ZooKeeper zk;
	String hostPort;
	
	Master_asyn(String hostPort) {
		this.hostPort = hostPort;
	}
	
	void startZK() throws IOException {
		zk = new ZooKeeper(hostPort, 15000, this);
	}
	
	void stopZK() throws Exception {
		zk.close();
	}
	
	static StringCallback masterCreateCallback = (int rc, String path, Object ctx, String name) -> {

			Printer.print("entering masterCreateCallback");
			switch(Code.get(rc)) {
			case CONNECTIONLOSS:
				checkMaster();
				return;
			case OK:
				isLeader = true;
				break;
			default:
				isLeader = false;
			}
			Printer.println("I am " + (isLeader ? "" : "not ") + "the leader");
	};
	
	static DataCallback masterCheckCallback = new DataCallback() {

		@Override
		public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
			switch(Code.get(rc)) {
			case CONNECTIONLOSS:
				checkMaster();
				return;
			case NONODE:
				runForMaster();
				return;
			}
		}
		
	};
	
	static void runForMaster() {
		zk.create("/master", serverId.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,masterCreateCallback, null);
	}
	
	boolean isLeader() {
		return isLeader;
	}
	
	static void checkMaster() {
		zk.getData("/master", false, masterCheckCallback, null);
	}

	@Override
	public void process(WatchedEvent e) {
		Printer.println(e.toString());
	}
	
	public static void main(String args[]) throws Exception {
		PropertyConfigurator.configure("/Users/fangjk/git/javaStudy/test/src/zookeeper/log4j.properties");
		Master_asyn m = new Master_asyn(args[0]);
		m.startZK();
		runForMaster();
		
		Thread.sleep(60000);
		m.stopZK();
	}

}
