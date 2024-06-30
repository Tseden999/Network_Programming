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

            if (address.isLoopbackAddress()) {
                System.out.println("This is a loopback address.");
            } else {
                System.out.println("This is not a loopback address.");
            }

            if (address.isMulticastAddress()) {
                System.out.println("This is a multicast address.");
            } else {
                System.out.println("This is not a multicast address.");
            }

            if (address.isAnyLocalAddress()) {
                System.out.println("This is a wildcard address.");
            } else {
                System.out.println("This is not a wildcard address.");
            }

            if (address.isLinkLocalAddress()) {
                System.out.println("This is a link-local address.");
            } else {
                System.out.println("This is not a link-local address.");
            }

            if (address.isSiteLocalAddress()) {
                System.out.println("This is a site-local address.");
            } else {
                System.out.println("This is not a site-local address.");
            }

        } catch (UnknownHostException e) {
            System.err.println("Unable to resolve the IP address/hostname: " + e.getMessage());
        }
    }
}
