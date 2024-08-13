package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class additionImp extends UnicastRemoteObject implements addition {

    // Constructor
    protected additionImp() throws RemoteException {
        super();
    }

    // Implement the add method
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
