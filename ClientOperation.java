
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

public class ClientOperation {

	private static RMIInterface look_up;

	public static void main(String[] args) 
		throws MalformedURLException, RemoteException, NotBoundException {
		
		look_up = (RMIInterface) Naming.lookup("//localhost/MyServer");
//		String txt = JOptionPane.showInputDialog("What is your name?");
		
		String response;
		try {
			response = look_up.helloTo(
					Runtime.getRuntime().availableProcessors(), 
					Runtime.getRuntime().freeMemory(),
					InetAddress.getLocalHost()
			);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}