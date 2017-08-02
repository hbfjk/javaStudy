package zookeeper;

import java.io.IOException;
import java.util.Random;

import org.apache.log4j.PropertyConfigurator;
import org.apache.zookeeper.AsyncCallback.StringCallback;
import org.apache.zookeeper.KeeperException.Code;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Utils.Printer;

public class Worker implements Watcher {
	
	private static final Logger LOG = LoggerFactory.getLogger(Worker.class);
	
	String serverId = Integer.toHexString(new Random().nextInt());
	ZooKeeper zk;
	String hostPort;
	
	Worker(String hostPort) {
		this.hostPort = hostPort;
	}
	
	void startZK() throws IOException {
		zk = new ZooKeeper(hostPort, 15000, this);
	}

	@Override
	public void process(WatchedEvent e) {
		Printer.println(e.toString() + hostPort);
	}
	
	void register() {
		zk.create("/workers/worker-"+serverId, "Idel".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL, createWorkerCalllback, null);
	}
	
	StringCallback createWorkerCalllback = new StringCallback() {
		@Override
		public void processResult(int rc, String path, Object ctx, String name) {
			switch(Code.get(rc)) {
			case CONNECTIONLOSS:
				register();
				break;
			case OK:
				LOG.info("Registered successfully: " + serverId);
				return;
			case NODEEXISTS:
				Printer.println("Already registered: " + serverId);
				break;
			default:
				LOG.error("Something went wrong: " + KeeperException.create(Code.get(rc), path));
			}
		}
	};
	
	StringCallback statusUpdateCallback = (int rc, String path, Object ctx, String name) -> {
		switch(Code.get(rc)) {
		case CONNECTIONLOSS:
			updateStatus((String)ctx);
			return;
		}
	};

	private String status;
	
	private void updateStatus(String status) {
		if(status == this.status) {
			zk.setData("/workers/" + name, status.getBytes(), -1, statusUpdateCallback, status);
		}
	}
	
	public void setStatus(String status){
		this.status = status;
		updateStatus(status);
	}
	
	public static void main(String args[]) throws Exception {
		PropertyConfigurator.configure("/Users/fangjk/git/javaStudy/test/src/zookeeper/log4j.properties");
		Worker w = new Worker(args[0]);
		w.startZK();
		w.register();
		
		Thread.sleep(60000);
	}

}
