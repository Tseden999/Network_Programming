
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;

public class NetworkInterfacesInfo {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        ArrayList<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterface());
        System.out.println("Getter method of NetworkInterface");

        for (NetworkInterface iface : interfaces) {
            System.out.println("name is" + iface.getDisplayName());
            System.out.println("name is" + iface.getName());
            System.out.println("name is" + iface.isUp());
            System.out.println("name is" + iface.isVirtual());
            System.out.println("name is" + iface.getMTU());
            System.out.println("name is" + iface.isLoopback());
        }
    }
}