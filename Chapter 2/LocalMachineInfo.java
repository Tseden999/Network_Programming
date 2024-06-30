import java.net.*;

public class LocalMachineInfo {

    public static void main(String[] args) {
        try {
            // Get the local host address
            InetAddress localHost = InetAddress.getLocalHost();

            // Get the IP address and hostname
            String localIPAddress = localHost.getHostAddress();
            String localHostName = localHost.getHostName();

            System.out.println("Local machine IP address: " + localIPAddress);
            System.out.println("Local machine hostname: " + localHostName);
        } catch (UnknownHostException e) {
            System.err.println("Unable to get local machine information: " + e.getMessage());
        }
    }
}
