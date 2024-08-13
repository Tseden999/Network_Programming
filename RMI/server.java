package RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class server {
    public static void main(String[] args) {
        try {
            // Start the RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Create an instance of the implementation class
            additionImp addImpl = new additionImp();

            // Bind the remote object in the registry
            Naming.rebind("rmi://localhost:1099/AddService", addImpl);

            System.out.println("Server is ready...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
