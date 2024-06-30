import java.net.*;
import java.util.Enumeration;

public class NetworkInterfacesInfo {

    public static void main(String[] args) {
        try {
            // Get all network interfaces
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();

                // Print network interface information
                System.out.println("Interface Name: " + networkInterface.getName());
                System.out.println("Display Name: " + networkInterface.getDisplayName());
                System.out.println("Is Up: " + networkInterface.isUp());
                System.out.println("Is Loopback: " + networkInterface.isLoopback());
                System.out.println("Is Virtual: " + networkInterface.isVirtual());
                System.out.println("Supports Multicast: " + networkInterface.supportsMulticast());
                System.out.println("MTU: " + networkInterface.getMTU());

                // Get and print IP addresses associated with the network interface
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    System.out.println("IP Address: " + inetAddress.getHostAddress());
                }

                System.out.println(".......");
            }
        } catch (SocketException e) {
            System.err.println("Error retrieving network interface information: " + e.getMessage());
        }
    }
}
