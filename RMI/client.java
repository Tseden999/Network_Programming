package RMI;

import java.rmi.Naming;

public class client {
    public static void main(String[] args) {
        try {
            // Lookup the remote object
            addition addService = (addition) Naming.lookup("rmi://localhost:1099/AddService");

            // Call the remote method
            int result = addService.add(5, 3);
            System.out.println("The sum is: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
