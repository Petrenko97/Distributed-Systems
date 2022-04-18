import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServerOperation extends UnicastRemoteObject implements RMIInterface{

    private static final long serialVersionUID = 1L;
    public static final long mb = 1024 * 1024; 
    
    static List<Connection> connections;

    protected ServerOperation() throws RemoteException {

        super();

    }

    @Override
    public String helloTo(int cores, long freeRam, InetAddress IP) throws RemoteException{

        System.err.println(IP + " is trying to contact!" + "with ram " +freeRam/mb + "cores " + cores);
        
        synchronized(connections) {
            connections.add(new Connection(cores, freeRam, IP));        	
        }

        
        return "Server says hello to " + IP;

    }

    public static void main(String[] args){
    	
    	connections = Collections.synchronizedList(new ArrayList<Connection>());

        try {

            Naming.rebind("//localhost/MyServer", new ServerOperation());            
            System.err.println("Server ready");

        } catch (Exception e) {

            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();

        }

    }

}