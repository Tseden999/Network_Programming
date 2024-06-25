import java.net.*;

public class CanonicalHostName {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("www.tufohss.edu.np");
        System.out.println(" Address is :" + address.getAddress());

    }

}
