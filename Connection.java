import java.net.InetAddress;

public class Connection {
	int cores=0;
	long freeRam=0;
	InetAddress IP;
	
	public Connection(int cores, long freeRam, InetAddress IP) {
		this.cores = cores;
		this.freeRam = freeRam;
		this.IP = IP;
	}
}
