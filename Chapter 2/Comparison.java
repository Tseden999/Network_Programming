import java.net.*;

public class Comparison {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("google.com");
        InetAddress address2 = InetAddress.getByName("www.google.org");

        if (address.equals(address2)) {
            System.out.println("IP address are equal");
        } else {
            System.out.println("IP address are not equal");
        }
    }
}
