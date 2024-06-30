import java.net.*;

public class LocalMachine {
    public static void main(String[] args) {
        try {
            // Get the local host address
            InetAddress localHost = InetAddress.getLocalHost();
            String localIPAddress = localHost.getHostAddress();

            System.out.println("Local machine IP address: " + localIPAddress);
        } catch (UnknownHostException e) {
            System.out.println("Unable to get IP address: " + e.getMessage());
        }
    }
}
