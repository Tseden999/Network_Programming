
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;

public class NetworkInterfacesInfo {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        ArrayList<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
        System.out.println("Getter method of NetworkInterface");

        for (NetworkInterface iface : interfaces) {
            System.out.println("Displayname is" + iface.getDisplayName());
            System.out.println("name is" + iface.getName());
            System.out.println("isUp" + iface.isUp());
            System.out.println("isVirtual" + iface.isVirtual());
            System.out.println("MTU is" + iface.getMTU());
            System.out.println("Loopback is" + iface.isLoopback());
        }
    }
}