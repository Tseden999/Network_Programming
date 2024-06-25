import java.net.*;

public class IPv4_IPv6 {
    public static void main(String[] args) throws UnknownHostException {

        InetAddress address[] = InetAddress.getAllByName("eiccollege.edu.np");
        byte[] bytes = address[0].getAddress();

        if (bytes.length == 4) {
            System.out.println("IP address is IPv4");
        } else if (bytes.length == 6) {
            System.out.println("IP address is IPv6");
        } else {
            System.out.println("Neither IPv4 nor IPv6 address");
        }
    }
}
