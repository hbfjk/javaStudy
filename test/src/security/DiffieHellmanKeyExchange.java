package security;

public class DiffieHellmanKeyExchange {
	
	int p = 17;
	int g = 6;
	
	public class Sender {
		int x = 45;
		
		double generatePulicKey() {
			double temp = Math.pow(g, x) % p;
			return temp;
		}
		
		double generateSecretKey(int senderReeiverKey) {
			double temp = Math.pow(senderReeiverKey, x) % p;
			return temp;
		}
		
	}
	
	public class Receiver {
		int y = 43;
		
		double generatePulicKey() {
			double temp = Math.pow(g, y) % p;
			return temp;
		}
		
		double generateSecretKey(int senderReeiverKey) {
			double temp = Math.pow(senderReeiverKey, y) % p;
			return temp;
		}
	}

	public static void main(String[] args) {
		DiffieHellmanKeyExchange dh = new DiffieHellmanKeyExchange();
		Sender sender = dh.new Sender();
		Receiver receiver = dh.new Receiver();
		
		int senderPublicKey = (int) sender.generatePulicKey();
		int receiverPublicKey = (int) receiver.generatePulicKey();
		
		System.out.println(sender.generateSecretKey(receiverPublicKey));
		System.out.println(receiver.generateSecretKey(senderPublicKey));
	}

}
