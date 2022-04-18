
import java.net.InetAddress;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {

    public String helloTo(int cores, long ramLeft, InetAddress IP) throws RemoteException;

}