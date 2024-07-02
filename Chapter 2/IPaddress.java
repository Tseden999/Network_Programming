import java.net.*;
import java.util.Arrays;
import java.util.List;

public class IPaddress {
    public static void main(String[] args) {
        String hostname = "www.google.com";

        try {
            InetAddress[] ipv4Addresses = InetAddress.getAllByName(hostname);
            InetAddress[] ipv6Addresses = InetAddress.getAllByName(hostname);

            List<InetAddress> ipv4List = filterAddresses(ipv4Addresses, 4);
            List<InetAddress> ipv6List = filterAddresses(ipv6Addresses, 6);

            System.out.println("IPv4 addresses for " + hostname + ":");
            printAddresses(ipv4List);

            System.out.println("\nIPv6 addresses for " + hostname + ":");
            printAddresses(ipv6List);

        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + hostname);
            e.printStackTrace();
        }
    }

    private static List<InetAddress> filterAddresses(InetAddress[] addresses, int ipVersion) {
        return Arrays.stream(addresses)
                .filter(addr -> {
                    if (ipVersion == 4) {
                        return addr instanceof java.net.Inet4Address;
                    } else if (ipVersion == 6) {
                        return addr instanceof java.net.Inet6Address;
                    }
                    return false;
                })
                .toList();
    }

    private static void printAddresses(List<InetAddress> addresses) {
        for (InetAddress address : addresses) {
            System.out.println(address.getHostAddress());
        }
    }
}