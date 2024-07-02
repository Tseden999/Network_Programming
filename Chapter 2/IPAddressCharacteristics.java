import java.net.*;
import java.util.Scanner;

public class IPAddressCharacteristics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an IP address or hostname: ");
        String input = scanner.nextLine();
        scanner.close();

        try {
            // Get the InetAddress object for the input
            InetAddress address = InetAddress.getByName(input);

            // Print the IP address
            System.out.println("IP Address: " + address.getHostAddress());

            // Check and print characteristics of the IP address
            if (address instanceof java.net.Inet4Address) {
                System.out.println("This is an IPv4 address.");
            } else if (address instanceof java.net.Inet6Address) {
                System.out.println("This is an IPv6 address.");
            }
            System.out.println(" loopback address" + address.isLoopbackAddress());
            System.out.println("multicast address" + address.isMulticastAddress());
            System.out.println("wildcard address" + address.isAnyLocalAddress());
            System.out.println("LinkLocal address" + address.isLinkLocalAddress());
            System.out.println("SiteLocal address" + address.isSiteLocalAddress());

        } catch (UnknownHostException e) {
            System.err.println("error " + e.getMessage());
        }
    }
}
