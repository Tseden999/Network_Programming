import java.net.*;
import java.util.Collections;
import java.net.NetworkInterface;
import java.util.List;

public class MacAddress {

    public static void main(String[] args) {
        try {
            // Get all network interfaces
            List<NetworkInterface> networkInterfaces = Collections.list(NetworkInterface.getNetworkInterfaces());

            for (NetworkInterface networkInterface : networkInterfaces) {
                // Get and print IP addresses associated with the network interface
                List<InetAddress> inetAddresses = Collections.list(networkInterface.getInetAddresses());
                for (InetAddress inetAddress : inetAddresses) {
                    System.out.println("Interface: " + networkInterface.getDisplayName());
                    System.out.println("IP Address: " + inetAddress.getHostAddress());

                    // Get and print MAC address
                    byte[] mac = networkInterface.getHardwareAddress();
                    if (mac != null) {
                        StringBuilder macAddress = new StringBuilder();
                        for (int i = 0; i < mac.length; i++) {
                            macAddress.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                        }
                        System.out.println("MAC Address" + macAddress.toString());
                    } else {
                        System.out.println("MAC Address Not available");
                    }
                }
            }
        } catch (SocketException e) {
            System.err.println("Error " + e.getMessage());
        }
    }
}
